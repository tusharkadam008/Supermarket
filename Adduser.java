import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Adduser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from staff");
			System.out.println("Current Users");
			System.out.println();
			System.out.println("ID" + "\t" + "NAME");
			System.out.println();
			while(myRs.next()){
				System.out.println(myRs.getString("id")+"\t"+ myRs.getString("name"));
			}
			System.out.println();
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adduser frame = new Adduser();
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
	public Adduser() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 534, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 520, 441);
		contentPane.add(panel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(131, 164, 94, 25);
		panel.add(lblName);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(131, 219, 94, 28);
		panel.add(label_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(276, 164, 133, 24);
		panel.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(276, 223, 133, 22);
		panel.add(passwordField);
		

		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String a = textField_1.getText();
				String b = textField.getText();
				String c = passwordField.getText();
				/*
				String aa = textField_1.getText();
				String bb = textField.getText();
				String cc = passwordField.getText();
				textField_1.setText("");
				textField.setText("");
				passwordField.setText("");
				
				
				String q1 = "insert into staff Values(\"";
				String t = q1 +aa+"\",\""+bb+"\",\""+cc+"\");";
				try
				{
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
					Statement myStmt = myConn.createStatement();
					 myStmt.executeUpdate(t);
					 System.out.println();
					System.out.println("User successfully added");
					//JOptionPane.showMessageDialog(null,"User successfully added!",null);
					
					ResultSet myRs = myStmt.executeQuery("select * from staff");
					System.out.println("Updated User List");
					System.out.println();
					System.out.println("ID" + "\t" + "NAME");
					while(myRs.next()){
						System.out.println(myRs.getString("id")+"\t"+ myRs.getString("name"));
					}
				}
				catch(Exception ax)
				{
					System.out.println(ax.toString());
				}
				*/
				test(a,b,c);
			}
				
		});
		btnAddUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddUser.setBounds(203, 293, 112, 35);
		panel.add(btnAddUser);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setBounds(276, 98, 133, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(131, 100, 71, 18);
		panel.add(lblId);
	}
	
	public void test(String a,String b,String c){
		
		String aa =a;
		String bb =b;
		String cc =c;
		textField_1.setText("");
		textField.setText("");
		passwordField.setText("");
		
		
		String q1 = "insert into staff Values(\"";
		String t = q1 +aa+"\",\""+bb+"\",\""+cc+"\");";
		try
		{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			Statement myStmt = myConn.createStatement();
			 myStmt.executeUpdate(t);
			 System.out.println();
			System.out.println("User successfully added");
			//JOptionPane.showMessageDialog(null,"User successfully added!",null);
			
			ResultSet myRs = myStmt.executeQuery("select * from staff");
			System.out.println("Updated User List");
			System.out.println();
			System.out.println("ID" + "\t" + "NAME");
			while(myRs.next()){
				System.out.println(myRs.getString("id")+"\t"+ myRs.getString("name"));
			}
		}
		catch(Exception ax)
		{
			System.out.println(ax.toString());
		}
	}
}
