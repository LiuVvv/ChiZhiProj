package com.edu.test;

import com.webtest.core.WebDriverEngine;

public class Action{
	
	WebDriverEngine webtest=null;
	public Action (WebDriverEngine webtest){
		this.webtest=webtest;
	}
	public void loginPass(String username,String passwd) throws InterruptedException{
	
		webtest.type("name=account", username);
		webtest.type("name=password", passwd);
		webtest.click("id=submit");
		}
}
