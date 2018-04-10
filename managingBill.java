import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollBar;

public class managingBill extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managingBill frame = new managingBill();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public managingBill() {

		setBounds(100, 100, 456, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 31, 315, 158);
		contentPane.add(table);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.setBounds(335, 27, 89, 23);
		contentPane.add(btnOpen);
		
		table_1 = new JTable();
		table_1.setBounds(10, 216, 315, 80);
		contentPane.add(table_1);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(308, 31, 17, 48);
		contentPane.add(scrollBar);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(308, 31, 17, 158);
		contentPane.add(scrollBar_1);
		
		JScrollBar scrollBar_2 = new JScrollBar();
		scrollBar_2.setBounds(423, 2, 17, 324);
		contentPane.add(scrollBar_2);
	}
}
