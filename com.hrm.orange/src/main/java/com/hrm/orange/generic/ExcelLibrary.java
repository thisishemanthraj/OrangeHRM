package com.hrm.orange.generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary 
{
	public static Object[][] getDataFromExcel(String filePath, String sheetName)
	{
		Object[][] arr = null;
		try
		{
			FileInputStream f1 = new FileInputStream(filePath);
			Workbook wb = WorkbookFactory.create(f1);
			Sheet sheet = wb.getSheet(sheetName);
			int rowsCount = sheet.getPhysicalNumberOfRows();
			
			arr = new Object[rowsCount-1][2];
								
			for(int i=1, k=0;i<=rowsCount-1;i++,k++)
			{
				int cellCount=sheet.getRow(i).getPhysicalNumberOfCells();
				
				for(int j=0;j<=cellCount-1;j++)
				{
					String data = sheet.getRow(i).getCell(j).getStringCellValue();
					arr[k][j]=data;
				}
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return arr;
	}
	
	public static String getDataFromExcel(String filePath, String sheetName, int rowNumber, int CellNumber)
	{
		String data=null;
		
		try
		{
			FileInputStream f1 = new FileInputStream(filePath);
			Workbook wb = WorkbookFactory.create(f1);
			data = wb.getSheet(sheetName).getRow(rowNumber).getCell(CellNumber).getStringCellValue();		
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return data;
	}
}
