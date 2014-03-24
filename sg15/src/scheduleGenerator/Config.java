/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduleGenerator;

import java.awt.Dimension;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * 
 * @author schneimd
 */
public class Config extends javax.swing.JFrame {

	private boolean firstSelection = true;
	private int numSelected = 0;
	@SuppressWarnings("rawtypes")
	private DefaultListModel[] models;

	/**
	 * QUALITY CHANGES Swap 1, Team 6
	 * 
	 * This was added as part of the refactoring for the Config Constructor.
	 * This allows us to remove duplication of Initialization of the Swing
	 * Objects for the various days. This also enables refactoring for each
	 * method that applies the same procedure to the different Swing Components
	 * of each day (i.e. get rid of case statements and methods that vary based
	 * on the name of the day only)
	 * 
	 */
	private HashMap<String, JCheckBox> daysChecked = new HashMap<String, JCheckBox>();
	private HashMap<String, JList> daysList = new HashMap<String, JList>();
	private HashMap<String, JScrollPane> daysScrollPane = new HashMap<String, JScrollPane>();
	private HashMap<String, JTextField> daysTextField = new HashMap<String, JTextField>();
	private HashMap<String, JButton> daysAdd = new HashMap<String, JButton>();
	private HashMap<String, JButton> daysDelete = new HashMap<String, JButton>();
	private HashMap<String, JLabel> daysLabel = new HashMap<String, JLabel>();
	private HashMap<String, JPanel> daysPanelTab = new HashMap<String, JPanel>();

	private String[] daysOfWeek = { "Sunday", "Monday", "Tuesday", "Wednesday",
			"Thursday", "Friday", "Saturday" };

	public int getDayNum(Day day) {

		int dayNum = 0;
		if (day.getNameOfDay().equals("Sunday")) {
			dayNum = 0;
		} else if (day.getNameOfDay().equals("Monday")) {
			dayNum = 1;
		} else if (day.getNameOfDay().equals("Tuesday")) {
			dayNum = 2;
		} else if (day.getNameOfDay().equals("Wednesday")) {
			dayNum = 3;
		} else if (day.getNameOfDay().equals("Thursday")) {
			dayNum = 4;
		} else if (day.getNameOfDay().equals("Friday")) {
			dayNum = 5;
		} else if (day.getNameOfDay().equals("Saturday")) {
			dayNum = 6;
		}
		return dayNum;
	}

	/**
	 * QUALITY CHANGES Swap 1, Team 6
	 * 
	 * Using the various HashMaps initialized we removed duplicate code from
	 * determining which days have been selected.This allowed us to get rid of
	 * the case statements and perform the entire function in a single for loop.
	 * For future use this will make any changes to the constructor affecting
	 * the individual days quicker and easier to locate. Now we only apply
	 * changes once rather than once for each day.
	 * 
	 */

	/**
	 * Used to edit days.
	 * 
	 * @param days
	 */
	@SuppressWarnings("unchecked")
	public Config(ArrayList<Day> days) {
		this.models = new DefaultListModel[7];
		initDyn();
		initComponents();

		for (Day day : days) {
			ArrayList<String> jobs = day.getJobs();
			this.daysChecked.get(day.getNameOfDay()).doClick();
			for (String job : jobs) {
				this.models[this.getDayNum(day)].addElement(job);
				this.daysList.get(day.getNameOfDay()).setModel(
						this.models[this.getDayNum(day)]);
			}
		}
	}

	/**
	 * Creates new form.
	 */
	public Config() {
		this.models = new DefaultListModel[7];
		initDyn();

		initComponents();
	}

	/**
	 * QUALITY CHANGES Swap 1, Team 6
	 * 
	 * Using the various HashMaps initialized we removed duplicate code for
	 * initialization. If any new day or parameter for a day is created, it is
	 * simple make make that change among all the days.
	 * 
	 */
	@SuppressWarnings("rawtypes")
	private void initDyn() {

		for (String day : daysOfWeek) {

			this.daysAdd.put(day, new JButton());
			this.daysDelete.put(day, new JButton());
			this.daysScrollPane.put(day, new JScrollPane());
			this.daysScrollPane.get(day).setPreferredSize(
					new Dimension(185, 150));
			this.daysList.put(day, new JList());
			this.daysLabel.put(day, new JLabel());
			this.daysTextField.put(day, new JTextField());
			this.daysChecked.put(day, new JCheckBox());
			this.daysPanelTab.put(day, new JPanel());
		}

	}

	private void initComponents() {

		this.jPanel1 = new javax.swing.JPanel();
		this.jLabel1 = new javax.swing.JLabel();
		this.nextButton = new javax.swing.JButton();
		this.dayTabs = new javax.swing.JTabbedPane();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Configuration");
		setPreferredSize(new java.awt.Dimension(801, 87));
		setResizable(false);

		this.daysChecked.get("Sunday").setText("Sunday");
		this.daysChecked.get("Sunday").setName("sundayCheck"); // NOI18N
		this.daysChecked.get("Sunday").addActionListener(
				new java.awt.event.ActionListener() {
					@Override
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						sundayCheckActionPerformed(evt);
					}
				});

		this.daysChecked.get("Wednesday").setText("Wednesday");
		this.daysChecked.get("Wednesday").setName("wednesdayCheck"); // NOI18N
		this.daysChecked.get("Wednesday").addActionListener(
				new java.awt.event.ActionListener() {
					@Override
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						wednesdayCheckActionPerformed(evt);
					}
				});

		this.daysChecked.get("Monday").setText("Monday");
		this.daysChecked.get("Monday").setName("mondayCheck"); // NOI18N
		this.daysChecked.get("Monday").addActionListener(
				new java.awt.event.ActionListener() {
					@Override
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						mondayCheckActionPerformed(evt);
					}
				});

		this.daysChecked.get("Tuesday").setText("Tuesday");
		this.daysChecked.get("Tuesday").setName("tuesdayCheck"); // NOI18N
		this.daysChecked.get("Tuesday").addActionListener(
				new java.awt.event.ActionListener() {
					@Override
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						tuesdayCheckActionPerformed(evt);
					}
				});

		this.jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		this.jLabel1.setText("Days:");

		this.daysChecked.get("Thursday").setText("Thursday");
		this.daysChecked.get("Thursday").setName("thursdayCheck"); // NOI18N
		this.daysChecked.get("Thursday").addActionListener(
				new java.awt.event.ActionListener() {
					@Override
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						thursdayCheckActionPerformed(evt);
					}
				});

		this.daysChecked.get("Friday").setText("Friday");
		this.daysChecked.get("Friday").setName("fridayCheck"); // NOI18N
		this.daysChecked.get("Friday").addActionListener(
				new java.awt.event.ActionListener() {
					@Override
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						fridayCheckActionPerformed(evt);
					}
				});

		this.daysChecked.get("Saturday").setText("Saturday");
		this.daysChecked.get("Saturday").setName("saturdayCheck"); // NOI18N
		this.daysChecked.get("Saturday").addActionListener(
				new java.awt.event.ActionListener() {
					@Override
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						saturdayCheckActionPerformed(evt);
					}
				});

		this.nextButton.setText("Next");
		this.nextButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nextButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				this.jPanel1);
		this.jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(this.jLabel1)
										.addGap(18, 18, 18)
										.addComponent(
												this.daysChecked.get("Sunday"))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												this.daysChecked.get("Monday"),
												javax.swing.GroupLayout.PREFERRED_SIZE,
												71,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												this.daysChecked.get("Tuesday"))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												this.daysChecked
														.get("Wednesday"),
												javax.swing.GroupLayout.PREFERRED_SIZE,
												100,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												this.daysChecked
														.get("Thursday"))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												this.daysChecked.get("Friday"),
												javax.swing.GroupLayout.PREFERRED_SIZE,
												65,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												this.daysChecked
														.get("Saturday"),
												javax.swing.GroupLayout.PREFERRED_SIZE,
												100,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(this.nextButton)
										.addGap(78, 78, 78)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																this.daysChecked
																		.get("Sunday"),
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																jPanel1Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				this.daysChecked
																						.get("Friday"),
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				this.daysChecked
																						.get("Saturday"),
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				33,
																				Short.MAX_VALUE)
																		.addComponent(
																				this.nextButton))
														.addComponent(
																this.daysChecked
																		.get("Wednesday"),
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																this.daysChecked
																		.get("Tuesday"),
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				this.jLabel1)
																		.addGap(0,
																				0,
																				Short.MAX_VALUE))
														.addComponent(
																this.daysChecked
																		.get("Thursday"),
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																this.daysChecked
																		.get("Monday"),
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(this.jPanel1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 18, Short.MAX_VALUE))
				.addComponent(this.dayTabs));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(this.jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(this.dayTabs,
								javax.swing.GroupLayout.DEFAULT_SIZE, 196,
								Short.MAX_VALUE)));

		this.dayTabs.getAccessibleContext().setAccessibleName("Days Tab");

		pack();
	}// </editor-fold>

	/**
	 * SWAP 1, TEAM 6
	 * 
	 * sundayCheckActionPerformed through saturdayCheckActionPerformed
	 * 
	 * SMELL: Duplicate Code - the code is duplicated for every day of the week. The only difference between each function is the 
	 * global variable used throughout the function. This can be refactored by fully utilizing the HashMaps for each component. This
	 * would allow a single function to perform the functionality for each global variable in a for loop.
	 */
	
	/**
	 * SWAP 1, TEAM 6
	 * 
	 * sundayCheckActionPerformed through saturdayCheckActionPerformed
	 * 
	 * SMELL: Shotgun Surgery - the code, due to the large duplication, any change made to these functions must be done for each day
	 * of the week, even if the change is minor.  When following the refactoring idea above for the previous smell, this smell would also
	 * be fixed, as merging them all into a single function would allow to only need to make each change once.
	 */
	
	/**
	 * @param evt
	 */
	@SuppressWarnings("unchecked")
	private void sundayCheckActionPerformed(java.awt.event.ActionEvent evt) {
		if (this.daysChecked.get("Sunday").isSelected()) {
			this.numSelected++;
			if (this.firstSelection) {
				stretch();
			}
			this.models[0] = new DefaultListModel();
			this.daysList.get("Sunday").setModel(this.models[0]);
			this.daysScrollPane.get("Sunday").setViewportView(
					this.daysList.get("Sunday"));

			this.daysTextField.get("Sunday").setColumns(20);

			this.daysLabel.get("Sunday").setText("Job Name:");

			this.daysAdd.get("Sunday").setText("Add Job");
			this.daysAdd.get("Sunday").addActionListener(
					new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(
								java.awt.event.ActionEvent evt) {
							if (!Config.this.daysTextField.get("Sunday")
									.getText().isEmpty()) {
								Config.this.models[0]
										.addElement(Config.this.daysTextField
												.get("Sunday").getText());
								Config.this.daysList.get("Sunday").setModel(
										Config.this.models[0]);
								Config.this.daysTextField.get("Sunday")
										.setText("");
							}
						}
					});

			this.daysDelete.get("Sunday").setText("Delete Job");
			this.daysDelete.get("Sunday").addActionListener(
					new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(
								java.awt.event.ActionEvent evt) {
							while (!Config.this.daysList.get("Sunday")
									.isSelectionEmpty()) {
								int n = Config.this.daysList.get("Sunday")
										.getSelectedIndex();
								Config.this.models[0].remove(n);
							}

						}
					});

			javax.swing.GroupLayout sundayTabLayout = new javax.swing.GroupLayout(
					this.daysPanelTab.get("Sunday"));
			this.daysPanelTab.get("Sunday").setLayout(sundayTabLayout);
			sundayTabLayout
					.setHorizontalGroup(sundayTabLayout
							.createParallelGroup(
									javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(
									sundayTabLayout
											.createSequentialGroup()
											.addContainerGap()
											.addComponent(
													this.daysScrollPane
															.get("Sunday"),
													javax.swing.GroupLayout.PREFERRED_SIZE,
													182,
													javax.swing.GroupLayout.PREFERRED_SIZE)
											.addGap(18, 18, 18)
											.addGroup(
													sundayTabLayout
															.createParallelGroup(
																	javax.swing.GroupLayout.Alignment.LEADING)
															.addGroup(
																	sundayTabLayout
																			.createSequentialGroup()
																			.addComponent(
																					this.daysLabel
																							.get("Sunday"))
																			.addGroup(
																					sundayTabLayout
																							.createParallelGroup(
																									javax.swing.GroupLayout.Alignment.LEADING)
																							.addGroup(
																									sundayTabLayout
																											.createSequentialGroup()
																											.addGap(14,
																													14,
																													14)
																											.addComponent(
																													this.daysAdd
																															.get("Sunday")))
																							.addGroup(
																									sundayTabLayout
																											.createSequentialGroup()
																											.addPreferredGap(
																													javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																											.addComponent(
																													this.daysTextField
																															.get("Sunday"),
																													javax.swing.GroupLayout.PREFERRED_SIZE,
																													100,
																													javax.swing.GroupLayout.PREFERRED_SIZE))))
															.addComponent(
																	this.daysDelete
																			.get("Sunday")))
											.addContainerGap(431,
													Short.MAX_VALUE)));
			sundayTabLayout
					.setVerticalGroup(sundayTabLayout
							.createParallelGroup(
									javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(
									sundayTabLayout
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													sundayTabLayout
															.createParallelGroup(
																	javax.swing.GroupLayout.Alignment.LEADING,
																	false)
															.addGroup(
																	sundayTabLayout
																			.createSequentialGroup()
																			.addGroup(
																					sundayTabLayout
																							.createParallelGroup(
																									javax.swing.GroupLayout.Alignment.BASELINE)
																							.addComponent(
																									this.daysTextField
																											.get("Sunday"),
																									javax.swing.GroupLayout.PREFERRED_SIZE,
																									javax.swing.GroupLayout.DEFAULT_SIZE,
																									javax.swing.GroupLayout.PREFERRED_SIZE)
																							.addComponent(
																									this.daysLabel
																											.get("Sunday")))
																			.addPreferredGap(
																					javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																			.addComponent(
																					this.daysAdd
																							.get("Sunday"))
																			.addPreferredGap(
																					javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																					javax.swing.GroupLayout.DEFAULT_SIZE,
																					Short.MAX_VALUE)
																			.addComponent(
																					this.daysDelete
																							.get("Sunday")))
															.addComponent(
																	this.daysScrollPane
																			.get("Sunday"),
																	javax.swing.GroupLayout.PREFERRED_SIZE,
																	javax.swing.GroupLayout.DEFAULT_SIZE,
																	javax.swing.GroupLayout.PREFERRED_SIZE))
											.addContainerGap(25,
													Short.MAX_VALUE)));
			this.dayTabs.addTab("Sunday", this.daysPanelTab.get("Sunday"));
		} else {
			this.numSelected--;
			stretch();
			this.dayTabs.remove(this.daysPanelTab.get("Sunday"));
		}

	}

	/**
	 * @param evt
	 */
	@SuppressWarnings("unchecked")
	private void mondayCheckActionPerformed(java.awt.event.ActionEvent evt) {
		if (this.daysChecked.get("Monday").isSelected()) {
			this.numSelected++;
			if (this.firstSelection) {
				stretch();
			}
			this.models[1] = new DefaultListModel();
			this.daysList.get("Monday").setModel(this.models[1]);
			this.daysScrollPane.get("Monday").setViewportView(
					this.daysList.get("Monday"));

			this.daysTextField.get("Monday").setColumns(20);

			this.daysLabel.get("Monday").setText("Job Name:");

			this.daysAdd.get("Monday").setText("Add Job");
			this.daysAdd.get("Monday").addActionListener(
					new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(
								java.awt.event.ActionEvent evt) {
							if (!Config.this.daysTextField.get("Monday")
									.getText().isEmpty()) {
								Config.this.models[1]
										.addElement(Config.this.daysTextField
												.get("Monday").getText());
								Config.this.daysList.get("Monday").setModel(
										Config.this.models[1]);
								Config.this.daysTextField.get("Monday")
										.setText("");
							}
						}
					});

			this.daysDelete.get("Monday").setText("Delete Job");
			this.daysDelete.get("Monday").addActionListener(
					new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(
								java.awt.event.ActionEvent evt) {
							while (!Config.this.daysList.get("Monday")
									.isSelectionEmpty()) {
								int n = Config.this.daysList.get("Monday")
										.getSelectedIndex();
								Config.this.models[1].remove(n);
							}

						}
					});

			javax.swing.GroupLayout mondayTabLayout = new javax.swing.GroupLayout(
					this.daysPanelTab.get("Monday"));
			this.daysPanelTab.get("Monday").setLayout(mondayTabLayout);
			mondayTabLayout
					.setHorizontalGroup(mondayTabLayout
							.createParallelGroup(
									javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(
									mondayTabLayout
											.createSequentialGroup()
											.addContainerGap()
											.addComponent(
													this.daysScrollPane
															.get("Monday"),
													javax.swing.GroupLayout.PREFERRED_SIZE,
													182,
													javax.swing.GroupLayout.PREFERRED_SIZE)
											.addGap(18, 18, 18)
											.addGroup(
													mondayTabLayout
															.createParallelGroup(
																	javax.swing.GroupLayout.Alignment.LEADING)
															.addGroup(
																	mondayTabLayout
																			.createSequentialGroup()
																			.addComponent(
																					this.daysLabel
																							.get("Monday"))
																			.addGroup(
																					mondayTabLayout
																							.createParallelGroup(
																									javax.swing.GroupLayout.Alignment.LEADING)
																							.addGroup(
																									mondayTabLayout
																											.createSequentialGroup()
																											.addGap(14,
																													14,
																													14)
																											.addComponent(
																													this.daysAdd
																															.get("Monday")))
																							.addGroup(
																									mondayTabLayout
																											.createSequentialGroup()
																											.addPreferredGap(
																													javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																											.addComponent(
																													this.daysTextField
																															.get("Monday"),
																													javax.swing.GroupLayout.PREFERRED_SIZE,
																													100,
																													javax.swing.GroupLayout.PREFERRED_SIZE))))
															.addComponent(
																	this.daysDelete
																			.get("Monday")))
											.addContainerGap(431,
													Short.MAX_VALUE)));
			mondayTabLayout
					.setVerticalGroup(mondayTabLayout
							.createParallelGroup(
									javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(
									mondayTabLayout
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													mondayTabLayout
															.createParallelGroup(
																	javax.swing.GroupLayout.Alignment.LEADING,
																	false)
															.addGroup(
																	mondayTabLayout
																			.createSequentialGroup()
																			.addGroup(
																					mondayTabLayout
																							.createParallelGroup(
																									javax.swing.GroupLayout.Alignment.BASELINE)
																							.addComponent(
																									this.daysTextField
																											.get("Monday"),
																									javax.swing.GroupLayout.PREFERRED_SIZE,
																									javax.swing.GroupLayout.DEFAULT_SIZE,
																									javax.swing.GroupLayout.PREFERRED_SIZE)
																							.addComponent(
																									this.daysLabel
																											.get("Monday")))
																			.addPreferredGap(
																					javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																			.addComponent(
																					this.daysAdd
																							.get("Monday"))
																			.addPreferredGap(
																					javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																					javax.swing.GroupLayout.DEFAULT_SIZE,
																					Short.MAX_VALUE)
																			.addComponent(
																					this.daysDelete
																							.get("Monday")))
															.addComponent(
																	this.daysScrollPane
																			.get("Monday"),
																	javax.swing.GroupLayout.PREFERRED_SIZE,
																	javax.swing.GroupLayout.DEFAULT_SIZE,
																	javax.swing.GroupLayout.PREFERRED_SIZE))
											.addContainerGap(25,
													Short.MAX_VALUE)));
			this.dayTabs.addTab("Monday", this.daysPanelTab.get("Monday"));
		} else {
			this.numSelected--;
			stretch();
			this.dayTabs.remove(this.daysPanelTab.get("Monday"));
		}

	}

	/**
	 * @param evt
	 */
	@SuppressWarnings("unchecked")
	private void tuesdayCheckActionPerformed(java.awt.event.ActionEvent evt) {
		if (this.daysChecked.get("Tuesday").isSelected()) {
			this.numSelected++;
			if (this.firstSelection) {
				stretch();
			}
			this.models[2] = new DefaultListModel();
			this.daysList.get("Tuesday").setModel(this.models[2]);
			this.daysScrollPane.get("Tuesday").setViewportView(
					this.daysList.get("Tuesday"));

			this.daysTextField.get("Tuesday").setColumns(20);

			this.daysLabel.get("Tuesday").setText("Job Name:");

			this.daysAdd.get("Tuesday").setText("Add Job");
			this.daysAdd.get("Tuesday").addActionListener(
					new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(
								java.awt.event.ActionEvent evt) {
							if (!Config.this.daysTextField.get("Tuesday")
									.getText().isEmpty()) {
								Config.this.models[2]
										.addElement(Config.this.daysTextField
												.get("Tuesday").getText());
								Config.this.daysList.get("Tuesday").setModel(
										Config.this.models[2]);
								Config.this.daysTextField.get("Tuesday")
										.setText("");
							}
						}
					});

			this.daysDelete.get("Tuesday").setText("Delete Job");
			this.daysDelete.get("Tuesday").addActionListener(
					new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(
								java.awt.event.ActionEvent evt) {
							while (!Config.this.daysList.get("Tuesday")
									.isSelectionEmpty()) {
								int n = Config.this.daysList.get("Tuesday")
										.getSelectedIndex();
								Config.this.models[2].remove(n);
							}

						}
					});

			javax.swing.GroupLayout tuesdayTabLayout = new javax.swing.GroupLayout(
					this.daysPanelTab.get("Tuesday"));
			this.daysPanelTab.get("Tuesday").setLayout(tuesdayTabLayout);
			tuesdayTabLayout
					.setHorizontalGroup(tuesdayTabLayout
							.createParallelGroup(
									javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(
									tuesdayTabLayout
											.createSequentialGroup()
											.addContainerGap()
											.addComponent(
													this.daysScrollPane
															.get("Tuesday"),
													javax.swing.GroupLayout.PREFERRED_SIZE,
													182,
													javax.swing.GroupLayout.PREFERRED_SIZE)
											.addGap(18, 18, 18)
											.addGroup(
													tuesdayTabLayout
															.createParallelGroup(
																	javax.swing.GroupLayout.Alignment.LEADING)
															.addGroup(
																	tuesdayTabLayout
																			.createSequentialGroup()
																			.addComponent(
																					this.daysLabel
																							.get("Tuesday"))
																			.addGroup(
																					tuesdayTabLayout
																							.createParallelGroup(
																									javax.swing.GroupLayout.Alignment.LEADING)
																							.addGroup(
																									tuesdayTabLayout
																											.createSequentialGroup()
																											.addGap(14,
																													14,
																													14)
																											.addComponent(
																													this.daysAdd
																															.get("Tuesday")))
																							.addGroup(
																									tuesdayTabLayout
																											.createSequentialGroup()
																											.addPreferredGap(
																													javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																											.addComponent(
																													this.daysTextField
																															.get("Tuesday"),
																													javax.swing.GroupLayout.PREFERRED_SIZE,
																													100,
																													javax.swing.GroupLayout.PREFERRED_SIZE))))
															.addComponent(
																	this.daysDelete
																			.get("Tuesday")))
											.addContainerGap(431,
													Short.MAX_VALUE)));
			tuesdayTabLayout
					.setVerticalGroup(tuesdayTabLayout
							.createParallelGroup(
									javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(
									tuesdayTabLayout
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													tuesdayTabLayout
															.createParallelGroup(
																	javax.swing.GroupLayout.Alignment.LEADING,
																	false)
															.addGroup(
																	tuesdayTabLayout
																			.createSequentialGroup()
																			.addGroup(
																					tuesdayTabLayout
																							.createParallelGroup(
																									javax.swing.GroupLayout.Alignment.BASELINE)
																							.addComponent(
																									this.daysTextField
																											.get("Tuesday"),
																									javax.swing.GroupLayout.PREFERRED_SIZE,
																									javax.swing.GroupLayout.DEFAULT_SIZE,
																									javax.swing.GroupLayout.PREFERRED_SIZE)
																							.addComponent(
																									this.daysLabel
																											.get("Tuesday")))
																			.addPreferredGap(
																					javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																			.addComponent(
																					this.daysAdd
																							.get("Tuesday"))
																			.addPreferredGap(
																					javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																					javax.swing.GroupLayout.DEFAULT_SIZE,
																					Short.MAX_VALUE)
																			.addComponent(
																					this.daysDelete
																							.get("Tuesday")))
															.addComponent(
																	this.daysScrollPane
																			.get("Tuesday"),
																	javax.swing.GroupLayout.PREFERRED_SIZE,
																	javax.swing.GroupLayout.DEFAULT_SIZE,
																	javax.swing.GroupLayout.PREFERRED_SIZE))
											.addContainerGap(25,
													Short.MAX_VALUE)));
			this.dayTabs.addTab("Tuesday", this.daysPanelTab.get("Tuesday"));
		} else {
			this.numSelected--;
			stretch();
			this.dayTabs.remove(this.daysPanelTab.get("Tuesday"));
		}
	}

	/**
	 * @param evt
	 */
	@SuppressWarnings("unchecked")
	private void wednesdayCheckActionPerformed(java.awt.event.ActionEvent evt) {
		if (this.daysChecked.get("Wednesday").isSelected()) {
			this.numSelected++;
			if (this.firstSelection) {
				stretch();
			}
			this.models[3] = new DefaultListModel();
			this.daysList.get("Wednesday").setModel(this.models[3]);
			this.daysScrollPane.get("Wednesday").setViewportView(
					this.daysList.get("Wednesday"));

			this.daysTextField.get("Wednesday").setColumns(20);

			this.daysLabel.get("Wednesday").setText("Job Name:");

			this.daysAdd.get("Wednesday").setText("Add Job");
			this.daysAdd.get("Wednesday").addActionListener(
					new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(
								java.awt.event.ActionEvent evt) {
							if (!Config.this.daysTextField.get("Wednesday")
									.getText().isEmpty()) {
								Config.this.models[3]
										.addElement(Config.this.daysTextField
												.get("Wednesday").getText());
								Config.this.daysList.get("Wednesday").setModel(
										Config.this.models[3]);
								Config.this.daysTextField.get("Wednesday")
										.setText("");
							}
						}
					});

			this.daysDelete.get("Wednesday").setText("Delete Job");
			this.daysDelete.get("Wednesday").addActionListener(
					new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(
								java.awt.event.ActionEvent evt) {
							while (!Config.this.daysList.get("Wednesday")
									.isSelectionEmpty()) {
								int n = Config.this.daysList.get("Wednesday")
										.getSelectedIndex();
								Config.this.models[3].remove(n);
							}

						}
					});

			javax.swing.GroupLayout wednesdayTabLayout = new javax.swing.GroupLayout(
					this.daysPanelTab.get("Wednesday"));
			this.daysPanelTab.get("Wednesday").setLayout(wednesdayTabLayout);
			wednesdayTabLayout
					.setHorizontalGroup(wednesdayTabLayout
							.createParallelGroup(
									javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(
									wednesdayTabLayout
											.createSequentialGroup()
											.addContainerGap()
											.addComponent(
													this.daysScrollPane
															.get("Wednesday"),
													javax.swing.GroupLayout.PREFERRED_SIZE,
													182,
													javax.swing.GroupLayout.PREFERRED_SIZE)
											.addGap(18, 18, 18)
											.addGroup(
													wednesdayTabLayout
															.createParallelGroup(
																	javax.swing.GroupLayout.Alignment.LEADING)
															.addGroup(
																	wednesdayTabLayout
																			.createSequentialGroup()
																			.addComponent(
																					this.daysLabel
																							.get("Wednesday"))
																			.addGroup(
																					wednesdayTabLayout
																							.createParallelGroup(
																									javax.swing.GroupLayout.Alignment.LEADING)
																							.addGroup(
																									wednesdayTabLayout
																											.createSequentialGroup()
																											.addGap(14,
																													14,
																													14)
																											.addComponent(
																													this.daysAdd
																															.get("Wednesday")))
																							.addGroup(
																									wednesdayTabLayout
																											.createSequentialGroup()
																											.addPreferredGap(
																													javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																											.addComponent(
																													this.daysTextField
																															.get("Wednesday"),
																													javax.swing.GroupLayout.PREFERRED_SIZE,
																													100,
																													javax.swing.GroupLayout.PREFERRED_SIZE))))
															.addComponent(
																	this.daysDelete
																			.get("Wednesday")))
											.addContainerGap(431,
													Short.MAX_VALUE)));
			wednesdayTabLayout
					.setVerticalGroup(wednesdayTabLayout
							.createParallelGroup(
									javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(
									wednesdayTabLayout
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													wednesdayTabLayout
															.createParallelGroup(
																	javax.swing.GroupLayout.Alignment.LEADING,
																	false)
															.addGroup(
																	wednesdayTabLayout
																			.createSequentialGroup()
																			.addGroup(
																					wednesdayTabLayout
																							.createParallelGroup(
																									javax.swing.GroupLayout.Alignment.BASELINE)
																							.addComponent(
																									this.daysTextField
																											.get("Wednesday"),
																									javax.swing.GroupLayout.PREFERRED_SIZE,
																									javax.swing.GroupLayout.DEFAULT_SIZE,
																									javax.swing.GroupLayout.PREFERRED_SIZE)
																							.addComponent(
																									this.daysLabel
																											.get("Wednesday")))
																			.addPreferredGap(
																					javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																			.addComponent(
																					this.daysAdd
																							.get("Wednesday"))
																			.addPreferredGap(
																					javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																					javax.swing.GroupLayout.DEFAULT_SIZE,
																					Short.MAX_VALUE)
																			.addComponent(
																					this.daysDelete
																							.get("Wednesday")))
															.addComponent(
																	this.daysScrollPane
																			.get("Wednesday"),
																	javax.swing.GroupLayout.PREFERRED_SIZE,
																	javax.swing.GroupLayout.DEFAULT_SIZE,
																	javax.swing.GroupLayout.PREFERRED_SIZE))
											.addContainerGap(25,
													Short.MAX_VALUE)));
			this.dayTabs
					.addTab("Wednesday", this.daysPanelTab.get("Wednesday"));
		} else {
			this.numSelected--;
			stretch();
			this.dayTabs.remove(this.daysPanelTab.get("Wednesday"));
		}

	}

	/**
	 * @param evt
	 */
	@SuppressWarnings("unchecked")
	private void thursdayCheckActionPerformed(java.awt.event.ActionEvent evt) {
		if (this.daysChecked.get("Thursday").isSelected()) {
			this.numSelected++;
			if (this.firstSelection) {
				stretch();
			}
			this.models[4] = new DefaultListModel();
			this.daysList.get("Thursday").setModel(this.models[4]);
			this.daysScrollPane.get("Thursday").setViewportView(
					this.daysList.get("Thursday"));

			this.daysTextField.get("Thursday").setColumns(20);

			this.daysLabel.get("Thursday").setText("Job Name:");

			this.daysAdd.get("Thursday").setText("Add Job");
			this.daysAdd.get("Thursday").addActionListener(
					new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(
								java.awt.event.ActionEvent evt) {
							if (!Config.this.daysTextField.get("Thursday")
									.getText().isEmpty()) {
								Config.this.models[4]
										.addElement(Config.this.daysTextField
												.get("Thursday").getText());
								Config.this.daysList.get("Thursday").setModel(
										Config.this.models[4]);
								Config.this.daysTextField.get("Thursday")
										.setText("");
							}
						}
					});

			this.daysDelete.get("Thursday").setText("Delete Job");
			this.daysDelete.get("Thursday").addActionListener(
					new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(
								java.awt.event.ActionEvent evt) {
							while (!Config.this.daysList.get("Thursday")
									.isSelectionEmpty()) {
								int n = Config.this.daysList.get("Thursday")
										.getSelectedIndex();
								Config.this.models[4].remove(n);
							}

						}
					});

			javax.swing.GroupLayout thursdayTabLayout = new javax.swing.GroupLayout(
					this.daysPanelTab.get("Thursday"));
			this.daysPanelTab.get("Thursday").setLayout(thursdayTabLayout);
			thursdayTabLayout
					.setHorizontalGroup(thursdayTabLayout
							.createParallelGroup(
									javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(
									thursdayTabLayout
											.createSequentialGroup()
											.addContainerGap()
											.addComponent(
													this.daysScrollPane
															.get("Thursday"),
													javax.swing.GroupLayout.PREFERRED_SIZE,
													182,
													javax.swing.GroupLayout.PREFERRED_SIZE)
											.addGap(18, 18, 18)
											.addGroup(
													thursdayTabLayout
															.createParallelGroup(
																	javax.swing.GroupLayout.Alignment.LEADING)
															.addGroup(
																	thursdayTabLayout
																			.createSequentialGroup()
																			.addComponent(
																					this.daysLabel
																							.get("Thursday"))
																			.addGroup(
																					thursdayTabLayout
																							.createParallelGroup(
																									javax.swing.GroupLayout.Alignment.LEADING)
																							.addGroup(
																									thursdayTabLayout
																											.createSequentialGroup()
																											.addGap(14,
																													14,
																													14)
																											.addComponent(
																													this.daysAdd
																															.get("Thursday")))
																							.addGroup(
																									thursdayTabLayout
																											.createSequentialGroup()
																											.addPreferredGap(
																													javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																											.addComponent(
																													this.daysTextField
																															.get("Thursday"),
																													javax.swing.GroupLayout.PREFERRED_SIZE,
																													100,
																													javax.swing.GroupLayout.PREFERRED_SIZE))))
															.addComponent(
																	this.daysDelete
																			.get("Thursday")))
											.addContainerGap(431,
													Short.MAX_VALUE)));
			thursdayTabLayout
					.setVerticalGroup(thursdayTabLayout
							.createParallelGroup(
									javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(
									thursdayTabLayout
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													thursdayTabLayout
															.createParallelGroup(
																	javax.swing.GroupLayout.Alignment.LEADING,
																	false)
															.addGroup(
																	thursdayTabLayout
																			.createSequentialGroup()
																			.addGroup(
																					thursdayTabLayout
																							.createParallelGroup(
																									javax.swing.GroupLayout.Alignment.BASELINE)
																							.addComponent(
																									this.daysTextField
																											.get("Thursday"),
																									javax.swing.GroupLayout.PREFERRED_SIZE,
																									javax.swing.GroupLayout.DEFAULT_SIZE,
																									javax.swing.GroupLayout.PREFERRED_SIZE)
																							.addComponent(
																									this.daysLabel
																											.get("Thursday")))
																			.addPreferredGap(
																					javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																			.addComponent(
																					this.daysAdd
																							.get("Thursday"))
																			.addPreferredGap(
																					javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																					javax.swing.GroupLayout.DEFAULT_SIZE,
																					Short.MAX_VALUE)
																			.addComponent(
																					this.daysDelete
																							.get("Thursday")))
															.addComponent(
																	this.daysScrollPane
																			.get("Thursday"),
																	javax.swing.GroupLayout.PREFERRED_SIZE,
																	javax.swing.GroupLayout.DEFAULT_SIZE,
																	javax.swing.GroupLayout.PREFERRED_SIZE))
											.addContainerGap(25,
													Short.MAX_VALUE)));
			this.dayTabs.addTab("Thursday", this.daysPanelTab.get("Thursday"));
		} else {
			this.numSelected--;
			stretch();
			this.dayTabs.remove(this.daysPanelTab.get("Thursday"));
		}

	}

	/**
	 * @param evt
	 */
	@SuppressWarnings("unchecked")
	private void fridayCheckActionPerformed(java.awt.event.ActionEvent evt) {
		if (this.daysChecked.get("Friday").isSelected()) {
			this.numSelected++;
			if (this.firstSelection) {
				stretch();
			}
			this.models[5] = new DefaultListModel();
			this.daysList.get("Friday").setModel(this.models[5]);
			this.daysScrollPane.get("Friday").setViewportView(
					this.daysList.get("Friday"));

			this.daysTextField.get("Friday").setColumns(20);

			this.daysLabel.get("Friday").setText("Job Name:");

			this.daysAdd.get("Friday").setText("Add Job");
			this.daysAdd.get("Friday").addActionListener(
					new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(
								java.awt.event.ActionEvent evt) {
							if (!Config.this.daysTextField.get("Friday")
									.getText().isEmpty()) {
								Config.this.models[5]
										.addElement(Config.this.daysTextField
												.get("Friday").getText());
								Config.this.daysList.get("Friday").setModel(
										Config.this.models[5]);
								Config.this.daysTextField.get("Friday")
										.setText("");
							}
						}
					});

			this.daysDelete.get("Friday").setText("Delete Job");
			this.daysDelete.get("Friday").addActionListener(
					new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(
								java.awt.event.ActionEvent evt) {
							while (!Config.this.daysList.get("Friday")
									.isSelectionEmpty()) {
								int n = Config.this.daysList.get("Friday")
										.getSelectedIndex();
								Config.this.models[5].remove(n);
							}

						}
					});

			javax.swing.GroupLayout fridayTabLayout = new javax.swing.GroupLayout(
					this.daysPanelTab.get("Friday"));
			this.daysPanelTab.get("Friday").setLayout(fridayTabLayout);
			fridayTabLayout
					.setHorizontalGroup(fridayTabLayout
							.createParallelGroup(
									javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(
									fridayTabLayout
											.createSequentialGroup()
											.addContainerGap()
											.addComponent(
													this.daysScrollPane
															.get("Friday"),
													javax.swing.GroupLayout.PREFERRED_SIZE,
													182,
													javax.swing.GroupLayout.PREFERRED_SIZE)
											.addGap(18, 18, 18)
											.addGroup(
													fridayTabLayout
															.createParallelGroup(
																	javax.swing.GroupLayout.Alignment.LEADING)
															.addGroup(
																	fridayTabLayout
																			.createSequentialGroup()
																			.addComponent(
																					this.daysLabel
																							.get("Friday"))
																			.addGroup(
																					fridayTabLayout
																							.createParallelGroup(
																									javax.swing.GroupLayout.Alignment.LEADING)
																							.addGroup(
																									fridayTabLayout
																											.createSequentialGroup()
																											.addGap(14,
																													14,
																													14)
																											.addComponent(
																													this.daysAdd
																															.get("Friday")))
																							.addGroup(
																									fridayTabLayout
																											.createSequentialGroup()
																											.addPreferredGap(
																													javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																											.addComponent(
																													this.daysTextField
																															.get("Friday"),
																													javax.swing.GroupLayout.PREFERRED_SIZE,
																													100,
																													javax.swing.GroupLayout.PREFERRED_SIZE))))
															.addComponent(
																	this.daysDelete
																			.get("Friday")))
											.addContainerGap(431,
													Short.MAX_VALUE)));
			fridayTabLayout
					.setVerticalGroup(fridayTabLayout
							.createParallelGroup(
									javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(
									fridayTabLayout
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													fridayTabLayout
															.createParallelGroup(
																	javax.swing.GroupLayout.Alignment.LEADING,
																	false)
															.addGroup(
																	fridayTabLayout
																			.createSequentialGroup()
																			.addGroup(
																					fridayTabLayout
																							.createParallelGroup(
																									javax.swing.GroupLayout.Alignment.BASELINE)
																							.addComponent(
																									this.daysTextField
																											.get("Friday"),
																									javax.swing.GroupLayout.PREFERRED_SIZE,
																									javax.swing.GroupLayout.DEFAULT_SIZE,
																									javax.swing.GroupLayout.PREFERRED_SIZE)
																							.addComponent(
																									this.daysLabel
																											.get("Friday")))
																			.addPreferredGap(
																					javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																			.addComponent(
																					this.daysAdd
																							.get("Friday"))
																			.addPreferredGap(
																					javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																					javax.swing.GroupLayout.DEFAULT_SIZE,
																					Short.MAX_VALUE)
																			.addComponent(
																					this.daysDelete
																							.get("Friday")))
															.addComponent(
																	this.daysScrollPane
																			.get("Friday"),
																	javax.swing.GroupLayout.PREFERRED_SIZE,
																	javax.swing.GroupLayout.DEFAULT_SIZE,
																	javax.swing.GroupLayout.PREFERRED_SIZE))
											.addContainerGap(25,
													Short.MAX_VALUE)));
			this.dayTabs.addTab("Friday", this.daysPanelTab.get("Friday"));
		} else {
			this.numSelected--;
			stretch();
			this.dayTabs.remove(this.daysPanelTab.get("Friday"));
		}

	}

	/**
	 * @param evt
	 */
	@SuppressWarnings("unchecked")
	private void saturdayCheckActionPerformed(java.awt.event.ActionEvent evt) {
		if (this.daysChecked.get("Saturday").isSelected()) {
			this.numSelected++;
			if (this.firstSelection) {
				stretch();
			}
			this.models[6] = new DefaultListModel();
			this.daysList.get("Saturday").setModel(this.models[6]);
			this.daysScrollPane.get("Saturday").setViewportView(
					this.daysList.get("Saturday"));

			this.daysTextField.get("Saturday").setColumns(20);

			this.daysLabel.get("Saturday").setText("Job Name:");

			this.daysAdd.get("Saturday").setText("Add Job");
			this.daysAdd.get("Saturday").addActionListener(
					new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(
								java.awt.event.ActionEvent evt) {
							if (!Config.this.daysTextField.get("Saturday")
									.getText().isEmpty()) {
								Config.this.models[6]
										.addElement(Config.this.daysTextField
												.get("Saturday").getText());
								Config.this.daysList.get("Saturday").setModel(
										Config.this.models[6]);
								Config.this.daysTextField.get("Saturday")
										.setText("");
							}
						}
					});

			this.daysDelete.get("Saturday").setText("Delete Job");
			this.daysDelete.get("Saturday").addActionListener(
					new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(
								java.awt.event.ActionEvent evt) {
							while (!Config.this.daysList.get("Saturday")
									.isSelectionEmpty()) {
								int n = Config.this.daysList.get("Saturday")
										.getSelectedIndex();
								Config.this.models[6].remove(n);
							}

						}
					});

			javax.swing.GroupLayout saturdayTabLayout = new javax.swing.GroupLayout(
					this.daysPanelTab.get("Saturday"));
			this.daysPanelTab.get("Saturday").setLayout(saturdayTabLayout);
			saturdayTabLayout
					.setHorizontalGroup(saturdayTabLayout
							.createParallelGroup(
									javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(
									saturdayTabLayout
											.createSequentialGroup()
											.addContainerGap()
											.addComponent(
													this.daysScrollPane
															.get("Saturday"),
													javax.swing.GroupLayout.PREFERRED_SIZE,
													182,
													javax.swing.GroupLayout.PREFERRED_SIZE)
											.addGap(18, 18, 18)
											.addGroup(
													saturdayTabLayout
															.createParallelGroup(
																	javax.swing.GroupLayout.Alignment.LEADING)
															.addGroup(
																	saturdayTabLayout
																			.createSequentialGroup()
																			.addComponent(
																					this.daysLabel
																							.get("Saturday"))
																			.addGroup(
																					saturdayTabLayout
																							.createParallelGroup(
																									javax.swing.GroupLayout.Alignment.LEADING)
																							.addGroup(
																									saturdayTabLayout
																											.createSequentialGroup()
																											.addGap(14,
																													14,
																													14)
																											.addComponent(
																													this.daysAdd
																															.get("Saturday")))
																							.addGroup(
																									saturdayTabLayout
																											.createSequentialGroup()
																											.addPreferredGap(
																													javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																											.addComponent(
																													this.daysTextField
																															.get("Saturday"),
																													javax.swing.GroupLayout.PREFERRED_SIZE,
																													100,
																													javax.swing.GroupLayout.PREFERRED_SIZE))))
															.addComponent(
																	this.daysDelete
																			.get("Saturday")))
											.addContainerGap(431,
													Short.MAX_VALUE)));
			saturdayTabLayout
					.setVerticalGroup(saturdayTabLayout
							.createParallelGroup(
									javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(
									saturdayTabLayout
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													saturdayTabLayout
															.createParallelGroup(
																	javax.swing.GroupLayout.Alignment.LEADING,
																	false)
															.addGroup(
																	saturdayTabLayout
																			.createSequentialGroup()
																			.addGroup(
																					saturdayTabLayout
																							.createParallelGroup(
																									javax.swing.GroupLayout.Alignment.BASELINE)
																							.addComponent(
																									this.daysTextField
																											.get("Saturday"),
																									javax.swing.GroupLayout.PREFERRED_SIZE,
																									javax.swing.GroupLayout.DEFAULT_SIZE,
																									javax.swing.GroupLayout.PREFERRED_SIZE)
																							.addComponent(
																									this.daysLabel
																											.get("Saturday")))
																			.addPreferredGap(
																					javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																			.addComponent(
																					this.daysAdd
																							.get("Saturday"))
																			.addPreferredGap(
																					javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																					javax.swing.GroupLayout.DEFAULT_SIZE,
																					Short.MAX_VALUE)
																			.addComponent(
																					this.daysDelete
																							.get("Saturday")))
															.addComponent(
																	this.daysScrollPane
																			.get("Saturday"),
																	javax.swing.GroupLayout.PREFERRED_SIZE,
																	javax.swing.GroupLayout.DEFAULT_SIZE,
																	javax.swing.GroupLayout.PREFERRED_SIZE))
											.addContainerGap(25,
													Short.MAX_VALUE)));
			this.dayTabs.addTab("Saturday", this.daysPanelTab.get("Saturday"));
		} else {
			this.numSelected--;
			stretch();
			this.dayTabs.remove(this.daysPanelTab.get("Saturday"));
		}
	}

	/**
	 * @param evt
	 */
	private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {
		ArrayList<Day> days = new ArrayList<Day>();
		if (this.daysChecked.get("Sunday").isSelected()) {
			ArrayList<Object> sun = new ArrayList<Object>();
			List<Object> jobs = Arrays.asList(this.models[0].toArray());
			sun.addAll(jobs);
			days.add(new Day("Sunday", sun));
		}
		if (this.daysChecked.get("Monday").isSelected()) {
			ArrayList<Object> mon = new ArrayList<Object>();
			List<Object> jobs = Arrays.asList(this.models[1].toArray());
			mon.addAll(jobs);
			days.add(new Day("Monday", mon));
		}
		if (this.daysChecked.get("Tuesday").isSelected()) {
			ArrayList<Object> tue = new ArrayList<Object>();
			List<Object> jobs = Arrays.asList(this.models[2].toArray());
			tue.addAll(jobs);
			days.add(new Day("Tuesday", tue));
		}
		if (this.daysChecked.get("Wednesday").isSelected()) {
			ArrayList<Object> wed = new ArrayList<Object>();
			List<Object> jobs = Arrays.asList(this.models[3].toArray());
			wed.addAll(jobs);
			days.add(new Day("Wednesday", wed));
		}
		if (this.daysChecked.get("Thursday").isSelected()) {
			ArrayList<Object> thu = new ArrayList<Object>();
			List<Object> jobs = Arrays.asList(this.models[4].toArray());
			thu.addAll(jobs);
			days.add(new Day("Thursday", thu));
		}
		if (this.daysChecked.get("Friday").isSelected()) {
			ArrayList<Object> fri = new ArrayList<Object>();
			List<Object> jobs = Arrays.asList(this.models[5].toArray());
			fri.addAll(jobs);
			days.add(new Day("Friday", fri));
		}
		if (this.daysChecked.get("Saturday").isSelected()) {
			ArrayList<Object> sat = new ArrayList<Object>();
			List<Object> jobs = Arrays.asList(this.models[6].toArray());
			sat.addAll(jobs);
			days.add(new Day("Saturday", sat));
		}
		if (days.size() > 0) {
			boolean hasJobs = true;
			int i = 0;
			while (hasJobs && i < days.size()) {
				if (days.get(i).getJobs().size() == 0) {
					hasJobs = false;
				}
				i++;
			}
			if (hasJobs) {
				Main.setDays(days);
				Main.wSet = new WorkerSetup();
				Main.toggleWorkerSetup();
				Main.config = this;
				Main.toggleConfig();
			} else {
				JOptionPane.showMessageDialog(this,
						"You must have at least one job each day.");
			}
		} else {
			JOptionPane.showMessageDialog(this, "You have not added any days.");
		}
	}

	private void stretch() {
		if (this.numSelected > 0) {
			this.setSize(801, 290);
			this.firstSelection = false;
		} else {
			this.setSize(801, 87);
			this.firstSelection = true;
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Config.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Config.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Config.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Config.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Config().setVisible(true);
			}
		});
	}

	private javax.swing.JTabbedPane dayTabs;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JButton nextButton;
}
