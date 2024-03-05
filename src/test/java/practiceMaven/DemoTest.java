package practiceMaven;

import org.testng.annotations.Test;

public class DemoTest {

@Test(groups= "regression")
public void script1Test1() {
}

@Test(groups= "regression")
public void script1Test()
{
	System.out.println("--test Sript1");
	}

@Test
public void script2Test()
{
	System.out.println("--test Sript2");
	}
}
