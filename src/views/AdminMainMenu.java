package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import composite.GJobAdd;
import composite.TableValues;
import control.ControlGroupJob;
import control.ControlJob;
import entity.GroupJob;
import entity.Job;

import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public class AdminMainMenu implements TableModelListener, ListSelectionListener  {

	private JFrame frame;
	private JTextField textSearch;
	private JList list;
	private GroupJobAdd groupJobAdd;
	private GroupJob groupJob;
	private GroupJobEdit groupJobEdit;
	private ControlGroupJob ctrGroup = new ControlGroupJob();
	private ControlJob ctrJob = new ControlJob();
	private List<GroupJob> lstGroup;
	private List<Job> lstJob;
	private int selectedIDJob;
	JScrollPane jsp;
	private JobAdd jobAdd;
	private boolean checkButton = true;
	private JTable table;
	private JLabel lblTime;
	private JComboBox comboBox;
	private JPanel ｐControl;
	
	private JTextField txtGroupJobName;
	private JTextField txtGroupJobMemo;
	private JPanel pAddGroupJob;
	private JPanel pLine_Start;
	private int sizeFontAddGroup = 24;
	private JButton btnSearch; 
//	private static final String imgLink = ".";
	private static final String imgLink = "C:\\Users\\J1637009\\workspace\\Jobs\\src";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMainMenu window = new AdminMainMenu();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminMainMenu() {
		try {
			initData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		initialize();
		clock();
		
		
	}

	private void initData() throws SQLException {
		// TODO Auto-generated method stub
		initDataGroupList();
		initDataJobList();
		TableDataLoad();
		
	}
	private void changeDataJobList(GroupJob groupJob) throws SQLException
	{
		lstJob =ctrJob.loadDataFromGroup(groupJob);
	}
	private void TableDataLoad()
	{
		if(lstJob.size()>0)
		{
			//cach 1
			TableValues tableValues = new TableValues(lstJob);
			table = new JTable(tableValues);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
			TableColumn column = null;
		    for (int i = 0; i < 5; i++) {
		        column = table.getColumnModel().getColumn(i);
		        if (i == 3) {
		            column.setPreferredWidth(400); 
		           
		        } 
		        
		        if(i==0)
		        {
		        	column.setMaxWidth(40);
		        }
		       
		        if(i==4) {
		            column.setMaxWidth(60);
		        }
		    } 
		    
		    ListSelectionModel listSelectionModel =table.getSelectionModel();
		    listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		    listSelectionModel.addListSelectionListener(this);
		    table.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
				
					if(e.getClickCount()==2)
					{
						System.out.println("double click");
						DoubleClick();
					}
				}
			});
		}
		else
		{
			JOptionPane.showMessageDialog(frame, "仕事がありません。");
		}
	}
	private void initDataJobList() throws SQLException {
		// TODO Auto-generated method stub
		lstJob = ctrJob.loadData();
	}

	protected void DoubleClick() {
		// TODO Auto-generated method stub
		Job job = new Job();
		job.setId(selectedIDJob);
		try {
			job=ctrJob.loadJob(job);
			System.out.println(job.getLink());
			frame.setVisible(false);
			JobUpdate jobUpdate = new JobUpdate(job);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void initDataGroupList() throws SQLException {
		// TODO Auto-generated method stub
		lstGroup = ctrGroup.loadData();
		DefaultListModel dModel = new DefaultListModel<>();
		for(GroupJob g:lstGroup)
		{
			dModel.addElement(g);
		}
		list = new JList(dModel);
		list.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				try {
					
					if(!e.getValueIsAdjusting())
					{
						groupJob = (GroupJob)list.getSelectedValue();
						clickListGroupJob();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		
		JPanel pPage_Start = new JPanel();
		frame.getContentPane().add(pPage_Start, BorderLayout.NORTH);
		pPage_Start.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel pHead = new JPanel();
		pHead.setBackground(SystemColor.activeCaption);
		pPage_Start.add(pHead);
		GridBagLayout gbl_pHead = new GridBagLayout();
		gbl_pHead.columnWidths = new int[]{100,100, 700, 200};
		gbl_pHead.rowHeights = new int[]{50, 0, 0};
		gbl_pHead.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_pHead.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		pHead.setLayout(gbl_pHead);
		
		JLabel wIconLogo = new JLabel("");
		
		
		try {
			ImageIcon imageIcon = new ImageIcon(".\\logo.png");
			wIconLogo.setIcon(new ImageIcon(imgLink+"\\img\\logo.png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		pHead.add(wIconLogo, gbc_lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		pHead.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("MS UI Gothic", Font.BOLD | Font.ITALIC, 16));
		panel_1.add(lblDate);
		
		lblTime = new JLabel("Time");
		lblTime.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		
		panel_1.add(lblTime);
		Date time = new Date();
		 
	       
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd ");
	 
	        //parse ngay thang sang dinh dang va chuyen thanh string.
	    String showTime = sdf.format(time.getTime());
		lblDate.setText(" "+showTime);
		JLabel label = new JLabel("\u6C42\u4EBA\u7968\u3092\u7BA1\u7406");
		label.setFont(new Font("MS UI Gothic", Font.BOLD, 50));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.anchor = GridBagConstraints.NORTH;
		gbc_label.gridx = 2;
		gbc_label.gridy = 0;
		pHead.add(label, gbc_label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 3;
		gbc_panel_2.gridy = 0;
		pHead.add(panel_2, gbc_panel_2);
		
		JLabel lblAcc = new JLabel("よろこそ、管理様");
		panel_2.add(lblAcc);
		
		JButton btnLogout = new JButton("\u30ED\u30B0\u30A2\u30A6\u30C8");
		btnLogout.setIcon(new ImageIcon(imgLink+"\\img\\exit.png"));
		btnLogout.setFont(new Font("MS UI Gothic", Font.PLAIN, 16));
		panel_2.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				MainMenu mainMenu = new MainMenu();
				
			}
		});
		btnLogout.setFocusable(false);
		
		JButton btnExit = new JButton("\u9589\u3058\u308B");
		btnExit.setIcon(new ImageIcon(imgLink+"\\img\\close.png"));
		panel_2.add(btnExit);
		btnExit.setFont(new Font("MS UI Gothic", Font.PLAIN, 16));
		btnExit.setFocusable(false);
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exit();
			}
		});
		
		ｐControl = new JPanel();
		ｐControl.setBackground(SystemColor.activeCaption);
		pPage_Start.add(ｐControl);
		String [] cString = {"仕事の内容","給料","勤務地"};
		comboBox = new JComboBox(cString);
		comboBox.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String selected = (String)comboBox.getSelectedItem();
				

				String search =textSearch.getText();
				
					
					System.out.println("Job aaa after "+lstJob.size());
					if(selected.equals("仕事の内容"))
					{
						
						textSearch.setText("希望勤務内容を入力");
					}
						
					if(selected.equals("給料"))
					{
//						ｐControl.remove(textSearch);
						
						textSearch.setText("希望給料で入力した金額以上が表示されます。");
					}
						
					if(selected.equals("勤務地"))
					{
						textSearch.setText("働きたい場所、例えば東京、神奈川");
					}
				
				
			}
		});
		ｐControl.add(comboBox);
		
		textSearch = new JTextField("希望勤務内容を入力");
		textSearch.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		ｐControl.add(textSearch);
		textSearch.setColumns(30);
		textSearch.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					try {
						Search();
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}
		});
		textSearch.addMouseMotionListener(new MouseMotionListener() {
			
			public void mouseMoved(MouseEvent e) {
				textSearch.setText(null);
				
			}
			
			public void mouseDragged(MouseEvent e) {
//				textSearch.setText(null);
				
			}
			public void mousePressed(MouseEvent e) {
//				textSearch.setText(null);
		      }
		});
		btnSearch = new JButton("\u691C\u7D22");
		btnSearch.setIcon(new ImageIcon(imgLink+"\\img\\search.png"));
		btnSearch.setFont(new Font("MS UI Gothic", Font.PLAIN, 16));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Search();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		ｐControl.add(btnSearch);
		
		JButton btnAddJob = new JButton("\u4ED5\u4E8B\u8FFD\u52A0");
		btnAddJob.setIcon(new ImageIcon(imgLink+"\\img\\add.png"));
		btnAddJob.setFont(new Font("MS UI Gothic", Font.PLAIN, 16));
		btnAddJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddJob();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		ｐControl.add(btnAddJob);
		
		pLine_Start = new JPanel();
		frame.getContentPane().add(pLine_Start, BorderLayout.WEST);
		GridBagLayout gbl_pLine_Start = new GridBagLayout();
		gbl_pLine_Start.columnWidths = new int[]{121, 0};
		gbl_pLine_Start.rowHeights = new int[]{35, 790, 60, 0};
		gbl_pLine_Start.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pLine_Start.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pLine_Start.setLayout(gbl_pLine_Start);
		
		JLabel label_1 = new JLabel("\u8077\u7A2E");
		label_1.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.fill = GridBagConstraints.VERTICAL;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		pLine_Start.add(label_1, gbc_label_1);
		
		
		
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.gridx = 0;
		gbc_list.gridy = 1;
		pLine_Start.add(list, gbc_list);
		
		JPanel pControl2 = new JPanel();
		GridBagConstraints gbc_pControl2 = new GridBagConstraints();
		gbc_pControl2.fill = GridBagConstraints.BOTH;
		gbc_pControl2.gridx = 0;
		gbc_pControl2.gridy = 2;
		pLine_Start.add(pControl2, gbc_pControl2);
		
		JButton btnAdd = new JButton("\u8077\u7A2E\u8FFD\u52A0");
		btnAdd.setIcon(new ImageIcon(imgLink+"\\img\\add.png"));
		btnAdd.setFont(new Font("MS UI Gothic", Font.PLAIN, 16));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Add();
				AddGJob();
			}
		});
		pControl2.add(btnAdd);
		
		JButton btnEdit = new JButton("\u4FEE\u7406");
		btnEdit.setIcon(new ImageIcon(imgLink+"\\img\\edit.png"));
		btnEdit.setFont(new Font("MS UI Gothic", Font.PLAIN, 16));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Edit();
			}
		});
		pControl2.add(btnEdit);
		
		setTableToMain();
		
		JPanel panel = new JPanel();
//		frame.getContentPane().add(panel, BorderLayout.EAST);
		frame.setVisible(true);
	}
	protected void AddGJob() {
		// TODO Auto-generated method stub
		pAddGroupJob = new JPanel();
		if(checkButton)
		{
			
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{200, 0, 0};
			gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
			gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			pAddGroupJob.setLayout(gridBagLayout);
			
			JLabel label = new JLabel("\u8077\u7A2E\u8FFD\u52A0");
			label.setFont(new Font("MS UI Gothic", Font.PLAIN, 35));
			label.setForeground(Color.BLUE);
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(0, 0, 5, 0);
			gbc_label.gridx = 1;
			gbc_label.gridy = 0;
			pAddGroupJob.add(label, gbc_label);
			
			JLabel label_1 = new JLabel("\u8077\u7A2E\u540D");
			label_1.setForeground(Color.BLUE);
			label_1.setFont(new Font("MS UI Gothic", Font.BOLD | Font.ITALIC, sizeFontAddGroup));
			GridBagConstraints gbc_label_1 = new GridBagConstraints();
			gbc_label_1.anchor = GridBagConstraints.EAST;
			gbc_label_1.insets = new Insets(0, 0, 5, 5);
			gbc_label_1.gridx = 0;
			gbc_label_1.gridy = 1;
			pAddGroupJob.add(label_1, gbc_label_1);
			
			txtGroupJobName = new JTextField();
			txtGroupJobName.setFont(new Font("MS UI Gothic", Font.PLAIN, sizeFontAddGroup));
			GridBagConstraints gbc_txtGroupJobName = new GridBagConstraints();
			gbc_txtGroupJobName.insets = new Insets(0, 0, 5, 0);
			gbc_txtGroupJobName.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtGroupJobName.gridx = 1;
			gbc_txtGroupJobName.gridy = 1;
			pAddGroupJob.add(txtGroupJobName, gbc_txtGroupJobName);
			txtGroupJobName.setColumns(10);
			
			JLabel label_2 = new JLabel("\u30E1\u30E2");
			label_2.setForeground(Color.BLUE);
			label_2.setFont(new Font("MS UI Gothic", Font.BOLD | Font.ITALIC, sizeFontAddGroup));
			GridBagConstraints gbc_label_2 = new GridBagConstraints();
			gbc_label_2.anchor = GridBagConstraints.EAST;
			gbc_label_2.insets = new Insets(0, 0, 5, 5);
			gbc_label_2.gridx = 0;
			gbc_label_2.gridy = 2;
			pAddGroupJob.add(label_2, gbc_label_2);
			
			txtGroupJobMemo = new JTextField();
			txtGroupJobMemo.setFont(new Font("MS UI Gothic", Font.PLAIN, sizeFontAddGroup));
			GridBagConstraints gbc_txtGroupJobMemo = new GridBagConstraints();
			gbc_txtGroupJobMemo.insets = new Insets(0, 0, 5, 0);
			gbc_txtGroupJobMemo.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtGroupJobMemo.gridx = 1;
			gbc_txtGroupJobMemo.gridy = 2;
			pAddGroupJob.add(txtGroupJobMemo, gbc_txtGroupJobMemo);
			txtGroupJobMemo.setColumns(10);
			
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
//			gbc_panel.anchor = GridBagConstraints.WEST;
			gbc_panel.fill = GridBagConstraints.BOTH;
			
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 3;
			pAddGroupJob.add(panel, gbc_panel);
			
			JButton btnAdd = new JButton("\u8FFD\u52A0");
			btnAdd.setFont(new Font("MS UI Gothic", Font.PLAIN, sizeFontAddGroup));
			btnAdd.setIcon(new ImageIcon(imgLink+"\\img\\add.png"));
			panel.add(btnAdd);
			
			JButton btnCancel = new JButton("\u30AD\u30E3\u30F3\u30BB\u30EB");
			btnCancel.setFont(new Font("MS UI Gothic", Font.PLAIN, sizeFontAddGroup));
			btnCancel.setIcon(new ImageIcon(imgLink+"\\img\\exit.png"));
			panel.add(btnCancel);
			//change frame
			frame.getContentPane().remove(jsp);
			frame.getContentPane().remove(pLine_Start);
			btnSearch.setEnabled(false);
			textSearch.setEnabled(false);
			frame.getContentPane().add(pAddGroupJob, BorderLayout.CENTER);
		
			frame.getContentPane().revalidate(); 
			frame.getContentPane().repaint();
			checkButton=false;
			btnAdd.addActionListener(new  ActionListener() {
				
				private GroupJob newgroupJob;

				@Override
				public void actionPerformed(ActionEvent e) {
					
					String name = txtGroupJobName.getText();
					String memo = txtGroupJobMemo.getText();
					try {
					if(name ==null||name.length()==0)
					{
						JOptionPane.showMessageDialog(
					            frame, "職種名を入力してください。");
					}
					else if(!checkName(new GroupJob(name, memo)))
					{
						JOptionPane.showMessageDialog(
					            frame, "もう一度職種名を入力してください。");
					}
					
					else
					{
						GroupJob groupJob = new GroupJob(name,memo);
						boolean checked= false;
						try {
							checked = ctrGroup.add(groupJob);
						} catch (SQLException e1) {
							ToMainMenu();
							e1.printStackTrace();
						}
						if(!checked)
						{
							pLine_Start.remove(list);
							initDataGroupList();
							GridBagConstraints gbc_list = new GridBagConstraints();
							gbc_list.fill = GridBagConstraints.BOTH;
							gbc_list.insets = new Insets(0, 0, 5, 0);
							gbc_list.gridx = 0;
							gbc_list.gridy = 1;
							pLine_Start.add(list, gbc_list);
							
							ToMainMenu();
						}
						else
						{
							System.out.println("Error");
						}
						
						
					}
					} catch (SQLException e1) {
						ToMainMenu();
						e1.printStackTrace();
					}
					
					
					
				}
			});
			btnCancel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					ToMainMenu();
					
				}
			});
		}
		
		
	}
	protected void ToMainMenu() {
		frame.getContentPane().remove(pAddGroupJob);
		checkButton=true;
		setTableToMain();
		btnSearch.setEnabled(true);
		textSearch.setEnabled(true);
		frame.getContentPane().add(pLine_Start, BorderLayout.WEST);
		frame.getContentPane().revalidate(); 
		frame.getContentPane().repaint();
		
	}

	private boolean checkName(GroupJob groupJob) throws SQLException
	{
		boolean check = false;
		check = ctrGroup.checkName(groupJob);
		return check;
	}
	private void setTableToMain() {
		// TODO Auto-generated method stub
		System.out.println("add?");
		if(jsp!=null)
		{
			//frame.getContentPane().remove(jsp);
//			frame.getContentPane().repaint();
			System.out.println("remove jsp-------------------------");
		}

		jsp = new JScrollPane(table);
		frame.getContentPane().add(jsp, BorderLayout.CENTER);
		
		
		
	}

	protected void clickListGroupJob() throws SQLException {

		
		if(groupJob!=null)
		{
			frame.getContentPane().remove(jsp);
//			frame.getContentPane().revalidate(); 
			
			System.out.println("Job aaa after "+lstJob.size());
			changeDataJobList(groupJob);
			System.out.println("Job aaa before "+lstJob.size());
			TableDataLoad();
			setTableToMain();
			frame.getContentPane().revalidate(); 
			frame.getContentPane().repaint();
		}
		//to load dataList of Jobs
		
	}

	protected void Edit() {
		// TODO Auto-generated method stub
		if(groupJob==null)
    	{
    		JOptionPane.showMessageDialog(
		            frame, "もうし、 1回職種を選んでください。");
    	}
    	else
    	{
    		pAddGroupJob = new JPanel();
   			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{200, 0, 0};
			gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
			gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			pAddGroupJob.setLayout(gridBagLayout);
			
			JLabel label = new JLabel("\u8077\u7A2E\u8FFD\u52A0");
			label.setFont(new Font("MS UI Gothic", Font.PLAIN, 35));
			label.setForeground(Color.BLUE);
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(0, 0, 5, 0);
			gbc_label.gridx = 1;
			gbc_label.gridy = 0;
			pAddGroupJob.add(label, gbc_label);
			
			JLabel label_1 = new JLabel("\u8077\u7A2E\u540D");
			label_1.setForeground(Color.BLUE);
			label_1.setFont(new Font("MS UI Gothic", Font.BOLD | Font.ITALIC, sizeFontAddGroup));
			GridBagConstraints gbc_label_1 = new GridBagConstraints();
			gbc_label_1.anchor = GridBagConstraints.EAST;
			gbc_label_1.insets = new Insets(0, 0, 5, 5);
			gbc_label_1.gridx = 0;
			gbc_label_1.gridy = 1;
			pAddGroupJob.add(label_1, gbc_label_1);
			
			txtGroupJobName = new JTextField();
			txtGroupJobName.setFont(new Font("MS UI Gothic", Font.PLAIN, sizeFontAddGroup));
			GridBagConstraints gbc_txtGroupJobName = new GridBagConstraints();
			gbc_txtGroupJobName.insets = new Insets(0, 0, 5, 0);
			gbc_txtGroupJobName.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtGroupJobName.gridx = 1;
			gbc_txtGroupJobName.gridy = 1;
			pAddGroupJob.add(txtGroupJobName, gbc_txtGroupJobName);
			txtGroupJobName.setColumns(10);
			
			JLabel label_2 = new JLabel("\u30E1\u30E2");
			label_2.setForeground(Color.BLUE);
			label_2.setFont(new Font("MS UI Gothic", Font.BOLD | Font.ITALIC, sizeFontAddGroup));
			GridBagConstraints gbc_label_2 = new GridBagConstraints();
			gbc_label_2.anchor = GridBagConstraints.EAST;
			gbc_label_2.insets = new Insets(0, 0, 5, 5);
			gbc_label_2.gridx = 0;
			gbc_label_2.gridy = 2;
			pAddGroupJob.add(label_2, gbc_label_2);
			
			txtGroupJobMemo = new JTextField();
			txtGroupJobMemo.setFont(new Font("MS UI Gothic", Font.PLAIN, sizeFontAddGroup));
			GridBagConstraints gbc_txtGroupJobMemo = new GridBagConstraints();
			gbc_txtGroupJobMemo.insets = new Insets(0, 0, 5, 0);
			gbc_txtGroupJobMemo.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtGroupJobMemo.gridx = 1;
			gbc_txtGroupJobMemo.gridy = 2;
			pAddGroupJob.add(txtGroupJobMemo, gbc_txtGroupJobMemo);
			txtGroupJobMemo.setColumns(10);
			
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
//    			gbc_panel.anchor = GridBagConstraints.WEST;
			gbc_panel.fill = GridBagConstraints.BOTH;
			
			gbc_panel.gridx = 1;
			gbc_panel.gridy = 3;
			pAddGroupJob.add(panel, gbc_panel);
			
			JButton btnUpdate = new JButton("\u4FEE\u7406");
			btnUpdate.setFont(new Font("MS UI Gothic", Font.PLAIN, sizeFontAddGroup));
			btnUpdate.setIcon(new ImageIcon(imgLink+"\\img\\edit.png"));
			panel.add(btnUpdate);
			JButton btnDelete = new JButton("\u6D88\u3059");
			btnDelete.setFont(new Font("MS UI Gothic", Font.PLAIN, sizeFontAddGroup));
			btnDelete.setIcon(new ImageIcon(imgLink+"\\img\\delete.png"));
			panel.add(btnDelete);
			JButton btnCancel = new JButton("\u30AD\u30E3\u30F3\u30BB\u30EB");
			btnCancel.setFont(new Font("MS UI Gothic", Font.PLAIN, sizeFontAddGroup));
			btnCancel.setIcon(new ImageIcon(imgLink+"\\img\\exit.png"));
			panel.add(btnCancel);
			//change frame
			frame.getContentPane().remove(jsp);
			frame.getContentPane().remove(pLine_Start);
			btnSearch.setEnabled(false);
			textSearch.setEnabled(false);
			txtGroupJobName.setText(groupJob.getGroupName());
			txtGroupJobMemo.setText(groupJob.getMemo());
			
			frame.getContentPane().add(pAddGroupJob, BorderLayout.CENTER);
		
			frame.getContentPane().revalidate(); 
			frame.getContentPane().repaint();
			checkButton=false;
			btnUpdate.addActionListener(new  ActionListener() {
				
				private GroupJob newgroupJob;

				@Override
				public void actionPerformed(ActionEvent e) {
					
					String name = txtGroupJobName.getText();
					String memo = txtGroupJobMemo.getText();
					try {
					if(name ==null||name.length()==0)
					{
						JOptionPane.showMessageDialog(
					            frame, "職種名を入力してください。");
					}
					else if(!checkName(new GroupJob(name, memo)))
					{
						JOptionPane.showMessageDialog(
					            frame, "もう一度職種名を入力してください。");
					}
					
					else
					{
						GroupJob groupJob2 = new GroupJob(name,memo);
						groupJob2.setId(groupJob.getId());
						boolean checked= false;
						try {
							checked = ctrGroup.update(groupJob2);
							
						} catch (SQLException e1) {
							ToMainMenu();
							e1.printStackTrace();
						}
						if(checked)
						{
							pLine_Start.remove(list);
							initDataGroupList();
							GridBagConstraints gbc_list = new GridBagConstraints();
							gbc_list.fill = GridBagConstraints.BOTH;
							gbc_list.insets = new Insets(0, 0, 5, 0);
							gbc_list.gridx = 0;
							gbc_list.gridy = 1;
							pLine_Start.add(list, gbc_list);
							
							ToMainMenu();
						}
						else
						{
							System.out.println("Error");
						}
						
						
					}
					} catch (SQLException e1) {
						ToMainMenu();
						e1.printStackTrace();
					}
					
					
					
				}
			});
			btnCancel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					ToMainMenu();
					
				}
			});
			btnDelete.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					boolean checkJobInGroupJob = false;
					try {
						checkJobInGroupJob = CheckJobInGroupJob(groupJob);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(checkJobInGroupJob)
					{
						int output =JOptionPane.showConfirmDialog(frame, "削除しますか？　削除する場合は　［OK］　をクリックします。下書きを残す場合は　［取消］　をクリックします。",groupJob.getGroupName()+
								" 職種を取消？",JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
						if(output==JOptionPane.YES_OPTION)
						{
							try {
								Delete(groupJob);
								pLine_Start.remove(list);
								initDataGroupList();
								GridBagConstraints gbc_list = new GridBagConstraints();
								gbc_list.fill = GridBagConstraints.BOTH;
								gbc_list.insets = new Insets(0, 0, 5, 0);
								gbc_list.gridx = 0;
								gbc_list.gridy = 1;
								pLine_Start.add(list, gbc_list);
								ToMainMenu();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							System.out.println("Da OK");
						}
					}
					
				}
			});
		}
    		
    	
	}

	protected void Add() {
		// TODO Auto-generated method stub
		try {
        	frame.setVisible(false);
			groupJobAdd = new GroupJobAdd();
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	protected void Exit() {
		// TODO Auto-generated method stub
		System.exit(0);
		
	}

	protected void AddJob() throws SQLException {
		// TODO Auto-generated method stub
		frame.setVisible(false);
		jobAdd = new JobAdd();
		
	}

	protected void Search() throws NumberFormatException, SQLException {
		// TODO Auto-generated method stub
		String selected = (String)comboBox.getSelectedItem();
		

		String search =textSearch.getText();
		if(search.equals("")||search==null)
			System.out.println(selected);
		else
		{
			
			System.out.println("Job aaa after "+lstJob.size());
			if(selected.equals("仕事の内容"))
			{
				frame.getContentPane().remove(jsp);
				searchForName(search);
			}
				
			if(selected.equals("給料"))
			{
				
				if(isInteger(search))
				{
					
					frame.getContentPane().remove(jsp);
					searchForSalary(Integer.parseInt(search));
				}
				else
				{
					frame.getContentPane().remove(jsp);
					frame.getContentPane().revalidate(); 
					frame.getContentPane().repaint();
					JOptionPane.showMessageDialog(frame, "給料とは　整数（INT型）で入力してください。");
				}
			}
				
			if(selected.equals("勤務地"))
			{
				frame.getContentPane().remove(jsp);
				searchForAddress(search);
			}
				

			System.out.println("Job aaa before "+lstJob.size());
			TableDataLoad();
			setTableToMain();
			frame.getContentPane().revalidate(); 
			frame.getContentPane().repaint();
		}
			
			
		
	}
	private boolean isInteger(String str) {
		try {
			System.out.println("aaaaaaaaaaaaaaaText"+str);
			Integer.parseInt(str);
		}catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
	private boolean CheckJobInGroupJob(GroupJob groupJob) throws SQLException
	{
		boolean check = false;
		check = ctrGroup.checkJobInGroupJob(groupJob);
		return check;
	}
	private boolean Delete(GroupJob groupJob) throws SQLException
	{
		boolean check = false;
		check = ctrGroup.delete(groupJob);
		return check;
	}
	private void searchForSalary(int salary) throws SQLException {
		// TODO Auto-generated method stub
		lstJob =ctrJob.loadJobForSalary(salary);
		
		
	}

	private void searchForName(String jobname) throws SQLException {
		// TODO Auto-generated method stub
		lstJob=ctrJob.loadDataForName(jobname);
		
	}

	private void searchForAddress(String address) throws SQLException {
		// TODO Auto-generated method stub
		lstJob = ctrJob.loadJobForAddress(address);
		
	}

	@Override
	public void tableChanged(TableModelEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
		int maxRows;
		int [] selRows;
		Object value;
		if(!e.getValueIsAdjusting())
		{
			selRows = table.getSelectedRows();
			if(selRows.length>0)
			{
				TableModel tableModel = table.getModel();
				value = tableModel.getValueAt(selRows[0],0);
				System.out.println("Selection:"+value);
				selectedIDJob = (int) value;
				System.out.println("Selectionaaa:"+selectedIDJob);

			}
		}
		
	}
	public void clock() {
		 Thread clock = new Thread() {
		  public void run() {
		   try {
		    while (true) {
		     Calendar cal = new GregorianCalendar();
		     int second = cal.get(Calendar.SECOND);
		     int minute = cal.get(Calendar.MINUTE);
		     int hour = cal.get(Calendar.HOUR_OF_DAY);

		     lblTime.setText("    "+hour + ":" + minute + ":" + second);
//		     timeSystemBD.setText(hour + ":" + minute + ":" + second);
		    
		     sleep(1000);
		    }
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		  }
		 };
		 clock.start();
	}

	

}
