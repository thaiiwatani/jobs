package views;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.plaf.FileChooserUI;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Link;
import composite.TestComposite;
import java.awt.Choice;
import org.eclipse.jface.fieldassist.ControlDecoration;
import composite.textChooseFile;
import org.eclipse.swt.widgets.Combo;

public class JobAdd {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Font fontText =  new Font("ÇlÇr ÇoÉSÉVÉbÉN å©èoÇµ",Font.BOLD , 18);
	private Shell shell;
	private AdminMainMenu adminMainMenu;
	private Text text_6;
	private String selectedDir=""   ;
	
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public JobAdd()
	{
		open();
	}
	public static void main(String[] args) {
		try {
			JobAdd window = new JobAdd();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	private void ToAdminMenu()
	{
		System.out.println("Day");
//		shell.setVisible(false);
		shell.close();
		
		try {
			adminMainMenu = new AdminMainMenu();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void open() {
		Display display = Display.getDefault();
		shell = new Shell();
		shell.setSize(605, 653);
		shell.setText("New Job");
		shell.setLayout(new GridLayout(2, false));
//		shell.setDefaultButton();
		new Label(shell, SWT.NONE);
		
		Label lblCreateNewJob = new Label(shell, SWT.NONE);
		lblCreateNewJob.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		lblCreateNewJob.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblCreateNewJob.setFont(SWTResourceManager.getFont("Yu Gothic UI", 18, SWT.NORMAL));
		lblCreateNewJob.setText("Create new Job");
		
		Label lblGroupJob = new Label(shell, SWT.NONE);
		lblGroupJob.setFont(SWTResourceManager.getFont("Yu Gothic UI", 14, SWT.NORMAL));
		lblGroupJob.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblGroupJob.setText("Group Job");
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setFont(SWTResourceManager.getFont("Yu Gothic UI", 14, SWT.NORMAL));
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblName = new Label(shell, SWT.NONE);
		lblName.setFont(SWTResourceManager.getFont("Yu Gothic UI", 16, SWT.NORMAL));
		lblName.setAlignment(SWT.RIGHT);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setText("Name");
		
		text = new Text(shell, SWT.BORDER);
		text.setFont(SWTResourceManager.getFont("Yu Gothic UI", 14, SWT.NORMAL));
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblCompany = new Label(shell, SWT.NONE);
		lblCompany.setFont(SWTResourceManager.getFont("Yu Gothic UI", 16, SWT.NORMAL));
		lblCompany.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCompany.setText("Company");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setFont(SWTResourceManager.getFont("Yu Gothic UI", 14, SWT.NORMAL));
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblAddress = new Label(shell, SWT.NONE);
		lblAddress.setFont(SWTResourceManager.getFont("Yu Gothic UI", 16, SWT.NORMAL));
		lblAddress.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAddress.setText("Address");
		
		text_2 = new Text(shell, SWT.BORDER | SWT.MULTI);
		text_2.setFont(SWTResourceManager.getFont("Yu Gothic UI", 14, SWT.NORMAL));
		GridData gd_text_2 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_2.heightHint = 61;
		text_2.setLayoutData(gd_text_2);
		
		Label lblSalary = new Label(shell, SWT.NONE);
		lblSalary.setFont(SWTResourceManager.getFont("Yu Gothic UI", 16, SWT.NORMAL));
		lblSalary.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSalary.setText("Salary");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setFont(SWTResourceManager.getFont("Yu Gothic UI", 14, SWT.NORMAL));
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblLinkAccess = new Label(shell, SWT.NONE);
		lblLinkAccess.setFont(SWTResourceManager.getFont("Yu Gothic UI", 16, SWT.NORMAL));
		lblLinkAccess.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLinkAccess.setText("Link Access");
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setFont(SWTResourceManager.getFont("Yu Gothic UI", 14, SWT.NORMAL));
		text_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblInformation = new Label(shell, SWT.NONE);
		lblInformation.setFont(SWTResourceManager.getFont("Yu Gothic UI", 16, SWT.NORMAL));
		lblInformation.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblInformation.setText("Information");
		
		text_5 = new Text(shell, SWT.BORDER | SWT.MULTI);
		text_5.setFont(SWTResourceManager.getFont("Yu Gothic UI", 14, SWT.NORMAL));
		GridData gd_text_5 = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_text_5.widthHint = 367;
		gd_text_5.heightHint = 193;
		text_5.setLayoutData(gd_text_5);
		
		
		Label lblFileName = new Label(shell, SWT.NONE);
		lblFileName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFileName.setFont(SWTResourceManager.getFont("Yu Gothic UI", 16, SWT.NORMAL));
		lblFileName.setText("File Name");
		JFileChooser fileChooser = new JFileChooser();
		
		text_6 = new Text(shell, SWT.BORDER);
		text_6.setFont(SWTResourceManager.getFont("Yu Gothic UI", 14, SWT.NORMAL));
		text_6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(shell, SWT.NONE);
		
		Button btnBroswer = new Button(shell, SWT.NONE);
		btnBroswer.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnBroswer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				text_6.setText(ChooseFile());
				if(!checkFilePDF(text_6.getText()))
				{
					JOptionPane.showMessageDialog(adminMainMenu, "Please choose a PDF file");
					text_6.setText("");
//					JOptionPane.showMessageDialog(adminMainMenu, message);
					
				}
				
					
			}
		});
		btnBroswer.setFont(SWTResourceManager.getFont("Yu Gothic UI", 12, SWT.NORMAL));
		btnBroswer.setText("Broswer");
				
				Button btnCancel = new Button(shell, SWT.NONE);
				btnCancel.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						ToAdminMenu();
//						adminMainMenu.setVisible(true);
					}
				});
				btnCancel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
				btnCancel.setFont(SWTResourceManager.getFont("Yu Gothic UI", 16, SWT.NORMAL));
				btnCancel.setText("Cancel");
				
				Button btnCreate = new Button(shell, SWT.NONE);
				btnCreate.setFont(SWTResourceManager.getFont("Yu Gothic UI", 16, SWT.NORMAL));
				btnCreate.setText("Create");
		shell.setDefaultButton(btnCancel);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
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
	private String ChooseFile()
	{
		String selected ="";
		FileDialog dialog = new FileDialog(shell, SWT.OPEN);
	    dialog.setFilterNames(new String[] { "Fdf Files", "All Files (*.*)" });
	    dialog.setFilterExtensions(new String[] { "*.pdf", "*.*" }); // Windows
	                                    // wild
	                                    // cards
//	    dialog.setFilterPath("c:\\"); // Windows path
	    try{
	    String dir =dialog.open();
	    if(dir!=null)
	    	{
	    	selected=dir;
	    	return dir;
	    	}
	    }
	    catch (Exception e) {
			selected="Error";
		}
	    
	    return selected;
	    
//		DirectoryDialog directoryDialog = new DirectoryDialog(shell);
//        System.out.println("OUT111111");
//        directoryDialog.setFilterPath(selectedDir);
//        directoryDialog.setMessage("Please select a directory and click OK");
//        
//        String dir = directoryDialog.open();
//        if(dir != null) {
//        	selectedDir = dir;
//        	return dir;
//        }
//        return selectedDir;
		//return dir;
	}
}
