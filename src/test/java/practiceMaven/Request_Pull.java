package practiceMaven;

import org.testng.annotations.Test;

public class Request_Pull {
	@Test(groups = {"smoke" , "integresion"})
	public void m5()
	{
		System.out.println("3.1");
	}
	
	@Test(groups = "regression")
	public void m6()
	{
		System.out.println("3.2");
	}
}
