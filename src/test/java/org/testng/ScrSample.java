package org.testng;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ScrSample extends BaseClass {
	
	public static void main(String[] args) throws IOException {
		

//		chromeBrowser();
//		
//		
//		launchUrl("https://www.softwaretestingmaterial.com/how-to-capture-full-page-screenshot-using-selenium-webdriver/");
//		String currentUrl = driver.getCurrentUrl();
//		fullScreenshot();
//		
		File f = new File("C:\\Users\\gopin\\Downloads\\Transformer xpaths.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook w = new XSSFWorkbook(fis);
		 XSSFSheet sheet = w.getSheetAt(2);
		 Row r = sheet.getRow(2);
		 Cell c =r.getCell(1);
		 String value = c.getStringCellValue();
		 System.out.println(value);
	}

}
