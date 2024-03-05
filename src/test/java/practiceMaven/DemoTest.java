package practiceMaven;

import org.testng.annotations.Test;

public class DemoTest {
@Test(groups= "integrat")
public void script1Test1()
{
	System.out.println("--test Sript1");
	}

@Test
public void script2Test()
{
	System.out.println("--test Sript2");
	}
}
