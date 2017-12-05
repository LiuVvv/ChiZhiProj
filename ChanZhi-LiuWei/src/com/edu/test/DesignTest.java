package com.edu.test;
/*30 test 2 provider*/
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class DesignTest extends BaseTest{
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
	
	@Test
	public void testInterTheme() throws Exception{
		
	/*	设置内置主题为蝉之格*/
		webtest.click("xpath=//a[contains(.,'设计')]");
		webtest.click("xpath=//img[@src='/chanzhieps/www/theme/default/tartan/preview.png']");
		check.verifyHtmlSource("设置成功");
	}
	
	@Test
	public void testViewIdet() throws Exception{
		/*点击导出主题*/
		webtest.click("xpath=//a[contains(.,'设计')]");
		webtest.click("xpath=//a[contains(.,'导出主题')]");
		check.verifyHtmlSource("导出主题");
		
	}
	@Test
	public void testThemeMarket() throws Exception{
		
	/*	点击主题市场-模板*/
		webtest.click("xpath=//a[contains(.,'设计')]");
		webtest.click("xpath=//a[@href='#storeSection']");
		webtest.click("xpath=//img[@src='http://snap.cnezsoft.com/chanzhi/qd0034.theme.chanzhi.org/thumb/index.jpg']");
		check.verifyHtmlSource("经典蓝色企业官网模板");
	}
	@Test
	public void testTMInternet() throws Exception{
		
	/*	点击主题市场-互联网*/
		webtest.click("xpath=//a[contains(.,'设计')]");
		webtest.click("xpath=//a[@href='#storeSection']");
		webtest.click("link=互联网");
		check.verifyHtmlSource("渐变色云计算科技公司响应式模板");
	}
	@Test
	public void testTMNew() throws Exception{
		/*	点击主题市场-最新*/
		webtest.click("xpath=//a[contains(.,'设计')]");
		webtest.click("xpath=//a[@href='#storeSection']");
		webtest.click("link=最新");
		check.verifyHtmlSource("英文陶瓷外贸营销型模板");
		
	}
	
	@Test
	public void testTpackage() throws Exception{
		/*	点击主题包-点不开*/
		webtest.click("xpath=//a[contains(.,'设计')]");
		webtest.click("xpath=//a[@href='#storeSection']");
		webtest.click("link=最新");
		check.verifyHtmlSource("英文陶瓷外贸营销型模板");
		
	}
	@Test
	public void testDistribution() throws Exception{
		
	/*	点击布局管理-header*/
		webtest.click("xpath=//a[contains(.,'设计')]");
		webtest.click("xpath=//a[contains(.,'布局管理')]");
		webtest.click("link=Header");
		check.verifyHtmlSource("保存");
	}
	@DataProvider(name="savename")
	public Object [][] getNameData() {
		Object[][] obj={{"新的布局方案"}};
		 return obj;
		}
	@Test(dataProvider="savename")
	public void testSaveDistri(String name) throws Exception{
		
	/*	点击布局管理-布局另存为*/
		webtest.click("xpath=//a[contains(.,'设计')]");
		webtest.click("xpath=//a[contains(.,'布局管理')]");
		webtest.click("link=布局另存为");
		webtest.type("id=name", name);
		webtest.click("id=submit");
		check.verifyHtmlSource("新的布局方案");
	}
	@Test
	public void testDistPage() throws Exception{
		
	/*	点击布局管理-上部*/
		webtest.click("xpath=//a[contains(.,'设计')]");
		webtest.click("xpath=//a[contains(.,'布局管理')]");
		webtest.click("link=上部");
		check.verifyHtmlSource("保存");
	}
	@DataProvider(name="color")
	public Object [][] getColorData() {
		Object[][] obj={{"#D0FFFD","#FF9400","#754FB9","#F2E205"}};
		 return obj;
		}
	@Test(dataProvider="color")
	public void testLookDitr(String back,String text,String link,String highLink) throws Exception{
		
		/*	点击外观管理-基本样式*/
			webtest.click("xpath=//a[contains(.,'设计')]");
			webtest.click("xpath=//a[contains(.,'外观管理')]");
			webtest.typeAndClear("id=background-color",back);
			webtest.typeAndClear("id=text-color",text);
			webtest.typeAndClear("id=link-color",link);
			webtest.typeAndClear("id=link-hover-color",highLink);
			webtest.click("id=resetTheme");
			//check.verifyHtmlSource("确认");
			webtest.click("xpath=//button[contains(.,'取消')]");
		//	driver.findElement(By.xpath("//button[contains(.,'取消')]"));
	}
	@Test
	public void testCodeMange() throws Exception{
		
		/*	点代码管理*/
			webtest.click("xpath=//a[contains(.,'设计')]");
			webtest.click("xpath=//a[contains(.,'代码管理')]");

			webtest.immediatelyClick("id=submit");
			Thread.sleep(1000);
			check.verifyHtmlSource("保存成功");
	}
	@Test
	public void testMaterialMange() throws Exception{
		
		/*	点素材管理-更改素材列表*/
			webtest.click("xpath=//a[contains(.,'设计')]");
			webtest.click("xpath=//a[contains(.,'素材管理')]");
			webtest.click("xpath=//a[@class='list-view btn']");
			check.verifyHtmlSource("编号");
	}
	
	@Test
	public void testUpLoadMaterial() throws Exception{
		
		/*	点素材管理-上传素材*/
			webtest.click("xpath=//a[contains(.,'设计')]");
			webtest.click("xpath=//a[contains(.,'素材管理')]");
			webtest.click("xpath=//a[contains(.,'上传素材')]");
			check.verifyHtmlSource("素材列表");
	}
	@Test
	public void testMark() throws Exception{
		
		/*	点标志-上传logo*/
			webtest.click("xpath=//a[contains(.,'设计')]");
			webtest.click("link=标志");
			check.verifyHtmlSource("标志设置");
	}
	
	@Test
	public void testPPTaddGroup() throws Exception{
		
		/*	点幻灯片-添加分组*/
			webtest.click("xpath=//a[contains(.,'设计')]");
			webtest.click("link=幻灯片");
			webtest.click("xpath=//a[@class='btn btn-primary']");
			webtest.type("id=name", "新添加的");
			webtest.click("xpath=//input[@value='添加分组']");
			check.verifyHtmlSource("新添加的");
	}
	@Test
	public void testPPTeditGroup() throws Exception{
		
		/*	点幻灯片-编辑分组*/
			webtest.click("xpath=//a[contains(.,'设计')]");
			webtest.click("link=幻灯片");
			webtest.click("xpath=//a[text()='编辑' and @href='/chanzhieps/www/admin.php?m=slide&f=browse&groupID=15']");
			check.verifyHtmlSource("添加幻灯片");
	}
	
	@Test
	public void testPPTeditGroupP() throws Exception{
		
		/*	点幻灯片-编辑分组使用图片*/
			webtest.click("xpath=//a[contains(.,'设计')]");
			webtest.click("link=幻灯片");
			webtest.click("xpath=//div[@class='plain-slide']");
			check.verifyHtmlSource("添加幻灯片");
	}
	
	@Test
	public void testAddPPT() throws Exception{
		
		/*	点幻灯片-编辑分组使用图片-添加幻灯片*/
			webtest.click("xpath=//a[contains(.,'设计')]");
			webtest.click("link=幻灯片");
			webtest.click("xpath=//div[@class='plain-slide']");
			webtest.click("xpath=//a[@class='btn btn-primary']");
			check.verifyHtmlSource("保存");
	}
	@Test
	public void testAddPPTtail() throws Exception{
		
		/*	点幻灯片-编辑分组使用图片-添加详细幻灯片*/
			webtest.click("xpath=//a[contains(.,'设计')]");
			webtest.click("link=幻灯片");
			webtest.click("xpath=//div[@class='plain-slide']");
			webtest.click("link=添加幻灯片");
			webtest.type("id=title", "value");
			webtest.click("id=backgroundType2");
			webtest.type("id=height", "120");
			webtest.immediatelyClick("id=submit");
			Thread.sleep(1000);		
			check.verifyHtmlSource("保存成功");
	}
	@Test
	public void testReturnGroups() throws Exception{
		
		/*	点幻灯片-编辑分组使用图片-返回分组*/
			webtest.click("xpath=//a[contains(.,'设计')]");
			webtest.click("link=幻灯片");
			webtest.click("xpath=//div[@class='plain-slide']");
			webtest.click("xpath=//a[contains(.,'返回分组')]");
			check.verifyHtmlSource("幻灯片分组");
	}
	@Test
	public void testRenamePPT() throws Exception{
		
		/*	点幻灯片-重命 名*/
			webtest.click("xpath=//a[contains(.,'设计')]");
			webtest.click("link=幻灯片");
			webtest.click("class=edit-group-btn");
			webtest.typeAndClear("id=groupName", "默认分组1");
			webtest.click("id=submit");
			check.verifyHtmlSource("默认分组1");
	}
	@Test
	public void testDeclearPPT() throws Exception{
		
		/*	点幻灯片-删除-取消*/
			webtest.click("xpath=//a[contains(.,'设计')]");
			webtest.click("link=幻灯片");
			webtest.click("xpath=//a[contains(.,'取消')]");
	}
	@Test
	public void testNavigation() throws Exception{
		
		/*	导航*/
			webtest.click("xpath=//a[contains(.,'设计')]");
			webtest.click("link=导航");
			webtest.click("link=博客");
			Select dropList = new Select(driver.findElement(By.xpath("//select[@name='nav[1][type][]' and @class='navType form-control']")));
			dropList.selectByVisibleText("文章类目");
			webtest.immediatelyClick("link=保存");
			Thread.sleep(1000);	
			check.verifyHtmlSource("设置成功");

	}
	
	@Test
	public void testNavAdd() throws Exception{
		
		/*	导航-加号*/
			webtest.click("xpath=//a[contains(.,'设计')]");
			webtest.click("link=导航");
			webtest.click("xpath=.//*[@id='navList']/li[1]/a[1]/i");
		
	}
	@Test
	public void testBlock() throws Exception{
		
		/*	区块-添加-样式*/
			webtest.click("xpath=//a[contains(.,'设计')]");
			webtest.click("link=区块");
			webtest.click("xpath=html/body/div/div/div[1]/div/div[1]/div/a/i");
			webtest.click("link=样式");
			check.verifyHtmlSource("内边距");
	}
	
	@Test
	public void testBlockContent() throws Exception{
		
		/*	区块-添加-内容-保存*/
			webtest.click("xpath=//a[contains(.,'设计')]");
			webtest.click("link=区块");
			webtest.click("xpath=html/body/div/div/div[1]/div/div[1]/div/a/i");
			webtest.type("id=title", "title");
			webtest.click("id=submit");
			check.verifyHtmlSource("内边距");
	}
	@Test
	public void testBlockConback() throws Exception{
		
		/*	区块-添加-内容-返回*/
			webtest.click("xpath=//a[contains(.,'设计')]");
			webtest.click("link=区块");
			webtest.click("xpath=html/body/div/div/div[1]/div/div[1]/div/a/i");
			webtest.type("id=title", "title");
			webtest.click("xpath=//a[contains(.,'返回')]");
			check.verifyHtmlSource("添加");
	}
	@Test
	public void testBlockList() throws Exception{
		
		/*	区块-单页列表*/
			webtest.click("xpath=//a[contains(.,'设计')]");
			webtest.click("link=区块");
			webtest.click("link=单页列表");
			check.verifyHtmlSource("保存");
	}
	@Test
	public void testMode() throws Exception{
		
		/*	编辑模板*/
			webtest.click("xpath=//a[contains(.,'设计')]");
			webtest.click("link=编辑模板");
			webtest.click("xpath=//span[contains(.,'首页')]");
			webtest.click("link=首页");
			check.verifyHtmlSource("index.html.php");
	}
	@Test
	public void testModeRe() throws Exception{
		
		/*	编辑模板-重置为默认*/
			webtest.click("xpath=//a[contains(.,'设计')]");
			webtest.click("link=编辑模板");
			webtest.immediatelyClick("link=重置为默认");
			Thread.sleep(1000);
			check.verifyHtmlSource("保存成功");
	}
	@Test
	public void testDesk() throws Exception{
		
		/*	设计-桌面*/
		
			webtest.click("xpath=//a[contains(.,'设计')]");
			webtest.click("//strong[contains(.,' 桌面')]");
			driver.findElement(By.xpath("//i[@class='icon icon-tablet']"));
			webtest.click("xpath=//i[@class='icon icon-tablet']");
			
			//check.verifyHtmlSource("保存成功");
	}
	@Test
	public void testVIPDel() throws Exception{
		
		/*	会员-论坛-删除*/
		
			webtest.click("xpath=//a[contains(.,'会员')]");
			webtest.click("link=论坛");
			webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=thread&f=delete&threadID=2']");
			webtest.click("xpath=//button[contains(.,'取消')]");
			check.verifyHtmlSource("搜索");
	}
	@Test
	public void testVIPHide() throws Exception{
		
		/*	会员-论坛-隐藏?????*/
		
			webtest.click("xpath=//a[contains(.,'会员')]");
			webtest.click("link=论坛");
			webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=thread&f=switchStatus&threadID=2']");
			check.verifyHtmlSource("已隐藏");
			Thread.sleep(1000);
			webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=thread&f=switchStatus&threadID=2']");
		
	}
	@Test
	public void testVIPFind() throws Exception{
		
		/*	会员-论坛-搜索*/
		
			webtest.click("xpath=//a[contains(.,'会员')]");
			webtest.click("link=论坛");
			webtest.type("id=searchWord", "傻子");
			webtest.click("id=submit");
			check.verifyHtmlSource("傻子");
		
	}
	@Test
	public void testVIPBlack() throws Exception{
		
		/*	会员-论坛-加黑*/
		
			webtest.click("xpath=//a[contains(.,'会员')]");
			webtest.click("link=论坛");
			webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=guarder&f=addToBlacklist&type=thread&id=2']");
			webtest.immediatelyClick("xpath=//input[@value='保存']");
			Thread.sleep(1000);
			check.verifyHtmlSource("设置成功");
		
	}

	
	
	
	
	
	

}
