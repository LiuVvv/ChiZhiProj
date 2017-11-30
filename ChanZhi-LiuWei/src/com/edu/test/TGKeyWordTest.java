package com.edu.test;



import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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
		webtest.open(base_Url);
	}
	@Test
	public void Guanjianzi() throws Exception{
		
	/*	����ؼ���*/
		webtest.click("xpath=//a[contains(.,'�ƹ�')]");
		webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=tag&f=admin']");
		check.verifyHtmlSource("����");
	}
	@Test
	public void Sousuo() throws Exception{
	/*	�����������*/
		webtest.click("xpath=//a[contains(.,'�ƹ�')]");
		webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=tag&f=admin']");
		webtest.type("id=tag", "CMS");
		webtest.click("id=submit");
		check.verifyHtmlSource("��ԴCMS");
		}


	@Test
	public void Weiquan() throws Exception{
		/*	����λȨ����*/
	webtest.click("xpath=//a[contains(.,'�ƹ�')]");
	webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=tag&f=admin']");
	webtest.click("xpath=//a[contains(.,'Ȩ��')]");
	check.verifyHtmlSource("��ȫcms");
	}
	@Test
	public void KaiyuanCMS() throws Exception{
		/*	�����ԴCMS����������ϸҳ��*/
	webtest.click("xpath=//a[contains(.,'�ƹ�')]");
	webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=tag&f=admin']");
	webtest.click("xpath=//a[contains(.,'��ԴCMS')]");
	check.verifyHtmlSource("��Դ");
	}
	@Test
	public void Editlink() throws Exception{
		/*  ����༭����*/
	webtest.click("xpath=//a[contains(.,'�ƹ�')]");
	webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=tag&f=admin']");
	webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=tag&f=link&id=9']");
	check.verifyHtmlSource("�༭����");
	}
	
	@Test
	public void Delsubmit() throws Exception{
		/*  ���ɾ�����c m s*/
	webtest.click("xpath=//a[contains(.,'�ƹ�')]");
	webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=tag&f=admin']");
	webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=tag&f=delete&id=10']");
	webtest.click("xpath=//button[contains(.,'ȡ��')]");
	check.verifyHtmlSource("���cms");
	}
	
	@Test
	public void Nextpage() throws Exception{
		/*  �����һҳ�İ�ť*/
	webtest.click("xpath=//a[contains(.,'�ƹ�')]");
	webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=tag&f=admin']");
	webtest.click("xpath=//i[@title='��һҳ']");
	check.verifyHtmlSource("�����ҵ��վ");
	}
	@Test
	public void Breadcrumb() throws Exception{
		/*  ������м����֪
		 * ��Ҫ��16���ؼ���*/
	webtest.click("xpath=//a[contains(.,'�ƹ�')]");
	webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=tag&f=admin']");
	webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=admin&f=index']");
	check.verifyHtmlSource("��ҳ");
	}
	@Test
	public void Propage() throws Exception{
		/*  ÿҳ��ʾ��������javascript*/
	webtest.click("xpath=//a[contains(.,'�ƹ�')]");
	webtest.click("xpath=//a[@href='/chanzhieps/www/admin.php?m=tag&f=admin']");
	webtest.click("id=_recPerPage");

//	JavascriptExecutor j = (JavascriptExecutor) driver;
//	j.executeScript(js);
	webtest.runJs("document.getElementByClass('dropdown dropup').getElementsTagName('ul')[0].removeAttribute('class')");
	webtest.click("linkText=15");
//	driver.FindElement(By.XPath("//a[@href='javascript:submitPage("changeRecPerPage", 5)']"));
	check.verifyHtmlSource("��ҳ");
	}

	
	
}
