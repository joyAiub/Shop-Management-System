import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.table.*;

public class MyProductActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private Customer customer;
	private JFrame activity;
	private JScrollPane frame;
	private JTable table;
	private JButton buttonLogout, buttonBack, buttonCheck;
	private JLabel title, header, keywordLabel, productNameLabel, productQtLabel, productPriceLabel;
	private JTextField keywordTF, productNameTF, productQtTF, productPriceTF;
	public MyProductActivity(JFrame prev, Customer customer) {
		super("Purchase History");
		
		this.setSize(800, 600);
		setBackground( new Color(214, 211, 211) );
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.activity = prev;
		this.customer = customer;
		
		panel = new JPanel();
		panel.setLayout(null);
		//panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("Purchase History");
		title.setBounds(30, 40, 480,75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setForeground(Color.WHITE);
		title.setBackground(new Color(88, 24, 69));
		panel.add(title);
		
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(660, 40, 100,30);
		buttonLogout.setBackground(new Color(88, 24, 69));
		buttonLogout.setForeground(Color.WHITE);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);
		
		buttonBack = new JButton("Back");
		buttonBack.setBounds(660, 80,100,30);
		buttonBack.setBackground(new Color(88, 24, 69));
		buttonBack.setForeground(Color.WHITE);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		
		table = new JTable();
		table.setModel(customer.myProduct());
		frame = new JScrollPane(table);
		frame.setBounds(40,140,600,300);
		panel.add(frame);
		
		header = new JLabel();
		//header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0,800, 75);
		panel.add(header);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonLogout)) {
			this.setVisible(false);
			new Login().setVisible(true);
		}
		else if (ae.getSource().equals(buttonBack)) {
			this.setVisible(false);
			activity.setVisible(true);
		}
		else {}
	}
	
	private void jTable_ClickMouseClicked(MouseEvent evt) {                                          
       
    }
}