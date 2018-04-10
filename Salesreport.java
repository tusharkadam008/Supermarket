import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Salesreport extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	
	public Salesreport(String s){
		test(s);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Salesreport frame = new Salesreport();
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
	public Salesreport() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterDateddmmyyyy = new JLabel("Enter Date(dd mm yy):");
		lblEnterDateddmmyyyy.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEnterDateddmmyyyy.setBounds(12, 76, 239, 59);
		contentPane.add(lblEnterDateddmmyyyy);
		
		textField = new JTextField();
		textField.setBounds(255, 96, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnShowSales = new JButton("Show Sales");
		btnShowSales.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				/*
				String a=textField.getText();
				
				//String t ="SELECT bill SET quantity = \"" +f+ "\"WHERE item_id =\"" + g + "\";";
				
				try
				{
					for(int i=0; i<100; i++){
						System.out.println();;
					}
					
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
					Statement myStmt = myConn.createStatement();
					ResultSet rs = myStmt.executeQuery("select * from bill;");
					int i=0;
					while (rs.next())
					{
						if (rs.getString(3).equals(a)){
							
							 i=i+rs.getInt(4);	
							 
						}
						
					} 
					if(i==0){
						System.out.println("Date not found\n");
						//JOptionPane.showMessageDialog(null,"date not found");
					}
					else{
						 System.out.println("Total sale:" + i);
						 //JOptionPane.showMessageDialog(null,"sale : "+ i);
					}
					
				}
				catch(SQLException cx)
				{
					System.out.println(cx.toString());
				}
				*/
				
				String aa=textField.getText();
				test(aa);
			}
		});
		btnShowSales.setBounds(127, 142, 157, 25);
		contentPane.add(btnShowSales);
	}

	
	public void test(String k)
	{
		String a=k;
		//String a=textField.getText();
		
		//String t ="SELECT bill SET quantity = \"" +f+ "\"WHERE item_id =\"" + g + "\";";
		
		try
		{
			for(int i=0; i<100; i++){
				System.out.println();;
			}
			
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			Statement myStmt = myConn.createStatement();
			ResultSet rs = myStmt.executeQuery("select * from bill;");
			int i=0;
			while (rs.next())
			{
				if (rs.getString(3).equals(a)){
					
					 i=i+rs.getInt(4);	
					 
				}
				
			} 
			if(i==0){
				System.out.println("Date not found\n");
				JOptionPane.showMessageDialog(null,"date not found");
			}
			else{
				 System.out.println("Total sale:" + i);
				 JOptionPane.showMessageDialog(null,"sale : "+ i);
			}
			
		}
		catch(SQLException cx)
		{
			System.out.println(cx.toString());
		}
	}
}
