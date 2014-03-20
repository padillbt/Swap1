package scheduleGenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Day is used to store jobs for a given day.
 *
 * @author schneimd.
 *         Created Oct 15, 2012.
 */
public class Day implements Serializable{
	
	private String dayOfWeek;
	private ArrayList<String> jobs = new ArrayList<String>();
	
	 // SWAP 1, TEAM 6
	 // QUALITY CHANGES
	private JScrollPane dayScrollPane = new JScrollPane();
    private JButton dayAddJob = new JButton();
    private JButton dayDeleteJob = new JButton();
    @SuppressWarnings("rawtypes")
	private JList dayJobList = new JList();
    private JTextField dayJobName = new JTextField();
    private JLabel dayLabel = new JLabel();
    private JPanel dayTab = new JPanel();
    private DefaultListModel model = new DefaultListModel();
    private JCheckBox dayCheck = new JCheckBox();

	
	/**
	 * Construct a day with a name and jobs.
	 * 
	 * @param name 
	 *
	 * @param jobs
	 */
	public Day(String name, ArrayList<Object> jobs)
	{
		this.dayOfWeek = name;
		for(Object i:jobs)
		{
			this.jobs.add((String)i);
		}
		this.initComponent(name);
	}
	
	// SWAP 1, TEAM 6
	// QUALITY CHANGES
	public Day(String name)
	{
		this.dayOfWeek = name;
		this.initComponent(this.dayOfWeek);
	}
	
	/**
	 * Add one jobName.
	 *
	 * @param jobName
	 */
	public void addJob(String jobName) {
		this.jobs.add(jobName);
	}
	
	// SWAP 1, TEAM 6
	// QUALITY CHANGES
	public void addJobs(ArrayList<Object> jobs){
		for(Object i:jobs)
		{
			this.jobs.add((String)i);
		}
	}
	
	/**
	 * Set jobs to new jobs.
	 *
	 * @param jobNames
	 */
	public void setJobs(ArrayList<String> jobNames) {
		this.jobs = jobNames;
	}
	
	/**
	 * return current jobs.
	 *
	 * @return jobs
	 */
	public ArrayList<String> getJobs() {
		return this.jobs;
	}
	
	/**
	 * Gives the name of this day.
	 *
	 * @return day of week
	 */
	public String getNameOfDay() {
		return this.dayOfWeek;
	}
	
	 // SWAP 1, TEAM 6
	 // QUALITY CHANGES
	public void initModel(DefaultListModel model){
		this.dayCheck.doClick();
		ArrayList<String> jobs = this.getJobs();
		for(String job: jobs) {
			model.addElement(job);
			this.dayJobList.setModel(model);
		}
	}
	
	// SWAP 1, TEAM 6
	// QUALITY CHANGES
	public void initComponent(String day){
		this.dayCheck.setText(day);
        this.dayCheck.setName(day.toLowerCase() + "Check"); // NOI18N
        this.dayCheck.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayCheckActionPerformed();
            }
        });
	}
	
	// SWAP 1, TEAM 6
	// QUALITY CHANGES
	public void add(){
		if(!this.dayJobName.getText().isEmpty()) {
            this.model.addElement(this.dayJobName.getText());
            this.addJob(this.dayJobName.getText());
            System.out.println(this.jobs.size());
            this.dayJobList.setModel(this.model);
            this.dayJobName.setText("");
        }
	}

	// SWAP 1, TEAM 6
	// QUALITY CHANGES
	public void delete(){
		while(!dayJobList.isSelectionEmpty()) {
           int n = dayJobList.getSelectedIndex();
           this.jobs.remove(n);
           this.model.remove(n);
        }
	}
	
	/**
	 * @param evt  
	 */
    @SuppressWarnings("unchecked")
	public void dayCheckActionPerformed() {                                            

            this.model = new DefaultListModel();
            this.dayJobList.setModel(model);
            this.dayScrollPane.setViewportView(this.dayJobList);

            this.dayJobName.setColumns(20);

            this.dayLabel.setText("Job Name:");

            this.dayAddJob.setText("Add Job");
            this.dayAddJob.addActionListener(new AddListener(this));

            this.dayDeleteJob.setText("Delete Job");
            this.dayDeleteJob.addActionListener(new DeleteListener(this));

            javax.swing.GroupLayout sundayTabLayout = new javax.swing.GroupLayout(this.dayTab);
            this.dayTab.setLayout(sundayTabLayout);
            sundayTabLayout.setHorizontalGroup(
                sundayTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sundayTabLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(this.dayScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(sundayTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sundayTabLayout.createSequentialGroup()
                            .addComponent(this.dayLabel)
                            .addGroup(sundayTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(sundayTabLayout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(this.dayAddJob))
                                .addGroup(sundayTabLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(this.dayJobName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(this.dayDeleteJob))
                    .addContainerGap(431, Short.MAX_VALUE))
            );
            sundayTabLayout.setVerticalGroup(
                sundayTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sundayTabLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(sundayTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(sundayTabLayout.createSequentialGroup()
                            .addGroup(sundayTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(this.dayJobName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(this.dayLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(this.dayAddJob)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(this.dayDeleteJob))
                        .addComponent(this.dayScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(25, Short.MAX_VALUE))
            );
        
    }
    
	// SWAP 1, TEAM 6
	// QUALITY CHANGES
    public boolean isSelected(){
    	return this.dayCheck.isSelected();
    }
    
	// SWAP 1, TEAM 6
	// QUALITY CHANGES
    public JCheckBox getCheckBox(){
    	return this.dayCheck;
    }
    
	// SWAP 1, TEAM 6
	// QUALITY CHANGES
    public JPanel getDayTab(){
    	return this.dayTab;
    }
    
	// SWAP 1, TEAM 6
	// QUALITY CHANGES
    public DefaultListModel getModel(){
    	return this.model;
    }
    
}
	
