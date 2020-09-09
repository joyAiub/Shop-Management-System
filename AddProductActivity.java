import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class AddProductActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private ViewProductActivity activity;
	private Employee employee;
	private JButton buttonLogout, buttonBack, buttonAdd;
	private JLabel title, header, productNameLabel, productQtLabel, productPriceLabel;
	private JTextField productNameTF, productQtTF, productPriceTF;
	
	public AddProductActivity(ViewProductActivity prev, Employee employee) {
		super("Add Product");
		
		this.setSize(800, 600);
		setBackground( new Color(214, 211, 211) );
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.activity = prev;
		this.employee = employee;
		
		panel = new JPanel();
		panel.setLayout(null);
		//panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("Add Product");
		title.setBounds(30, 40, 280,75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setBackground(new Color(88, 24, 69));
		title.setForeground(Color.WHITE);
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
		
		productNameLabel = new JLabel("Name: ");
		productNameLabel.setBounds(60, 190, 140, 30);
		panel.add(productNameLabel);
		
		productPriceLabel = new JLabel("Price: ");
		productPriceLabel.setBounds(60, 240, 140, 30);
		panel.add(productPriceLabel);
		
		productQtLabel = new JLabel("Quantity: ");
		productQtLabel.setBounds(60, 290, 140, 30);
		panel.add(productQtLabel);
		
		productNameTF = new JTextField();
		productNameTF.setBounds(180, 190, 220, 30);
		panel.add(productNameTF);
		
		productPriceTF = new JTextField();
		productPriceTF.setBounds(180, 240, 220, 30);
		panel.add(productPriceTF);
		
		productQtTF = new JTextField();
		productQtTF.setBounds(180, 290, 220, 30);
		panel.add(productQtTF);
		
		buttonAdd = new JButton("Add");
		buttonAdd.setBounds(60, 340, 100,30);
	    buttonAdd.setBackground(new Color(88, 24, 69));
		buttonAdd.setForeground(Color.WHITE);
		buttonAdd.addActionListener(this);
		panel.add(buttonAdd);
		
		header = new JLabel();
		//header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, 100, 75);
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
			new ViewProductActivity(new EmployeeActivity(employee.getUserId()), employee).setVisible(true);
		}
		else if (ae.getSource().equals(buttonAdd)) {
			try {
				Product p = new Product();
				p.setProductName(productNameTF.getText().trim());
				p.setPrice(Double.parseDouble(productPriceTF.getText()));
				p.setQuantity(Integer.parseInt(productQtTF.getText()));
				p.createProduct();
				productNameTF.setText("");
				productPriceTF.setText("");
				productQtTF.setText("");
				if (!activity.keywordTF.getText().trim().isEmpty())
					activity.table.setModel(Product.searchProduct(activity.keywordTF.getText().trim(), activity.byWhatCB.getSelectedItem().toString()));
				else
					activity.table.setModel(Product.searchProduct("", "By Name"));
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Enter price/quantity correctly!"); 
			}
			catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(this,e.getMessage()); 
			}
		}
		else {}
	}
}