package com.nwnt.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int r=0; r<sheet.getLastRowNum(); r++)
		{
			for(int c=0; c<sheet.getRow(0).getLastCellNum(); c++)
			{
				cell=sheet.getRow(r+1).getCell(c);
				if(cell.getCellType()==CellType.STRING)
				//if(cell.getCellTypeEnum()==CellType.STRING)
					data[r][c] = cell.getStringCellValue();
				else if(cell.getCellType()==CellType.NUMERIC||cell.getCellType()==CellType.FORMULA)
					//else if(cell.getCellTypeEnum()==CellType.NUMERIC||cell.getCellTypeEnum()==CellType.FORMULA)
				{
					String cellText = String.valueOf((long) cell.getNumericCellValue());
					if (HSSFDateUtil.isCellDateFormatted(cell))
					{
						Date d=(Date) cell.getDateCellValue();
						//double d = cell.getNumericCellValue();
						Calendar cal = Calendar.getInstance();
						//cal.setTime(HSSFDateUtil.getJavaDate(d));
						cal.setTime(d);
						String yearText = (String.valueOf(cal.get(Calendar.YEAR))).substring(0);
						SimpleDateFormat Mon = new SimpleDateFormat("MMM");
						// cellText = cal.get(Calendar.DAY_OF_MONTH)+"-"+cal.get(Calendar.MONTH)+1+"-"+cellText;
						// Date date=(Date) cell.getDateCellValue();
						cellText = cal.get(Calendar.DAY_OF_MONTH) + "-" + Mon.format((Date) cell.getDateCellValue()) +"-" + yearText;
					}
					data[r][c] = cellText;
				}
				else if(cell.getCellType()==CellType.BLANK)
				//else if(cell.getCellTypeEnum()==CellType.BLANK)
					data[r][c] = " "; 		
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
