package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import control.ControlGroupJob;
import control.ControlJob;
import entity.GroupJob;
import entity.Job;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AdminMainMenu {

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
	
	private JobAdd jobAdd;
	public final static String[] columnNames = {
	        "Name", "Company", "Address", "Salary"
	    };
	private JTable table;

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
		
	}

	private void initData() throws SQLException {
		// TODO Auto-generated method stub
		initDataGroupList();
		initDataJobList();
		
		
	}

	private void initDataJobList() throws SQLException {
		// TODO Auto-generated method stub
		lstJob = ctrJob.loadData();
//		Cach 1
		Vector<Object> vector = new Vector<Object>();
		for(Job job:lstJob)
		{
			Vector<String> vString = new Vector<>();
			vString.add(job.getJobName());
			vString.add(job.getcompany());
			vString.add(job.getAddress());
			int salary =job.getSalary();
			vString.add(""+salary);
			vector.add(vString);
		}
		Vector<String> vColum = new Vector<>();
		for(String s:columnNames)
		{
			vColum.add(s);
		}
		table = new JTable(vector,vColum);
//		Vector<String> colName = new Vector<>();
//		for(String s:columnNames)
//		{
//			colName.add(s);
//		}
//		table = new JTable(vector, colName);
		//cach 2
//		DefaultTableColumnModel defaultTableColumnModel = new DefaultTableColumnModel();
//		for(Job job:lstJob)
//		{
//			Vector<String> vString = new Vector<>();
//			vString.add(job.getJobName());
//			vString.add(job.getcompany());
//			vString.add(job.getAddress());
//			int salary =job.getSalary();
//			vString.add(""+salary);
//			defaultTableModel.addRow(vString);
//		}
//		
//		table = new JTable(defaultTableModel);

		
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
		
		JLabel label = new JLabel("\u6C42\u4EBA\u7968\u3092\u63A2\u3059");
		label.setFont(new Font("MS UI Gothic", Font.BOLD, 50));
		pHead.add(label);
		
		JPanel ÇêControl = new JPanel();
		pPage_Start.add(ÇêControl);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("MS UI Gothic", Font.PLAIN, 16));
		ÇêControl.add(comboBox);
		
		textSearch = new JTextField();
		textSearch.setFont(new Font("MS UI Gothic", Font.PLAIN, 16));
		ÇêControl.add(textSearch);
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
					System.out.println("Mhay vao cau search nhe");
				}
				
			}
		});
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Search();
			}
		});
		ÇêControl.add(btnSearch);
		
		JButton btnAddJob = new JButton("AddJob");
		btnAddJob.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
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
		ÇêControl.add(btnAddJob);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exit();
			}
		});
		ÇêControl.add(btnExit);
		
		JPanel pLine_Start = new JPanel();
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
		
		list.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				clickListGroupJob();
				
			}
		});
		
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
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add();
			}
		});
		pControl2.add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Edit();
			}
		});
		pControl2.add(btnEdit);
		
		
		frame.getContentPane().add(table, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.EAST);
		frame.setVisible(true);
	}
	protected void clickListGroupJob() {
		// TODO Auto-generated method stub
		groupJob = (GroupJob)list.getSelectedValue();
//		if(groupJob!=null)
//		{
//		System.out.println("6  "+groupJob.getGroupName()+groupJob.getMemo()+groupJob.getId());
//		}
		//to load dataList of Jobs
		
	}

	protected void Edit() {
		// TODO Auto-generated method stub
		if(groupJob==null)
    	{
    		JOptionPane.showMessageDialog(
		            frame, "please chose in name of GroupJob");
    	}
    	else
    	{
        try {
        	System.out.println("Update");
        	frame.setVisible(false);
			groupJobEdit = new GroupJobEdit(groupJob);
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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

	protected void Search() {
		// TODO Auto-generated method stub
		
	}

	

}
