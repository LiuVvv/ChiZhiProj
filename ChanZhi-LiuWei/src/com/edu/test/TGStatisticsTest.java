package com.edu.test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.Checker;

public class TGStatisticsTest extends BaseTest{
	
	Action action=null;

	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Action(webtest);
		action.loginPass("admin", "admin");
			}	
	@Test
	public void testbackLogin(String username,String passwd) throws Exception{
		
		/*
		 * ��¼��̨�Ƿ�ɹ�
		 */
		check.verifyHtmlSource("ǰ̨");
			
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
		webtest.click("xpath=//a[contains(.,'�ƹ�')]");
		webtest.type("id=begin", firstTime);
		webtest.type("id=end", secondTime);
		webtest.click("id=submit");
		}
	@Test
	public void ZuiJinWeek() throws InterruptedException{
		/*
		 * �ƹ�-������һ��
		 * ͼ��û�취��֤
		 */
			webtest.click("xpath=//a[contains(.,'�ƹ�')]");
			webtest.click("xpath=//a[contains(.,'���һ��')]");
			}
	@Test
	public void KeyWord() throws Exception{
		/*
		 * �ƹ�-ͳ��-����ؼ���  
		 */
		webtest.click("xpath=//a[contains(.,'�ƹ�')]");
		webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=stat&f=keywords']");
		check.verifyHtmlSource("�ؼ���ͳ��");
	}
	@DataProvider(name="day")
	public Object [][] getDayData() {
		Object[][] obj={{"50","60"}};
		 return obj;
		}
	

	@Test(dataProvider="day")
	public void Set(String save,String max) throws Exception{
		
		/*
		 * �ƹ�-ͳ��-���������������
		 */
		webtest.click("xpath=//a[contains(.,'�ƹ�')]");
		webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=stat&f=setting']");
		check.verifyHtmlSource("����ͳ������");
		webtest.click("id=saveDays");
		webtest.Backspace();
		webtest.type("id=saveDays", save);
		webtest.click("id=maxDays");
		webtest.Backspace();
		webtest.type("id=maxDays", max);
		webtest.click("id=submit");
	
	}
	
	/*��before����д�ص�*/
}
