package org.testng;

import java.io.IOException;

public class ScrSample extends BaseClass {
	
	public static void main(String[] args) throws IOException {
		
chromeBrowser();
		
		maxWindow();
		launchUrl("https://www.softwaretestingmaterial.com/how-to-capture-full-page-screenshot-using-selenium-webdriver/");
		String currentUrl = driver.getCurrentUrl();
		fullScreenshot();
		
		
	}

}
