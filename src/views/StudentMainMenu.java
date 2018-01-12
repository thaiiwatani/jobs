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
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import composite.TableValues;
import control.ControlGroupJob;
import control.ControlJob;
import entity.GroupJob;
import entity.Job;

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
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public class StudentMainMenu implements TableModelListener, ListSelectionListener  {

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
	public final static String[] columnNames = {
	        "Name", "Company", "Address", "Salary"
	    };
	private JTable table;
	private JLabel lblTime;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMainMenu window = new StudentMainMenu();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentMainMenu() {
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
			JOptionPane.showMessageDialog(frame, "No data in Job");
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
			JobView jobUpdate = new JobView(job);
			
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
		gbl_pHead.columnWidths = new int[]{100,100, 740, 200};
		gbl_pHead.rowHeights = new int[]{50, 0, 0};
		gbl_pHead.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_pHead.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		pHead.setLayout(gbl_pHead);
		
		JLabel wIconLogo = new JLabel("");
		
		
		try {
			ImageIcon imageIcon = new ImageIcon(".\\logo.png");
			wIconLogo.setIcon(new ImageIcon("C:\\Users\\J1637009\\workspace\\Jobs\\src\\img\\logo.png"));
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
		JLabel label = new JLabel("\u6C42\u4EBA\u7968\u3092\u63A2\u3059");
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
		
		JLabel lblAcc = new JLabel("Hello Admin");
		panel_2.add(lblAcc);
		
		JButton btnLogout = new JButton("\u623B\u308A");
		btnLogout.setIcon(new ImageIcon("C:\\Users\\J1637009\\workspace\\Jobs\\src\\img\\exit.png"));
		
		btnLogout.setFont(new Font("MS UI Gothic", Font.PLAIN, 16));
		panel_2.add(btnLogout);
		btnLogout.setFocusable(false);
		btnLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BackMainMenu();
				
			}
		});;
		
		JButton btnExit = new JButton("\u9589\u3058\u308B");
		btnExit.setIcon(new ImageIcon("C:\\Users\\J1637009\\workspace\\Jobs\\src\\img\\close.png"));
		panel_2.add(btnExit);
		btnExit.setFont(new Font("MS UI Gothic", Font.PLAIN, 16));
		btnExit.setFocusable(false);
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exit();
			}
		});
		
		JPanel ｐControl = new JPanel();
		ｐControl.setBackground(SystemColor.activeCaption);
		pPage_Start.add(ｐControl);
		String [] cString = {"営業","給料","勤務地"};
		comboBox = new JComboBox(cString);
		comboBox.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		ｐControl.add(comboBox);
		
		textSearch = new JTextField();
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
		
		JButton btnSearch = new JButton("\u691C\u7D22");
		btnSearch.setIcon(new ImageIcon("C:\\Users\\J1637009\\workspace\\Jobs\\src\\img\\search.png"));
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
		
		JPanel pLine_Start = new JPanel();
		frame.getContentPane().add(pLine_Start, BorderLayout.WEST);
		GridBagLayout gbl_pLine_Start = new GridBagLayout();
		gbl_pLine_Start.columnWidths = new int[]{100, 0};
		gbl_pLine_Start.rowHeights = new int[]{48, 48, 0};
		gbl_pLine_Start.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pLine_Start.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pLine_Start.setLayout(gbl_pLine_Start);
		
		JLabel label_1 = new JLabel("\u8077\u7A2E");
		label_1.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.fill = GridBagConstraints.VERTICAL;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		pLine_Start.add(label_1, gbc_label_1);
		
		
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
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.anchor = GridBagConstraints.EAST;
		gbc_list.fill = GridBagConstraints.VERTICAL;
		gbc_list.gridx = 0;
		gbc_list.gridy = 1;
		pLine_Start.add(list, gbc_list);
		
		setTableToMain();
		
		JPanel panel_South = new JPanel();
		panel_South.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel_South, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_South = new GridBagLayout();
		gbl_panel_South.columnWidths = new int[]{700, 300};
		gbl_panel_South.rowHeights = new int[]{0, 0, 0};
		gbl_panel_South.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_South.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_South.setLayout(gbl_panel_South);
		
		JPanel panel_GroupMember = new JPanel();
		panel_GroupMember.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panel_GroupMember = new GridBagConstraints();
		gbc_panel_GroupMember.insets = new Insets(0, 0, 5, 0);
		gbc_panel_GroupMember.fill = GridBagConstraints.BOTH;
		gbc_panel_GroupMember.gridx = 0;
		gbc_panel_GroupMember.gridy = 0;
		panel_South.add(panel_GroupMember, gbc_panel_GroupMember);
		GridBagLayout gbl_panel_GroupMember = new GridBagLayout();
		gbl_panel_GroupMember.columnWidths = new int[]{325, 325, 325, 0};
		gbl_panel_GroupMember.rowHeights = new int[]{13, 13, 13, 13, 0};
		gbl_panel_GroupMember.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_GroupMember.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_GroupMember.setLayout(gbl_panel_GroupMember);
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("リーダー: DAO DUC THAI");
		GridBagConstraints gbc_lblNewLabelr = new GridBagConstraints();
		gbc_lblNewLabelr.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabelr.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabelr.gridx = 1;
		gbc_lblNewLabelr.gridy = 1;
		panel_GroupMember.add(lblNewLabel, gbc_lblNewLabelr);
		
		JLabel lblNewLabel_5 = new JLabel("メンバー: DANG VAN HIEN");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 1;
		panel_GroupMember.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
	
		JLabel lblNewLabel_4 = new JLabel("メンバー: PAUDEL DAMODAR");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 2;
		panel_GroupMember.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel("メンバー: SHRESTHA RAJENDRA");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_7.gridx = 2;
		gbc_lblNewLabel_7.gridy = 2;
		panel_GroupMember.add(lblNewLabel_7, gbc_lblNewLabel_7);
		

		
	
		
		JLabel lblNewLabel_6 = new JLabel("メンバー: PAUDEL BIDUR");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 3;
		panel_GroupMember.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		
		JPanel panel_GroupInfor = new JPanel();
		panel_GroupInfor.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panel_GroupInfor = new GridBagConstraints();
		gbc_panel_GroupInfor.anchor = GridBagConstraints.WEST;
		gbc_panel_GroupInfor.fill = GridBagConstraints.VERTICAL;
		gbc_panel_GroupInfor.gridx = 1;
		gbc_panel_GroupInfor.gridy = 0;
		panel_South.add(panel_GroupInfor, gbc_panel_GroupInfor);
		GridBagLayout gbl_panel_GroupInfor = new GridBagLayout();
		gbl_panel_GroupInfor.columnWidths = new int[]{206, 0};
		gbl_panel_GroupInfor.rowHeights = new int[]{13, 13, 13, 0};
		gbl_panel_GroupInfor.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_GroupInfor.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_GroupInfor.setLayout(gbl_panel_GroupInfor);
		
		JLabel lblNewLabel_1 = new JLabel("\u5CA9\u8C37\u5B66\u5712\u30C6\u30AF\u30CE\u30D3\u30B8\u30CD\u30B9\u6A2A\u6D5C\u4FDD\u80B2\u5C02\u9580\u5B66\u6821");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_GroupInfor.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u3012220-0023\u3000\u6A2A\u6D5C\u5E02\u897F\u533A\u5E73\u6CBC1-38-10");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel_GroupInfor.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TEL\uFF1A045-321-3210\u3000FAX\uFF1A045-290-0608");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel_GroupInfor.add(lblNewLabel_3, gbc_lblNewLabel_3);
//		frame.getContentPane().add(panel, BorderLayout.EAST);
		frame.setVisible(true);
	}
	protected void BackMainMenu() {
		
		MainMenu mainMenu = new MainMenu();
		frame.setVisible(false);
		
		
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
			if(selected.equals("営業"))
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
			Integer.parseInt(str);
		}catch(NumberFormatException e) {
			return false;
		}
		return true;
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
