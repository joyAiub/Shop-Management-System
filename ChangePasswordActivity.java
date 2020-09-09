import java.lang.*;
import java.awt.*;
import java.awt.event.*;

public class ChangePasswordActivity extends Frame implements ActionListener {
	private User user;
	private Label oldLabel, newLabel;
	private TextField oldPF, newPF;
	private Button buttonSubmit, buttonCancel;
	
	public ChangePasswordActivity(User user) {
		super("Change Password");
		
		this.setSize(500,200);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		setBackground( new Color(214, 211, 211) );
		
		this.user = user;
		
		oldLabel = new Label("Old Password: ");
		oldLabel.setBounds(40, 50, 100, 30);
		add(oldLabel);
		
		oldPF = new TextField();
		oldPF.setBounds(160, 50, 280, 30);
		oldPF.setBackground(new Color(207, 181, 204));
		oldPF.setEchoChar('*');
		add(oldPF);
		
		newLabel = new Label("New Password: ");
		newLabel.setBounds(40, 100, 100, 30);
		add(newLabel);
		
		newPF = new TextField();
		newPF.setBounds(160, 100, 280, 30);
		newPF.setBackground(new Color(207, 181, 204));
		newPF.setEchoChar('*');
		add(newPF);
		
		buttonSubmit = new Button("Change");
		buttonSubmit.setBounds(300, 150, 70,30);
		buttonSubmit.setBackground(new Color(88, 24, 69));
		buttonSubmit.setForeground(Color.WHITE);
		buttonSubmit.addActionListener(this);
		add(buttonSubmit);
		
		buttonCancel = new Button("Cancel");
		buttonCancel.setBounds(200, 150, 70,30);
		buttonCancel.setBackground(new Color(88, 24, 69));
		buttonCancel.setForeground(Color.WHITE);
		buttonCancel.addActionListener(this);
		add(buttonCancel);
		
		setSize(500,200);
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
		if (ae.getSource().equals(buttonSubmit)) {
			user.changePassword(this, oldPF.getText(), newPF.getText());
		}
		else if (ae.getSource().equals(buttonCancel)) {
			this.setVisible(false);
		}
		else {}
	}
}