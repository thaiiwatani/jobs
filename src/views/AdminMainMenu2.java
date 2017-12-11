package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableColumnModel;

import control.ControlGroupJob;
import control.ControlJob;
import entity.GroupJob;
import entity.Job;


public class AdminMainMenu2 extends JFrame implements ActionListener {
   private JFrame mainFrame;
   private JPanel pPAGE_START;
   private JPanel pPAGE_END;
   private JPanel pLINE_START;
   private JPanel pLINE_START_GRID;
   private JPanel pLINE_END;
   private JPanel pCENTER;
   private JPanel pLINE_END_GRID;
   private JPanel pCENTER_GRID;
   private JLabel lCENTER_HEAD;
   private JLabel lLINE_START_HEAD;
   private JLabel lLINE_END_HEAD;
   //panel Head Search
   private JPanel pHSearch;
   private Font fontButton =  new Font("ÇlÇr ÇoÉSÉVÉbÉN å©èoÇµ",Font.BOLD , 22);
   private Font fontText =  new Font("ÇlÇr ÇoÉSÉVÉbÉN å©èoÇµ",Font.BOLD , 18);
   private JLabel lHeadTitle;
   private JButton bSearch1;
   private JButton bEdit;
   private JButton bSearch3;
   private JButton bAddJob;
   private JButton bExit;
   private JButton bAdd;
   
   private GroupJob groupJob;
   public GroupJobAdd groupJobAdd;
   public GroupJobEdit groupJobEdit;
   public JobAdd jobAdd;
   //Test Frame moi
   
   private JPanel pLINE_START_START;
   private JPanel pLINE_START_CENTER;
   private JPanel pLINE_START_END;
   
   //Het test
   //Var data
   private ControlGroupJob ctrGroup = new ControlGroupJob();
   private ControlJob ctrJob = new ControlJob();
   
   private List<GroupJob> lstGroup;
   private List<Job> lstJob;
   
   private JList jLGroup;
   JScrollPane scroll1;
   private JTextField textSearch;
   
   public final static String[] columnNames = {
	        "Name", "Company", "Address", "Salary"
	    };


	public AdminMainMenu2()  throws SQLException 
	{
		dataLoad();
		guiStart();
		//bAdd.addActionListener(this);
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		AdminMainMenu2 mainMenu = new AdminMainMenu2();

	}
	private void dataLoad() throws SQLException
	{
		LoadListGroup();
		LoadListJob();
		
	}
	private void LoadListGroup() throws SQLException
	{
		lstGroup = ctrGroup.loadData();
		DefaultListModel dModel = new DefaultListModel<>();
//		for(GroupJob g:lstGroup)
//		{   JPanel p = new JPanel();
//			p.add(new JLabel(g.getGroupName()));
//			JButton btnEdit = new JButton("Edit");
//			JButton btnDelete = new JButton("Delete");
//			p.add(btnEdit);
//			p.add(btnDelete);
//			dModel.addElement(p);
//		}
//		
		for(GroupJob g:lstGroup)
		{
			dModel.addElement(g);
		}
		
//		for(int i =0;i<lstGroup.size();i++)
//		{
//			dModel.addElement(lstGroup.get(i));
//		}
		jLGroup = new JList(dModel);
		jLGroup.setFixedCellHeight(40);
		jLGroup.setSelectedIndex(-1);

		jLGroup.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				groupJob = (GroupJob)jLGroup.getSelectedValue();
				if(groupJob!=null)
				{
				System.out.println("6  "+groupJob.getGroupName()+groupJob.getMemo()+groupJob.getId());
				}
				
			}
		});

		//jLGroup.setCellRenderer(new JPanelToJList.PanelRenderer());
         scroll1 = new JScrollPane(jLGroup);
       // final JScrollBar scrollBar = scroll1.getVerticalScrollBar();
		
	}
	private void LoadListJob() throws SQLException
	
	{
		lstJob = ctrJob.loadData();
//		DefaultTableColumnModel 
	}
	private void LoadListJob(GroupJob g)
	{
		
	}
	private void LoadListJob(String search)
	{
		
	}
	private void guiStart()
	{
		mainFrame = new JFrame("ãÅêlèÓïÒä«óù");
//		mainFrame.setSize(1280,950);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		mainFrame.setUndecorated(true);
		mainFrame.setLayout(new  BorderLayout());

		PAGE_START();
		PAGE_END();
		LINE_START();
		CENTER();
		LINE_END();
		
		
		mainFrame.add(pPAGE_START,BorderLayout.PAGE_START);
		mainFrame.add(pLINE_START,BorderLayout.LINE_START);
		mainFrame.add(pCENTER,BorderLayout.CENTER);
		//mainFrame.add(pLINE_END,BorderLayout.LINE_END);
		mainFrame.add(pPAGE_END,BorderLayout.PAGE_END);
	  	
		mainFrame.setVisible(true);
	
	  
	
	}
	private void PAGE_START()
	{
		pPAGE_START = new JPanel(new GridLayout(2, 1));
		pPAGE_START.setBackground(Color.CYAN);
		lHeadTitle = new JLabel("ãÅêlÇíTÇ∑",JLabel.CENTER );
		lHeadTitle.setFont(new Font("ÇlÇr ÇoÉSÉVÉbÉN å©èoÇµ",Font.BOLD , 40));
		lHeadTitle.setForeground(Color.BLUE);
		pHSearch = new JPanel(new FlowLayout());
		pHSearch.setBackground(Color.LIGHT_GRAY);
		textSearch = new JTextField("Search");
		textSearch.setFont(new Font("ÇlÇr ÇoÉSÉVÉbÉN å©èoÇµ", 2, 25));
		textSearch.setSize(800,25);
		textSearch.setColumns(25);
		textSearch.addMouseMotionListener(new MouseMotionListener() {
			
			public void mouseMoved(MouseEvent e) {
				//textSearch.setText(null);
				
			}
			
			public void mouseDragged(MouseEvent e) {
				textSearch.setText(null);
				
			}
			public void mousePressed(MouseEvent e) {
				//textSearch.setText(null);
		      }
		});
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
		bSearch1 = new JButton("Search");
		bSearch1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				String url = "https://www.google.com";
//				String url = "C://Users//J1637009//Desktop//1702004 SKY GROUP.pdf";
				String url = "file:///C:/Users/J1637009/Desktop/1702004SKYGROUP.pdf";
				
		        try {
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		bAddJob = new JButton("Add Job");
		bExit = new JButton("Exit");
		bAddJob.setFont(fontButton);
		bExit.setFont(fontButton);
		bSearch1.setFont(fontButton);
		
		//addActionListener(this);
		bAddJob.addActionListener(this);
		bExit.addActionListener(this);
		pHSearch.add(textSearch);
		pHSearch.add(bSearch1);
		pHSearch.add(bAddJob);
		pHSearch.add(bExit);
		
		pPAGE_START.add(lHeadTitle);
		pPAGE_START.add(pHSearch);
	}
	private void PAGE_END()
	{
		pPAGE_END = new JPanel(new FlowLayout());
		bAdd = new JButton("Add");
		bAdd.setFont(fontButton);
		bAdd.addActionListener(this);
		bEdit = new JButton("Edit");
		bEdit.setFont(fontButton);
		bEdit.addActionListener(this);
		//bSearch3 = new JButton("Search");
		//bSearch3.setFont(fontButton);
		pPAGE_END.add(bAdd);
		pPAGE_END.add(bEdit);
		//pPAGE_END.add(bSearch3);
		pPAGE_END.setBackground(Color.LIGHT_GRAY);
		pPAGE_END.setSize(1000,100);
		
		
	}
	private void LINE_START()
	{

		pLINE_START = new JPanel(new GridLayout(2, 1));
		
		
		pLINE_START_START = new JPanel();
		pLINE_START_START.setBorder(BorderFactory.createTitledBorder("êEéÌ"));
		jLGroup.setFont(fontText);
//		jLGroup.setSize(200, 750);
//		jLGroup.setFixedCellHeight(700);
//		jLGroup.setFixedCellWidth(250);
		scroll1 = new JScrollPane(jLGroup);
//		scroll1.add(jLGroup);
		pLINE_START_START.add(scroll1);
		
//		for(int i=0;i<6;i++)
//			{
//				
//				JCheckBox checkBox = new JCheckBox("èÍèä"+i);
//				checkBox.setFont(fontText);
//				pLINE_START_CENTER.add(checkBox);
//			}
		
		pLINE_START_END= new JPanel();
		pLINE_START_END.add(bAdd);
		pLINE_START_END.add(bEdit);
		//pLINE_START_END.add(bSearch3);
		pLINE_START_END.setBackground(Color.LIGHT_GRAY);
		
		pLINE_START.add(pLINE_START_START);
//		pLINE_START.add(pLINE_START_CENTER);
		pLINE_START.add(pLINE_START_END);
		
	}
	private void CENTER()
	{
//		pCENTER = new JPanel();
//		pCENTER.setFont(new Font("ÇlÇr ÇoÉSÉVÉbÉN å©èoÇµ",Font.BOLD , 20));
//		
//		lCENTER_HEAD = new JLabel("èÍèä");
//		lCENTER_HEAD.setFont(fontText);
//		
//		pCENTER_GRID = new JPanel(new GridLayout(3, 2));
//		for(int i=0;i<6;i++)
//		{
//			
//			JCheckBox checkBox = new JCheckBox("èÍèä"+i);
//			checkBox.setFont(fontText);
//			pCENTER_GRID.add(checkBox);
//		}
//		pCENTER.add(lCENTER_HEAD);
//		pCENTER.add(pCENTER_GRID);
		pCENTER = new JPanel(new GridLayout(3, 2));
		pCENTER.setBorder(BorderFactory.createTitledBorder("ì‡óe"));
				
	}
	private void LINE_END()
	{
//		pLINE_END = new JPanel();
//		pLINE_END.setFont(new Font("ÇlÇr ÇoÉSÉVÉbÉN å©èoÇµ",Font.BOLD , 20));
//		
//		lLINE_END_HEAD = new JLabel("ããó^");
//		lLINE_END_HEAD.setFont(fontText);
//		
//		pLINE_END_GRID = new JPanel(new GridLayout(3, 2));
//		for(int i=0;i<6;i++)
//		{
//			JCheckBox checkBox = new JCheckBox("ããó^"+i);
//			checkBox.setFont(fontText);
//			pLINE_START_GRID.add(checkBox);
//		}
//		pLINE_END.add(lLINE_END_HEAD);
//		pLINE_END.add(pLINE_END_GRID);
		pLINE_END = new JPanel(new GridLayout(3, 2));
		pLINE_END.setBorder(BorderFactory.createTitledBorder("èÍèä"));
		for(int i=0;i<6;i++)
			{
				
				JCheckBox checkBox = new JCheckBox("èÍèäèÍèä"+i);
				checkBox.setFont(fontText);
				pLINE_END.add(checkBox);
			}
		
	}
	 public void actionPerformed(ActionEvent e) { 
		 //Add  Job
		 	if(e.getSource()==bAddJob)
		 	{
		 		mainFrame.setVisible(false);
//		 		jobAdd = new JobAdd2();
//		 		jobAdd.open();
		 		
		 	}
		 
		 //Add Group Job
	        if(e.getSource()==bAdd){ 
	            try {
	            	mainFrame.setVisible(false);
					groupJobAdd = new GroupJobAdd();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        }
	        //Add Edit Group Job
	        if(e.getSource()==bEdit){ 
	        	if(groupJob==null)
	        	{
	        		JOptionPane.showMessageDialog(
				            mainFrame, "please chose in name of GroupJob");
	        	}
	        	else
	        	{
	            try {
	            	System.out.println("Update");
	            	mainFrame.setVisible(false);
					groupJobEdit = new GroupJobEdit(groupJob);
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	}
	        }
	    } 

}
