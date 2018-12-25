package com.api.test;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.api.core.BaseTest;
import com.api.core.Common;
import com.api.core.HttpDriver;
import com.api.utils.Checker;
import com.api.utils.ReadPro;

import net.sf.json.JSONObject;

public class DeleteTest extends BaseTest{
	Checker check = null;
	public void delete(int id) throws Exception {
		String url=ReadPro.getPropValue("BaseUrl")+ReadPro.getPropValue("delete");
		JSONObject did = new JSONObject();
		did.element("id", id);
		CookieStore cookie = Common.getLoginCookie();
		String content=HttpDriver.doPost(url,did,cookie);
		check = new Checker(content);
	}
	public void delete(String id) throws Exception {
		String url=ReadPro.getPropValue("BaseUrl")+ReadPro.getPropValue("delete");
		JSONObject did = new JSONObject();
		did.element("id", id);
		CookieStore cookie = Common.getLoginCookie();
		String content=HttpDriver.doPost(url,did,cookie);
		check = new Checker(content);
	}
	@Test(priority=0)
	public void addressdel1() throws Exception {
		delete(null);
		check.verifyXpath("message", "may not be null");
	}
	@Test(priority=1)
	public void addressdel2() throws Exception {
		delete("77243286");
		check.verifyXpath("message", "«Î«Û ß∞‹");
	}
	@Test(priority=2)
	public void addressdel3() throws Exception {
		delete(1111);
		check.verifyXpath("message", "«Î«Û ß∞‹");
	}
	@Test(priority=3)
	public void addressdel4() throws Exception {
		delete(82319977);
		check.verifyXpath("message", "success");
	}

}
