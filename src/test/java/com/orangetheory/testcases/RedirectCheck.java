package com.orangetheory.testcases;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.orangetheory.base.BasePage;

public class RedirectCheck extends BasePage {
	
	@BeforeTest
	public void setUp() throws IOException{
		initialize();
	}
	
	@Test(dataProvider="getData")
	public void checkRedirect(String current, String redirect) throws InterruptedException{
		driver.get(current);
		Thread.sleep(2000);
		String redirectUrl = driver.getCurrentUrl();
		System.out.println(redirectUrl);
		Assert.assertEquals(redirectUrl, redirect);
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
		
		XSSFWorkbook workbook = new XSSFWorkbook("D:\\OTF\\Redirects\\test\\OTFAus.xlsx");
		XSSFSheet sheet = workbook.getSheetAt(0);
		int row = sheet.getLastRowNum();
		int column = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[row][column];
		
		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++){
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}	
		}
		workbook.close();
		return data;
	}
}