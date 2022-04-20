package org.testng;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePojo extends BaseClass {
	
	public HomePojo() {
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(xpath="(//span[@class='wd-tools-icon'])[4]")
	private WebElement menuBtn; 
	
	@FindBy(xpath="//img[@Style='max-width: 138px;']")
	private WebElement hairUnitsImage;
	
	@FindBy(xpath="(//span[@class='wd-tools-icon'])[1]")
	private WebElement searchProducts;
	
	public WebElement getMenuBtn() {
		return menuBtn;
	}

	public WebElement getHairUnitsImage() {
		return hairUnitsImage;
	}

	public WebElement getSearchProducts() {
		return searchProducts;
	}

	public WebElement getAccBtn() {
		return accBtn;
	}

	public WebElement getCartBtn() {
		return cartBtn;
	}

	public WebElement getHeroImg1() {
		return heroImg1;
	}

	public WebElement getHeroImg2() {
		return heroImg2;
	}

	public WebElement getLftArrow() {
		return lftArrow;
	}

	public WebElement getRgtArrow() {
		return rgtArrow;
	}

	public WebElement getHeroImgText1() {
		return heroImgText1;
	}

	public WebElement getHeroImgText2() {
		return heroImgText2;
	}

	public WebElement getSingleImg() {
		return singleImg;
	}

	public WebElement getAboutUs() {
		return aboutUs;
	}

	public WebElement getPara1() {
		return para1;
	}

	public WebElement getPara2() {
		return para2;
	}

	public WebElement getReadMore() {
		return readMore;
	}

	@FindBy(xpath="(//span[@class='wd-tools-icon'])[5]")
	private WebElement accBtn;
	
	@FindBy(xpath="(//span[@class='wd-tools-icon'])[6]")
	private WebElement cartBtn;
	
	@FindBy(xpath="//img[@width='734']")
	private WebElement heroImg1;
	
	@FindBy(xpath="//img[@width='1138']")
	private WebElement heroImg2;
	
	@FindBy(xpath="//rs-arrow[@class='tp-leftarrow tparrows hesperiden noSwipe']")
	private WebElement lftArrow;
	
	@FindBy(xpath="//rs-arrow[@class='tp-rightarrow tparrows hesperiden noSwipe']")
	private WebElement rgtArrow;
	
	@FindBys({
		@FindBy(id="slider-49-slide-128-layer-3"),
		@FindBy(xpath="//h4[@id='slider-49-slide-128-layer-3']")
	})
	private WebElement heroImgText1;
	
	@FindBys({
		@FindBy(id="slider-49-slide-145-layer-3"),
		@FindBy(xpath="//h4[@id='slider-49-slide-145-layer-3']")
		})
	private WebElement heroImgText2;
	
	@FindBy(xpath="//img[@class='vc_single_image-img ']")
	private WebElement singleImg;
	
	@FindBy(xpath="//h4[contains(text(),'ABOUT')]")
	private WebElement aboutUs;
	
	@FindBy(xpath="//p[contains(text(),'many of the studios accessible')]")
	private WebElement para1;
	
	@FindBy(xpath="//p[contains(text(),'customise the colour')]")
	private WebElement para2;
	
	@FindBy(xpath="//a[text()='Read More']")
	private WebElement readMore;

	
	
	
	
}


