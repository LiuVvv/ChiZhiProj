package com.edu.test;

import org.testng.annotations.AfterClass;

// 9 test 1 provider

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.webtest.core.BaseTest;

public class TGKeyWordTest  extends BaseTest {
	Action action=null;

	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Action(webtest);
		action.loginPass("admin", "admin");
			}
	
	@BeforeMethod
	public void back(){
		webtest.open(index_Url);
	}
	
	@AfterClass
	public void quit(){
		if(driver!=null){
			driver.quit();
			}
		
	}
	@Test
	public void Guanjianzi() throws Exception{
		
	/*	点击关键字*/
		webtest.click("xpath=//a[contains(.,'推广')]");
		webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=tag&f=admin']");
		check.verifyHtmlSource("搜索");
	}
	@DataProvider(name="today")
	public Object [][] getData() {
		Object[][] obj={{"CMS","开源CMS"}};
		 return obj;
		}
	

	
	@Test(dataProvider="today")
	public void Sousuo(String tag,String verify) throws Exception{
	/*	搜索相关内容*/
		webtest.click("xpath=//a[contains(.,'推广')]");
		webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=tag&f=admin']");
		webtest.type("id=tag",tag);
		webtest.click("id=submit");
		check.verifyHtmlSource(verify);
		}
	
	@Test
	public void Weiquan() throws Exception{
		/*	按照位权排序*/
	webtest.click("xpath=//a[contains(.,'推广')]");
	webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=tag&f=admin']");
	webtest.click("xpath=//a[contains(.,'权重')]");
	check.verifyHtmlSource("安全cms");
	}
	@Test
	public void KaiyuanCMS() throws Exception{
		/*	点击开源CMS，进入其详细页面*/
	webtest.click("xpath=//a[contains(.,'推广')]");
	webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=tag&f=admin']");
	webtest.click("xpath=//a[contains(.,'开源CMS')]");
	check.verifyHtmlSource("来源");
	}
	@Test
	public void Editlink() throws Exception{
		/*  点击编辑链接*/
	webtest.click("xpath=//a[contains(.,'推广')]");
	webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=tag&f=admin']");
	webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=tag&f=link&id=9']");
	check.verifyHtmlSource("编辑链接");
	}
	
	@Test
	public void Delsubmit() throws Exception{
		/*  点击删除免费c m s*/
	webtest.click("xpath=//a[contains(.,'推广')]");
	webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=tag&f=admin']");
	webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=tag&f=delete&id=10']");
	webtest.click("xpath=//button[contains(.,'取消')]");
	check.verifyHtmlSource("免费cms");
	}
	
	@Test
	public void Nextpage() throws Exception{
		/*  点击下一页的按钮*/
	webtest.click("xpath=//a[contains(.,'推广')]");
	webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=tag&f=admin']");
	webtest.click("xpath=//i[@title='下一页']");
	check.verifyHtmlSource("免费企业建站");
	}
	@Test
	public void Breadcrumb() throws Exception{
		/*  点击面包屑的禅知
		 * 需要有16条关键词*/
	webtest.click("xpath=//a[contains(.,'推广')]");
	webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=tag&f=admin']");
	webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=admin&f=index']");
	check.verifyHtmlSource("首页");
	}
	@Test
	public void Propage() throws Exception{
		/*  每页显示条数更改javascript
		 * 
		 * 没有成功运行*/
	webtest.click("xpath=//a[contains(.,'推广')]");
	webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=tag&f=admin']");
//	webtest.click("id=_recPerPage");
//	webtest.click("xpath=javascript:submitPage(\"changeRecPerPage\", 15)");
	webtest.runJs("document.getElementsByClassName('dropdown dropup')[0].getElementsByTagName('ul')[0].removeAttribute('class')");
	webtest.click("link=15");
//	check.verifyHtmlSource("15");
	}

	
	
}
