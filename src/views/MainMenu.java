package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import composite.ImagePanel;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainMenu {

	private JFrame frame;
	private JLabel lblTime;
	private JLabel lbltextContent3;
	private JLabel lbltextContent2;
	private JLabel lbltextContent1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
		clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{100,100, 700, 200};
		gbl_panel.rowHeights = new int[]{50, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0};
		panel.setLayout(gbl_panel);
		JLabel wIcon = new JLabel("");
		
		
		try {
			ImageIcon imageIcon = new ImageIcon(".\\logo.png");
			wIcon.setIcon(new ImageIcon("C:\\Users\\J1637009\\workspace\\Jobs\\src\\img\\logo.png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_11.gridx = 0;
		gbc_lblNewLabel_11.gridy = 0;
		panel.add(wIcon, gbc_lblNewLabel_11);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{24, 25, 0};
		gbl_panel_2.rowHeights = new int[]{13, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDate.insets = new Insets(0, 0, 0, 5);
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 1;
		panel_2.add(lblDate, gbc_lblDate);
		Date time = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd ");
 
   
		String showTime = sdf.format(time.getTime());
		lblDate.setText(" "+showTime);
		
		lblTime = new JLabel("Time");
		lblTime.setFont(new Font("MS UI Gothic", Font.BOLD | Font.ITALIC, 18));
		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTime.gridx = 0;
		gbc_lblTime.gridy = 2;
		panel_2.add(lblTime, gbc_lblTime);
		
		JLabel lblAaaaaaaaaaaaaccccccccc = new JLabel("\u5B66\u751F\u5411\u3051\u5C31\u8077\u60C5\u5831\u30A2\u30D7\u30EA");
		lblAaaaaaaaaaaaaccccccccc.setFont(new Font("MS UI Gothic", Font.BOLD, 50));
		GridBagConstraints gbc_lblAaaaaaaaaaaaaccccccccc = new GridBagConstraints();
		gbc_lblAaaaaaaaaaaaaccccccccc.insets = new Insets(0, 0, 5, 5);
		gbc_lblAaaaaaaaaaaaaccccccccc.gridx = 2;
		gbc_lblAaaaaaaaaaaaaccccccccc.gridy = 0;
		panel.add(lblAaaaaaaaaaaaaccccccccc, gbc_lblAaaaaaaaaaaaaccccccccc);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaption);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 3;
		gbc_panel_3.gridy = 0;
		panel.add(panel_3, gbc_panel_3);
		
		JButton btnCus = new JButton("\u691C\u7D22");
		btnCus.setFocusPainted(false);
		btnCus.setIcon(new ImageIcon("C:\\Users\\J1637009\\workspace\\Jobs\\src\\img\\search.png"));
		btnCus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				StudentMainMenu studentMainMenu = new StudentMainMenu();
				
			}
		});
		panel_3.add(btnCus);
		
		JButton btnAdmin = new JButton("\u7BA1\u7406");
		btnAdmin.setFocusPainted(false);
		btnAdmin.setIcon(new ImageIcon("C:\\Users\\J1637009\\workspace\\Jobs\\src\\img\\login.png"));
		btnAdmin.setFocusable(false);
		btnAdmin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				AdminMainMenu adminMainMenu = new AdminMainMenu();
				
			}
		});
		panel_3.add(btnAdmin);
		
		JButton btnNewButton_5 = new JButton("\u9589\u3058\u308B");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_5.setFocusPainted(false);
		btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\J1637009\\workspace\\Jobs\\src\\img\\close.png"));
		panel_3.add(btnNewButton_5);
		
		
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(8, 1, 0, 0));
		
		JLabel lblGuido = new JLabel("アプリガイド");
		panel_1.add(lblGuido);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel_1.add(btnNewButton_3);
		
		ImagePanel panel_imgage = new ImagePanel("C:\\Users\\J1637009\\workspace\\Jobs\\src\\img\\admin.jpg");
//		JPanel panel_imgage = new JPanel();
		frame.getContentPane().add(panel_imgage, BorderLayout.CENTER);
		GridBagLayout gbl_panel_imgage = new GridBagLayout();
		gbl_panel_imgage.columnWidths = new int[]{850, 200, 0, 0};
		gbl_panel_imgage.rowHeights = new int[]{700, 0};
		gbl_panel_imgage.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_imgage.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_imgage.setLayout(gbl_panel_imgage);
		
//		ImagePanel panel_ViewImage = new ImagePanel(".\\admin.jpg");
//		JPanel panel_ViewImage = new JPanel();
//		GridBagConstraints gbc_panel_ViewImage = new GridBagConstraints();
//		gbc_panel_ViewImage.anchor = GridBagConstraints.NORTHWEST;
////		gbc_panel_ViewImage.insets = new Insets(5, 0, 5, 5);
//		
//		gbc_panel_ViewImage.gridx = 0;
//		gbc_panel_ViewImage.gridy = 0;
//		panel_imgage.add(panel_ViewImage, gbc_panel_ViewImage);
//		
		JPanel panel_ViewText = new JPanel();
		GridBagConstraints gbc_panel_ViewText = new GridBagConstraints();
		gbc_panel_ViewText.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel_ViewText.gridx = 1;
		gbc_panel_ViewText.gridy = 0;
		panel_imgage.add(panel_ViewText, gbc_panel_ViewText);
		GridBagLayout gbl_panel_ViewText = new GridBagLayout();
		gbl_panel_ViewText.columnWidths = new int[]{1, 0};
		gbl_panel_ViewText.rowHeights = new int[]{1, 0, 0, 0};
		gbl_panel_ViewText.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_ViewText.rowWeights = new double[]{0.0, Double.MIN_VALUE, 0.0, 1.0};
		panel_ViewText.setLayout(gbl_panel_ViewText);
		
		JLabel lblNewLabel_8 = new JLabel("Step 1");
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setFont(new Font("MS UI Gothic", Font.BOLD | Font.ITALIC, 14));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 0;
		panel_ViewText.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		lbltextContent1 = new JLabel("  textContent1 textContent1 textContent1textContent1textContent1textContent1textContent1textContent1");
		GridBagConstraints gbc_lbltextContent1 = new GridBagConstraints();
		gbc_lbltextContent1.insets = new Insets(0, 0, 5, 0);
		gbc_lbltextContent1.fill = GridBagConstraints.BOTH;
		gbc_lbltextContent1.gridx = 1;
		gbc_lbltextContent1.gridy = 0;
		panel_ViewText.add(lbltextContent1, gbc_lbltextContent1);
		
		JLabel lblNewLabel_9 = new JLabel("Step 2");
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setFont(new Font("MS UI Gothic", Font.BOLD | Font.ITALIC, 14));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 1;
		panel_ViewText.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		lbltextContent2 = new JLabel("  textContent2");
		GridBagConstraints gbc_lbltextContent2 = new GridBagConstraints();
		gbc_lbltextContent2.insets = new Insets(0, 0, 5, 0);
		gbc_lbltextContent2.fill = GridBagConstraints.BOTH;
		gbc_lbltextContent2.gridx = 1;
		gbc_lbltextContent2.gridy = 1;
		panel_ViewText.add(lbltextContent2, gbc_lbltextContent2);
		
		
		JLabel lblNewLabel_10 = new JLabel("Step 3");
		lblNewLabel_10.setForeground(Color.RED);
		lblNewLabel_10.setFont(new Font("MS UI Gothic", Font.BOLD | Font.ITALIC, 14));
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 2;
		panel_ViewText.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		lbltextContent3 = new JLabel("  textContent3");
		GridBagConstraints gbc_lbltextContent3 = new GridBagConstraints();
		gbc_lbltextContent3.insets = new Insets(0, 0, 5, 0);
		gbc_lbltextContent3.fill = GridBagConstraints.BOTH;
		gbc_lbltextContent3.gridx = 1;
		gbc_lbltextContent3.gridy = 2;
		panel_ViewText.add(lbltextContent3, gbc_lbltextContent3);
		
		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 0, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 3;
		panel_ViewText.add(textArea, gbc_textArea);
		
		
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
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel_GroupMember.add(lblNewLabel, gbc_lblNewLabel);
		
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
		
		JPanel panel_East = new JPanel();
		frame.getContentPane().add(panel_East, BorderLayout.EAST);
		frame.setVisible(true);
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
