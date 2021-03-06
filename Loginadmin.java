import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Loginadmin extends Frame implements ActionListener
{
	
	public Label title,header;
	public Label usernameLabel;
	public Label passwordLabel;
	public TextField usernameTF;
	public TextField password;
	public Button buttonLogin;
	public Button buttonExit;
	public Button buttonBack;
	public JLabel imgLabel;
	private ImageIcon img;
	public ImageIcon img2;
	public ImageIcon img3;
	private Font f1;
	
	public Loginadmin(){
		super("Admin Login Window");
		
		this.setSize(800, 600);
		setBackground( new Color(214, 211, 211) );
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		f1 = new Font("ARIAL", Font.BOLD, 20);
	
	    title = new Label("Shop Management System");
		title.setBounds(30, 40, 555, 75);
		title.setAlignment(Label.CENTER);
		title.setFont(f1);
		title.setForeground(Color.WHITE);
		title.setBackground(new Color(88, 24, 69));
		add(title);
		
	    buttonBack=new Button("Back");
		buttonBack.setBounds(660, 80, 100,30);
		buttonBack.setBackground(new Color(88, 24, 69));
		buttonBack.setForeground(Color.WHITE);
		buttonBack.addActionListener(this);
		add(buttonBack);
		
		usernameTF=new TextField();
		usernameTF.setBounds(330, 220, 220, 30);
		usernameTF.setBackground(new Color(207, 181, 204));
		usernameTF.setForeground(Color.BLACK);
		add(usernameTF);
		
		password=new TextField();
		password.setBounds(330, 280, 220, 30);
		password.setBackground(new Color(207, 181, 204));
		password.setForeground(Color.BLACK);
		password.setEchoChar('*');
		add(password);
		
		buttonLogin=new Button("Login");
		buttonLogin.setBounds(230, 345, 300, 30);
		buttonLogin.setBackground(new Color(88, 24, 69));
		buttonLogin.setForeground(Color.WHITE);
		buttonLogin.addActionListener(this);
		add(buttonLogin);
		
		buttonExit=new Button("Exit");
		buttonExit.setBounds(660, 40,100,30);
		buttonExit.setBackground(new Color(88, 24, 69));
		buttonExit.setForeground(Color.WHITE);
		buttonExit.addActionListener(this);
		add(buttonExit);
		
		header = new Label();
		header.setBackground(new Color(12, 20, 91));
		header.setBounds(0, 40, 800, 75);
		add(header);
		
	
		usernameLabel = new Label("User ID: ");
		usernameLabel.setBounds(210, 220, 120, 30);
		usernameLabel.setBackground(new Color(173, 91, 163));
		usernameLabel.setForeground(Color.BLACK);
		add(usernameLabel);
		
		passwordLabel = new Label("Password: ");
		passwordLabel.setBounds(210, 280, 120, 30);
		passwordLabel.setBackground(new Color(173, 91, 163));
		passwordLabel.setForeground(Color.BLACK);
		add(passwordLabel);
		
		img = new ImageIcon("A.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(50, 400, 220, 180);
		add(imgLabel);
		
        img = new ImageIcon("B.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(300, 400, 220, 180);
		add(imgLabel);		
      
	    img = new ImageIcon("C.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(550, 400, 220, 180);
		add(imgLabel);
		
		setSize(800,600);
		setLocation(100,100);
		setLayout(null);
		
		WindowSensor ws=new WindowSensor();
		addWindowListener(ws);
	}
class WindowSensor extends WindowAdapter{
	public void windowClosing(WindowEvent we){
		System.out.println("Window closing");
		System.exit(0);
	}
}
public void actionPerformed(ActionEvent ae) 
{
	if (ae.getSource().equals(buttonExit))
	{
		System.exit(0);
	}
	else if (ae.getSource().equals(buttonBack))
	{
		this.setVisible(false);
		new WelcomeWindow().setVisible(true);
	}
else if (ae.getSource().equals(buttonLogin)) {
			int status = User.checkStatus(usernameTF.getText(), password.getText());
			if (status == 0) {
				EmployeeActivity ea = new EmployeeActivity(usernameTF.getText());
				ea.setVisible(true);
				this.setVisible(false);
			}
			/*else if (status == 1) {
				CustomerActivity ca = new CustomerActivity(usernameTF.getText());
				ca.setVisible(true);
				this.setVisible(false);
			}*/
			else {
				JOptionPane.showMessageDialog(this,"Invalid ID or Password"); 
			}
		}
	
	else{}
}
}