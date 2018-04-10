import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Inventory extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		
		try{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			Statement st = myConn.createStatement();
			ResultSet myRs = st.executeQuery("select * from inventory");
			System.out.println("ID" + "\t" + "NAME" + "\t" + "PRICE" +"\t" + "QUANTITY");
			while(myRs.next()){
				System.out.println(myRs.getString("item_id")+"\t"+ myRs.getString("item_name") +"\t" + myRs.getString("price")+"\t"+ myRs.getString("quantity"));
			}
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventory frame = new Inventory();

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inventory() {
	//	super("hello");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 454, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(22, 23, 97, 22);
		contentPane.add(lblProductName);
		
		textField = new JTextField();
		textField.setBounds(135, 24, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblProductId = new JLabel("Product id");
		lblProductId.setBounds(257, 25, 69, 18);
		contentPane.add(lblProductId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(338, 24, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(22, 76, 97, 14);
		contentPane.add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(257, 76, 69, 14);
		contentPane.add(lblQuantity);
		
		textField_2 = new JTextField();
		textField_2.setBounds(135, 73, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(338, 73, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String bb = textField.getText();
				String aa = textField_1.getText();
				String cc = textField_2.getText();
				String dd = textField_3.getText();
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				try{
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
					Statement st = myConn.createStatement();
					ResultSet myRs = st.executeQuery("select * from inventory");
					System.out.println("ID" + "\t" + "NAME" + "\t" + "PRICE" +"\t" + "QUANTITY");
					while(myRs.next()){
						System.out.println(myRs.getString("item_id")+"\t"+ myRs.getString("item_name") +"\t" + myRs.getString("price")+"\t"+ myRs.getString("quantity"));
					}
				}
				catch (Exception exc){
					exc.printStackTrace();
				} 

				String t = "insert into inventory values(\"" +aa+"\",\""+bb+"\",\""+cc+"\",\""+dd+"\");";	
					try
						{
						Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
						Statement st = myConn.createStatement();
						int i = st.executeUpdate(t);
						
						System.out.println(aa+"\t"+ bb +"\t" + cc +"\t"+ dd);
						}
						catch(Exception ax)
						{
						System.out.println(ax.toString());
						}

			}
		});
		btnAdd.setBounds(174, 118, 89, 23);
		contentPane.add(btnAdd);
		
		JLabel lblProductId_1 = new JLabel("Product ID");
		lblProductId_1.setBounds(68, 205, 79, 23);
		contentPane.add(lblProductId_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(221, 205, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String ee = textField_4.getText();
				int g =Integer.valueOf(ee);
				textField_4.setText("");
				try{
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
					Statement st = myConn.createStatement();
					ResultSet myRs = st.executeQuery("select * from inventory");	
					System.out.println();	
					int flag=0;
					while(myRs.next()){
						if (myRs.getInt(1)==(g))
						{
							System.out.println("Item Found!");
							System.out.println("ID" + "\t" + "NAME" + "\t" + "PRICE" +"\t" + "QUANTITY");
							System.out.println(myRs.getString("item_id")+"\t"+ myRs.getString("item_name") +"\t" + myRs.getString("price")+"\t"+ myRs.getString("quantity"));
							flag=1;
						}
					}
					if(flag==0){
						System.out.println("Item Not Found!");
					}
				}
				catch (Exception exc){
					exc.printStackTrace();
				} 
			}
		});
		btnCheck.setBounds(166, 265, 97, 25);
		contentPane.add(btnCheck);
	
	}
}
