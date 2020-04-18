package com.orangetheory.utilities;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestUtils {
	
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
