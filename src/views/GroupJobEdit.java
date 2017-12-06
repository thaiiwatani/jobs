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

import control.ControlGroupJob;
import entity.GroupJob;


public class GroupJobEdit extends JFrame implements ActionListener {
   private JFrame mainFrame;
   private JPanel pPAGE_START;
   private JPanel pLINE_START;
   private JPanel pPAGE_END;
   private JLabel lHeadTitle,lGroupJobName,lGroupJobMemo;
   private JTextField txtGroupJobName,txtGroupJobMemo;
   
   private JButton bt1,bt2,bt3;
   private Font fontButton =  new Font("ÇlÇr ÇoÉSÉVÉbÉN å©èoÇµ",Font.BOLD , 22);
   private Font fontText =  new Font("ÇlÇr ÇoÉSÉVÉbÉN å©èoÇµ",Font.BOLD , 18);
   private Font fontTextBox =  new Font("ÇlÇr ÇoÉSÉVÉbÉN å©èoÇµ",Font.BOLD , 18);
   private AdminMainMenu adminMainMenu =null;
   private GroupJob groupJob;

   private ControlGroupJob ctrGroup = new ControlGroupJob();
   

	public GroupJobEdit(GroupJob groupJob) throws SQLException
	{
		this.groupJob = groupJob;
		guiStart();
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//GroupJobUpdate s = new GroupJobUpdate();

	}
	

	private void guiStart()
	{
		mainFrame = new JFrame("ãÅêlèÓïÒä«óù");
		mainFrame.setSize(400,300);
		mainFrame.setLayout(new  BorderLayout());

		PAGE_START();
		LINE_START();
		PAGE_END();
		mainFrame.add(pPAGE_START,BorderLayout.PAGE_START);
		mainFrame.add(pLINE_START,BorderLayout.LINE_START);
		mainFrame.add(pPAGE_END,BorderLayout.PAGE_END);
		
		mainFrame.setVisible(true);

	}
	private void PAGE_START()
	{
		pPAGE_START = new JPanel();
		pPAGE_START.setBackground(Color.CYAN);
		lHeadTitle = new JLabel("êEéÌÇUpdate",JLabel.CENTER );
		lHeadTitle.setFont(new Font("ÇlÇr ÇoÉSÉVÉbÉN å©èoÇµ",Font.BOLD , 40));
		lHeadTitle.setForeground(Color.BLUE);
		pPAGE_START.add(lHeadTitle);

	}
	private void PAGE_END()
	{
		pPAGE_END = new JPanel(new FlowLayout());
		bt1 = new JButton("Update");
		bt1.setFont(fontButton);
		bt3= new JButton("Delete");
		bt3.setFont(fontButton);
		bt2 = new JButton("Cancel");
		bt2.setFont(fontButton);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		pPAGE_END.add(bt1);
		pPAGE_END.add(bt3);
		
		pPAGE_END.add(bt2);
		pPAGE_END.setBackground(Color.LIGHT_GRAY);
		
	}
	private void LINE_START()
	{

		pLINE_START = new JPanel(new GridLayout(2, 2));
		lGroupJobName = new JLabel("Name");
		lGroupJobName.setFont(fontText);
		lGroupJobMemo = new JLabel("Memo");
		lGroupJobMemo.setFont(fontText);
		
		txtGroupJobName = new JTextField(11);
		txtGroupJobName.setFont(fontTextBox);
		
		//txtGroupJobName.setSize(500, 20);
		txtGroupJobMemo = new JTextField(11);
		txtGroupJobMemo.setFont(fontTextBox);
		//set text in to textbox
		System.out.println("groupJob.getMemo()"+groupJob.getMemo());
		txtGroupJobName.setText(groupJob.getGroupName());
		txtGroupJobMemo.setText(groupJob.getMemo());
		pLINE_START.add(lGroupJobName);
		pLINE_START.add(txtGroupJobName);
		pLINE_START.add(lGroupJobMemo);
		pLINE_START.add(txtGroupJobMemo);

	}
	private boolean UpdateGroupJob(GroupJob groupJob) throws SQLException
	{
		boolean check = false;
		check = ctrGroup.update(groupJob);
		return check;
	}
	private boolean CheckName(GroupJob groupJob) throws SQLException
	{
		boolean check = false;
		check = ctrGroup.checkName(groupJob);
		return check;
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
	
	private void ToMainAdminMenu()
	{
		mainFrame.setVisible(false);
		try {
			adminMainMenu = new AdminMainMenu();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// btnUpdate
		if(e.getSource()==bt1)
		{
			String name = txtGroupJobName.getText();
			String memo = txtGroupJobMemo.getText();
			if(name ==null||name.length()==0)
			{
				JOptionPane.showMessageDialog(
			            mainFrame, "please input in name of GroupJob");
			}
			else if(name ==null||name.length()==0)
			{
				JOptionPane.showMessageDialog(
			            mainFrame, "please input in name of GroupJob");
			}
			else
			{
				GroupJob groupJob = new GroupJob(this.groupJob.getId(),name,memo);
				System.out.println("AAAAAAAAAAAAAAAA"+groupJob.getId()+groupJob.getGroupName()+groupJob.getMemo());
				boolean checked= false;
				boolean checkName = false;
				try {
					checkName =CheckName(groupJob);
						if(checkName)
						{
							checked = UpdateGroupJob(groupJob);
						}
						else 
						{
							JOptionPane.showMessageDialog(
						            mainFrame, "Duplicate Data, please change the different groupName");
						}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(checked)
				{
					ToMainAdminMenu();
				}
				else
				{
					System.out.println("Error");
				}
			}
		}
		
		
		
		//bCancel 
		if(e.getSource()==bt2)
		{
			ToMainAdminMenu();
			
		}
		//btn Delete 
		if(e.getSource()==bt3)
		{
			boolean checkJobInGroupJob = false;
			try {
				checkJobInGroupJob = CheckJobInGroupJob(groupJob);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(checkJobInGroupJob)
			{
				int output =JOptionPane.showConfirmDialog(mainFrame, "Delete you are OK?",groupJob.getGroupName()+
						" of GroupJob to Delete",JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				if(output==JOptionPane.YES_OPTION)
				{
					try {
						Delete(groupJob);
						ToMainAdminMenu();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("Da OK");
				}
			}
			
			
		}
		
	}

	
}
