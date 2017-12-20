package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Font;

public class MainMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{100, 800, 200};
		gbl_panel.rowHeights = new int[]{50, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		
		JLabel lblDate = new JLabel("Date");
		panel_2.add(lblDate);
		
		JLabel lblTime = new JLabel("Time");
		panel_2.add(lblTime);
		
		JLabel lblAaaaaaaaaaaaaccccccccc = new JLabel("\u5B66\u751F\u5411\u3051\u5C31\u8077\u60C5\u5831\u30A2\u30D7\u30EA");
		lblAaaaaaaaaaaaaccccccccc.setFont(new Font("MS UI Gothic", Font.BOLD, 30));
		GridBagConstraints gbc_lblAaaaaaaaaaaaaccccccccc = new GridBagConstraints();
		gbc_lblAaaaaaaaaaaaaccccccccc.insets = new Insets(0, 0, 0, 5);
		gbc_lblAaaaaaaaaaaaaccccccccc.gridx = 1;
		gbc_lblAaaaaaaaaaaaaccccccccc.gridy = 0;
		panel.add(lblAaaaaaaaaaaaaccccccccc, gbc_lblAaaaaaaaaaaaaccccccccc);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaption);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 0;
		panel.add(panel_3, gbc_panel_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
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
		
		JPanel panel_imgage = new JPanel();
		frame.getContentPane().add(panel_imgage, BorderLayout.CENTER);
		
		JPanel panel_South = new JPanel();
		frame.getContentPane().add(panel_South, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_South = new GridBagLayout();
		gbl_panel_South.columnWidths = new int[]{700, 300};
		gbl_panel_South.rowHeights = new int[]{0, 0, 0};
		gbl_panel_South.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_South.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_South.setLayout(gbl_panel_South);
		
		JPanel panel_GroupMember = new JPanel();
		GridBagConstraints gbc_panel_GroupMember = new GridBagConstraints();
		gbc_panel_GroupMember.insets = new Insets(0, 0, 5, 0);
		gbc_panel_GroupMember.fill = GridBagConstraints.BOTH;
		gbc_panel_GroupMember.gridx = 0;
		gbc_panel_GroupMember.gridy = 0;
		panel_South.add(panel_GroupMember, gbc_panel_GroupMember);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_GroupMember.add(lblNewLabel);
		
		JPanel panel_GroupInfor = new JPanel();
		GridBagConstraints gbc_panel_GroupInfor = new GridBagConstraints();
		gbc_panel_GroupInfor.fill = GridBagConstraints.BOTH;
		gbc_panel_GroupInfor.gridx = 1;
		gbc_panel_GroupInfor.gridy = 0;
		panel_South.add(panel_GroupInfor, gbc_panel_GroupInfor);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_GroupInfor.add(lblNewLabel_1);
		
		JPanel panel_East = new JPanel();
		frame.getContentPane().add(panel_East, BorderLayout.EAST);
	}

}
