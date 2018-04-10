import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Removeuser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from staff");
			System.out.println("Current User List");
			System.out.println();
			System.out.println("ID" + "\t" + "NAME");
			System.out.println();
			while(myRs.next()){
				System.out.println(myRs.getString("id")+"\t"+ myRs.getString("name"));
			}
		}
		catch (Exception exc){++++
			exc.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Removeuser frame = new Removeuser();
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
	public Removeuser() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 533, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 520, 441);
		contentPane.add(panel);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUserId.setBounds(131, 113, 94, 25);
		panel.add(lblUserId);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(276, 113, 133, 24);
		panel.add(textField);
		
		JButton btnRemoveUser = new JButton("Remove User");
		btnRemoveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			//	textField.setText("FINISHED");
			//	revalidate();
			//	repaint();

				String q2 = "delete from staff where id=";
				String bb=textField.getText();
				textField.setText("");
				/*
				String t=q2+bb;
				int g =Integer.valueOf(bb);
				try{
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
					Statement myStmt = myConn.createStatement();
					ResultSet myRs = myStmt.executeQuery("select * from staff");
					
					int flag=0;
					while (myRs.next())
					{
						if (myRs.getInt(1)==(g)){
							
							 myStmt.executeUpdate(t);	
							 flag=1;
							 System.out.println();
							 System.out.println("User successfully removed!");
							 //JOptionPane.showMessageDialog(null,"User successfully removed!",null);
						
						}
					
					}
					if(flag==0){
						System.out.println("Incorrect user id");
					}
				}
				catch(Exception bx){
				//	System.out.println(bx.toString());
				}*/
				test(bb);
			}
		});
		btnRemoveUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRemoveUser.setBounds(195, 194, 133, 35);
		panel.add(btnRemoveUser);
	}

	public void test(String bb){
		String q2 = "delete from staff where id=";
		String t=q2+bb;
		int g =Integer.valueOf(bb);
		try{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from staff");
			
			int flag=0;
			while (myRs.next())
			{
				if (myRs.getInt(1)==(g)){
					
					 myStmt.executeUpdate(t);	
					 flag=1;
					 System.out.println();
					 System.out.println("User successfully removed!");
					 JOptionPane.showMessageDialog(null,"User successfully removed!");
					 
				
				}
			
			}
			if(flag==0){
				System.out.println("Incorrect user id");
			}
		}
		catch(Exception bx){
		//	System.out.println(bx.toString());
		}
		
	}
	
	
}
