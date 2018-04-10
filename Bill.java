import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;

public class Bill extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_3;
	static int amount=0;
	private JTextField textField_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from inventory;");
			System.out.println("ITEMID   " + "ITEMNAME  " + "PRICE  "+ "QUANTITY");
			while(myRs.next()){
				System.out.println(myRs.getString("item_id")+"\t"+ myRs.getString("item_name") +"\t" + myRs.getString("price")+"\t"+ myRs.getString("quantity"));
			}
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		
	
		System.out.println("ITEMID   " + "ITEMNAME  " + "PRICE  "+ "QUANTITY");
		System.out.println();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill frame = new Bill();
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
	public Bill() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 426, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBillNo = new JLabel("Bill no");
		lblBillNo.setBounds(32, 34, 46, 14);
		contentPane.add(lblBillNo);
		
		textField = new JTextField();
		textField.setBounds(202, 31, 116, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(202, 96, 116, 23);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a= textField_1.getText();
				String b = textField_3.getText(); 
				int g=Integer.valueOf(b);
				textField_1.setText("");
				textField_3.setText("");
				int h=0,p=0;
				int qf=0;
				String q=null;
				try
				{
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
					Statement myStmt = myConn.createStatement();
					ResultSet rs = myStmt.executeQuery("select * from inventory;");
				
					while (rs.next())
					{
						if (rs.getString(1).equals(a) ){
							//i=i+rs.getInt(4);
							q=rs.getString(2);
							p=rs.getInt(3);
							h =rs.getInt(4);
							if(h<g){
								qf=1;
								System.out.println("NOT AVAILABLE");
								break;
							}
							amount+=g*p;
						}
						
					} 
				
					
				}
				catch(SQLException cx)
				{
					System.out.println(cx.toString());
				}
				int f=h-g;
				if(qf==0){
				System.out.println(a+"\t"+q+"\t"+p+"\t"+g);
				
				try
				{
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
					Statement myStmt = myConn.createStatement();
					ResultSet myrs = myStmt.executeQuery("select * from inventory;");
					String t ="UPDATE inventory SET quantity = \"" +f+ "\"WHERE item_id =\"" + a+ "\";";
					int flag=0;
					while (myrs.next())
					{
						if (myrs.getString(1).equals(a)){
							
							 myStmt.executeUpdate(t);	
							 flag=1;
							 //System.out.println("Updated quantity!");
						
						}
					}
				}
							
				catch(SQLException cx)
				{
					//System.out.println(cx.toString()); 		 
				}
				}
			}	
		});
		
		btnAdd.setBounds(48, 448, 89, 23);
		contentPane.add(btnAdd);
		
		JLabel lblCustomername = new JLabel("CustomerName");
		lblCustomername.setBounds(32, 93, 121, 28);
		contentPane.add(lblCustomername);
		
		JLabel lblNewLabel = new JLabel("Item id");
		lblNewLabel.setBounds(32, 175, 56, 16);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(202, 172, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("quantity");
		lblNewLabel_1.setBounds(32, 318, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(202, 315, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		String[]choice ={"5","10","15"};
		JComboBox comboBox = new JComboBox(choice);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		comboBox.setBounds(202, 375, 116, 22);
		contentPane.add(comboBox);
		
		String aa= (String) comboBox.getSelectedItem();
		int g =Integer.valueOf(aa);
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String aa = textField.getText();
				String bb = textField_2.getText();
				String cc = textField_4.getText();
	
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			
				System.out.println();
				amount=amount +(g*amount)/100;		
				System.out.println("TOTAL AMOUNT: "+amount);
				
				String q1 = "insert into bill Values(\"";
				String t = q1 +aa+"\",\""+bb+"\",\""+cc+"\",\""+amount+"\");";
				try
				{
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
					Statement myStmt = myConn.createStatement();
					 myStmt.executeUpdate(t);
				//	System.out.println("");
				}
				catch(Exception ax)
				{
					System.out.println(ax.toString());
				}	
			}
		});
		btnCreate.setBounds(187, 447, 97, 25);
		contentPane.add(btnCreate);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(32, 251, 56, 16);
		contentPane.add(lblDate);
		
		textField_4 = new JTextField();
		textField_4.setBounds(202, 248, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblTaxId = new JLabel("Tax ID(%)");
		lblTaxId.setBounds(32, 378, 56, 16);
		contentPane.add(lblTaxId);
		
		
	}
}
