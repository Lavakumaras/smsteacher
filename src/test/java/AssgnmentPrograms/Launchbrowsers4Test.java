package AssgnmentPrograms;

import org.testng.annotations.Test;

import com.genericUtility.BaseClass;

public class Launchbrowsers4Test extends BaseClass {
@Test
public void launchBrowser() throws Throwable
{
	driver.get(flib.readDataFromPropertyFile("url1"));
	wlib.openNewTab(driver);
	driver.get(flib.readDataFromPropertyFile("url2"));
	}
}
