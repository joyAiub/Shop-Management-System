import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class MyProfileActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private JButton buttonEdit, buttonBack, buttonLogout, buttonSubmit, buttonPass, buttonDelete;
	private JFrame backActivity;
	private User usr;
	//private Employee employee;
	private Customer customer;
	private JLabel title, header, usernameLabel, nameLabel, phoneLabel, addressLabel;
	private JTextField nameTF, phoneTF1, phoneTF2, addressTF;
	private JLabel roleLabel, salaryLabel;
	
	public MyProfileActivity(JFrame activity, Customer customer) {
		super("My Profile");
		
		this.setSize(800, 600);
		setBackground( new Color(214, 211, 211) );
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		backActivity = activity;
		this.customer = customer;
		this.usr = (User) customer;
		
		title = new JLabel("Profile");
		title.setBounds(30, 40, 260,50);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(new Font("Open Sans", Font.BOLD, 25));
		title.setBackground(new Color(88, 24, 69));
		title.setForeground(Color.WHITE);
		panel.add(title);
		
		buttonEdit = new JButton("Edit Profile");
		buttonEdit.setBounds(60, 330, 140, 30);
		buttonEdit.setBackground(Color.RED);
		buttonEdit.setForeground(Color.WHITE);
		buttonEdit.addActionListener(this);
		panel.add(buttonEdit);
		
		buttonSubmit = new JButton("Submit");
		buttonSubmit.setBounds(60, 360, 140, 30);
		buttonSubmit.setBackground(Color.RED);
		buttonSubmit.setForeground(Color.WHITE);
		buttonSubmit.setVisible(false);
		buttonSubmit.addActionListener(this);
		panel.add(buttonSubmit);
		
		buttonPass = new JButton("Change Password");
		buttonPass.setBounds(620, 115, 140, 30);
		buttonPass.setBackground(Color.RED);
		buttonPass.setForeground(Color.WHITE);
		buttonPass.addActionListener(this);
		panel.add(buttonPass);
		
		buttonDelete = new JButton("Delete Account");
		buttonDelete.setBounds(620, 150, 140, 30);
		buttonDelete.setBackground(Color.RED);
		buttonDelete.setForeground(Color.WHITE);
		buttonDelete.addActionListener(this);
		panel.add(buttonDelete);
		
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(620, 40, 140, 30);
		buttonLogout.setBackground(Color.RED);
		buttonLogout.setForeground(Color.WHITE);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);
		
		buttonBack = new JButton("Back");
		buttonBack.setBounds(620, 80, 140, 30);
		buttonBack.setBackground(Color.RED);
		buttonBack.setForeground(Color.WHITE);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		
		usernameLabel = new JLabel("User ID:       "+customer.getUserId());
		usernameLabel.setBounds(60, 140, 440, 30);
		panel.add(usernameLabel);
		
		nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(60, 190, 440, 30);
		panel.add(nameLabel);
		
		phoneLabel = new JLabel("Phone No: ");
		phoneLabel.setBounds(60, 240, 440, 30);
		panel.add(phoneLabel);
		
		nameTF = new JTextField(customer.getCustomerName());
		nameTF.setBounds(180, 190, 220, 30);
		nameTF.setEnabled(false);
		nameTF.setDisabledTextColor(Color.BLACK);
		panel.add(nameTF);
		
		
		phoneTF1 = new JTextField("+880");
		phoneTF1.setBounds(180, 240, 40, 30);
		phoneTF1.setEnabled(false);
		phoneTF1.setDisabledTextColor(Color.BLACK);
		panel.add(phoneTF1);
		
		phoneTF2 = new JTextField(customer.getPhoneNumber().substring(4));
		phoneTF2.setBounds(220, 240, 180, 30);
		phoneTF2.setEnabled(false);
		phoneTF2.setDisabledTextColor(Color.BLACK);
		panel.add(phoneTF2);
		
		addressTF = new JTextField(customer.getAddress());
		addressTF.setBounds(180, 290, 220, 30);
		addressTF.setEnabled(false);
		addressTF.setDisabledTextColor(Color.BLACK);
		panel.add(addressTF);
		
		addressLabel = new JLabel("Address: ");
		addressLabel.setBounds(60, 290, 440, 30);
		panel.add(addressLabel);
		
		header = new JLabel();
		header.setOpaque(true);
		header.setBounds(0, 0, 800, 75);
		panel.add(header);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonBack)) {
			this.setVisible(false);
			backActivity.setVisible(true);
		}
		else if (ae.getSource().equals(buttonLogout)) {
			this.setVisible(false);
			new Login().setVisible(true);
		}
		else if (ae.getSource().equals(buttonEdit)) {
			buttonEdit.setVisible(false);
			buttonSubmit.setVisible(true);
			nameTF.setEnabled(true);
			phoneTF2.setEnabled(true);
			if (customer!=null)
				addressTF.setEnabled(true);
		}
		else if (ae.getSource().equals(buttonSubmit)) 
		{
			
			if (customer!=null) {
				addressTF.setEnabled(false);
				try {
					customer.updateCustomer(nameTF.getText().trim(), Integer.parseInt(phoneTF2.getText()), addressTF.getText().trim());
					buttonEdit.setVisible(true);
					buttonSubmit.setVisible(false);
					nameTF.setEnabled(false);
					phoneTF2.setEnabled(false);
				}
				catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,"Invalid Number!");
				}
			}

		}
		else if (ae.getSource().equals(buttonPass)) {
			new ChangePasswordActivity( this.usr).setVisible(true);
		}
		else if (ae.getSource().equals(buttonDelete)) {
			int input = JOptionPane.showConfirmDialog(null, "Sure to Delete?", "Delete "+customer.getUserId()+"?", JOptionPane.YES_NO_OPTION);
			if (input == 0) {
				customer.deleteCustomer();
				this.setVisible(false);
				new Login().setVisible(true);
			}
			else {}
		}
		else {}
	}
}