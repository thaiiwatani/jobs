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


public class GroupJobAdd extends JFrame implements ActionListener {
   private JFrame mainFrame;
   private JPanel pPAGE_START;
   private JPanel pLINE_START;
   private JPanel pPAGE_END;
   private JLabel lHeadTitle,lGroupJobName,lGroupJobMemo;
   private JTextField txtGroupJobName,txtGroupJobMemo;
   
   private JButton bt1,bt2;
   private Font fontButton =  new Font("ÇlÇr ÇoÉSÉVÉbÉN å©èoÇµ",Font.BOLD , 22);
   private Font fontText =  new Font("ÇlÇr ÇoÉSÉVÉbÉN å©èoÇµ",Font.BOLD , 18);
   private Font fontTextBox =  new Font("ÇlÇr ÇoÉSÉVÉbÉN å©èoÇµ",Font.BOLD , 18);
   private AdminMainMenu adminMainMenu =null;

   private ControlGroupJob ctrGroup = new ControlGroupJob();
   

	public GroupJobAdd() throws SQLException
	{
		
		guiStart();
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		GroupJobAdd s = new GroupJobAdd();

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
		lHeadTitle = new JLabel("êEéÌÇADD",JLabel.CENTER );
		lHeadTitle.setFont(new Font("ÇlÇr ÇoÉSÉVÉbÉN å©èoÇµ",Font.BOLD , 40));
		lHeadTitle.setForeground(Color.BLUE);
		pPAGE_START.add(lHeadTitle);

	}
	private void PAGE_END()
	{
		pPAGE_END = new JPanel(new FlowLayout());
		bt1 = new JButton("Create");
		bt1.setFont(fontButton);
		bt2 = new JButton("Cancel");
		bt2.setFont(fontButton);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		pPAGE_END.add(bt1);
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
		pLINE_START.add(lGroupJobName);
		pLINE_START.add(txtGroupJobName);
		pLINE_START.add(lGroupJobMemo);
		pLINE_START.add(txtGroupJobMemo);

	}
	private boolean addGroupJob(GroupJob groupJob) throws SQLException
	{
		boolean check = false;
		check = ctrGroup.add(groupJob);
		return check;
	}
	private boolean checkName(GroupJob groupJob) throws SQLException
	{
		boolean check = false;
		check = ctrGroup.checkName(groupJob);
		return check;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bt1)
		{
			String name = txtGroupJobName.getText();
			String memo = txtGroupJobMemo.getText();
			try {
			if(name ==null||name.length()==0)
			{
				JOptionPane.showMessageDialog(
			            mainFrame, "please input in name of GroupJob");
			}
			else if(!checkName(new GroupJob(name, memo)))
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
				GroupJob groupJob = new GroupJob(name,memo);
				boolean checked= false;
				try {
					checked = addGroupJob(groupJob);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(!checked)
				{
					mainFrame.setVisible(false);
					try {
						adminMainMenu = new AdminMainMenu();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block					
						e1.printStackTrace();
					}
				}
				else
				{
					System.out.println("Error");
				}
			}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==bt2)
		{
			System.out.println("Day");
			mainFrame.setVisible(false);
			try {
				adminMainMenu = new AdminMainMenu();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}

	
}
