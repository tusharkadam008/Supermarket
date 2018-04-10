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

public class Tax extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tax frame = new Tax();
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
	public Tax() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 362, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTaxId = new JLabel("Tax ID");
		lblTaxId.setBounds(71, 29, 56, 16);
		contentPane.add(lblTaxId);
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setBounds(71, 76, 56, 16);
		contentPane.add(lblValue);
		
		textField = new JTextField();
		textField.setBounds(182, 26, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(182, 73, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String aa = textField.getText();
				int g=Integer.valueOf(aa);
				String bb = textField_1.getText();
				
				
				String t ="UPDATE tax SET tax = \"" +bb+ "\"WHERE id =\"" + aa + "\";";
				try
				{
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "mysql");
					Statement myStmt = myConn.createStatement();
					ResultSet rs = myStmt.executeQuery("select * from tax;");
					int flag=0;
					while (rs.next())
					{
						if (rs.getInt(1)==(g)){
							
							 myStmt.executeUpdate(t);	
							 flag=1;
							 System.out.println("Tax changed!");
						
						}
						
							System.out.println("incorrect tax id ");
						
					}
					if(flag==0)
						System.out.println("incorrect tax id ");
					
				}
				catch(SQLException cx)
				{
					System.out.println(cx.toString());
				}
			}
				
			
		});
		btnUpdate.setBounds(103, 168, 97, 25);
		contentPane.add(btnUpdate);
	}
}
