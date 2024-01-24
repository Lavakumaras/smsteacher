package testNgPrograms;



import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertclass {
SoftAssert sa = new SoftAssert();
	@Test
	public void test1()
	{
		String exp="lava";
		String act="lav";
		
		sa.assertEquals(exp, act);	
		System.out.println("print test 1 ");
	sa.assertAll();
	}
	

	@Test
	public void test2()
	{
		String exp="lava";
		String act="lava";
		
		sa.assertEquals(exp, act);	
		System.out.println("print test 2 ");
		sa.assertAll();	
	}
	@Test
	public void test3()
	{
		String exp="lava";
		String act="lav";
		
		sa.assertEquals(exp, act);	
		System.out.println("print test 3 ");
		sa.assertAll();
	}
}
