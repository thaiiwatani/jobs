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
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
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
import javax.swing.table.TableColumn;

import composite.TableValues;
import composite.TableValuesOfComment;
import control.ControlComment;
import control.ControlGroupJob;
import control.ControlJob;
import entity.Comment;
import entity.GroupJob;
import entity.Job;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JobView extends JFrame {
private JPanel contentPane;
private JTextField txtName;
private JTextField txtCompany;
private JTextField txtAddress;
private JTextField txtSalary;
private JTextField txtFileName;
private JFrame mainFrame;
private JFileChooser fileChooser = new JFileChooser();


private ControlJob ctrJob = new ControlJob();
private ControlComment ctrCom;
private ControlGroupJob ctrGroup = new ControlGroupJob();
private DefaultComboBoxModel<GroupJob> dModelGroup = new DefaultComboBoxModel<GroupJob>();
private Job job;
private Comment comment;
private JComboBox comboBox;
private StudentMainMenu StudentMainMenu;
private String fontName ="ＭＳ Ｐゴシック 見出し";
private JTextArea txtInformation;
private JTextField txtStudentID;
private JTextArea txtContentComment;
private JTextField txtLink;
private List<Comment> lstCom;
private JTable table;
private JScrollPane jsp;
private static final int fontTextSize =16;
//private static final String imgLink = ".";
private static final String imgLink = "C:\\Users\\J1637009\\workspace\\Jobs\\src";
/**
 * Launch the application.
 */
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				
//				JobView frame = new JobView();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

/**
 * Create the frame.
 */
public JobView(Job job) throws SQLException {
	this.job=job;
	LoadData();
	init();
}
private void init() {
	// TODO Auto-generated method stub
	mainFrame = new JFrame("仕事を修理");
	mainFrame.setBackground(Color.GRAY);
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	mainFrame.setTitle("詳細の営業");
//	mainFrame.setBounds(100, 100, 800, 550);
	mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	mainFrame.setUndecorated(true);
	contentPane = new JPanel();
	contentPane.setBackground(Color.LIGHT_GRAY);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	mainFrame.setContentPane(contentPane);
	GridBagLayout gbl_contentPane = new GridBagLayout();
	gbl_contentPane.columnWidths = new int[]{80, 489, 0};
	gbl_contentPane.rowHeights = new int[]{29, 23, 23, 23, 23, 23, 23,23, 250, 250, 23, 100, 0, 0, 0};
	gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
	gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	contentPane.setLayout(gbl_contentPane);
	
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setIcon(new ImageIcon(imgLink+"\\img\\logo.png"));
	GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
	gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
	gbc_lblNewLabel.gridx = 0;
	gbc_lblNewLabel.gridy = 0;
	contentPane.add(lblNewLabel, gbc_lblNewLabel);
	
	JLabel lblCreateANew = new JLabel("\u8A73\u7D30\u306A\u55B6\u696D");
	lblCreateANew.setBackground(SystemColor.activeCaption);
	lblCreateANew.setFont(new Font(fontName, Font.BOLD, 30));
	GridBagConstraints gbc_lblCreateANew = new GridBagConstraints();
	gbc_lblCreateANew.insets = new Insets(0, 0, 5, 0);
	gbc_lblCreateANew.gridx = 1;
	gbc_lblCreateANew.gridy = 0;
	contentPane.add(lblCreateANew, gbc_lblCreateANew);
	
	JLabel lblGroupJob = new JLabel("\u8077\u7A2E");
	lblGroupJob.setFont(new Font(fontName, Font.BOLD, fontTextSize));
	GridBagConstraints gbc_lblGroupJob = new GridBagConstraints();
	gbc_lblGroupJob.anchor = GridBagConstraints.EAST;
	gbc_lblGroupJob.insets = new Insets(0, 0, 5, 5);
	gbc_lblGroupJob.gridx = 0;
	gbc_lblGroupJob.gridy = 1;
	contentPane.add(lblGroupJob, gbc_lblGroupJob);
	
	comboBox = new JComboBox(dModelGroup);
	comboBox.setForeground(Color.RED);
	comboBox.setEditable(true);
	comboBox.setEnabled(false);
	comboBox.setFont(new Font(fontName, Font.PLAIN, 16));
	
	
	
	GridBagConstraints gbc_comboBox = new GridBagConstraints();
	gbc_comboBox.insets = new Insets(0, 0, 5, 0);
	gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
	gbc_comboBox.gridx = 1;
	gbc_comboBox.gridy = 1;
	contentPane.add(comboBox, gbc_comboBox);
	
	JLabel lblName = new JLabel("\u55B6\u696D\u540D");
	lblName.setFont(new Font(fontName, Font.BOLD, fontTextSize));
	GridBagConstraints gbc_lblName = new GridBagConstraints();
	gbc_lblName.anchor = GridBagConstraints.EAST;
	gbc_lblName.insets = new Insets(0, 0, 5, 5);
	gbc_lblName.gridx = 0;
	gbc_lblName.gridy = 2;
	contentPane.add(lblName, gbc_lblName);
	
	txtName = new JTextField();
	txtName.setEditable(false);
	txtName.setFont(new Font(fontName, Font.PLAIN, 16));
	GridBagConstraints gbc_txtName = new GridBagConstraints();
	gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtName.insets = new Insets(0, 0, 5, 0);
	gbc_txtName.gridx = 1;
	gbc_txtName.gridy = 2;
	contentPane.add(txtName, gbc_txtName);
	txtName.setColumns(10);
	
	JLabel lblCompany = new JLabel("\u4F1A\u793E");
	lblCompany.setFont(new Font(fontName, Font.BOLD, fontTextSize));
	GridBagConstraints gbc_lblCompany = new GridBagConstraints();
	gbc_lblCompany.anchor = GridBagConstraints.EAST;
	gbc_lblCompany.insets = new Insets(0, 0, 5, 5);
	gbc_lblCompany.gridx = 0;
	gbc_lblCompany.gridy = 3;
	contentPane.add(lblCompany, gbc_lblCompany);
	
	txtCompany = new JTextField();
	txtCompany.setEditable(false);
	txtCompany.setFont(new Font(fontName, Font.PLAIN, 16));
	GridBagConstraints gbc_txtCompany = new GridBagConstraints();
	gbc_txtCompany.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtCompany.insets = new Insets(0, 0, 5, 0);
	gbc_txtCompany.gridx = 1;
	gbc_txtCompany.gridy = 3;
	contentPane.add(txtCompany, gbc_txtCompany);
	txtCompany.setColumns(10);
	
	JLabel lblAddress = new JLabel("\u4F4F\u6240");
	lblAddress.setFont(new Font(fontName, Font.BOLD, fontTextSize));
	GridBagConstraints gbc_lblAddress = new GridBagConstraints();
	gbc_lblAddress.anchor = GridBagConstraints.EAST;
	gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
	gbc_lblAddress.gridx = 0;
	gbc_lblAddress.gridy = 4;
	contentPane.add(lblAddress, gbc_lblAddress);
	
	txtAddress = new JTextField();
	txtAddress.setEditable(false);
	txtAddress.setFont(new Font(fontName, Font.PLAIN, 16));
	GridBagConstraints gbc_txtAddress = new GridBagConstraints();
	gbc_txtAddress.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtAddress.insets = new Insets(0, 0, 5, 0);
	gbc_txtAddress.gridx = 1;
	gbc_txtAddress.gridy = 4;
	contentPane.add(txtAddress, gbc_txtAddress);
	txtAddress.setColumns(10);
	
	JLabel lblSalary = new JLabel("\u7D66\u6599");
	lblSalary.setFont(new Font(fontName, Font.BOLD, fontTextSize));
	GridBagConstraints gbc_lblSalary = new GridBagConstraints();
	gbc_lblSalary.anchor = GridBagConstraints.EAST;
	gbc_lblSalary.insets = new Insets(0, 0, 5, 5);
	gbc_lblSalary.gridx = 0;
	gbc_lblSalary.gridy = 5;
	contentPane.add(lblSalary, gbc_lblSalary);
	
	txtSalary = new JTextField();
	txtSalary.setEditable(false);
	txtSalary.setFont(new Font(fontName, Font.PLAIN, 16));
	GridBagConstraints gbc_txtSalary = new GridBagConstraints();
	gbc_txtSalary.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtSalary.insets = new Insets(0, 0, 5, 0);
	gbc_txtSalary.gridx = 1;
	gbc_txtSalary.gridy = 5;
	contentPane.add(txtSalary, gbc_txtSalary);
	txtSalary.setColumns(10);
	
	JLabel labelLink = new JLabel("\u8A73\u7D30\u306A\u30EA\u30F3\u30AF");
	GridBagConstraints gbc_labelLink = new GridBagConstraints();
	gbc_labelLink.anchor = GridBagConstraints.EAST;
	gbc_labelLink.insets = new Insets(0, 0, 5, 5);
	gbc_labelLink.gridx = 0;
	gbc_labelLink.gridy = 6;
	contentPane.add(labelLink, gbc_labelLink);
	
	JPanel panel_txtLink = new JPanel();
	GridBagConstraints gbc_panel_txtLink = new GridBagConstraints();
	gbc_panel_txtLink.fill = GridBagConstraints.HORIZONTAL;
	gbc_panel_txtLink.insets = new Insets(0, 0, 5, 0);
	gbc_panel_txtLink.gridx = 1;
	gbc_panel_txtLink.gridy = 6;
	contentPane.add(panel_txtLink, gbc_panel_txtLink);
	GridBagLayout gbl_panel_txtlink = new GridBagLayout();
	gbl_panel_txtlink.columnWidths = new int[]{800, 75, 0};
	gbl_panel_txtlink.rowHeights = new int[]{30, 0};
	gbl_panel_txtlink.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
	gbl_panel_txtlink.rowWeights = new double[]{0.0, Double.MIN_VALUE};
	panel_txtLink.setLayout(gbl_panel_txtlink);
	
	txtLink = new JTextField();
	txtLink.setFont(new Font(fontName, Font.PLAIN, 18));
	txtLink.setEditable(false);
	GridBagConstraints gbc_textLink = new GridBagConstraints();
	gbc_textLink.insets = new Insets(0, 0, 0, 5);
	gbc_textLink.fill = GridBagConstraints.HORIZONTAL;
	gbc_textLink.gridx = 0;
	gbc_textLink.gridy = 0;
	panel_txtLink.add(txtLink, gbc_textLink);
	txtLink.setColumns(10);
	
	JButton btnOpenLink = new JButton("\u8A73\u7D30\u306A\u30EA\u30F3\u30AF");
	btnOpenLink.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			clickToLink();
		}
	});
	GridBagConstraints gbc_btnOpenLink = new GridBagConstraints();
	gbc_btnOpenLink.gridx = 1;
	gbc_btnOpenLink.gridy = 0;
	panel_txtLink.add(btnOpenLink, gbc_btnOpenLink);
	
	
	
	JLabel lblFileName = new JLabel("\u6C42\u4EBA\u7968\u30D5\u30A1\u30A4\u30EB");
	lblFileName.setFont(new Font(fontName, Font.BOLD, fontTextSize));
	GridBagConstraints gbc_lblFileName = new GridBagConstraints();
	gbc_lblFileName.anchor = GridBagConstraints.EAST;
	gbc_lblFileName.insets = new Insets(0, 0, 5, 5);
	gbc_lblFileName.gridx = 0;
	gbc_lblFileName.gridy = 7;
	contentPane.add(lblFileName, gbc_lblFileName);
	
	JPanel panel_1 = new JPanel();
	GridBagConstraints gbc_panel_1 = new GridBagConstraints();
	gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
	gbc_panel_1.insets = new Insets(0, 0, 5, 0);
	gbc_panel_1.gridx = 1;
	gbc_panel_1.gridy = 7;
	contentPane.add(panel_1, gbc_panel_1);
	GridBagLayout gbl_panel_1 = new GridBagLayout();
	gbl_panel_1.columnWidths = new int[]{800, 75, 0};
	gbl_panel_1.rowHeights = new int[]{30, 0};
	gbl_panel_1.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
	gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
	panel_1.setLayout(gbl_panel_1);
	
	JButton btnOpenPDF = new JButton("求人票を開ける");
	btnOpenPDF.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			clickOpenPDF();
		}
	});
	
	txtFileName = new JTextField();
	txtFileName.setEditable(false);
	GridBagConstraints gbc_txtFileName = new GridBagConstraints();
	gbc_txtFileName.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtFileName.insets = new Insets(0, 0, 0, 5);
	gbc_txtFileName.gridx = 0;
	gbc_txtFileName.gridy = 0;
	panel_1.add(txtFileName, gbc_txtFileName);
	txtFileName.setFont(new Font(fontName, Font.PLAIN, 18));
	txtFileName.setColumns(10);
	GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
	gbc_btnNewButton.anchor = GridBagConstraints.EAST;
	gbc_btnNewButton.gridx = 1;
	gbc_btnNewButton.gridy = 0;
	panel_1.add(btnOpenPDF, gbc_btnNewButton);
	
	
	JLabel lblInformation = new JLabel("\u55B6\u696D\u306E\u5185\u5BB9");
	lblInformation.setFont(new Font(fontName, Font.BOLD, fontTextSize));
	GridBagConstraints gbc_lblInformation = new GridBagConstraints();
	gbc_lblInformation.anchor = GridBagConstraints.EAST;
	gbc_lblInformation.insets = new Insets(0, 0, 5, 5);
	gbc_lblInformation.gridx = 0;
	gbc_lblInformation.gridy = 8;
	contentPane.add(lblInformation, gbc_lblInformation);
	
	txtInformation = new JTextArea();
	txtInformation.setEditable(false);
	txtInformation.setFont(new Font(fontName, Font.PLAIN, fontTextSize));
	GridBagConstraints gbc_txtInformation = new GridBagConstraints();
	gbc_txtInformation.insets = new Insets(0, 0, 5, 0);
	gbc_txtInformation.fill = GridBagConstraints.BOTH;
	gbc_txtInformation.gridx = 1;
	gbc_txtInformation.gridy = 8;
	contentPane.add(txtInformation, gbc_txtInformation);
	txtInformation.setText(job.getIndustry());
	
	
	
	JLabel label = new JLabel("\u30B3\u30E1\u30F3\u30C8\u30EA\u30B9\u30C8");
	label.setFont(new Font(fontName, Font.BOLD, fontTextSize));
	GridBagConstraints gbc_label = new GridBagConstraints();
	gbc_label.anchor = GridBagConstraints.EAST;
	
	gbc_label.insets = new Insets(0, 0, 5, 5);
	gbc_label.gridx = 0;
	gbc_label.gridy = 9;
	contentPane.add(label, gbc_label);
	
	//JPanel panel_ListComment = new JPanel();
//	jsp = new JScrollPane(table);
//
//	GridBagConstraints gbc_panel_ListComment = new GridBagConstraints();
//	gbc_panel_ListComment.insets = new Insets(0, 0, 5, 0);
//	gbc_panel_ListComment.fill = GridBagConstraints.BOTH;
//	gbc_panel_ListComment.gridx = 1;
//	gbc_panel_ListComment.gridy = 9;
//	contentPane.add(jsp, gbc_panel_ListComment);
//	panel_ListComment.add(scrollPane);
	
	setTableToMain();
	
	
	//Add data to textbox
	txtAddress.setText(job.getAddress());
	txtCompany.setText(job.getCompany());
	txtFileName.setText(job.getImage());
	txtName.setText(job.getJobName());
	txtSalary.setText(""+job.getSalary()+"円");
	txtLink.setText(job.getLink());
//	comboBox.setSelectedItem();
//	for(GroupJob groupJob:ls);
	
	JLabel lbCommentID = new JLabel("\u5B66\u751F\u756A\u53F7");
	lbCommentID.setFont(new Font(fontName, Font.BOLD, fontTextSize));
	GridBagConstraints gbc_lbCommentID = new GridBagConstraints();
	gbc_lbCommentID.anchor = GridBagConstraints.EAST;
	gbc_lbCommentID.insets = new Insets(0, 0, 5, 5);
	gbc_lbCommentID.gridx = 0;
	gbc_lbCommentID.gridy = 10;
	contentPane.add(lbCommentID, gbc_lbCommentID);
	
	txtStudentID = new JTextField();
	txtStudentID.setForeground(SystemColor.textHighlight);
	txtStudentID.setColumns(10);
	txtStudentID.setFont(new Font(fontName, Font.PLAIN, fontTextSize));
	GridBagConstraints gbc_txtStudentID = new GridBagConstraints();
	gbc_txtStudentID.insets = new Insets(0, 0, 5, 0);
	gbc_txtStudentID.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtStudentID.gridx = 1;
	gbc_txtStudentID.gridy = 10;
	contentPane.add(txtStudentID, gbc_txtStudentID);
	
	JLabel lbContentComment = new JLabel("\u30B3\u30E1\u30F3\u30C8\u306E\u5185\u5BB9");
	lbContentComment.setFont(new Font(fontName, Font.BOLD, fontTextSize));
	GridBagConstraints gbc_lbContentComment = new GridBagConstraints();
	gbc_lbContentComment.anchor = GridBagConstraints.EAST;
	gbc_lbContentComment.insets = new Insets(0, 0, 0, 5);
	gbc_lbContentComment.gridx = 0;
	gbc_lbContentComment.gridy = 11;
	contentPane.add(lbContentComment, gbc_lbContentComment);
	
	txtContentComment = new JTextArea();
	txtContentComment.setForeground(SystemColor.textHighlight);
	
	txtContentComment.setFont(new Font(fontName, Font.PLAIN, 16));
	GridBagConstraints gbc_txtContentComment = new GridBagConstraints();
	gbc_txtContentComment.insets = new Insets(0, 0, 5, 0);
	gbc_txtContentComment.fill = GridBagConstraints.BOTH;
	gbc_txtContentComment.gridx = 1;
	gbc_txtContentComment.gridy = 11;
	contentPane.add(txtContentComment, gbc_txtContentComment);
	
	
	JPanel panel = new JPanel();
	panel.setBackground(Color.LIGHT_GRAY);
	GridBagConstraints gbc_panel = new GridBagConstraints();
	gbc_panel.insets = new Insets(0, 0, 5, 0);
	gbc_panel.anchor = GridBagConstraints.EAST;
	gbc_panel.fill = GridBagConstraints.VERTICAL;
	gbc_panel.gridx = 1;
	gbc_panel.gridy = 12;
	contentPane.add(panel, gbc_panel);
	
	JButton btnUpdate = new JButton("\u30B3\u30E1\u30F3\u30C8\u8FFD\u52A0");
	btnUpdate.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				clickAddComment();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	btnUpdate.setFont(new Font(fontName, Font.PLAIN, 18));
	panel.add(btnUpdate);
	
	JButton btnCancel = new JButton("\u30AD\u30E3\u30F3\u30BB\u30EB");
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


protected void clickToLink() {
	String url = job.getLink();
	try {
		java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(contentPane, "現在はファイルがありません。");
		e.printStackTrace();
	}
	
}

private void LoadData() throws SQLException
{
	LoadDataGroupJob();
	LoadDataOFListComment();
	
	
}
private void LoadDataGroupJob() throws SQLException
{
	List<GroupJob> lstGroup = ctrGroup.loadData();
	
	
	for(GroupJob g:lstGroup)
	{
		dModelGroup.addElement(g);
		if(g.getId()==job.getGroupid())
		{
			dModelGroup.setSelectedItem(g);
		}
	}
	
	
}



protected void clickCancel() {
	// TODO Auto-generated method stub
	ToMainMenu();
}

protected void clickAddComment() throws SQLException {
	// TODO Auto-generated method stub
	if(checkTextBox())
	{
		if(comment!=null)
		{
			
//			Date date = new Date();
//			String dateString = date.toString();
			comment.setMemo(new Date().toString());
			ctrCom.add(comment);
			toReloadComment();
			//ToMainMenu();
		}
	}
	
}


private void toReloadComment() {
	// TODO Auto-generated method stub
	contentPane.remove(jsp);
	LoadDataOFListComment();
	setTableToMain();
	contentPane.revalidate(); 
	contentPane.repaint();
	txtContentComment.setText("");
	
	
}
private void setTableToMain() {
	// TODO Auto-generated method stub
	System.out.println("add?");
	if(jsp!=null)
	{
		//frame.getContentPane().remove(jsp);
//		frame.getContentPane().repaint();
		System.out.println("remove jsp-------------------------");
	}

	jsp = new JScrollPane(table);
	GridBagConstraints gbc_panel_ListComment = new GridBagConstraints();
	gbc_panel_ListComment.insets = new Insets(0, 0, 5, 0);
	gbc_panel_ListComment.fill = GridBagConstraints.BOTH;
	gbc_panel_ListComment.gridx = 1;
	gbc_panel_ListComment.gridy = 9;
	contentPane.add(jsp, gbc_panel_ListComment);
}
	

protected void clickOpenPDF() {
	String fileName = job.getImage();

    	if(checkFilePDF(fileName))
    	{
    		txtFileName.setText(fileName);
    		System.out.println("file-"+fileName);
    		String url = "file:///"+fixUrl(fileName);
    		System.out.println("-------------------"+url);
//			String url = "file:///N:\\就職\\2017\\求人票\\カケハシ就職エージェント求人票\\doubLe（クリエイティブ職）_18.pdf";
//			url=job.getLinkAddress();
	        try {
				java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(contentPane, "現在はファイルがありません。");
				e.printStackTrace();
			}
    	}
    	else
    	{
    		JOptionPane.showMessageDialog(contentPane, "すみませんが、ファイルはPDFではありません。");
    		txtFileName.setText("");
    	}

    
}

private void ToMainMenu()
{
	mainFrame.setVisible(false);
	StudentMainMenu = new StudentMainMenu();
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
	
	String studentId = txtStudentID.getText();
	String content = txtContentComment.getText();
	int countCheck=0;
	
	
	if(studentId==null||studentId.equals(""))
	{
		check= false;
		
	}
	if(content==null||content.equals(""))
	{
		
		check= false;
	}
	if(check)
	{
		comment = new Comment(job.getId(), studentId, content);
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
private String fixUrl(String url)
{
	String result ="";
	char oldChar='\\';
	char newChar ='/';
	result=url.replace(oldChar, newChar);
	return result;
}
private boolean AddComment(Comment comment)
{
	boolean check = false;
	
	return check;
}
private void LoadDataOFListComment() 
{
	try {
		ctrCom = new ControlComment();
		lstCom=  ctrCom.loadData(job);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(lstCom.size()>0)
	{
		//cach 1
		TableValuesOfComment tableValues = new TableValuesOfComment(lstCom);
		table = new JTable(tableValues);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		TableColumn column = null;
	    for (int i = 0; i < 3; i++) {
	        column = table.getColumnModel().getColumn(i);
	        if (i == 1) {
	            column.setPreferredWidth(750); 
	           
	        } 
	        
	        if(i==0)
	        {
	        	column.setMaxWidth(80);
	        }
	       
	      
	    }
	}
	
	
}

}
