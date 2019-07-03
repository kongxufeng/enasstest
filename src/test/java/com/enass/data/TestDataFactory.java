package com.enass.data;

import com.enass.utils.ReadExcel;
import org.testng.annotations.DataProvider;

public class TestDataFactory {
	@DataProvider(name="loginTestData")
	public static Object[][] getLoginTestData(){
		return ReadExcel.getDataFromExcel("loginTestData.xlsx", "Sheet1");
	}
	
	@DataProvider(name="registerTestData_tips")
	public static Object[][] getRegisterTestData_tips(){
		Object[][] object = ReadExcel.getDataFromExcel("registerTestData.xlsx", "Sheet1");
		return object;
	}
	
	@DataProvider(name="registerTestData_success")
	public static Object[][] getRegisterTestData_success(){
		return ReadExcel.getDataFromExcel("registerTestData.xlsx", "Sheet2");
	}
}
