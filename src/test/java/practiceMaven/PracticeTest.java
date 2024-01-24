package practiceMaven;

import org.testng.annotations.Test;

public class PracticeTest {
	@Test(groups= "smoke")
	public void script5Test()
	{
		System.out.println("--test Sript5");
		}

	@Test(groups= {"smoke","regression"})
	public void script6Test()
	{
		System.out.println("--test Sript6");
		}
}
