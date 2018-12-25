package com.api.test;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.api.core.BaseTest;
import com.api.core.Common;
import com.api.core.HttpDriver;
import com.api.utils.Checker;
import com.api.utils.ReadPro;

import net.sf.json.JSONObject;

public class AddressTest extends BaseTest{
	Checker check = null;
	public void address() throws Exception {
		String url=ReadPro.getPropValue("BaseUrl")+ReadPro.getPropValue("address");
		CookieStore cookie = Common.getLoginCookie();
		String content=HttpDriver.doGet(url,cookie);
		System.out.println(content);
		check = new Checker(content);
	}
	@Test
	public void getAddress() throws Exception {
		address();
		check.verifyXpath("message", "success");
	}

}
