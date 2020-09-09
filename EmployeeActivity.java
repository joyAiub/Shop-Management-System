import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class EmployeeActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private Employee employee;
	private JButton buttonLogout, buttonProfile, buttonViewProduct;
	private JButton buttonViewCustomer, buttonViewEmployee;
	private JLabel title, header;
	public JLabel imgLabel;
	private ImageIcon img;
	public ImageIcon img2;
	public ImageIcon img3;
	public EmployeeActivity(String userId) {
		super("Dashboard - Employee");
		
		this.setSize(800, 600);
		setBackground( new Color(214, 211, 211) );
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		employee = new Employee(userId);
		employee.fetch();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Welcome, "+userId);
		title.setBounds(30, 40, userId.length()*30+220,75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setBackground(new Color(88, 24, 69));
		title.setForeground(Color.WHITE);
		panel.add(title);
		
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(60, 220, 200, 30);
	    buttonLogout.setBackground(new Color(88, 24, 69));
		buttonLogout.setForeground(Color.WHITE);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);
		
		buttonProfile = new JButton("My Profile");
		buttonProfile.setBounds(650, 80, 120,30);
		buttonProfile.setBackground(new Color(88, 24, 69));
		buttonProfile.setForeground(Color.WHITE);
		buttonProfile.addActionListener(this);
		panel.add(buttonProfile);
		
		buttonViewProduct = new JButton("View Product");
		buttonViewProduct.setBounds(60, 160, 200, 30);
		buttonViewProduct.setBackground(new Color(88, 24, 69));
		buttonViewProduct.setForeground(Color.WHITE);
		buttonViewProduct.addActionListener(this);
		panel.add(buttonViewProduct);
		
		buttonViewCustomer = new JButton("View Customer");
		buttonViewCustomer.setBounds(60, 190, 200, 30);
	    buttonViewCustomer.setBackground(new Color(88, 24, 69));
		buttonViewCustomer.setForeground(Color.WHITE);
		buttonViewCustomer.addActionListener(this);
		panel.add(buttonViewCustomer);
		
		img = new ImageIcon("A.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(50, 380, 220, 180);
		add(imgLabel);
		
        img = new ImageIcon("B.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(300, 380, 220, 180);
		add(imgLabel);		
      
	    img = new ImageIcon("C.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(550, 380, 220, 180);
		add(imgLabel);
		
		if (employee.getRole().equals("Manager")) {
			buttonViewEmployee = new JButton("View Employee");
			buttonViewEmployee.setBounds(60, 220, 200, 30);
			buttonViewEmployee.setBackground(new Color(88, 24, 69));
		    buttonViewEmployee.setForeground(Color.WHITE);
			//buttonViewEmployee.addActionListener(this);
			panel.add(buttonViewEmployee);
		}
		
		header = new JLabel();
		header.setOpaque(true);
		header.setBounds(0, 0, 800, 75);
		panel.add(header);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonProfile)) {
			this.setVisible(false);
			new MyProfileActivity(this, employee).setVisible(true);
		}
		else if (ae.getSource().equals(buttonLogout)) {
			this.setVisible(false);
			new Loginadmin().setVisible(true);
		}
		else if (ae.getSource().equals(buttonViewProduct)) {
			this.setVisible(false);
			new ViewProductActivity(this, employee).setVisible(true);
		}
		else if (ae.getSource().equals(buttonViewCustomer)) {
			this.setVisible(false);
			new ViewCustomerActivity(this, employee).setVisible(true);
		}
		/*else if (ae.getSource().equals(buttonViewEmployee)) {
			this.setVisible(false);
			new ViewEmployeeActivity(this, employee).setVisible(true);
		}*/
		else {}
	}
}