package org.testng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PropertyRead extends BaseClass {

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		 
			
		
			chromeBrowser();
			
			File file = new File("C:\\Users\\gopin\\eclipse-workspace\\TestNgSession\\src\\test\\java\\xpath.properties");
			  
			FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		 
			Properties prop = new Properties();
			
			//load properties file
			try {
				prop.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			driver.get(prop.getProperty("url"));
			driver.findElement(By.xpath(prop.getProperty("usernamexpath"))).sendKeys(prop.getProperty("username"));
			driver.findElement(By.xpath(prop.getProperty("passwordxpath"))).sendKeys(prop.getProperty("password"));
			driver.findElement(By.xpath(prop.getProperty("submitxpath"))).click();
			
			Thread.sleep(5000);
			Actions a = new Actions(driver);
			WebElement findElement = driver.findElement(By.xpath(prop.getProperty("modules_menu")));
			a.moveToElement(findElement).build().perform();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			a.moveToElement(driver.findElement(By.xpath(prop.getProperty("taken")))).click().perform();
			System.out.println("Clicked");
		
//			System.out.println(getFromExcel("TAKEN", 2, 2));
			
//			System.out.println(driver.findElements(By.tagName("iframe")).size());
			
			driver.switchTo().frame("mainwindow");
//			String text = driver.findElement(By.xpath("//div[@class='pageHeader makeInline']")).getText();
//			System.out.println(text);
			
			selectByIndex(driver.findElement(By.xpath("//select[@name='drType']")), 0);
			String text2 = driver.findElement(By.xpath("//a[@id='gvTaskList_ctl02_HyperLink1']")).getText();
			System.out.println(text2);
			driver.switchTo().defaultContent();
			
			a.moveToElement(driver.findElement(By.xpath(prop.getProperty("cockpit")))).click().perform();
			System.out.println("Clicked");
			
			Thread.sleep(3000);
			
			driver.switchTo().frame("mainwindow");
//			driver.findElement(By.xpath("//span[text()='Hours']")).click();
//			System.out.println("Clicked");
//			
//			List<WebElement> findElements = driver.findElements(By.tagName("label"));
//			System.out.println(findElements.size());
//			
//			for (int i = 3; i < 8; i++) {
//				WebElement webElement = findElements.get(i);
//				boolean selected = webElement.isSelected();
//				
//				if (webElement.isSelected()==false) {
//					jsClick(webElement);
//					System.out.println(webElement.getText()+" "+ "is Selected");
//				}
//			}
			Thread.sleep(3000);
			WebElement reject = driver.findElement(By.xpath("//input[@id='chkStatusRejected']"));
			WebElement draft = driver.findElement(By.xpath("//input[@id='chkStatusDraft']"));
			WebElement open = driver.findElement(By.xpath("//input[@id='chkStatusOpen']"));
			WebElement processed = driver.findElement(By.xpath("//input[@id='chkStatusProcessed']"));
			WebElement closed = driver.findElement(By.xpath("//input[@id='chkStatusClosed']"));
			
			List<WebElement> li = new ArrayList<>();
			li.add(reject);
			li.add(draft);
			li.add(open);
			li.add(processed);
			li.add(closed);
			
			for (int i = 0; i < li.size(); i++) {
				WebElement webElement = li.get(i);
				
				if (webElement.isSelected()==false) {
					jsClick(webElement);
					System.out.println(webElement.getText()+" "+ "is Selected");
				}
			}
			Actions a1= new Actions(driver);
			a1.doubleClick(driver.findElement(By.xpath("//input[@aria-controls='tblHourSummary']")));
			
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_BACK_SPACE);
			r.keyRelease(KeyEvent.VK_BACK_SPACE);
			
			driver.findElement(By.xpath("//input[@aria-controls='tblHourSummary']")).sendKeys(text2);
			System.out.println("Pasted");
			JavascriptExecutor js =(JavascriptExecutor) driver;
			driver.findElement(By.xpath("//input[@aria-controls='tblHourSummary']")).getAttribute("value");
	}
	
	
}
