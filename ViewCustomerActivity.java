import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.event.*;

public class ViewCustomerActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private JFrame activity;
	private Employee employee;
	private JScrollPane frame;
	JComboBox byWhatCB;
	JTable table;
	private JButton buttonLogout, buttonBack, buttonCheck;
	private JLabel title, header, keywordLabel;
	JTextField keywordTF;
	
	public ViewCustomerActivity(JFrame prev, Employee employee) {
		super("View Customer");
		
		this.setSize(800, 600);
		setBackground( new Color(214, 211, 211) );
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		
		panel = new JPanel();
		panel.setLayout(null);
		//panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("View Customer");
		title.setBounds(30, 40, 340,75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setForeground(Color.WHITE);
		title.setBackground(new Color(88, 24, 69));
		panel.add(title);
		
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(660, 40,100,30);
		buttonLogout.setForeground(Color.WHITE);
		buttonLogout.setBackground(new Color(88, 24, 69));
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);
		
		buttonBack = new JButton("Back");
		buttonBack.setBounds(660, 80, 100,30);
		buttonBack.setForeground(Color.WHITE);
		buttonBack.setBackground(new Color(88, 24, 69));
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		
		keywordLabel = new JLabel("Keyword: ");
		keywordLabel.setBounds(60, 140, 140, 30);
		panel.add(keywordLabel);
		
		keywordTF = new JTextField();
		keywordTF.setBounds(160, 140, 240, 30);
		panel.add(keywordTF);
		
		byWhatCB = new JComboBox(new Object[]{"By ID", "By Name"});
		byWhatCB.setBounds(400, 140, 100,30);
		panel.add(byWhatCB);
		
		buttonCheck = new JButton("Search");
		buttonCheck.setBounds(500, 140, 100,30);
		buttonCheck.setForeground(Color.WHITE);
		buttonCheck.setBackground(new Color(88, 24, 69));
		buttonCheck.addActionListener(this);
		panel.add(buttonCheck);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(Customer.columnName);
		table.setModel(model);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
               jTable_ClickMouseClicked(evt);
            }
		});
		frame = new JScrollPane(table);
		frame.setBounds(40,185,600,300);
		panel.add(frame);
		
		table.setModel(Customer.searchCustomer("", "By Name"));
		
		header = new JLabel();
		//header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, 800, 75);
		panel.add(header);
		
		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonLogout)) {
			this.setVisible(false);
			new Loginadmin().setVisible(true);
		}
		else if (ae.getSource().equals(buttonBack)) {
			this.setVisible(false);
			activity.setVisible(true);
		}
		else if (ae.getSource().equals(buttonCheck)) {
			table.setModel(Customer.searchCustomer(keywordTF.getText().trim(), byWhatCB.getSelectedItem().toString()));
		}
		else {}
	}
	
	private void jTable_ClickMouseClicked(MouseEvent evt) {                                          
       int index = table.getSelectedRow();

       TableModel model = table.getModel();

       String value1 = model.getValueAt(index, 0).toString();
	   new ManageCustomer(value1, this).setVisible(true);
    }
}