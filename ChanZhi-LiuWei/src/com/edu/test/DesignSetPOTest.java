package com.edu.test;
// 1 test 1 PO
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class DesignSetPOTest extends BaseTest{
	Action action=null;

	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Action(webtest);
		action.loginPass("admin", "admin");
			}	
	
	
	
	@Test
	public void testAddLink() throws Exception{
		DesignSetPageObject linkPageObject=new DesignSetPageObject(driver);
		linkPageObject.addLink();
		assertTrue(driver.getPageSource().contains("…Ë÷√≥…π¶"));
	}
	
	@AfterClass
	public void quit(){
		if(driver!=null){
			driver.quit();
			}
		
	}
	
	
}
