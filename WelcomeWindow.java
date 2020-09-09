import java. lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class WelcomeWindow extends Frame implements ActionListener
{
    public Label title;
	public JLabel imgLabel;
	public JLabel imgLabel2;
	public JLabel imgLabel3;
	private Button logInAsAdminBtn;
    private Button logInAsUserBtn;
	private ImageIcon img;
	public ImageIcon img2;
	public ImageIcon img3;
	private Font f1;
	private Font f2;
	
	public WelcomeWindow(){
		super("Welcome Window");
		
		this.setSize(800, 600);
		setBackground( new Color(214, 211, 211) );
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		f1 = new Font("ARIAL", Font.BOLD, 25);
		f2 = new Font("ARIAL", Font.PLAIN, 15);
	
	    title = new Label("Shop Management System");
		title.setBounds(30, 40, 740, 75);
		title.setFont(f1);
		title.setAlignment(Label.CENTER);
		title.setForeground(Color.WHITE);
		title.setBackground(new Color(88, 24, 69));
		add(title);
		
		logInAsUserBtn = new Button("Log In As User");
        logInAsUserBtn.setBounds(300, 280, 220, 50);
        logInAsUserBtn.setBackground(new Color(88, 24, 69));
		logInAsUserBtn.setForeground(Color.WHITE);
		logInAsUserBtn.setFont(new Font("Microsoft Himalaya",Font.BOLD,14));
		logInAsUserBtn.addActionListener(this);
		add(logInAsUserBtn); 
		
		 logInAsAdminBtn = new Button("Log In As Admin");
		 logInAsAdminBtn.setBounds(300, 220, 220, 50);
		 logInAsAdminBtn.setBackground(new Color(88, 24, 69));
		 logInAsAdminBtn.setForeground(Color.WHITE);
		 logInAsAdminBtn.setFont(new Font("Microsoft Himalaya",Font.BOLD,14));
		 logInAsAdminBtn.addActionListener(this);
		 add(logInAsAdminBtn);
		 
		/*img = new ImageIcon("Bus2.png");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(100, 350, 600, 250);
		add(imgLabel);*/
		 
       
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
	if (ae.getSource().equals(logInAsUserBtn))
	{
		this.setVisible(false);
	    new Login().setVisible(true);
	}
	else if (ae.getSource().equals(logInAsAdminBtn))
	{
	    this.setVisible(false);
		new Loginadmin().setVisible(true);
	}	
		else {}
}

}