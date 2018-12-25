package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import java.io.File;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebDriverEngine;
import com.webtest.core.WebTestListener;
import com.webtest.dataprovider.NSDataProvider;
import com.webtest.utils.ReadPro;


public class Login_Action extends BaseTest{
	WebDriverEngine webtest = null;
	public Login_Action(WebDriverEngine webtest) {
		this.webtest = webtest;
	}
	
	public void login(String username,String password) throws IOException {
		webtest.open(ReadPro.getPropertyValue("base_url"));
		webtest.type("id=vipname", username);
		webtest.type("id=vippassword", password);
		webtest.click("link=µÇÂ¼");
//		webtest.wait(5000);
	}

}
