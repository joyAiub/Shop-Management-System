import java. lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CustomerActivity extends JFrame implements ActionListener{
	private Button buttonLogout, buttonProfile, buttonpurchase, buttonhistory;
	private Label title, header;
	private JLabel imgLabel;
	private ImageIcon img;
	private Font f1;
	private Font f2;
	private Customer customer;
	
	public CustomerActivity(String userId) {
		super("Dashboard - Customer");
		
		this.setSize(800, 600);
		setBackground( new Color(214, 211, 211) );
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		f1 = new Font("ARIAL", Font.BOLD, 25);
		f2 = new Font("ARIAL", Font.BOLD, 15);
		
		customer = new Customer(userId);
		customer.fetch();
		
		title = new Label("Welcome, "+userId);
	    title.setBounds(30, 40,userId.length()*30+220,75);
		title.setFont(f1);
		title.setAlignment(Label.CENTER);
		title.setForeground(Color.WHITE);
		title.setBackground(new Color(88, 24, 69));
		add(title);
		
		buttonLogout = new Button("Logout");
		buttonLogout.setBounds(650, 40, 120,30);
		buttonLogout.setBackground(new Color(88, 24, 69));
		buttonLogout.setForeground(Color.WHITE);
		buttonLogout.addActionListener(this);
		add(buttonLogout);
		
		buttonProfile = new Button("My Profile");
		buttonProfile.setBounds(650, 80, 120,30);
		buttonProfile.setBackground(new Color(88, 24, 69));
		buttonProfile.setForeground(Color.WHITE);
		buttonProfile.addActionListener(this);
		add(buttonProfile);
		
		buttonpurchase = new Button("View Product");
		buttonpurchase.setBounds(60, 160, 200, 40);
		buttonpurchase.setFont(f2);
		buttonpurchase.setBackground(new Color(88, 24, 69));
		buttonpurchase.setForeground(Color.WHITE);
		buttonpurchase.addActionListener(this);
		add(buttonpurchase);
		
		buttonhistory = new Button("Purchase History");
		buttonhistory.setBounds(60, 210, 200, 40);
		buttonhistory.setFont(f2);
		buttonhistory.setBackground(new Color(88, 24, 69));
		buttonhistory.setForeground(Color.WHITE);
		//buttonhistory.addActionListener(this);
		add(buttonhistory);
		
		header = new Label();
		header.setBackground(new Color(12, 20, 91));
		header.setBounds(0, 40, 800, 75);
		add(header);
		
		img = new ImageIcon("Bus2.png");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(10, 300, 750, 250);
		add(imgLabel);
		 
		
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
		if (ae.getSource().equals(buttonLogout)) {
			this.setVisible(false);
			new Login().setVisible(true);
		}
		/*else if (ae.getSource().equals(buttonpurchase)) {
			this.setVisible(false);
			new BusInfo().setVisible(true);
		}*/
		else if (ae.getSource().equals(buttonpurchase)) {
			this.setVisible(false);
			new ViewProductActivity(this, customer).setVisible(true);
		}
		else if (ae.getSource().equals(buttonProfile)) {
			this.setVisible(false);
			new MyProfileActivity(this, customer).setVisible(true);
		}
		else {}
	}
}