import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Signup extends JFrame implements ActionListener{
	public Button buttonExit;
	public Button buttonBack ;
	public Button buttonSubmit;
	public Label title;
	public Label header;
	public Label usernameLabel;
	public Label passwordLabel;
	public Label nameLabel;
	public Label phoneLabel;
	public Label addressLabel;
	public TextField usernameTF;
	public TextField nameTF; 
	public TextField phoneTF1; 
	public TextField phoneTF2;
	public TextField addressTF; 
	public TextField passwordF;
	private Font f1;
	
	public Signup() {
		super("Sign up");
		this.setSize(800, 600);
		setBackground( new Color(214, 211, 211) );
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		f1 = new Font("ARIAL", Font.BOLD, 20);
		
		title = new Label(" Sign Up With Your Correct Details ");
		title.setBounds(30, 40, 555, 75);
		title.setAlignment(Label.CENTER);
		title.setFont(f1);
		title.setForeground(Color.WHITE);
		title.setBackground(new Color(88, 24, 69));
		add(title);
		
		
		
		buttonExit = new Button("Exit");
		buttonExit.setBounds(660, 40, 100,30);
		buttonExit.setBackground(new Color(88, 24, 69));
		buttonExit.setForeground(Color.WHITE);
		buttonExit.addActionListener(this);
		add(buttonExit);
		
		buttonBack = new Button("Back");
		buttonBack.setBounds(660, 80, 100,30);
		buttonBack.setBackground(new Color(88, 24, 69));
		buttonBack.setForeground(Color.WHITE);
		buttonBack.addActionListener(this);
		add(buttonBack);
		
		header = new Label();
		header.setBackground(new Color(12, 20, 91));
		header.setBounds(0, 40, 800, 75);
		add(header);
		
		usernameLabel = new Label("User ID: ");
		usernameLabel.setBounds(60, 140, 100, 30);
		usernameLabel.setBackground(new Color(173, 91, 163));
		usernameLabel.setForeground(Color.WHITE);
		add(usernameLabel);
		
		passwordLabel = new Label("Password: ");
		passwordLabel.setBounds(60, 190, 100, 30);
		passwordLabel.setBackground(new Color(173, 91, 163));
		passwordLabel.setForeground(Color.WHITE);
		add(passwordLabel);
		
		nameLabel = new Label("Name: ");
		nameLabel.setBounds(60, 240, 100, 30);
		nameLabel.setBackground(new Color(173, 91, 163));
		nameLabel.setForeground(Color.WHITE);
		add(nameLabel);
		
		phoneLabel = new Label("Phone No: ");
		phoneLabel.setBounds(60, 290, 100, 30);
		phoneLabel.setBackground(new Color(173, 91, 163));
		phoneLabel.setForeground(Color.WHITE);
		add(phoneLabel);
		
		addressLabel = new Label("Address: ");
		addressLabel.setBounds(60, 340, 100, 30);
		addressLabel.setBackground(new Color(173, 91, 163));
		addressLabel.setForeground(Color.WHITE);
		add(addressLabel);
		
		usernameTF = new TextField(50);
		usernameTF.setBounds(160, 140, 220, 30);
		usernameTF.setBackground(new Color(207, 181, 204));
		usernameTF.setForeground(Color.BLACK);
		add(usernameTF);
		
		
		passwordF = new TextField();
		passwordF.setBounds(160, 190, 220, 30);
		passwordF.setBackground(new Color(207, 181, 204));
		passwordF.setForeground(Color.BLACK);
		passwordF.setEchoChar('*');
		add(passwordF);
		
		nameTF = new TextField();
		nameTF.setBounds(160, 240, 220, 30);
		nameTF.setBackground(new Color(207, 181, 204));
		nameTF.setForeground(Color.BLACK);
		add(nameTF);
		
		phoneTF1 = new TextField(" +880 ");
		phoneTF1.setBounds(160, 290, 40, 30);
		phoneTF1.setBackground(new Color(207, 181, 204));
		phoneTF1.setForeground(Color.BLACK);
		phoneTF1.setEnabled(false);
		add(phoneTF1);
		
		phoneTF2 = new TextField(50);
		phoneTF2.setBounds(200, 290, 180, 30);
		phoneTF2.setBackground(new Color(207, 181, 204));
		phoneTF2.setForeground(Color.BLACK);
		add(phoneTF2);
		
		addressTF = new TextField(50);
		addressTF.setBounds(160, 340, 220, 30);
		addressTF.setBackground(new Color(207, 181, 204));
		addressTF.setForeground(Color.BLACK);
		add(addressTF);
	
	    buttonSubmit = new Button("Submit");
		buttonSubmit.setBounds(70, 400, 300, 35);
		buttonSubmit.setBackground(new Color(88, 24, 69));
		buttonSubmit.setForeground(Color.WHITE);
		buttonSubmit.addActionListener(this);
		add(buttonSubmit);
	
		setSize(800,600);
		setLocation(100,100);
		setLayout(null);
		
		WindowSensor ws=new WindowSensor();
		addWindowListener(ws);
	}
	
	class WindowSensor extends WindowAdapter
	{
	public void windowClosing(WindowEvent we)
	{
		System.out.println("Window closing");
		System.exit(0);
	}
    }
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonExit))
			System.exit(0);
		else if (ae.getSource().equals(buttonBack)) {
			this.setVisible(false);
			new Login().setVisible(true);
		}
		else if (ae.getSource().equals(buttonSubmit)) {
			try {
				Customer c = new Customer(usernameTF.getText().trim());
				c.setPassword(passwordF.getText());
				c.setCustomerName(nameTF.getText());
				c.setPhoneNumber(Integer.parseInt(phoneTF2.getText()));
				c.setAddress(addressTF.getText());
				c.createCustomer(this);
				
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Enter phone no correctly!"); 
			}
			catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(this,e.getMessage()); 
			}
		}
		else {}
	}
}