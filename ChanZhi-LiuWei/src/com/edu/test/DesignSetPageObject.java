package com.edu.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*页面对象*/
public class DesignSetPageObject {
	public WebDriver _driver;
	@FindBy(xpath="//a[contains(.,'设计')]")
	public WebElement design;
	
	
	@FindBy(xpath="//a[@href='/chanzhieps/www/admin.php?m=ui&f=others']")
	public WebElement set;
	
	
	@FindBy(id="QRCode2")
	public WebElement two;
	
	
	
	@FindBy(id="execInfo2")
	public WebElement run;
	
	@FindBy(id="submit")
	public WebElement submit;

	public DesignSetPageObject (WebDriver driver){
		this._driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	public void addLink() throws InterruptedException{
		this.design.click();
		this.set.click();
		Thread.sleep(3000);
		this.two.click();
		Thread.sleep(3000);
		this.submit.click();
		
		
	}
	
	
	
	
}
