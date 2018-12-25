package com.api.test;

import org.testng.annotations.Test;

import com.api.core.BaseTest;
import com.api.core.HttpDriver;
import com.api.utils.Checker;
import com.api.utils.ReadPro;

import net.sf.json.JSONObject;

public class LoginTest extends BaseTest{
	Checker check=null;
	public void login(String phoneArea,String phoneNumber,String password) throws Exception {
		String url = ReadPro.getPropValue("BaseUrl")+ReadPro.getPropValue("login");
		JSONObject json = new JSONObject();
		json.element("phoneArea", phoneArea);
		json.element("phoneNumber", phoneNumber);
		json.element("password", password);
		String content = HttpDriver.doPost(url, json);
		System.out.println(content);
		check = new Checker(content);
	}
	public void login(int phoneArea,String phoneNumber,String password) throws Exception {
		String url = ReadPro.getPropValue("BaseUrl")+ReadPro.getPropValue("login");
		JSONObject json = new JSONObject();
		json.element("phoneArea", phoneArea);
		json.element("phoneNumber", phoneNumber);
		json.element("password", password);
		String content = HttpDriver.doPost(url, json);
		System.out.println(content);
		check = new Checker(content);
	}
	public void login(String phoneArea,int phoneNumber,String password) throws Exception {
		String url = ReadPro.getPropValue("BaseUrl")+ReadPro.getPropValue("login");
		JSONObject json = new JSONObject();
		json.element("phoneArea", phoneArea);
		json.element("phoneNumber", phoneNumber);
		json.element("password", password);
		String content = HttpDriver.doPost(url, json);
		System.out.println(content);
		check = new Checker(content);
	}
	public void login(String phoneArea,String phoneNumber,int password) throws Exception {
		String url = ReadPro.getPropValue("BaseUrl")+ReadPro.getPropValue("login");
		JSONObject json = new JSONObject();
		json.element("phoneArea", phoneArea);
		json.element("phoneNumber", phoneNumber);
		json.element("password", password);
		String content = HttpDriver.doPost(url, json);
		System.out.println(content);
		check = new Checker(content);
	}
	@Test(priority=0)
	public void login1() throws Exception {
		login("86","20000000000","netease123");
		check.verifyXpath("code", "200");
	}
	@Test(priority=1)
	public void login2() throws Exception {
		login(86,"20000000000","netease123");
		check.verifyXpath("code", "400");
	}
	@Test(priority=2)
	public void login3() throws Exception {
		login("abc","20000000000","netease123");
		check.verifyXpath("code", "400");
	}
	@Test(priority=3)
	public void login4() throws Exception {
		login(null,"20000000000","netease123");
		check.verifyXpath("code", "400");
	}
	@Test(priority=4)
	public void login5() throws Exception {
		login("86",123456,"netease123");
		check.verifyXpath("code", "400");
	}
	@Test(priority=5)
	public void login6() throws Exception {
		login("86",null,"netease123");
		check.verifyXpath("code", "400");
	}
	@Test(priority=6)
	public void login7() throws Exception {
		login("86","12345678901234","netease123");
		check.verifyXpath("code", "400");
	}
	@Test(priority=7)
	public void login8() throws Exception {
		login("86","20000000000",123);
		check.verifyXpath("code", "400");
	}
	@Test(priority=8)
	public void login9() throws Exception {
		login("86","20000000000",null);
		check.verifyXpath("code", "400");
	}

}
