import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Test;

public class unitTest {

	@Test
	public void test2() {
		ViewBills bill = new ViewBills("1001");
		System.out.println();
		System.out.println("Test case passed");
		
		//test1.setVisible(true);
				
	}
	@Test
	public void test3(){
		Removeuser user = new Removeuser();
		
		
		String bb = "1002";
		
		user.test(bb);
		
		
	}
	
	@Test
	public void test4() {
		Salesreport sale = new Salesreport("10 jan 17");
		
		System.out.println("Test case passed");

}
	@Test
	public void test5() {
		Adduser usr = new Adduser();
		usr.test("1004", "Ram", "1004");
		
	
	}	
}
