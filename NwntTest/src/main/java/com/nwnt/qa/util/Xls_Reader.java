package com.nwnt.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

//import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.nwnt.qa.base.Testbase;

public class Xls_Reader extends Testbase
{
	public String Path; 
	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;
		
	String sheetname = prop.getProperty("ChangePassSheetData");
	
	//To get the excel file name 
	public Xls_Reader(String Path) throws Throwable
	{
		this.Path=Path;
		try {
		File file = new File(Path);
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		//workbook = new HSSFWorkbook(fis);
		
		/*for(int i=0; i<workbook.getNumberOfSheets(); i++)
		{
			if(workbook.getSheetName(i).equals(sheetName))
				workbook.getSheet(workbook.getSheetName(i));
			break;
		}*/
		sheet = workbook.getSheetAt(0);
		}
		catch(Exception e)
		{e.printStackTrace();}
	}
	
	//returns the row count in the respective sheet
		public int getRowCount(String sheetname)
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
		
		//returns the Column count in the respective sheet
		public int getColCount(String sheetname)
		{
			sheet = workbook.getSheet(sheetname);
			int colNum = sheet.getRow(1).getLastCellNum();
			if(colNum==-1)
				return 0;
			else
				return colNum-1;
		}
		
		
		//to returns the cell data on passing as arguments(only sheetname)
		public String[][] getcelldata(String sheetName)
		{
			
			String[][] LoginData = new String[5][3];
			sheet = workbook.getSheet(sheetName);  
			for(int r=1; r<=this.getRowCount(sheetName); r++)
			{
				for(int c=0; c<=this.getColCount(sheetName); c++)
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
		
	
	/****************************************************************************************************/
	/*//Constructor to get respective sheet with no argument
	public Xls_Reader() throws Throwable
	{ 
		File xlFile = new File(prop.getProperty("testDataFilePath"));
		fis = new FileInputStream(xlFile);
		workbook = new XSSFWorkbook(fis);
		for(int i=0; i<workbook.getNumberOfSheets(); i++)
		{
			if(workbook.getSheetName(i).equals(prop.getProperty("sheetName")))
				sheet=workbook.getSheet(workbook.getSheetName(i));
			break;
		}
		
	}
	//returns row count in respective sheet
	public int getRowCount()
	{
		return sheet.getLastRowNum();
	}
	 //returns column count in respective sheet
	public int getColCount()
	{
		return sheet.getRow(0).getLastCellNum();
	}
	
	//return row-wise cells data
	public Object[][] getTestData()
	{
		//String[][] data = new String[getRowCount()][getColCount()];
		Object[][] data = new Object[getRowCount()][getColCount()];
		for(int r=1; r<getRowCount(); r++)
		{
			for(int c=0; c<getColCount(); c++)
			{
				data[r][c]=sheet.getRow(r).getCell(c).getStringCellValue();
			}
		}
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public ArrayList<Object[]> getExcelData()
	{
		ArrayList<Object[]> completeXl = new ArrayList<Object[]>();
		completeXl.add(getCellData());
		return completeXl;
	}*/
	
	/**********************************************************************************************/
	
	
	/*
	//to returns the cell data on passing as arguments(sheetname, colName, rowNum)
	public String getCellData(String sheetName, String colName, int rowNum)
	{
		try
		{ if(rowNum<=0)
			return "";
		int index = workbook.getSheetIndex(sheetName);
		int col_Num = -1;
		if(index==-1)
			return "";
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		for(int i=0; i<row.getLastCellNum(); i++)
		{
			if(row.getCell(0).getStringCellValue().trim().equals(colName.trim()))
			col_Num = i;
		}
		if(col_Num==-1)
			return "";
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum-1);
		if(row==null)
			return "";
		cell = row.getCell(col_Num);
		if(cell==null)
			return "";
		if(cell.getCellTypeEnum() == CellType.STRING)
			return cell.getStringCellValue();
		else if(cell.getCellTypeEnum()==CellType.NUMERIC||cell.getCellTypeEnum()==CellType.FORMULA)
		{
			String cellText = String.valueOf(cell.getNumericCellValue());
			if(HSSFDateUtil.isCellDateFormatted(cell))
			{
				double d = cell.getNumericCellValue();
				Calendar cal = Calendar.getInstance();
				cal.setTime(HSSFDateUtil.getJavaDate(d));
				cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
				cellText = cal.get(Calendar.DAY_OF_MONTH) +"/"+cal.get(Calendar.MONTH)+1+"/"+cellText;
			}
			return cellText;
		}
		else if(cell.getCellTypeEnum()==CellType.BLANK)
			return "";
		else
		return String.valueOf(cell.getBooleanCellValue());
	}
		catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colName + " does not exist in xls";
		}
	}
*/	
		
}
	
	