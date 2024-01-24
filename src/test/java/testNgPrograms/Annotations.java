package testNgPrograms;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {

	@BeforeSuite
	public void BS()
	{
		System.out.println("Before Suite");
	}
	@BeforeTest
	public void BT()
	{
		System.out.println("before test");
	}
	
	@BeforeClass
	public void BC()
	{
		System.out.println("before class");
	}
	@BeforeMethod
	public void BM()
	{
		System.out.println("before method");
	}

	@Test
	public void test1()
	{
		System.out.println("test 1 ");
	}
	@AfterMethod
	public void AM()
	{
		System.out.println("after method");
	}
		@AfterClass
	public void AC()
	{
		System.out.println("after class");
	}
	@AfterTest
	public void AT()
	{
		System.out.println("after test");
	}
	@AfterSuite
	public void AS()
	{
		System.out.println("after suite");
	}
}

