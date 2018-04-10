import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class UpdateQuantity extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateQuantity frame = new UpdateQuantity();
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
	public UpdateQuantity() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 449, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProductName = new JLabel("Product name");
		lblProductName.setBounds(29, 11, 89, 14);
		contentPane.add(lblProductName);
		
		JLabel lblProductId = new JLabel("Product id");
		lblProductId.setBounds(29, 64, 78, 17);
		contentPane.add(lblProductId);
		
		textField = new JTextField();
		textField.setBounds(182, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(182, 61, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUpdateQuantity = new JLabel("Update Quantity");
		lblUpdateQuantity.setBounds(29, 122, 104, 14);
		contentPane.add(lblUpdateQuantity);
		
		textField_2 = new JTextField();
		textField_2.setBounds(182, 119, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String a=textField.getText();
				String b=textField_1.getText();
				String c=textField_2.getText();
				
				int g =Integer.valueOf(b);
				int f =Integer.valueOf(c);
				
				String t ="UPDATE inventory SET quantity = \"" +f+ "\"WHERE item_id =\"" + g + "\";";
				
				try
				{
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
					Statement myStmt = myConn.createStatement();
					ResultSet rs = myStmt.executeQuery("select * from inventory;");
					int flag=0;
					while (rs.next())
					{
						if (rs.getInt(1)==(g)){
							
							 myStmt.executeUpdate(t);	
							 flag=1;
							 System.out.println("Updated quantity!");
							 System.out.println();
							 System.out.println("ITEMID   " + "ITEMNAME  " + "PRICE  "+ "QUANTITY");
							 System.out.println(rs.getString("item_id")+"\t"+ rs.getString("item_name") +"\t" + rs.getString("price")+"\t"+ rs.getString("quantity"));
						
						}
													
					}
					if(flag==0)
					System.out.println("incorrect product id");
				}
				catch(SQLException cx)
				{
					//System.out.println(cx.toString());
				}
			}
		});
		btnUpdate.setBounds(125, 183, 89, 23);
		contentPane.add(btnUpdate);
	}

}
