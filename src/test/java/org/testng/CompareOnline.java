package org.testng;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CompareOnline extends BaseClass {
	
	
		
		static ExtentTest test;
		static ExtentReports report;
		
		@BeforeClass
		private void startTest() {
			report = new ExtentReports("C:\\Users\\gopin\\eclipse-workspace\\TestNgSession\\reports\\ExtentReportResults.html");
			test = report.startTest("CompareOnline");
		
		}
		
		@Test
		private void comparing() throws InterruptedException, IOException {
			
			chromeBrowser();
			launchUrl("https://www.corefiling.com/opensource/xmldiff/");
			
		
		WebElement choosefile1 = driver.findElement(By.xpath("//input[@name='file1']"));
		choosefile1.sendKeys("C:\\\\Users\\\\gopin\\\\Downloads\\\\SOLP0000005381-Urenbriefje_verzonden_2022_08_Candela_C._Grima_Rufete.xml");
		
		
		Thread.sleep(5000);
		WebElement choosefile2 = driver.findElement(By.xpath("//input[@name='file2']"));
		choosefile2.sendKeys("C:\\\\Users\\\\gopin\\\\Downloads\\\\SOLT0000008123-Urenbriefje_2022_08_Candela_C._Grima_Rufete.xml");
		 
	
		Thread.sleep(5000);
		
		WebElement finddiff = driver.findElement(By.cssSelector("button[type=submit]"));
	JavascriptExecutor js =(JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", finddiff);
	
	
//	entireScreenshot("src20");
	
	test.log(LogStatus.PASS,test.addScreenCapture(entireScreenshot(driver))+ " Xml Compare ScreenShot");
	
	System.out.println("Screenshot Taken");
	
	List<WebElement> findElements = driver.findElements(By.xpath("//font[@color='red']"));
	List<WebElement> findElements1 = driver.findElements(By.xpath("//font[@color='green']"));
	
	if (findElements.size()== findElements1.size()) {
		int size = findElements.size();
		for (int i = 0; i < size; i++) {

			WebElement webElement = findElements.get(i);
			String text = webElement.getText();
		
			WebElement webElement2 = findElements1.get(i);
			String text2 = webElement2.getText();
			if (i>0) {
				System.out.println("The Differences are "+text.substring(5)+" And "+text2.substring(5));
			}
//			System.out.println("The Differences are "+text.substring(5)+" And "+text2.substring(5));
	}
	}
	else if (findElements.size()> findElements1.size()) {
		for (int i = 0; i <findElements.size() ; i++) {
			WebElement webElement = findElements.get(i);
			String text = webElement.getText();
			if (i>0) {
				System.out.println("Differences from 1st File "+text);
			}
//			System.out.println("Differences from 1st File "+text);
		}
		for (int j = 0; j <findElements1.size(); j++) {
			WebElement webElement2 = findElements1.get(j);
			String text2 = webElement2.getText();
			if (j>0) {
				System.out.println("Differences from 2nD File "+text2);
			}
//			System.out.println("Differences from 2nD File "+text2);
		}
		
	}
	else {
		for (int i = 0; i <findElements.size() ; i++) {
			WebElement webElement = findElements.get(i);
			String text = webElement.getText();
			if (i>0) {
				System.out.println("Differences from 1st File "+text);
			}
//			System.out.println("Differences from 1st File "+text);
		}
		for (int j = 0; j <findElements1.size(); j++) {
			WebElement webElement2 = findElements1.get(j);
			String text2 = webElement2.getText();
			if (j >0) {
				System.out.println("Differences from 2nD File "+text2);
			}
//			System.out.println("Differences from 2nD File "+text2);
		}
		
	}
		}
		
		@AfterClass
		private void endTest() {
			report.endTest(test);
			report.flush();

		}
	}

	
	

	
