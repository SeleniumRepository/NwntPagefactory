package com.nwnt.qa.util;

import java.util.ArrayList;

public class TestUtil 
{
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	
	static Xls_Reader reader;
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
		
	}

}
