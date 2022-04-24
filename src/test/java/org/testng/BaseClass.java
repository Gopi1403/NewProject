package org.testng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BaseClass {
	
	public static WebDriver driver;
	
	
	
	public static void chromeBrowser() {
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	}
	
	public static void launchUrl(String url) {
		driver.get(url);
	}
	
   public static String pageTitle() {
	   String titleName =  driver.getTitle();
	   return titleName;
   }
  
   public static String pageUrl() {
	   String url = driver.getCurrentUrl();
	   return url;
   }
   
    public static void pageRefresh() {
    	driver.navigate().refresh();
    }
   
    public static String getFromExcel(String sheetName ,int rowNo, int cellNo) throws IOException {
		
    	File f = new File("C:\\Users\\gopin\\Downloads\\Transformer xpaths.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook w = new XSSFWorkbook(fis);
		 XSSFSheet sheet = w.getSheet(sheetName);
		 Row r = sheet.getRow(rowNo);
		 Cell c =r.getCell(cellNo);
		 String value = c.getStringCellValue();
	
		return value;
	
	}
   
    public static void viewPortScreenshot() throws IOException {
    	TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File f= new File("C:\\Users\\gopin\\eclipse-workspace\\TestNgSession\\Screenshots\\src1.png");
		FileUtils.copyFile(src, f);

	}
   
    public static String entireScreenshot(WebDriver driver) throws IOException  {
    	
    	
		Screenshot src=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(10000)).takeScreenshot(driver);
		
		File f=new File("C:\\Users\\gopin\\eclipse-workspace\\TestNgSession\\src" + System.currentTimeMillis() + ".png");
		ImageIO.write(src.getImage(), "PNG", f);
		
		String absolutePath = f.getAbsolutePath();
		
		return absolutePath;
	}
    
    public static void fullScreenshot() throws IOException {
Screenshot src=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(10000)).takeScreenshot(driver);
		
		File f=new File("C:\\Users\\gopin\\eclipse-workspace\\TestNgSession\\Screenshots" + System.currentTimeMillis() + ".png");
		ImageIO.write(src.getImage(), "PNG", f);

	}
    
	
    
    public static void jsClick(WebElement webElement) {
    	JavascriptExecutor js =(JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click()", webElement);

	}
    
    public static void jsSendkeys(String valueToEnter ,WebElement webElement) {
    	JavascriptExecutor js =(JavascriptExecutor) driver;
    	js.executeScript("arguments[0].setAttribute('value', 'valueToEnter')", webElement);
	}
    
    public static void jsReturnAttribute(WebElement webElement) {
    	JavascriptExecutor js =(JavascriptExecutor) driver;
    	js.executeScript("return arguments[0].getAttribute('value')", webElement);

	}
    
    public static void uploadFile(String path) throws AWTException {
    	
    	 StringSelection StringSelection = new StringSelection(path);
    	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(StringSelection, null);

    	    driver.switchTo().window(driver.getWindowHandle());

    	    Robot robot = new Robot();

    	    //Open Goto window
    	    robot.keyPress(KeyEvent.VK_ALT);
    	    robot.keyPress(KeyEvent.VK_TAB);
    	    
    	    robot.keyRelease(KeyEvent.VK_ALT);
    	    robot.keyRelease(KeyEvent.VK_TAB);
    	    

    	    //Paste the clipboard value
    	    robot.keyPress(KeyEvent.VK_CONTROL);
    	    robot.keyPress(KeyEvent.VK_V);
    	    robot.keyRelease(KeyEvent.VK_CONTROL);
    	    robot.keyRelease(KeyEvent.VK_V);

    	    //Press Enter key to close the Goto window and Upload window
    	    robot.delay(1000);
    	    robot.keyPress(KeyEvent.VK_ENTER);
    	    robot.keyRelease(KeyEvent.VK_ENTER);
    	    robot.delay(1000);
    	    robot.keyPress(KeyEvent.VK_ENTER);
    	    robot.keyRelease(KeyEvent.VK_ENTER);
	}
    public static void selectByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
		
	}
    
    
	
}
