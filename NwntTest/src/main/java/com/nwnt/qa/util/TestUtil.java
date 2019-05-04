package com.nwnt.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.nwnt.qa.base.Testbase;

public class TestUtil extends Testbase
{
	public TestUtil() throws Throwable {
	}

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	static Workbook workbook;
	static Sheet sheet;
	static Cell cell;
	
	public static Object[][] getTestData(String dataPath, String sheetName) throws Throwable
	{
		//File file = new File(prop.getProperty("testDatafilePath"));
		File file = new File(dataPath);
		FileInputStream fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		//System.out.println("Row: "+sheet.getLastRowNum()+"          Cell: "+sheet.getRow(0).getLastCellNum());
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int r=0; r<sheet.getLastRowNum(); r++)
		{
			for(int c=0; c<sheet.getRow(0).getLastCellNum(); c++)
			{
				//System.out.println(sheet.getRow(r).getCell(c).getStringCellValue()+"    Row: "+r+"     Cell: "+c);
				cell=sheet.getRow(r).getCell(c);
				if(cell.getCellTypeEnum()==CellType.STRING)
					data[r][c] = sheet.getRow(r+1).getCell(c).getStringCellValue();
				else if(cell.getCellTypeEnum()==CellType.NUMERIC)
					//data[r][c] = String.valueOf(sheet.getRow(r+1).getCell(c).getNumericCellValue());
					data[r][c] = sheet.getRow(r+1).getCell(c).getNumericCellValue();
				/*else if(cell.getCellTypeEnum()==CellType.)
					data[r][c] = sheet.getRow(r+1).getCell(c).get;
				data[r][c] = sheet.getRow(r+1).getCell(c).getStringCellValue();*/ 		
			}
		}
		workbook.close();
		return data;
	}
	
	
	/*static Xls_Reader reader;
	public static ArrayList<Object[]> getDataFromExcel()
	{
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader("D:\\Amritesh\\Selenium\\git\\NWNTAutomation\\NwntPagefactory\\NwntTest\\src\\main\\java\\com\\nwnt\\qa\\testdata\\AssignAppointment.xlsx");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		for(int rowNum=1; rowNum<reader.getRowCount("DoctorApp"); rowNum++)
		{
			String appointmentwith = reader.getCellData("DoctorApp", "Appwith", rowNum);
			String ClinicLocation = reader.getCellData("DoctorApp", "ClinicLoc", rowNum);
			String AppointmentTo = reader.getCellData("DoctorApp", "AppTo", rowNum);
			String caseType = reader.getCellData("DoctorApp", "CaseType", rowNum);
			String AppointmentIn = reader.getCellData("DoctorApp", "AppIn", rowNum);
			String PatienNotBrought = reader.getCellData("DoctorApp", "PatientNotBrought", rowNum);
			String IsCorporateAppointment = reader.getCellData("DoctorApp", "IsCorporateAppointment", rowNum);
			
			Object ob[] = {appointmentwith, ClinicLocation, AppointmentTo, caseType, AppointmentIn, PatienNotBrought, IsCorporateAppointment};
			myData.add(ob);
		}
		return myData;	
	}*/
	

}
