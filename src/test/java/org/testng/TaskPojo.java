package org.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPojo extends BaseClass {
public TaskPojo() {
	PageFactory.initElements(driver, this);
}

@CacheLookup
@FindBy(xpath="//select[@name='drplstEntity']")
private WebElement entityBtn;

@FindBy(xpath="//select[@name='drType']")
private WebElement type;

@FindBy(xpath="//table[@class='FTtable_scheduleFinal1_modified']")
private WebElement table;

public WebElement getTable() {
	return table;
}

public WebElement getEntityBtn() {
	return entityBtn;
}

public WebElement getType() {
	return type;
}
















}
