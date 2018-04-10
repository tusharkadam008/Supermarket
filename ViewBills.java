import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ViewBills extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public ViewBills(String s){
		test(s);
		
	}
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBills frame = new ViewBills();
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
	public ViewBills() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBillNumber = new JLabel("Bill number");
		lblBillNumber.setFont(new Font("Arial", Font.PLAIN, 15));
		lblBillNumber.setBounds(85, 60, 103, 27);
		contentPane.add(lblBillNumber);
		
		textField = new JTextField();
		textField.setBounds(238, 62, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				String ee = textField.getText();
				int g =Integer.valueOf(ee);
				textField.setText("");
				try{
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
					Statement st = myConn.createStatement();
					ResultSet myRs = st.executeQuery("select * from bill");	
					System.out.println();	
					int flag=0;
					while(myRs.next()){
						if (myRs.getInt(1)==(g))
						{
							System.out.println("Bill Found!");
							System.out.println("bill_no" + "\t" + "NAME" + "\t" + "DATE" +"\t" + "AMOUNT");
							System.out.println(myRs.getString("bill_no")+"\t"+ myRs.getString("username") +"\t" + myRs.getString("date")+"\t"+ myRs.getString("amount"));
							flag=1;
						}
					}
					if(flag==0){
						System.out.println("Bill Not Found!");
					}
				}
				catch (Exception exc){
					exc.printStackTrace();
				} 
				*/
				String ee = textField.getText();
				test(ee);
				
			}
		});
		btnView.setBounds(159, 130, 97, 25);
		contentPane.add(btnView);
	}

	public void test(String s){
		String ee = s;
		int g =Integer.valueOf(ee);
		//textField.setText("");
		try{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			Statement st = myConn.createStatement();
			ResultSet myRs = st.executeQuery("select * from bill");	
			System.out.println();	
			int flag=0;
			while(myRs.next()){
				if (myRs.getInt(1)==(g))
				{
					System.out.println("Bill Found!");
					System.out.println("bill_no" + "\t" + "NAME" + "\t" + "DATE" +"\t" + "AMOUNT");
					System.out.println(myRs.getString("bill_no")+"\t"+ myRs.getString("username") +"\t" + myRs.getString("date")+"\t"+ myRs.getString("amount"));
					flag=1;
				}
			}
			if(flag==0){
				System.out.println("Bill Not Found!");
			}
		}
		catch (Exception exc){
			exc.printStackTrace();
		} 
	
	}
}
