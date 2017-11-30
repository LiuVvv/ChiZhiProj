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
		 * 登录后台是否成功
		 */
		check.verifyHtmlSource("前台");
			
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
		webtest.click("xpath=//a[contains(.,'推广')]");
		webtest.type("id=begin", firstTime);
		webtest.type("id=end", secondTime);
		webtest.click("id=submit");
		}
	@Test
	public void ZuiJinWeek() throws InterruptedException{
		/*
		 * 推广-点击最近一周
		 * 图表没办法验证
		 */
			webtest.click("xpath=//a[contains(.,'推广')]");
			webtest.click("xpath=//a[contains(.,'最近一周')]");
			}
	@Test
	public void KeyWord() throws Exception{
		/*
		 * 推广-统计-点击关键词  
		 */
		webtest.click("xpath=//a[contains(.,'推广')]");
		webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=stat&f=keywords']");
		check.verifyHtmlSource("关键词统计");
	}
	@DataProvider(name="day")
	public Object [][] getDayData() {
		Object[][] obj={{"50","60"}};
		 return obj;
		}
	

	@Test(dataProvider="day")
	public void Set(String save,String max) throws Exception{
		
		/*
		 * 推广-统计-点击设置数据驱动
		 */
		webtest.click("xpath=//a[contains(.,'推广')]");
		webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=stat&f=setting']");
		check.verifyHtmlSource("流量统计设置");
		webtest.click("id=saveDays");
		webtest.Backspace();
		webtest.type("id=saveDays", save);
		webtest.click("id=maxDays");
		webtest.Backspace();
		webtest.type("id=maxDays", max);
		webtest.click("id=submit");
	
	}
	
	/*在before里面写回到*/
}
