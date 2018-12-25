package com.api.test;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.api.core.BaseTest;
import com.api.core.Common;
import com.api.core.HttpDriver;
import com.api.utils.Checker;
import com.api.utils.ReadPro;

import net.sf.json.JSONObject;

public class SubmitTest extends BaseTest{
	Checker check = null;
	public void submit(String skuIds,String skuNumbers,String stockIds ,String receiverName ,String cellPhone ,String addressDetail ,String province ,String city ,String area ) throws Exception {
		String url=ReadPro.getPropValue("BaseUrl")+ReadPro.getPropValue("submit");
		CookieStore cookie = Common.getLoginCookie();
		JSONObject su = new JSONObject();
		su.element("skuIds", skuIds);
		su.element("skuNumbers",skuNumbers);
		su.element("stockIds", stockIds);
		su.element("receiverName", receiverName);
		su.element("cellPhone",cellPhone);
		su.element("addressDetail", addressDetail);
		su.element("province", province);
		su.element("city",city);
		su.element("area", area);
		String content=HttpDriver.doPost(url,su,cookie);
		System.out.println(content);
		check = new Checker(content);
	}
	public void submit(int skuIds,String skuNumbers,String stockIds,String receiverName ,String cellPhone ,String addressDetail ,String province ,String city ,String area) throws Exception {
		String url=ReadPro.getPropValue("BaseUrl")+ReadPro.getPropValue("submit");
		CookieStore cookie = Common.getLoginCookie();
		JSONObject su = new JSONObject();
		su.element("skuIds", skuIds);
		su.element("skuNumbers",skuNumbers);
		su.element("stockIds", stockIds);
		su.element("receiverName", receiverName);
		su.element("cellPhone",cellPhone);
		su.element("addressDetail", addressDetail);
		su.element("province", province);
		su.element("city",city);
		su.element("area", area);
		String content=HttpDriver.doPost(url,su,cookie);
		System.out.println(content);
		check = new Checker(content);
	}
	public void submit(String skuIds,int skuNumbers,String stockIds,String receiverName ,String cellPhone ,String addressDetail ,String province ,String city ,String area ) throws Exception {
		String url=ReadPro.getPropValue("BaseUrl")+ReadPro.getPropValue("submit");
		CookieStore cookie = Common.getLoginCookie();
		JSONObject su = new JSONObject();
		su.element("skuIds", skuIds);
		su.element("skuNumbers",skuNumbers);
		su.element("stockIds", stockIds);
		su.element("receiverName", receiverName);
		su.element("cellPhone",cellPhone);
		su.element("addressDetail", addressDetail);
		su.element("province", province);
		su.element("city",city);
		su.element("area", area);
		String content=HttpDriver.doPost(url,su,cookie);
		System.out.println(content);
		check = new Checker(content);
	}
	public void submit(String skuIds,String skuNumbers,int stockIds,String receiverName ,String cellPhone ,String addressDetail ,String province ,String city ,String area ) throws Exception {
		String url=ReadPro.getPropValue("BaseUrl")+ReadPro.getPropValue("submit");
		CookieStore cookie = Common.getLoginCookie();
		JSONObject su = new JSONObject();
		su.element("skuIds", skuIds);
		su.element("skuNumbers",skuNumbers);
		su.element("stockIds", stockIds);
		su.element("receiverName", receiverName);
		su.element("cellPhone",cellPhone);
		su.element("addressDetail", addressDetail);
		su.element("province", province);
		su.element("city",city);
		su.element("area", area);
		String content=HttpDriver.doPost(url,su,cookie);
		System.out.println(content);
		check = new Checker(content);
	}
	@Test(priority=0)
	public void submit1() throws Exception {
		submit("2","1","74966312","","","","","","");
		check.verifyXpath("message", "success");
	}
	@Test(priority=1)
	public void submit2() throws Exception {
		submit(2,"1","74966312","","","","","","");
		check.verifyXpath("message", "«Î«Û ß∞‹");
	}
	@Test(priority=2)
	public void submit3() throws Exception {
		submit(null,"1","74966312","","","","","","");
		check.verifyXpath("message", "«Î«Û ß∞‹");
	}
	@Test(priority=3)
	public void submit4() throws Exception {
		submit("2","100000","74966312","","","","","","");
		check.verifyXpath("message", "œﬁπ∫100Ã®");
	}
	@Test(priority=4)
	public void submit5() throws Exception {
		submit("2",null,"74966312","","","","","","");
		check.verifyXpath("message", "«Î«Û ß∞‹");
	}
	@Test(priority=5)
	public void submit6() throws Exception {
		submit("2",1,"74966312","","","","","","");
		check.verifyXpath("message", "«Î«Û ß∞‹");
	}
	@Test(priority=6)
	public void submit7() throws Exception {
		submit("2","1",74966312,"","","","","","");
		check.verifyXpath("message", "«Î«Û ß∞‹");
	}
	@Test(priority=7)
	public void submit8() throws Exception {
		submit("2","1",null,"","","","","","");
		check.verifyXpath("message", "«Î«Û ß∞‹");
	}

}
