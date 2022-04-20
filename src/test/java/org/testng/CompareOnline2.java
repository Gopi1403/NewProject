package org.testng;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class CompareOnline2 extends BaseClass {
	
public static void main(String[] args) throws InterruptedException {
		
		chromeBrowser();
		launchUrl("https://www.corefiling.com/opensource/xmldiff/");
		maxWindow();
		
		
		WebElement choosefile1 = driver.findElement(By.xpath("//input[@name='file1']"));
		choosefile1.sendKeys("C:\\Users\\gopin\\Downloads\\SOLT0000000103-Urenbriefje_2022_04source.xml");
		
		
		Thread.sleep(5000);
		WebElement choosefile2 = driver.findElement(By.xpath("//input[@name='file2']"));
		choosefile2.sendKeys("C:\\Users\\gopin\\Downloads\\SOLT0000000103-Urenbriefje_2022_04_ (1).xml");
		 
	
		Thread.sleep(5000);
		
		WebElement finddiff = driver.findElement(By.cssSelector("button[type=submit]"));
	JavascriptExecutor js =(JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", finddiff);
	
	List<WebElement> findElements = driver.findElements(By.xpath("//font[@color='red']"));
	List<WebElement> findElements1 = driver.findElements(By.xpath("//font[@color='green']"));
	
	
	
	
	List<String> tI1=new ArrayList<String>();
	List<String> tI2=new ArrayList<String>();
	
	for (int i = 0; i < findElements.size(); i++) {
		String text = findElements.get(i).getText();
		if (text.contains("TimeInterval")) {
			tI1.add(text);
		}
	
	}
	
	for (int i = 0; i <findElements1.size(); i++) {
		String text = findElements1.get(i).getText();
		if (text.contains("TimeInterval")) {
			tI2.add(text);
	}
	}
	
	if (tI1.size()==tI2.size()) {
		for (int i = 0; i < tI1.size(); i++) {
			System.out.println("The Differences are "+tI1.get(i)+"and "+ tI2.get(i));
		}
	} 
	else if (tI1.size()>tI2.size()) {
		for (int i = 0; i < tI2.size(); i++) {
			System.out.println("The Differences are "+tI1.get(i)+ "and "+ tI2.get(i));
		}
		for (int j = tI2.size(); j < tI1.size(); j++) {
			System.out.println("The Missing part is "+tI1.get(j));
		}
	}
	else {
		for (int i = 0; i < tI1.size(); i++) {
			System.out.println("The Differences are "+tI1.get(i)+ "and "+ tI2.get(i));
		}
		for (int j = tI1.size(); j < tI1.size(); j++) {
			System.out.println("The Missing part is "+tI2.get(j));
		}
	}
	
	List<String> d1=new ArrayList<String>();
	List<String> d2=new ArrayList<String>();
	
	for (int i = 0; i < findElements.size(); i++) {
		String text = findElements.get(i).getText();
		if (text.contains("Duration")) {
			d1.add(text);
		}
	
	}
//	for (int i = 0; i < d1.size(); i++) {
//		String string = d1.get(i);
//		System.out.println(string);
//	}
	for (int i = 0; i <findElements1.size(); i++) {
		String text = findElements1.get(i).getText();
		if (text.contains("Duration")) {
			d2.add(text);
	}
	}
	
	if (d1.size()==d2.size()) {
		for (int i = 0; i < d1.size(); i++) {
			System.out.println("The Differences are "+d1.get(i)+"and "+ d2.get(i));
		}
	} 
	else if (d1.size()>d2.size()) {
		for (int i = 0; i < d2.size(); i++) {
			System.out.println("The Differences are "+d1.get(i)+ "and "+ d2.get(i));
		}
		for (int j = d2.size(); j < d1.size(); j++) {
			System.out.println("The Missing part is "+d1.get(j));
		}
	}
	else {
		for (int i = 0; i < d1.size(); i++) {
			System.out.println("The Differences are "+d1.get(i)+ "and "+ d2.get(i));
		}
		for (int j = d1.size(); j < d1.size(); j++) {
			System.out.println("The Missing part is "+d2.get(j));
		}
	}
	
	List<String> sDT1=new ArrayList<String>();
	List<String> sDT2=new ArrayList<String>();
	
	for (int i = 0; i < findElements.size(); i++) {
		String text = findElements.get(i).getText();
		if (text.contains("StartDateTime")) {
			sDT1.add(text);
		}
	
	}
	
	for (int i = 0; i <findElements1.size(); i++) {
		String text = findElements1.get(i).getText();
		if (text.contains("StartDateTime")) {
			sDT2.add(text);
	}
	}
	
	if (sDT1.size()==sDT2.size()) {
		for (int i = 0; i < sDT1.size(); i++) {
			System.out.println("The Differences are "+sDT1.get(i)+"and "+ sDT2.get(i));
		}
	} 
	else if (sDT1.size()>sDT2.size()) {
		for (int i = 0; i < sDT2.size(); i++) {
			System.out.println("The Differences are "+sDT1.get(i)+ "and "+ sDT2.get(i));
		}
		for (int j = sDT2.size(); j < sDT1.size(); j++) {
			System.out.println("The Missing part is "+sDT1.get(j));
		}
	}
	else {
		for (int i = 0; i < sDT1.size(); i++) {
			System.out.println("The Differences are "+sDT1.get(i)+ "and "+ sDT2.get(i));
		}
		for (int j = sDT1.size(); j < sDT1.size(); j++) {
			System.out.println("The Missing part is "+sDT2.get(j));
		}
	}
	
	List<String> eDT1=new ArrayList<String>();
	List<String> eDT2=new ArrayList<String>();
	
	for (int i = 0; i < findElements.size(); i++) {
		String text = findElements.get(i).getText();
		if (text.contains("EndDateTime")) {
			eDT1.add(text);
		}
	
	}
	
	for (int i = 0; i <findElements1.size(); i++) {
		String text = findElements1.get(i).getText();
		if (text.contains("EndDateTime")) {
			eDT2.add(text);
	}
	}
	
	if (eDT1.size()==eDT2.size()) {
		for (int i = 0; i < eDT1.size(); i++) {
			System.out.println("The Differences are "+eDT1.get(i)+"and "+ eDT2.get(i));
		}
	} 
	else if (eDT1.size()>eDT2.size()) {
		for (int i = 0; i < eDT2.size(); i++) {
			System.out.println("The Differences are "+eDT1.get(i)+ "and "+ eDT2.get(i));
		}
		for (int j = eDT2.size(); j < eDT1.size(); j++) {
			System.out.println("The Missing part is "+eDT1.get(j));
		}
	}
	else {
		for (int i = 0; i < eDT1.size(); i++) {
			System.out.println("The Differences are "+eDT1.get(i)+ "and "+ eDT2.get(i));
		}
		for (int j = eDT1.size(); j < eDT1.size(); j++) {
			System.out.println("The Missing part is "+eDT2.get(j));
		}
	}
	List<String> rOA1=new ArrayList<String>();
	List<String> rOA2=new ArrayList<String>();
	
	for (int i = 0; i < findElements.size(); i++) {
		String text = findElements.get(i).getText();
		if (text.contains("RateOrAmount")) {
			rOA1.add(text);
		}
	
	}
	
	for (int i = 0; i <findElements1.size(); i++) {
		String text = findElements1.get(i).getText();
		if (text.contains("RateOrAmount")) {
			rOA2.add(text);
	}
	}
	
	if (rOA1.size()==rOA2.size()) {
		for (int i = 0; i < rOA1.size(); i++) {
			System.out.println("The Differences are "+rOA1.get(i)+"and "+ rOA2.get(i));
		}
	} 
	else if (rOA1.size()>rOA2.size()) {
		for (int i = 0; i < rOA2.size(); i++) {
			System.out.println("The Differences are "+rOA1.get(i)+ "and "+ rOA2.get(i));
		}
		for (int j = rOA2.size(); j < rOA1.size(); j++) {
			System.out.println("The Missing part is "+rOA1.get(j));
		}
	}
	else {
		for (int i = 0; i < rOA1.size(); i++) {
			System.out.println("The Differences are "+rOA1.get(i)+ "and "+ rOA2.get(i));
		}
		for (int j = rOA1.size(); j < rOA1.size(); j++) {
			System.out.println("The Missing part is "+rOA2.get(j));
		}
	}
	
}
}

