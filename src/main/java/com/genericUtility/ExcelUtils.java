package com.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtils {
	/**
	 * This methos is used to return data from excel file
	 * 
	 * @author admin parm sheetName, intNo, cellNo
	 */
	public String redDatafromExcel(String sheetName, int rowNo, int cellNo) throws Throwable {
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;

	}

	/**
	 * This method user to return last row num
	 * 
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public int getLastRowNum(String SheetName) throws Throwable {
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		int rowcount = wb.getSheet(SheetName).getLastRowNum();
		return rowcount;

	}

	/**
	 * This methos is used get hashmap data from excel
	 * 
	 * @param sheetName
	 * @param cell
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String, String> hashMapData(String sheetName, int cell) throws Throwable {
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i <= lastRow; i++) {
			String key = sh.getRow(i).getCell(cell).getStringCellValue();
			String value = sh.getRow(i).getCell(cell + 1).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}

	/**
	 * This method is used write data into excel
	 * 
	 * @param SheetName
	 * @param row
	 * @param cell
	 * @param data
	 * @throws Throwable
	 */
	public void wrireDataintoExcel(String SheetName, int row, int cell, String data) throws Throwable {
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		sh.createRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fos);
		wb.close();
	}
	/**
	 * This method is used to read data from excel to data provider
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] ReadDatafromDataProvider(String sheetName) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		int lastCell = sheet.getRow(0).getLastCellNum();

		Object[][] obj = new Object[lastRow][lastCell];
		for(int i = 0; i < lastRow; i++)
		{
			for(int j = 0; j < lastCell; j++)
			{
				obj[i][j]= sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}

}
