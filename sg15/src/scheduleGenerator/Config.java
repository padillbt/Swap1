/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduleGenerator;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author schneimd
 */
public class Config extends javax.swing.JFrame {

    private boolean firstSelection = true;
    private int numSelected = 0;
    @SuppressWarnings("rawtypes")
	private DefaultListModel[] models;
    
 // SWAP 1, TEAM 6
 // QUALITY CHANGES
    private Day sunday;
    private Day monday;
    private Day tuesday;
    private Day wednesday;
    private Day thursday;
    private Day friday;
    private Day saturday;
    
    /**
     * Used to edit days.
     *
     * @param days
     */
    @SuppressWarnings("unchecked")
	public Config(ArrayList<Day> days) {
    	this.models = new DefaultListModel[7];
        //initDyn();
        initComponents();
        
    	for(Day day: days) {
    		if(day.getNameOfDay().equals("Sunday")) {
    			day.initModel(this.models[0]);
    		} else if(day.getNameOfDay().equals("Monday")) {
    			day.initModel(this.models[1]);
    		} else if(day.getNameOfDay().equals("Tuesday")) {
    			day.initModel(this.models[2]);
    		} else if(day.getNameOfDay().equals("Wednesday")) {
    			day.initModel(this.models[3]);
    		} else if(day.getNameOfDay().equals("Thursday")) {
    			day.initModel(this.models[4]);
    		} else if(day.getNameOfDay().equals("Friday")) {
    			day.initModel(this.models[5]);
    		} else if(day.getNameOfDay().equals("Saturday")) {
    			day.initModel(this.models[6]);
    		}
    	}
    }
    
    /**
     * Creates new form.
     */
    public Config() {
        this.models = new DefaultListModel[7];
        //initDyn();
        
        initComponents();
    }
    
//    @SuppressWarnings("rawtypes")
//	private void initDyn() {
//        this.sundayScrollPane = new javax.swing.JScrollPane();
//        this.sundayScrollPane.setPreferredSize(new Dimension(185,150));
//        this.sundayJobList = new javax.swing.JList();
//        this.sundayJobName = new javax.swing.JTextField();
//        this.sundayLabel = new javax.swing.JLabel();
//        this.sundayAddJob = new javax.swing.JButton();
//        this.sundayDeleteJob = new javax.swing.JButton();
//        
//        this.mondayScrollPane = new javax.swing.JScrollPane();
//        this.mondayScrollPane.setPreferredSize(new Dimension(185,150));
//        this.mondayJobList = new javax.swing.JList();
//        this.mondayJobName = new javax.swing.JTextField();
//        this.mondayLabel = new javax.swing.JLabel();
//        this.mondayAddJob = new javax.swing.JButton();
//        this.mondayDeleteJob = new javax.swing.JButton();
//        
//        this.tuesdayScrollPane = new javax.swing.JScrollPane();
//        this.tuesdayScrollPane.setPreferredSize(new Dimension(185,150));
//        this.tuesdayJobList = new javax.swing.JList();
//        this.tuesdayJobName = new javax.swing.JTextField();
//        this.tuesdayLabel = new javax.swing.JLabel();
//        this.tuesdayAddJob = new javax.swing.JButton();
//        this.tuesdayDeleteJob = new javax.swing.JButton();
//        
//        this.wednesdayScrollPane = new javax.swing.JScrollPane();
//        this.wednesdayScrollPane.setPreferredSize(new Dimension(185,150));
//        this.wednesdayJobList = new javax.swing.JList();
//        this.wednesdayJobName = new javax.swing.JTextField();
//        this.wednesdayLabel = new javax.swing.JLabel();
//        this.wednesdayAddJob = new javax.swing.JButton();
//        this.wednesdayDeleteJob = new javax.swing.JButton();
//        
//        this.thursdayScrollPane = new javax.swing.JScrollPane();
//        this.thursdayScrollPane.setPreferredSize(new Dimension(185,150));
//        this.thursdayJobList = new javax.swing.JList();
//        this.thursdayJobName = new javax.swing.JTextField();
//        this.thursdayLabel = new javax.swing.JLabel();
//        this.thursdayAddJob = new javax.swing.JButton();
//        this.thursdayDeleteJob = new javax.swing.JButton();
//        
//        this.fridayScrollPane = new javax.swing.JScrollPane();
//        this.fridayScrollPane.setPreferredSize(new Dimension(185,150));
//        this.fridayJobList = new javax.swing.JList();
//        this.fridayJobName = new javax.swing.JTextField();
//        this.fridayLabel = new javax.swing.JLabel();
//        this.fridayAddJob = new javax.swing.JButton();
//        this.fridayDeleteJob = new javax.swing.JButton();
//        
//        this.saturdayScrollPane = new javax.swing.JScrollPane();
//        this.saturdayScrollPane.setPreferredSize(new Dimension(185,150));
//        this.saturdayJobList = new javax.swing.JList();
//        this.saturdayJobName = new javax.swing.JTextField();
//        this.saturdayLabel = new javax.swing.JLabel();
//        this.saturdayAddJob = new javax.swing.JButton();
//        this.saturdayDeleteJob = new javax.swing.JButton();
//        
//        this.mondayTab = new javax.swing.JPanel();
//        this.tuesdayTab = new javax.swing.JPanel();
//        this.wednesdayTab = new javax.swing.JPanel();
//        this.thursdayTab = new javax.swing.JPanel();
//        this.fridayTab = new javax.swing.JPanel();
//        this.saturdayTab = new javax.swing.JPanel();
//        this.sundayTab = new javax.swing.JPanel();
//    }

 // SWAP 1, TEAM 6
    // QUALITY CHANGES
    private void initComponents() {
    	
    	this.sunday = new Day("Sunday");
    	this.monday = new Day("Monday");
    	this.tuesday = new Day("Tuesday");
    	this.wednesday = new Day("Wednesday");
    	this.thursday = new Day("Thursday");
    	this.friday = new Day("Friday");
    	this.saturday = new Day("Saturday");

    	this.jPanel1 = new javax.swing.JPanel();
//        this.sundayCheck = new javax.swing.JCheckBox();
//        this.wednesdayCheck = new javax.swing.JCheckBox();
//        this.mondayCheck = new javax.swing.JCheckBox();
//        this.tuesdayCheck = new javax.swing.JCheckBox();
        this.jLabel1 = new javax.swing.JLabel();
//        this.thursdayCheck = new javax.swing.JCheckBox();
//        this.fridayCheck = new javax.swing.JCheckBox();
//        this.saturdayCheck = new javax.swing.JCheckBox();
        this.nextButton = new javax.swing.JButton();
        this.dayTabs = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Configuration");
        setPreferredSize(new java.awt.Dimension(801, 87));
        setResizable(false);

        this.sunday.getCheckBox().addActionListener(new TabListener(this, this.sunday));

        this.monday.getCheckBox().addActionListener(new TabListener(this, this.monday));

        this.tuesday.getCheckBox().addActionListener(new TabListener(this, this.tuesday));
        
        this.wednesday.getCheckBox().addActionListener(new TabListener(this, this.wednesday));
        
        this.thursday.getCheckBox().addActionListener(new TabListener(this, this.thursday));
        
        this.friday.getCheckBox().addActionListener(new TabListener(this, this.friday));
        
        this.saturday.getCheckBox().addActionListener(new TabListener(this, this.saturday));
        
        
        this.jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        this.jLabel1.setText("Days:");

        this.nextButton.setText("Next");
        this.nextButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(this.jLabel1)
                .addGap(18, 18, 18)
                .addComponent(this.sunday.getCheckBox())
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.monday.getCheckBox(), javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(this.tuesday.getCheckBox())
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.wednesday.getCheckBox(), javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(this.thursday.getCheckBox())
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.friday.getCheckBox(), javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.saturday.getCheckBox(), javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(this.nextButton)
                .addGap(78, 78, 78))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(this.sunday.getCheckBox(), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(this.friday.getCheckBox(), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(this.saturday.getCheckBox(), javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(this.nextButton))
                    .addComponent(this.wednesday.getCheckBox(), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(this.tuesday.getCheckBox(), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(this.jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(this.thursday.getCheckBox(), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(this.monday.getCheckBox(), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(this.jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
            .addComponent(this.dayTabs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(this.jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(this.dayTabs, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
        );

        this.dayTabs.getAccessibleContext().setAccessibleName("Days Tab");

        pack();
    }// </editor-fold>

    
 // SWAP 1, TEAM 6
    // QUALITY CHANGES
    /**
	 * @param evt  
	 */
    @SuppressWarnings("unchecked")
	public void dayCheckActionPerformed(Day day) {                                            
        if(day.isSelected()) {
            this.numSelected++;
            if(this.firstSelection) {
                stretch();
            }
           day.dayCheckActionPerformed();
            this.dayTabs.addTab(day.getNameOfDay(), day.getDayTab());
        } else {
            this.numSelected--;
            stretch();
            this.dayTabs.remove(day.getDayTab());
        }
        
    }                                           

   
 // SWAP 1, TEAM 6
    // QUALITY CHANGES
    private Day initDay(String name, int index){
    	ArrayList<Object> day = new ArrayList<Object>();
		List<Object> jobs = Arrays.asList(this.models[index].toArray());
		day.addAll(jobs);
    	return new Day(name, day);
    }
    
    /**
	 * @param evt  
	 */
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	ArrayList<Day> days = new ArrayList<Day>();
    	if(this.sunday.isSelected())
        {
        	days.add(this.initDay("Sunday", 0));
        }
    	if(this.monday.isSelected())
        {
    		days.add(this.initDay("Monday", 1));
        }
    	if(this.tuesday.isSelected())
        {
    		days.add(this.initDay("Tuesday", 2));
        }
    	if(this.wednesday.isSelected())
        {
    		days.add(this.initDay("Wednesday", 3));
        }
    	if(this.thursday.isSelected())
        {
    		days.add(this.initDay("Thursday", 4));
        }
    	if(this.friday.isSelected())
        {
    		days.add(this.initDay("Friday", 5));
        }
    	if(this.saturday.isSelected())
        {
    		days.add(this.initDay("Saturday", 6));
        }
    	if(days.size() > 0) {
    		boolean hasJobs = true;
    		int i = 0;
    		while(hasJobs && i<days.size()) {
    			if(days.get(i).getJobs().size() == 0) {
    				hasJobs = false;
    			}
    			i++;
    		}
    		if(hasJobs) {
		    	Main.setDays(days);
		    	Main.wSet = new WorkerSetup();
		    	Main.toggleWorkerSetup();
		    	Main.config = this;
		    	Main.toggleConfig();
    		} else {
    			JOptionPane.showMessageDialog(this, "You must have at least one job each day.");
    		}
    	} else {
    		JOptionPane.showMessageDialog(this, "You have not added any days.");
    	}
    }
    
    
    private void stretch() {
        if(this.numSelected > 0) {
            this.setSize(801, 290);
            this.firstSelection = false;
        } else {
            this.setSize(801, 87);
            this.firstSelection = true;
        }
    }
    
 // SWAP 1, TEAM 6
    // QUALITY CHANGES
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Config.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
			public void run() {
                new Config().setVisible(true);
            }
        });
    }
    
//    private javax.swing.JScrollPane sundayScrollPane;
//    private javax.swing.JButton sundayAddJob;
//    private javax.swing.JButton sundayDeleteJob;
//    @SuppressWarnings("rawtypes")
//	private javax.swing.JList sundayJobList;
//    private javax.swing.JTextField sundayJobName;
//    private javax.swing.JLabel sundayLabel;
//    private javax.swing.JPanel sundayTab;
    
    
    
//    private javax.swing.JScrollPane mondayScrollPane;
//    private javax.swing.JButton mondayAddJob;
//    private javax.swing.JButton mondayDeleteJob;
//    @SuppressWarnings("rawtypes")
//	private javax.swing.JList mondayJobList;
//    private javax.swing.JTextField mondayJobName;
//    private javax.swing.JLabel mondayLabel;
//    private javax.swing.JPanel mondayTab;
//    
//    private javax.swing.JScrollPane tuesdayScrollPane;
//    private javax.swing.JButton tuesdayAddJob;
//    private javax.swing.JButton tuesdayDeleteJob;
//    @SuppressWarnings("rawtypes")
//	private javax.swing.JList tuesdayJobList;
//    private javax.swing.JTextField tuesdayJobName;
//    private javax.swing.JLabel tuesdayLabel;
//    private javax.swing.JPanel tuesdayTab;
//    
//    private javax.swing.JScrollPane wednesdayScrollPane;
//    private javax.swing.JButton wednesdayAddJob;
//    private javax.swing.JButton wednesdayDeleteJob;
//    @SuppressWarnings("rawtypes")
//	private javax.swing.JList wednesdayJobList;
//    private javax.swing.JTextField wednesdayJobName;
//    private javax.swing.JLabel wednesdayLabel;
//    private javax.swing.JPanel wednesdayTab;
//    
//    private javax.swing.JScrollPane thursdayScrollPane;
//    private javax.swing.JButton thursdayAddJob;
//    private javax.swing.JButton thursdayDeleteJob;
//    @SuppressWarnings("rawtypes")
//	private javax.swing.JList thursdayJobList;
//    private javax.swing.JTextField thursdayJobName;
//    private javax.swing.JLabel thursdayLabel;
//    private javax.swing.JPanel thursdayTab;
//    
//    private javax.swing.JScrollPane fridayScrollPane;
//    private javax.swing.JButton fridayAddJob;
//    private javax.swing.JButton fridayDeleteJob;
//    @SuppressWarnings("rawtypes")
//	private javax.swing.JList fridayJobList;
//    private javax.swing.JTextField fridayJobName;
//    private javax.swing.JLabel fridayLabel;
//    private javax.swing.JPanel fridayTab;
//    
//    private javax.swing.JScrollPane saturdayScrollPane;
//    private javax.swing.JButton saturdayAddJob;
//    private javax.swing.JButton saturdayDeleteJob;
//    @SuppressWarnings("rawtypes")
//	private javax.swing.JList saturdayJobList;
//    private javax.swing.JTextField saturdayJobName;
//    private javax.swing.JLabel saturdayLabel;
//    private javax.swing.JPanel saturdayTab;
//    
    private javax.swing.JTabbedPane dayTabs;
//    private javax.swing.JCheckBox fridayCheck;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
//    private javax.swing.JCheckBox mondayCheck;
    private javax.swing.JButton nextButton;
//    private javax.swing.JCheckBox saturdayCheck;
//    private javax.swing.JCheckBox sundayCheck;
//    private javax.swing.JCheckBox thursdayCheck;
//    private javax.swing.JCheckBox tuesdayCheck;
//    private javax.swing.JCheckBox wednesdayCheck;
}
