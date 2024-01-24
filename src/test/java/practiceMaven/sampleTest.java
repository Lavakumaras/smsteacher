package practiceMaven;

import org.testng.annotations.Test;

public class sampleTest {
	@Test(groups= {"smoke","regression"})
	public void script3Test()
	{
		System.out.println("--test Sript3");
		}

	@Test(groups= "smoke")
	public void script4Test()
	{
		System.out.println("--test Sript4");
		}
}
