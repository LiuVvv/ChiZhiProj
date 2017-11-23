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
		 * ��¼��̨�Ƿ�ɹ�,��������
		 */
		String back_Url =getCfgProperty("base_Url");
		webtest.open(back_Url);
		webtest.type("name=account", username);
		webtest.type("name=password", passwd);
		webtest.click("id=submit");
		//assertTrue(driver.getPageSource().contains("ǰ̨"));
			
		}

	@DataProvider(name="today")
	public Object [][] getData() {
		Object[][] obj={{"2017-11-20","2017-11-23"}};
		 return obj;
		}
	
	@Test(dataProvider="today")
	public void TuiguangToday(String firstTime,String secondTime) throws InterruptedException{
		/*
		 * �ƹ㣬�����ſ����������������
		 */
		String usname="admin";
		String passwd="admin";
		loginPass(usname, passwd);
		webtest.click("xpath=//a[contains(.,'�ƹ�')]");
		webtest.type("id=begin", firstTime);
		webtest.type("id=end", secondTime);
		webtest.click("id=submit");
		}
	@Test
	public void ZuiJinWeek() throws InterruptedException{
		/*
		 * �ƹ�-������һ��
		 */
			String usname="admin";
			String passwd="admin";
			loginPass(usname, passwd);
			webtest.click("xpath=//a[contains(.,'�ƹ�')]");
			webtest.click("xpath=//a[contains(.,'���һ��')]");
			}
	

}
