package org.testng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginSolid extends BaseClass {
  
	
	public static void main(String[] args) throws IOException {
		
		chromeBrowser();
		launchUrl("https://start.solidonline.com/portal/");
		
		
		driver.findElement(By.xpath("//input[@name='lgPlanner$UserName']")).sendKeys(getFromExcel("Login", 1, 0));
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(getFromExcel("Login", 1, 1));
		driver.findElement(By.xpath("//input[@class='make40x40']")).click();
		
		
//		int RowNo;
//		int CellNo;
//		
//		for (int i = 1; i < 3; i++) {
//			driver.findElement(By.xpath("//input[@name='lgPlanner$UserName']")).sendKeys(getFromExcel("Login", i, 0));
//			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(getFromExcel("Login", i+1, 1));
//			driver.findElement(By.xpath("//input[@class='make40x40']")).click();
//			String text = driver.findElement(By.xpath("//td[@style='color: Red; padding-left:20px; font-size:10px;']")).getText();
//			System.out.println(text);
//		}
		
		
	}
}
