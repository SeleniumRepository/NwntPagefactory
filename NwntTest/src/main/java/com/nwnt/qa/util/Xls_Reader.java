package com.nwnt.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.nwnt.qa.base.Testbase;

public class Xls_Reader extends Testbase
{
	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	
	
	String sheetname = prop.getProperty("ChangePassSheetData");
	
	public Xls_Reader() throws Throwable
	{
		
		try {
		File file = new File(prop.getProperty("Path_TestData"));
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetname);
		}
		catch(Exception e)
		{e.printStackTrace();}
	}
	
	//returns the row count in the sheet
	public int getRowCount()
	{
		int index = workbook.getSheetIndex(sheetname);
		if(index==-1)
			return 0;
		else
		{
			//sheet = workbook.getSheet(sheetname);
			int rowCount = sheet.getLastRowNum();
			return rowCount;
		}
	}
	
	//returns the Column count in the sheet
	public int getColCount()
	{
		sheet = workbook.getSheet(sheetname);
		int colNum = sheet.getRow(1).getLastCellNum();
		if(colNum==-1)
			return 0;
		else
			return colNum-1;
	}
	//returns the cell data
	public String[][] getcelldata()
	{
		
		String[][] LoginData = new String[5][3];
		sheet = workbook.getSheet(prop.getProperty("ChangePassSheetData"));  
		for(int r=1; r<=this.getRowCount(); r++)
		{
			for(int c=0; c<=this.getColCount(); c++)
			{
				String str = sheet.getRow(r).getCell(c).getStringCellValue();
				if(str!=null)
				LoginData[r][c] = sheet.getRow(r).getCell(c).getStringCellValue();
			} 
			
		}
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return LoginData;
	}
}
	
	