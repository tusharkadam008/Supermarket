import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Staff extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff frame = new Staff();
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
	public Staff() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 593, 433);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("");
		menuBar.add(menu);
		
		JMenu mnBilling = new JMenu("Bill");
		menuBar.add(mnBilling);
		
		JMenuItem mntmCreateBill = new JMenuItem("Create Bill");
		mntmCreateBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0; i<100; i++){
					System.out.println();
					
				}
				
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
				
				System.out.println();
				//System.out.println("ITEMID   " + "ITEMNAME  " + "PRICE  "+ "QUANTITY");
				System.out.println();
			
				
				Bill bl = new Bill();
				bl.setVisible(true);
			}
		});
		mnBilling.add(mntmCreateBill);
		
		JMenuItem mntmChangePassword = new JMenuItem("Change Password");
		menuBar.add(mntmChangePassword);
		mntmChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Changepwd changepassword=new Changepwd();
				changepassword.setVisible(true);
			}
		});
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		
		
		
		JMenu mnInventory = new JMenu("Inventory");
		menuBar.add(mnInventory);
		
		JMenuItem mntmAddItem = new JMenuItem("Add/Check item");
		mntmAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventory inventory=new Inventory();
				inventory.setVisible(true);
				
			}
		});
		mnInventory.add(mntmAddItem);
		
		JMenuItem mntmUpdateQuantity = new JMenuItem("Update quantity");
		mntmUpdateQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateQuantity updatequantity =new UpdateQuantity();
				updatequantity.setVisible(true);
			}
		});
		mnInventory.add(mntmUpdateQuantity);
		 
		 
	}
}
