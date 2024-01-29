package testNgPrograms;

import org.testng.annotations.DataProvider;

import com.genericUtility.ExcelUtils;


public class Dataprovider {

	@DataProvider
	public Object[][] product()
	{
		Object[][] obj = new Object[3][2];
		obj[0][0]="samsung";
		obj[0][1]=10000;
		
		obj[1][0]="sony";
		obj[1][1]=20000;
		
		obj[2][0]="aceer";
		obj[2][1]=15000;
		
		return obj;
	}
	
	
	@DataProvider
	public Object[][] location()
	{
		Object[][] obj = new Object[3][2];
		obj[0][0]="bangalore";
		obj[0][1]="mysore";
		
		obj[1][0]="mysore";
		obj[1][1]="shivamogga";
		
		obj[2][0]="shivamogga";
		obj[2][1]="chitradurga";
		
		return obj;
	}
	
	@DataProvider
	public Object[][] readdata() throws Throwable
	{
		ExcelUtils exlUtil = new ExcelUtils();
		Object[][] obj = new Object[3][2];
		
		obj[0][0] =  exlUtil.redDatafromExcel("LogInDetails",0, 0);
	    obj[0][1] =  exlUtil.redDatafromExcel("LogInDetails",0, 1);
		
		obj[1][0] =  exlUtil.redDatafromExcel("LogInDetails",1, 0);
		obj[1][1] =  exlUtil.redDatafromExcel("LogInDetails",1, 1);
		
		obj[2][0] =  exlUtil.redDatafromExcel("LogInDetails",2, 0);
		obj[2][1] =  exlUtil.redDatafromExcel("LogInDetails",2, 1);
	
		return obj;
	}

	@DataProvider
	public Object[][] addClassRoom() throws Throwable
	{
		ExcelUtils exlUtil = new ExcelUtils();
		Object[][] obj = new Object[3][2];
		
		obj[0][0] =  exlUtil.redDatafromExcel("addclassroom",0, 0);
	    obj[0][1] =  exlUtil.redDatafromExcel("addclassroom",0, 1);
		
		obj[1][0] =  exlUtil.redDatafromExcel("addclassroom",1, 0);
		obj[1][1] =  exlUtil.redDatafromExcel("addclassroom",1, 1);
		
		obj[2][0] =  exlUtil.redDatafromExcel("addclassroom",2, 0);
		obj[2][1] =  exlUtil.redDatafromExcel("addclassroom",2, 1);
	
		return obj;
	}
	/*
	 0,0	0,1
	 1,0	1,1
	 2,0	2,1
	 un 	pwd	    (same as excel sheet)
	 * */
	


@DataProvider
public Object[][] addRoom() throws Throwable
{
	ExcelUtils exlUtil = new ExcelUtils();
	Object[][] obj = exlUtil.ReadDatafromDataProvider("addclassroom");
	return obj;
}

}