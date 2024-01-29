package testNgPrograms;

import org.testng.annotations.Test;

import com.genericUtility.BaseClass;
import com.genericUtility.Fileutils;

public class class4 {
	@Test
	public void testclass1()
	{
		System.out.println("class4 1");
	}
	@Test
	public void testclass2() throws Throwable{
	Fileutils f =new Fileutils();
		f.writeDataToPropertyFile("name", "lava");
	}
	
}
