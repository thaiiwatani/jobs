package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.ControlGroupJob;
import control.ControlJob;
import entity.GroupJob;
import entity.Job;

public class JobUpdate extends JFrame {private JPanel contentPane;
private JTextField txtName;
private JTextField txtCompany;
private JTextField txtAddress;
private JTextField txtSalary;
private JTextField txtLink;
private JTextField txtFileName;
private JFrame mainFrame;
private JFileChooser fileChooser = new JFileChooser();
private List<Job> lstJob;

private ControlJob ctrJob = new ControlJob();
private ControlGroupJob ctrGroup = new ControlGroupJob();
private DefaultComboBoxModel<GroupJob> dModelGroup = new DefaultComboBoxModel<GroupJob>();
private Job job;
private JComboBox comboBox;
private AdminMainMenu adminMainMenu;
private String fontName ="ÇlÇr ÇoÉSÉVÉbÉN å©èoÇµ";
private JTextArea txtInformation;
/**
 * Launch the application.
 */
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				
//				JobUpdate frame = new JobUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

/**
 * Create the frame.
 */
public JobUpdate(Job job) throws SQLException {
	this.job=job;
	LoadData();
	init();
}
private void init() {
	// TODO Auto-generated method stub
	mainFrame = new JFrame("Job Add");
	mainFrame.setBackground(Color.LIGHT_GRAY);
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	mainFrame.setTitle("Create a new Job");
	mainFrame.setBounds(100, 100, 800, 550);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	mainFrame.setContentPane(contentPane);
	GridBagLayout gbl_contentPane = new GridBagLayout();
	gbl_contentPane.columnWidths = new int[]{80, 489, 0};
	gbl_contentPane.rowHeights = new int[]{29, 23, 23, 23, 23, 23, 23, 150, 23, 50, 0, 0};
	gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
	gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
	contentPane.setLayout(gbl_contentPane);
	
	JLabel lblCreateANew = new JLabel("Create a new Job");
	lblCreateANew.setBackground(SystemColor.activeCaption);
	lblCreateANew.setFont(new Font(fontName, Font.BOLD, 30));
	GridBagConstraints gbc_lblCreateANew = new GridBagConstraints();
	gbc_lblCreateANew.insets = new Insets(0, 0, 5, 0);
	gbc_lblCreateANew.gridx = 1;
	gbc_lblCreateANew.gridy = 0;
	contentPane.add(lblCreateANew, gbc_lblCreateANew);
	
	JLabel lblGroupJob = new JLabel("Group Job");
	lblGroupJob.setFont(new Font(fontName, Font.BOLD, 16));
	GridBagConstraints gbc_lblGroupJob = new GridBagConstraints();
	gbc_lblGroupJob.anchor = GridBagConstraints.EAST;
	gbc_lblGroupJob.insets = new Insets(0, 0, 5, 5);
	gbc_lblGroupJob.gridx = 0;
	gbc_lblGroupJob.gridy = 1;
	contentPane.add(lblGroupJob, gbc_lblGroupJob);
	
	comboBox = new JComboBox(dModelGroup);
	comboBox.setFont(new Font(fontName, Font.PLAIN, 16));
	GridBagConstraints gbc_comboBox = new GridBagConstraints();
	gbc_comboBox.insets = new Insets(0, 0, 5, 0);
	gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
	gbc_comboBox.gridx = 1;
	gbc_comboBox.gridy = 1;
	contentPane.add(comboBox, gbc_comboBox);
	
	JLabel lblName = new JLabel("Name");
	lblName.setFont(new Font(fontName, Font.BOLD, 16));
	GridBagConstraints gbc_lblName = new GridBagConstraints();
	gbc_lblName.anchor = GridBagConstraints.EAST;
	gbc_lblName.insets = new Insets(0, 0, 5, 5);
	gbc_lblName.gridx = 0;
	gbc_lblName.gridy = 2;
	contentPane.add(lblName, gbc_lblName);
	
	txtName = new JTextField();
	txtName.setFont(new Font(fontName, Font.PLAIN, 16));
	GridBagConstraints gbc_txtName = new GridBagConstraints();
	gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtName.insets = new Insets(0, 0, 5, 0);
	gbc_txtName.gridx = 1;
	gbc_txtName.gridy = 2;
	contentPane.add(txtName, gbc_txtName);
	txtName.setColumns(10);
	
	JLabel lblCompany = new JLabel("Company");
	lblCompany.setFont(new Font(fontName, Font.BOLD, 16));
	GridBagConstraints gbc_lblCompany = new GridBagConstraints();
	gbc_lblCompany.anchor = GridBagConstraints.EAST;
	gbc_lblCompany.insets = new Insets(0, 0, 5, 5);
	gbc_lblCompany.gridx = 0;
	gbc_lblCompany.gridy = 3;
	contentPane.add(lblCompany, gbc_lblCompany);
	
	txtCompany = new JTextField();
	txtCompany.setFont(new Font(fontName, Font.PLAIN, 16));
	GridBagConstraints gbc_txtCompany = new GridBagConstraints();
	gbc_txtCompany.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtCompany.insets = new Insets(0, 0, 5, 0);
	gbc_txtCompany.gridx = 1;
	gbc_txtCompany.gridy = 3;
	contentPane.add(txtCompany, gbc_txtCompany);
	txtCompany.setColumns(10);
	
	JLabel lblAddress = new JLabel("Address");
	lblAddress.setFont(new Font(fontName, Font.BOLD, 16));
	GridBagConstraints gbc_lblAddress = new GridBagConstraints();
	gbc_lblAddress.anchor = GridBagConstraints.EAST;
	gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
	gbc_lblAddress.gridx = 0;
	gbc_lblAddress.gridy = 4;
	contentPane.add(lblAddress, gbc_lblAddress);
	
	txtAddress = new JTextField();
	txtAddress.setFont(new Font(fontName, Font.PLAIN, 16));
	GridBagConstraints gbc_txtAddress = new GridBagConstraints();
	gbc_txtAddress.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtAddress.insets = new Insets(0, 0, 5, 0);
	gbc_txtAddress.gridx = 1;
	gbc_txtAddress.gridy = 4;
	contentPane.add(txtAddress, gbc_txtAddress);
	txtAddress.setColumns(10);
	
	JLabel lblSalary = new JLabel("Salary");
	lblSalary.setFont(new Font(fontName, Font.BOLD, 16));
	GridBagConstraints gbc_lblSalary = new GridBagConstraints();
	gbc_lblSalary.anchor = GridBagConstraints.EAST;
	gbc_lblSalary.insets = new Insets(0, 0, 5, 5);
	gbc_lblSalary.gridx = 0;
	gbc_lblSalary.gridy = 5;
	contentPane.add(lblSalary, gbc_lblSalary);
	
	txtSalary = new JTextField();
	txtSalary.setFont(new Font(fontName, Font.PLAIN, 16));
	GridBagConstraints gbc_txtSalary = new GridBagConstraints();
	gbc_txtSalary.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtSalary.insets = new Insets(0, 0, 5, 0);
	gbc_txtSalary.gridx = 1;
	gbc_txtSalary.gridy = 5;
	contentPane.add(txtSalary, gbc_txtSalary);
	txtSalary.setColumns(10);
	
	JLabel lblLinkAcc = new JLabel("Link Access");
	lblLinkAcc.setFont(new Font(fontName, Font.BOLD, 16));
	GridBagConstraints gbc_lblLinkAcc = new GridBagConstraints();
	gbc_lblLinkAcc.anchor = GridBagConstraints.EAST;
	gbc_lblLinkAcc.insets = new Insets(0, 0, 5, 5);
	gbc_lblLinkAcc.gridx = 0;
	gbc_lblLinkAcc.gridy = 6;
	contentPane.add(lblLinkAcc, gbc_lblLinkAcc);
	
	txtLink = new JTextField();
	txtLink.setFont(new Font(fontName, Font.PLAIN, 16));
	GridBagConstraints gbc_txtLink = new GridBagConstraints();
	gbc_txtLink.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtLink.insets = new Insets(0, 0, 5, 0);
	gbc_txtLink.gridx = 1;
	gbc_txtLink.gridy = 6;
	contentPane.add(txtLink, gbc_txtLink);
	txtLink.setColumns(10);
	
	JLabel lblInformation = new JLabel("Information");
	lblInformation.setFont(new Font(fontName, Font.BOLD, 16));
	GridBagConstraints gbc_lblInformation = new GridBagConstraints();
	gbc_lblInformation.anchor = GridBagConstraints.EAST;
	gbc_lblInformation.insets = new Insets(0, 0, 5, 5);
	gbc_lblInformation.gridx = 0;
	gbc_lblInformation.gridy = 7;
	contentPane.add(lblInformation, gbc_lblInformation);
	
	txtInformation = new JTextArea();
	txtInformation.setFont(new Font(fontName, Font.PLAIN, 16));
	GridBagConstraints gbc_txtInformation = new GridBagConstraints();
	gbc_txtInformation.insets = new Insets(0, 0, 5, 0);
	gbc_txtInformation.fill = GridBagConstraints.BOTH;
	gbc_txtInformation.gridx = 1;
	gbc_txtInformation.gridy = 7;
	contentPane.add(txtInformation, gbc_txtInformation);
	
	JLabel lblFileName = new JLabel("File Name");
	lblFileName.setFont(new Font(fontName, Font.BOLD, 16));
	GridBagConstraints gbc_lblFileName = new GridBagConstraints();
	gbc_lblFileName.anchor = GridBagConstraints.EAST;
	gbc_lblFileName.insets = new Insets(0, 0, 5, 5);
	gbc_lblFileName.gridx = 0;
	gbc_lblFileName.gridy = 8;
	contentPane.add(lblFileName, gbc_lblFileName);
	
	JPanel panel_1 = new JPanel();
	GridBagConstraints gbc_panel_1 = new GridBagConstraints();
	gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
	gbc_panel_1.insets = new Insets(0, 0, 5, 0);
	gbc_panel_1.gridx = 1;
	gbc_panel_1.gridy = 8;
	contentPane.add(panel_1, gbc_panel_1);
	GridBagLayout gbl_panel_1 = new GridBagLayout();
	gbl_panel_1.columnWidths = new int[]{572, 75, 0};
	gbl_panel_1.rowHeights = new int[]{30, 0};
	gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
	gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
	panel_1.setLayout(gbl_panel_1);
	
	JButton btnNewButton = new JButton("Browser");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			clickBrowser();
		}
	});
	
	txtFileName = new JTextField();
	GridBagConstraints gbc_txtFileName = new GridBagConstraints();
	gbc_txtFileName.fill = GridBagConstraints.BOTH;
	gbc_txtFileName.insets = new Insets(0, 0, 0, 5);
	gbc_txtFileName.gridx = 0;
	gbc_txtFileName.gridy = 0;
	panel_1.add(txtFileName, gbc_txtFileName);
	txtFileName.setFont(new Font(fontName, Font.PLAIN, 18));
	txtFileName.setColumns(31);
	GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
	gbc_btnNewButton.anchor = GridBagConstraints.EAST;
	gbc_btnNewButton.gridx = 1;
	gbc_btnNewButton.gridy = 0;
	panel_1.add(btnNewButton, gbc_btnNewButton);
	
	
	//Add data to textbox
	txtAddress.setText(job.getAddress());
	txtInformation.setText(job.getIndustry());
	txtCompany.setText(job.getCompany());
	txtFileName.setText(job.getJobName());
	txtLink.setText(job.getLinkAddress());
	txtName.setText(job.getJobName());
	txtSalary.setText(""+job.getSalary());
	
//	comboBox.setSelectedItem();
	
	
	
	JPanel panel = new JPanel();
	GridBagConstraints gbc_panel = new GridBagConstraints();
	gbc_panel.insets = new Insets(0, 0, 5, 0);
	gbc_panel.anchor = GridBagConstraints.EAST;
	gbc_panel.fill = GridBagConstraints.VERTICAL;
	gbc_panel.gridx = 1;
	gbc_panel.gridy = 9;
	contentPane.add(panel, gbc_panel);
	
	JButton btnUpdate = new JButton("Create");
	btnUpdate.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				clickCreate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	
	JButton btnDelete = new JButton("Delete");
	btnDelete.setFont(new Font(fontName, Font.PLAIN, 18));
	panel.add(btnDelete);
	btnUpdate.setFont(new Font(fontName, Font.PLAIN, 18));
	panel.add(btnUpdate);
	
	JButton btnCancel = new JButton("Cancel");
	btnCancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			clickCancel();
		}
	});
	btnCancel.setFont(new Font(fontName, Font.PLAIN, 18));
	
	panel.add(btnCancel);
	mainFrame.setUndecorated(true);
	mainFrame.setVisible(true);
}

private void Load()
{
	
}
private void LoadData() throws SQLException
{
	LoadDataGroupJob();
	
	
}
private void LoadDataGroupJob() throws SQLException
{
	List<GroupJob> lstGroup = ctrGroup.loadData();
	
	
	for(GroupJob g:lstGroup)
	{
		dModelGroup.addElement(g);
	}
	
}
private void LoadDataJob() throws SQLException
{
	lstJob = ctrJob.loadData();
	for(Job g:lstJob)
	{
//		dModel.addElement(g);
	}
}


protected void clickCancel() {
	// TODO Auto-generated method stub
	ToMainMenu();
}

protected void clickCreate() throws SQLException {
	// TODO Auto-generated method stub
	if(checkTextBox())
	{
		if(job!=null)
		{
		ctrJob.add(job);
		ToMainMenu();
		}
	}
	
}


protected void clickBrowser() {
	int select = fileChooser.showOpenDialog(this);
    if (select == JFileChooser.APPROVE_OPTION) {
    	
    	String fileName = fileChooser.getSelectedFile().toString();
    	if(checkFilePDF(fileName))
    	{
    		txtFileName.setText(fileName);
    	}
    	else
    	{
    		JOptionPane.showMessageDialog(contentPane, "Please choose a PDF file");
    		txtFileName.setText("");
    	}
    } else {
        
    }
    
}

private void ToMainMenu()
{
	mainFrame.setVisible(false);
	adminMainMenu = new AdminMainMenu();
}

private boolean checkFilePDF(String fileName)
{
	boolean check=false;
	String s =".pdf";
	int size = fileName.length();
	String substring = fileName.substring(size-4, size);
	
	check =s.equals(substring);
	System.out.println(substring+check);
	return check;
}
private boolean checkTextBox()
{
	//not done
	boolean check=true;
	boolean checkpdf=true;
	String name = txtName.getText();
	String address = txtAddress.getText();
	String company = txtCompany.getText();
	String fileName = txtFileName.getText();
	String link = txtLink.getText();
	String txtsalary = txtSalary.getText();
	int countCheck=0;
	
	if(name==null||name.equals(""))
	{
		check =false;
		
	}
	
	if(address==null||address.equals(""))
	{
		check= false;
	}
	
	if(company==null||company.equals(""))
	{
		check= false;
		
	}
	if(fileName==null||fileName.equals(""))
	{
		check= false;
		
	}
	else if(!checkFilePDF(fileName))
	{
		checkpdf=false;
		
	}
	if(link==null||link.equals(""))
	{
		check= false;
		
	}
	if(txtsalary==null||txtsalary.equals(""))
	{
		
		check= false;
	}
	if(check)
	{
		if(isInteger(txtsalary))
		{
			if(checkpdf)
			{
			job= new Job();
			job.setAddress(address);
			GroupJob groupJob=(GroupJob)comboBox.getSelectedItem();
			job.setGroupid(groupJob.getId());
			job.setImage(fileName);
			job.setJobName(name);
			job.setCompany(company);
			job.setLink(link);
			job.setIndustry(txtInformation.getText());
			job.setSalary(Integer.parseInt(txtsalary));
			System.out.println("TEST"+job.getAddress());
			System.out.println("TEST"+job.getImage());
			}
			else
			{
				JOptionPane.showMessageDialog(contentPane, "Please choose pdf file");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(contentPane, "Please intput number to salary");
		}
	}
	else
	{
		JOptionPane.showMessageDialog(contentPane, "Please intput value to textbox");
	}
	
	return check;
}
private boolean isInteger(String str) {
	try {
		Integer.parseInt(str);
	}catch(NumberFormatException e) {
		return false;
	}
	return true;
}

}
