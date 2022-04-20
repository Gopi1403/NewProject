package org.testng;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DiffMerge extends BaseClass {

	public static void main(String[] args) throws IOException, AWTException {
		

		chromeBrowser();
		
		maxWindow();
		launchUrl("https://extendsclass.com/xml-diff.html");
//		launchUrl("https://editor.mergely.com/");
//		 
//		 
//		
//		driver.findElement(By.xpath("(//span[@class='icon icon-import'])[2]")).click();
//		
//		
//		WebElement file1 = driver.findElement(By.xpath("//input[@id='file-lhs']"));
//		file1.sendKeys("C:\\Users\\gopin\\Downloads\\SOLT0000000103-Urenbriefje_2022_04source.xml");
//		
//		WebElement file2 = driver.findElement(By.xpath("//input[@id='file-rhs']"));
//		file2.sendKeys("C:\\Users\\gopin\\Downloads\\SOLT0000000103-Urenbriefje_2022_04_ (1).xml");
//		
//		driver.findElement(By.xpath("//button[text()='Import']")).click();
//		
//		entireScreenshot();
//		
//		String currentUrl = driver.getCurrentUrl();
//		
//		entireScreenshot(currentUrl);
//		System.out.println("Taken Screenshot");
//		
	driver.findElement(By.xpath("(//input[@class='action-button-editor right span'])[1]")).click();
	uploadFile("C:\\Users\\gopin\\Downloads\\SOLT0000000103-Urenbriefje_2022_04source.xml");
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	
	
	driver.findElement(By.xpath("(//input[@class='action-button-editor right span'])[3]")).click();
	
	uploadFile("C:\\Users\\gopin\\Downloads\\SOLT0000000103-Urenbriefje_2022_04_ (1).xml");
	
	driver.findElement(By.xpath("//input[@onclick='xmlDiff();']")).click();
	
	
	fullScreenshot();

	System.out.println("Taken Screenshot");
	
	
	
	
	
	
	}
}
