package com.edu.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class FrontEndmyMovie extends BaseTest{

	@Test
	public void testFrontLogin(){
		webtest.open("http://localhost:8032/MyMovie");
		webtest.click("link=µÇÂ¼");
		webtest.type("name=username", "tom01");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//input[@value='ÂíÉÏµÇÂ¼']");
		webtest.tabClick();
		//assertTrue(webtest, );
		
	}
}
