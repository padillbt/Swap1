package scheduleGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Used to store predicted days and generate new days.
 * 
 * @author schneimd. Created Oct 18, 2012.
 */
public class Schedule extends Thread implements Serializable {

	private ArrayList<Worker> workers;
	private ArrayList<Day> days;
	private TreeMap<String, TreeMap<String, Worker>> schedule;
	private GregorianCalendar cal;
	private HashMap<Integer, ArrayList<Worker>> workerIndices;
	private boolean workerForEveryJob = true;

	/**
	 * Used to construct an initial schedule, used if one does not exist.
	 * 
	 * @param daySlots
	 * @param wrks
	 */
	public Schedule(ArrayList<Day> daySlots, ArrayList<Worker> wrks) {
		this.workers = wrks;
		this.days = daySlots;
		this.workerIndices = new HashMap<Integer, ArrayList<Worker>>();
		for (int i = 1; i <= 7; i++) {
			this.workerIndices.put(i, new ArrayList<Worker>());
		}
		this.generateIndices();

		// Key is year/month/day format and item is a hashmap with key nameOfJob
		// and item Worker
		this.schedule = new TreeMap<String, TreeMap<String, Worker>>();

		this.cal = new GregorianCalendar();

		this.calculateNextMonth();
	}

	@Override
	public void run() {
		this.calculateNextMonth();
	}

	/**
	 * returns workers in schedule.
	 * 
	 * @return workers
	 */
	public ArrayList<Worker> getWorkers() {
		return this.workers;
	}

	private void generateIndices() {
		for (int i = 0; i < this.workers.size(); i++) {
			for (Day day : this.workers.get(i).getDays()) {
				int numDay = this.numForName(day.getNameOfDay());
				this.workerIndices.get(numDay).add(this.workers.get(i));
			}
		}
	}

	/**
	 * Calculates another month of schedule based on workers availability.
	 * 
	 * QUALITY CHANGES Swap 1, Team 6
	 * 
	 * Explanation of refactoring:
	 * 
	 * The code in the if statement for a schedule with size larger than zero:
	 * that part was extracted out into it's own method:
	 * previouslyGenerateCalendarSetup().
	 * 
	 * The long for-loop going through the jobsInOrder was extracted and put
	 * into the private helper method: assignWorkersAndJobs(Day day). There were
	 * a lot of temporary variables that were created for that.
	 * 
	 * The multi-line calculation to create a string for the Date in a readable
	 * format was extracted to the new method: createDateString().
	 * 
	 * Additional features could use the new smaller methods to create new
	 * functionality.
	 */
	private synchronized void calculateNextMonth() {

		int initialSize = this.schedule.size();

		// If the schedule has already been generated
		if (!this.schedule.isEmpty()) {
			resetCalendarMonth();
		}

		// These variables are for the HTML table generator
		int daysInMonth = 0;
		ArrayList<Integer> numOfJobs = new ArrayList<Integer>();

		// Used to see if month changes
		int currentMonth = this.cal.get(Calendar.MONTH);

		// While still in the current month generate a schedule for each day
		while (currentMonth == this.cal.get(Calendar.MONTH)) {

			for (Day day : this.days) {
				if (this.cal.get(Calendar.DAY_OF_WEEK) == this.numForName(day
						.getNameOfDay())) {
					daysInMonth++;
					int numOfNewJobs = assignWorkersAndJobs(day);
					numOfJobs.add(numOfNewJobs);
					break; // Breaks so it doesn't check the other days
				}
			}
			this.cal.add(Calendar.DATE, 1);
		}
		HTMLGenerator.makeTable(daysInMonth, numOfJobs);
		// Calls itself if there aren't many days generated
		// For instance if the date it was created is the last day of the
		// month it would only makes one day of schedule.
		if (this.schedule.size() - initialSize < 2 && !this.workerForEveryJob) {
			this.calculateNextMonth();
		}

		Main.dumpConfigFile();
	}

	/**
	 * QUALITY CHANGES Swap 1, Team 6
	 * 
	 * This was added as part of the refactoring of the calculateNextMonth()
	 * long method.
	 * 
	 * Additionally, this code was simplified by just creating the calendar at
	 * the desired date instead of this going through calculations to reset to
	 * the beginning of the month.
	 * 
	 */
	private void resetCalendarMonth() {
		String lastDateMade = this.schedule.lastKey();
		String[] parts = lastDateMade.split("/");
		int year = Integer.parseInt(parts[0]);
		int month = Integer.parseInt(parts[1]);
		this.cal = new GregorianCalendar(year, month, 1);
	}

	/**
	 * QUALITY CHANGES Swap 1, Team 6
	 * 
	 * This was added as part of refactoring calculateNextMonth(), which was a
	 * long method.
	 * 
	 * @param day
	 * @return the number of new jobs assigned by this method
	 */
	private int assignWorkersAndJobs(Day day) {

		TreeMap<String, Worker> jobsWithWorker = null;
		ArrayList<String> workersWorking = new ArrayList<String>();
		ArrayList<String> jobsInOrder = day.getJobs();

		for (String job : jobsInOrder) {
			ArrayList<Worker> workersForJob = new ArrayList<Worker>();
			for (Worker worker : this.workerIndices.get(this.numForName(day
					.getNameOfDay()))) {
				// for (Worker worker : this.workerIndices.get(day.getDayNum()))
				// {
				Day workerDay = worker.getDayWithName(day.getNameOfDay());
				if (workerDay.getJobs().contains(job)
						&& !workersWorking.contains(worker.getName())) {
					workersForJob.add(worker);
				}
			}
			jobsWithWorker = createDailySchedule(workersForJob, job,
					workersWorking, day);
			if (this.workerForEveryJob = false) {
				break;
			}
		}

		String date = createDateString();
		this.schedule.put(date, jobsWithWorker);
		return jobsInOrder.size();
	}

	/**
	 * QUALITY CHANGES Swap 1, Team 6
	 * 
	 * This pulls the if/else code out of the AssignWorkersAndJobs() method.
	 * 
	 * @param workersForJob
	 * @param job
	 * @param workersWorking
	 * @param day
	 * @return a tree map with jobs assigned to workers
	 */
	private TreeMap<String, Worker> createDailySchedule(
			ArrayList<Worker> workersForJob, String job,
			ArrayList<String> workersWorking, Day day) {

		TreeMap<String, Worker> jobsWithWorker = new TreeMap<String, Worker>();

		if (workersForJob.size() > 0) {
			Worker workerForJob = workersForJob.get(new Random()
					.nextInt(workersForJob.size()));
			for (Worker w : workersForJob) {
				if (w.numWorkedForJob(job) < workerForJob.numWorkedForJob(job)) {
					workerForJob = w;
				}
			}
			jobsWithWorker.put(job, workerForJob);
			workersWorking.add(workerForJob.getName());
			workerForJob.addWorkedJob(job);
		} else {
			jobsWithWorker.put(job, new Worker("Empty", new ArrayList<Day>()));
			JOptionPane.showMessageDialog(
					new JFrame(),
					"No workers are able to work as a(n) " + job + " on "
							+ day.getNameOfDay());
			this.workerForEveryJob = false;
		}

		return jobsWithWorker;

	}

	/**
	 * QUALITY CHANGES Swap 1, Team 6
	 * 
	 * This was added as part of the refactoring of the calculateNextMonth()
	 * long method. The multi-line calculation to create the date string was
	 * pulled out to clean up the main method.
	 * 
	 */
	private String createDateString() {
		return this.cal.get(Calendar.YEAR) + "/"
				+ String.format("%02d", (this.cal.get(Calendar.MONTH) + 1))
				+ "/"
				+ String.format("%02d", this.cal.get(Calendar.DAY_OF_MONTH));
	}

	/**
	 * QUALITY CHANGES SWAP 1, TEAM 6
	 * 
	 * SMELL: Switch Statements - an assortment of if cases shows that the
	 * abstraction was not thoroughly thought out. Refactoring this would allow
	 * a cleaner use of this method and less of a need to for other switch
	 * statements.
	 */
	private int numForName(String nameOfDay) {
		int dayNum = 0;
		if (nameOfDay.equals("Sunday")) {
			dayNum = 1;
		} else if (nameOfDay.equals("Monday")) {
			dayNum = 2;
		} else if (nameOfDay.equals("Tuesday")) {
			dayNum = 3;
		} else if (nameOfDay.equals("Wednesday")) {
			dayNum = 4;
		} else if (nameOfDay.equals("Thursday")) {
			dayNum = 5;
		} else if (nameOfDay.equals("Friday")) {
			dayNum = 6;
		} else if (nameOfDay.equals("Saturday")) {
			dayNum = 7;
		}
		return dayNum;
	}

	// /**
	// * Returns the month/day/year of next date with the name of day.
	// *
	// * @param nameOfDay
	// * @return string of year/month/day format
	// */
	// private String getNextDate(String nameOfDay) {
	// int dayNum = numForName(nameOfDay);
	// GregorianCalendar tempCal = (GregorianCalendar) this.cal.clone();
	//
	// tempCal.add(Calendar.DATE, 1);
	// while (tempCal.get(Calendar.DAY_OF_WEEK) != dayNum) {
	// tempCal.add(Calendar.DATE, 1);
	// }
	// return String.valueOf(tempCal.get(Calendar.YEAR)) + "/" +
	// String.valueOf(tempCal.get(Calendar.MONTH)) + "/"
	// + String.valueOf(tempCal.get(Calendar.DAY_OF_MONTH));
	// }

	/**
	 * Returns the schedule.
	 * 
	 * @return HashMap schedule
	 */
	public TreeMap<String, TreeMap<String, Worker>> getSchedule() {
		return this.schedule;
	}

}
