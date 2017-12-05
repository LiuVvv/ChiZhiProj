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
		
	/*	������������Ϊ��֮��*/
		webtest.click("xpath=//a[contains(.,'���')]");
		webtest.click("xpath=//img[@src='/chanzhieps/www/theme/default/tartan/preview.png']");
		check.verifyHtmlSource("���óɹ�");
	}
	
	@Test
	public void testViewIdet() throws Exception{
		/*�����������*/
		webtest.click("xpath=//a[contains(.,'���')]");
		webtest.click("xpath=//a[contains(.,'��������')]");
		check.verifyHtmlSource("��������");
		
	}
	@Test
	public void testThemeMarket() throws Exception{
		
	/*	��������г�-ģ��*/
		webtest.click("xpath=//a[contains(.,'���')]");
		webtest.click("xpath=//a[@href='#storeSection']");
		webtest.click("xpath=//img[@src='http://snap.cnezsoft.com/chanzhi/qd0034.theme.chanzhi.org/thumb/index.jpg']");
		check.verifyHtmlSource("������ɫ��ҵ����ģ��");
	}
	@Test
	public void testTMInternet() throws Exception{
		
	/*	��������г�-������*/
		webtest.click("xpath=//a[contains(.,'���')]");
		webtest.click("xpath=//a[@href='#storeSection']");
		webtest.click("link=������");
		check.verifyHtmlSource("����ɫ�Ƽ���Ƽ���˾��Ӧʽģ��");
	}
	@Test
	public void testTMNew() throws Exception{
		/*	��������г�-����*/
		webtest.click("xpath=//a[contains(.,'���')]");
		webtest.click("xpath=//a[@href='#storeSection']");
		webtest.click("link=����");
		check.verifyHtmlSource("Ӣ���մ���óӪ����ģ��");
		
	}
	
	@Test
	public void testTpackage() throws Exception{
		/*	��������-�㲻��*/
		webtest.click("xpath=//a[contains(.,'���')]");
		webtest.click("xpath=//a[@href='#storeSection']");
		webtest.click("link=����");
		check.verifyHtmlSource("Ӣ���մ���óӪ����ģ��");
		
	}
	@Test
	public void testDistribution() throws Exception{
		
	/*	������ֹ���-header*/
		webtest.click("xpath=//a[contains(.,'���')]");
		webtest.click("xpath=//a[contains(.,'���ֹ���')]");
		webtest.click("link=Header");
		check.verifyHtmlSource("����");
	}
	@DataProvider(name="savename")
	public Object [][] getNameData() {
		Object[][] obj={{"�µĲ��ַ���"}};
		 return obj;
		}
	@Test(dataProvider="savename")
	public void testSaveDistri(String name) throws Exception{
		
	/*	������ֹ���-�������Ϊ*/
		webtest.click("xpath=//a[contains(.,'���')]");
		webtest.click("xpath=//a[contains(.,'���ֹ���')]");
		webtest.click("link=�������Ϊ");
		webtest.type("id=name", name);
		webtest.click("id=submit");
		check.verifyHtmlSource("�µĲ��ַ���");
	}
	@Test
	public void testDistPage() throws Exception{
		
	/*	������ֹ���-�ϲ�*/
		webtest.click("xpath=//a[contains(.,'���')]");
		webtest.click("xpath=//a[contains(.,'���ֹ���')]");
		webtest.click("link=�ϲ�");
		check.verifyHtmlSource("����");
	}
	@DataProvider(name="color")
	public Object [][] getColorData() {
		Object[][] obj={{"#D0FFFD","#FF9400","#754FB9","#F2E205"}};
		 return obj;
		}
	@Test(dataProvider="color")
	public void testLookDitr(String back,String text,String link,String highLink) throws Exception{
		
		/*	�����۹���-������ʽ*/
			webtest.click("xpath=//a[contains(.,'���')]");
			webtest.click("xpath=//a[contains(.,'��۹���')]");
			webtest.typeAndClear("id=background-color",back);
			webtest.typeAndClear("id=text-color",text);
			webtest.typeAndClear("id=link-color",link);
			webtest.typeAndClear("id=link-hover-color",highLink);
			webtest.click("id=resetTheme");
			//check.verifyHtmlSource("ȷ��");
			webtest.click("xpath=//button[contains(.,'ȡ��')]");
		//	driver.findElement(By.xpath("//button[contains(.,'ȡ��')]"));
	}
	@Test
	public void testCodeMange() throws Exception{
		
		/*	��������*/
			webtest.click("xpath=//a[contains(.,'���')]");
			webtest.click("xpath=//a[contains(.,'�������')]");

			webtest.immediatelyClick("id=submit");
			Thread.sleep(1000);
			check.verifyHtmlSource("����ɹ�");
	}
	@Test
	public void testMaterialMange() throws Exception{
		
		/*	���زĹ���-�����ز��б�*/
			webtest.click("xpath=//a[contains(.,'���')]");
			webtest.click("xpath=//a[contains(.,'�زĹ���')]");
			webtest.click("xpath=//a[@class='list-view btn']");
			check.verifyHtmlSource("���");
	}
	
	@Test
	public void testUpLoadMaterial() throws Exception{
		
		/*	���زĹ���-�ϴ��ز�*/
			webtest.click("xpath=//a[contains(.,'���')]");
			webtest.click("xpath=//a[contains(.,'�زĹ���')]");
			webtest.click("xpath=//a[contains(.,'�ϴ��ز�')]");
			check.verifyHtmlSource("�ز��б�");
	}
	@Test
	public void testMark() throws Exception{
		
		/*	���־-�ϴ�logo*/
			webtest.click("xpath=//a[contains(.,'���')]");
			webtest.click("link=��־");
			check.verifyHtmlSource("��־����");
	}
	
	@Test
	public void testPPTaddGroup() throws Exception{
		
		/*	��õ�Ƭ-��ӷ���*/
			webtest.click("xpath=//a[contains(.,'���')]");
			webtest.click("link=�õ�Ƭ");
			webtest.click("xpath=//a[@class='btn btn-primary']");
			webtest.type("id=name", "����ӵ�");
			webtest.click("xpath=//input[@value='��ӷ���']");
			check.verifyHtmlSource("����ӵ�");
	}
	@Test
	public void testPPTeditGroup() throws Exception{
		
		/*	��õ�Ƭ-�༭����*/
			webtest.click("xpath=//a[contains(.,'���')]");
			webtest.click("link=�õ�Ƭ");
			webtest.click("xpath=//a[text()='�༭' and @href='/chanzhieps/www/admin.php?m=slide&f=browse&groupID=15']");
			check.verifyHtmlSource("��ӻõ�Ƭ");
	}
	
	@Test
	public void testPPTeditGroupP() throws Exception{
		
		/*	��õ�Ƭ-�༭����ʹ��ͼƬ*/
			webtest.click("xpath=//a[contains(.,'���')]");
			webtest.click("link=�õ�Ƭ");
			webtest.click("xpath=//div[@class='plain-slide']");
			check.verifyHtmlSource("��ӻõ�Ƭ");
	}
	
	@Test
	public void testAddPPT() throws Exception{
		
		/*	��õ�Ƭ-�༭����ʹ��ͼƬ-��ӻõ�Ƭ*/
			webtest.click("xpath=//a[contains(.,'���')]");
			webtest.click("link=�õ�Ƭ");
			webtest.click("xpath=//div[@class='plain-slide']");
			webtest.click("xpath=//a[@class='btn btn-primary']");
			check.verifyHtmlSource("����");
	}
	@Test
	public void testAddPPTtail() throws Exception{
		
		/*	��õ�Ƭ-�༭����ʹ��ͼƬ-�����ϸ�õ�Ƭ*/
			webtest.click("xpath=//a[contains(.,'���')]");
			webtest.click("link=�õ�Ƭ");
			webtest.click("xpath=//div[@class='plain-slide']");
			webtest.click("link=��ӻõ�Ƭ");
			webtest.type("id=title", "value");
			webtest.click("id=backgroundType2");
			webtest.type("id=height", "120");
			webtest.immediatelyClick("id=submit");
			Thread.sleep(1000);		
			check.verifyHtmlSource("����ɹ�");
	}
	@Test
	public void testReturnGroups() throws Exception{
		
		/*	��õ�Ƭ-�༭����ʹ��ͼƬ-���ط���*/
			webtest.click("xpath=//a[contains(.,'���')]");
			webtest.click("link=�õ�Ƭ");
			webtest.click("xpath=//div[@class='plain-slide']");
			webtest.click("xpath=//a[contains(.,'���ط���')]");
			check.verifyHtmlSource("�õ�Ƭ����");
	}
	@Test
	public void testRenamePPT() throws Exception{
		
		/*	��õ�Ƭ-���� ��*/
			webtest.click("xpath=//a[contains(.,'���')]");
			webtest.click("link=�õ�Ƭ");
			webtest.click("class=edit-group-btn");
			webtest.typeAndClear("id=groupName", "Ĭ�Ϸ���1");
			webtest.click("id=submit");
			check.verifyHtmlSource("Ĭ�Ϸ���1");
	}
	@Test
	public void testDeclearPPT() throws Exception{
		
		/*	��õ�Ƭ-ɾ��-ȡ��*/
			webtest.click("xpath=//a[contains(.,'���')]");
			webtest.click("link=�õ�Ƭ");
			webtest.click("xpath=//a[contains(.,'ȡ��')]");
	}
	@Test
	public void testNavigation() throws Exception{
		
		/*	����*/
			webtest.click("xpath=//a[contains(.,'���')]");
			webtest.click("link=����");
			webtest.click("link=����");
			Select dropList = new Select(driver.findElement(By.xpath("//select[@name='nav[1][type][]' and @class='navType form-control']")));
			dropList.selectByVisibleText("������Ŀ");
			webtest.immediatelyClick("link=����");
			Thread.sleep(1000);	
			check.verifyHtmlSource("���óɹ�");

	}
	
	@Test
	public void testNavAdd() throws Exception{
		
		/*	����-�Ӻ�*/
			webtest.click("xpath=//a[contains(.,'���')]");
			webtest.click("link=����");
			webtest.click("xpath=.//*[@id='navList']/li[1]/a[1]/i");
		
	}
	@Test
	public void testBlock() throws Exception{
		
		/*	����-���-��ʽ*/
			webtest.click("xpath=//a[contains(.,'���')]");
			webtest.click("link=����");
			webtest.click("xpath=html/body/div/div/div[1]/div/div[1]/div/a/i");
			webtest.click("link=��ʽ");
			check.verifyHtmlSource("�ڱ߾�");
	}
	
	@Test
	public void testBlockContent() throws Exception{
		
		/*	����-���-����-����*/
			webtest.click("xpath=//a[contains(.,'���')]");
			webtest.click("link=����");
			webtest.click("xpath=html/body/div/div/div[1]/div/div[1]/div/a/i");
			webtest.type("id=title", "title");
			webtest.click("id=submit");
			check.verifyHtmlSource("�ڱ߾�");
	}
	@Test
	public void testBlockConback() throws Exception{
		
		/*	����-���-����-����*/
			webtest.click("xpath=//a[contains(.,'���')]");
			webtest.click("link=����");
			webtest.click("xpath=html/body/div/div/div[1]/div/div[1]/div/a/i");
			webtest.type("id=title", "title");
			webtest.click("xpath=//a[contains(.,'����')]");
			check.verifyHtmlSource("���");
	}
	@Test
	public void testBlockList() throws Exception{
		
		/*	����-��ҳ�б�*/
			webtest.click("xpath=//a[contains(.,'���')]");
			webtest.click("link=����");
			webtest.click("link=��ҳ�б�");
			check.verifyHtmlSource("����");
	}
	@Test
	public void testMode() throws Exception{
		
		/*	�༭ģ��*/
			webtest.click("xpath=//a[contains(.,'���')]");
			webtest.click("link=�༭ģ��");
			webtest.click("xpath=//span[contains(.,'��ҳ')]");
			webtest.click("link=��ҳ");
			check.verifyHtmlSource("index.html.php");
	}
	@Test
	public void testModeRe() throws Exception{
		
		/*	�༭ģ��-����ΪĬ��*/
			webtest.click("xpath=//a[contains(.,'���')]");
			webtest.click("link=�༭ģ��");
			webtest.immediatelyClick("link=����ΪĬ��");
			Thread.sleep(1000);
			check.verifyHtmlSource("����ɹ�");
	}
	@Test
	public void testDesk() throws Exception{
		
		/*	���-����*/
		
			webtest.click("xpath=//a[contains(.,'���')]");
			webtest.click("//strong[contains(.,' ����')]");
			driver.findElement(By.xpath("//i[@class='icon icon-tablet']"));
			webtest.click("xpath=//i[@class='icon icon-tablet']");
			
			//check.verifyHtmlSource("����ɹ�");
	}
	@Test
	public void testVIPDel() throws Exception{
		
		/*	��Ա-��̳-ɾ��*/
		
			webtest.click("xpath=//a[contains(.,'��Ա')]");
			webtest.click("link=��̳");
			webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=thread&f=delete&threadID=2']");
			webtest.click("xpath=//button[contains(.,'ȡ��')]");
			check.verifyHtmlSource("����");
	}
	@Test
	public void testVIPHide() throws Exception{
		
		/*	��Ա-��̳-����?????*/
		
			webtest.click("xpath=//a[contains(.,'��Ա')]");
			webtest.click("link=��̳");
			webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=thread&f=switchStatus&threadID=2']");
			check.verifyHtmlSource("������");
			Thread.sleep(1000);
			webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=thread&f=switchStatus&threadID=2']");
		
	}
	@Test
	public void testVIPFind() throws Exception{
		
		/*	��Ա-��̳-����*/
		
			webtest.click("xpath=//a[contains(.,'��Ա')]");
			webtest.click("link=��̳");
			webtest.type("id=searchWord", "ɵ��");
			webtest.click("id=submit");
			check.verifyHtmlSource("ɵ��");
		
	}
	@Test
	public void testVIPBlack() throws Exception{
		
		/*	��Ա-��̳-�Ӻ�*/
		
			webtest.click("xpath=//a[contains(.,'��Ա')]");
			webtest.click("link=��̳");
			webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=guarder&f=addToBlacklist&type=thread&id=2']");
			webtest.immediatelyClick("xpath=//input[@value='����']");
			Thread.sleep(1000);
			check.verifyHtmlSource("���óɹ�");
		
	}

	
	
	
	
	
	

}
