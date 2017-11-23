package com.edu.test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class BackChanZhi extends BaseTest{
	
	public void loginPass(String username,String passwd) throws InterruptedException{
		String back_Url =getCfgProperty("base_Url");
		webtest.open(back_Url);
		webtest.type("name=account", username);
		webtest.type("name=password", passwd);
		webtest.click("id=submit");
		}
	
	@DataProvider(name="login")
	public Object [][] getLoginData() {
		Object[][] obj={{"admin","admin"}};
		 return obj;
		}
	
	@Test(dataProvider="login")
	public void testbackLogin(String username,String passwd) throws Exception{
		
		/*
		 * 登录后台是否成功,数据驱动
		 */
		String back_Url =getCfgProperty("base_Url");
		webtest.open(back_Url);
		webtest.type("name=account", username);
		webtest.type("name=password", passwd);
		webtest.click("id=submit");
		//assertTrue(driver.getPageSource().contains("前台"));
			
		}

	@DataProvider(name="today")
	public Object [][] getData() {
		Object[][] obj={{"2017-11-20","2017-11-23"}};
		 return obj;
		}
	
	@Test(dataProvider="today")
	public void TuiguangToday(String firstTime,String secondTime) throws InterruptedException{
		/*
		 * 推广，流量概况，用数据驱动完成
		 */
		String usname="admin";
		String passwd="admin";
		loginPass(usname, passwd);
		webtest.click("xpath=//a[contains(.,'推广')]");
		webtest.type("id=begin", firstTime);
		webtest.type("id=end", secondTime);
		webtest.click("id=submit");
		}
	@Test
	public void ZuiJinWeek() throws InterruptedException{
		/*
		 * 推广-点击最近一周
		 */
			String usname="admin";
			String passwd="admin";
			loginPass(usname, passwd);
			webtest.click("xpath=//a[contains(.,'推广')]");
			webtest.click("xpath=//a[contains(.,'最近一周')]");
			}
	

}
