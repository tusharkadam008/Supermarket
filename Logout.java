import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Logout extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logout frame = new Logout();
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
	public Logout() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoYouReally = new JLabel("Do you really want to logout?");
		lblDoYouReally.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDoYouReally.setBounds(76, 28, 356, 65);
		contentPane.add(lblDoYouReally);
		
		JButton btnYes = new JButton("YES");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		btnYes.setBounds(46, 138, 97, 25);
		contentPane.add(btnYes);
		
		JButton btnNo = new JButton("NO");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//	contentPane.setLayout(null);
				//frame.setVisible(false);
			//	Admin admin1=new Admin();
				//admin1.remove(contentPane);
			}
		});
		btnNo.setBounds(261, 138, 97, 25);
		contentPane.add(btnNo);
	}

}
