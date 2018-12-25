package com.api.test;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.api.core.BaseTest;
import com.api.core.Common;
import com.api.core.HttpDriver;
import com.api.utils.Checker;
import com.api.utils.ReadPro;

import net.sf.json.JSONObject;

public class NewaddressTest extends BaseTest{
	Checker check = null;
	public void newAddress(String receiverName,String cellPhone,String addressDetail,String province,String city,String area) throws Exception {
		String url=ReadPro.getPropValue("BaseUrl")+ReadPro.getPropValue("newaddress");
		CookieStore cookie = Common.getLoginCookie(); 
		JSONObject nadd = new JSONObject();
		nadd.element("receiverName", receiverName);
		nadd.element("cellPhone",cellPhone);
		nadd.element("addressDetail", addressDetail);
		nadd.element("province", province);
		nadd.element("city",city);
		nadd.element("area", area);
		String content=HttpDriver.doPost(url,nadd,cookie);
		check = new Checker(content);
		
	}
	public void newAddress(int id,String receiverName,String cellPhone,String addressDetail,String province,String city,String area) throws Exception {
		String url=ReadPro.getPropValue("BaseUrl")+ReadPro.getPropValue("newaddress");
		CookieStore cookie = Common.getLoginCookie(); 
		JSONObject nadd = new JSONObject();
		nadd.element("receiverName", receiverName);
		nadd.element("cellPhone",cellPhone);
		nadd.element("addressDetail", addressDetail);
		nadd.element("province", province);
		nadd.element("city",city);
		nadd.element("area", area);
		String content=HttpDriver.doPost(url,nadd,cookie);
		check = new Checker(content);
		
	}
	@Test(priority=0)
	public void new1() throws Exception {
		newAddress("张三","12345678901","浙江大学","浙江省","杭州市","滨江区");
		check.verifyXpath("message", "success");
	}
	@Test(priority=1)
	public void new2() throws Exception {
		newAddress(123,"张三","12345678901","浙江大学","浙江省","杭州市","滨江区");
		check.verifyXpath("code", "400");
	}
	@Test(priority=2)
	public void new3() throws Exception {
		newAddress(null,"12345678901","浙江大学","浙江省","杭州市","滨江区");
		check.verifyXpath("message", "may not be null");
	}
	@Test(priority=3)
	public void new4() throws Exception {
		newAddress("张三",null,"浙江大学","浙江省","杭州市","滨江区");
		check.verifyXpath("message", "may not be null");
	}
	@Test(priority=4)
	public void new5() throws Exception {
		newAddress("张三","12345678901",null,"浙江省","杭州市","滨江区");
		check.verifyXpath("message", "may not be null");
	}
	@Test(priority=5)
	public void new6() throws Exception {
		newAddress("张三","12345678901","浙江大学",null,"杭州市","滨江区");
		check.verifyXpath("message", "may not be null");
	}
	@Test(priority=6)
	public void new7() throws Exception {
		newAddress("张三","12345678901","浙江大学","浙江省",null,"滨江区");
		check.verifyXpath("message", "may not be null");
	}
	@Test(priority=7)
	public void new8() throws Exception {
		newAddress("张三","12345678901","浙江大学","浙江省","杭州市",null);
		check.verifyXpath("message", "may not be null");
	}

}
