package composite;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;

import entity.GroupJob;
import views.AdminMainMenu;

import javax.swing.JButton;
import java.awt.Color;

public class GJobAdd extends JPanel {
	private JTextField txtGroupJobName;
	private JTextField txtGroupJobMemo;
	private GroupJob groupJob;
	private boolean check = false;

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	/**
	 * Create the panel.
	 */
	public GJobAdd() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("\u7BA1\u7406\u30B7\u30B9\u30C6\u30E0\u3000\u30B5\u30A4\u30F3\u30A4\u30F3");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel label = new JLabel("\u8077\u7A2E\u8FFD\u52A0");
		label.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		add(label, gbc_label);
		
		JLabel label_1 = new JLabel("\u8077\u7A2E\u540D");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("MS UI Gothic", Font.BOLD | Font.ITALIC, 18));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		add(label_1, gbc_label_1);
		
		txtGroupJobName = new JTextField();
		txtGroupJobName.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		GridBagConstraints gbc_txtGroupJobName = new GridBagConstraints();
		gbc_txtGroupJobName.insets = new Insets(0, 0, 5, 0);
		gbc_txtGroupJobName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGroupJobName.gridx = 1;
		gbc_txtGroupJobName.gridy = 1;
		add(txtGroupJobName, gbc_txtGroupJobName);
		txtGroupJobName.setColumns(10);
		
		JLabel label_2 = new JLabel("\u30E1\u30E2");
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("MS UI Gothic", Font.BOLD | Font.ITALIC, 18));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 2;
		add(label_2, gbc_label_2);
		
		txtGroupJobMemo = new JTextField();
		txtGroupJobMemo.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		GridBagConstraints gbc_txtGroupJobMemo = new GridBagConstraints();
		gbc_txtGroupJobMemo.insets = new Insets(0, 0, 5, 0);
		gbc_txtGroupJobMemo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGroupJobMemo.gridx = 1;
		gbc_txtGroupJobMemo.gridy = 2;
		add(txtGroupJobMemo, gbc_txtGroupJobMemo);
		txtGroupJobMemo.setColumns(10);
		
		JLabel label_pas = new JLabel("\u30D1\u30B9\u30EF\u30FC\u30C9");
		GridBagConstraints gbc_label_pas = new GridBagConstraints();
		gbc_label_pas.insets = new Insets(0, 0, 5, 5);
		gbc_label_pas.gridx = 0;
		gbc_label_pas.gridy = 3;
		add(label_pas, gbc_label_pas);
		
		JLabel label_account = new JLabel("\u30A2\u30AB\u30A6\u30F3\u30C8");
		GridBagConstraints gbc_label_account = new GridBagConstraints();
		gbc_label_account.insets = new Insets(0, 0, 0, 5);
		gbc_label_account.gridx = 0;
		gbc_label_account.gridy = 4;
		add(label_account, gbc_label_account);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 4;
		add(panel, gbc_panel);
		
		JButton btnlogin = new JButton("\u30B5\u30A4\u30F3\u30A4\u30F3");
		panel.add(btnlogin);
		
		JButton btnAdd = new JButton("\u8FFD\u52A0");
		btnAdd.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		panel.add(btnAdd);
		
		JButton btnCancel = new JButton("\u30AD\u30E3\u30F3\u30BB\u30EB");
		btnCancel.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
		panel.add(btnCancel);
		btnAdd.addActionListener(new  ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name = txtGroupJobName.getText();
				String memo = txtGroupJobMemo.getText();
				groupJob = new GroupJob(name,memo);
				check = true;
				
			}
		});

	}

	public GroupJob getGroupJob() {
		return groupJob;
	}

	public void setGroupJob(GroupJob groupJob) {
		this.groupJob = groupJob;
	}
	

}
