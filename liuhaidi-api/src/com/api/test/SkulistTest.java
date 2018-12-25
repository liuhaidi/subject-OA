package com.api.test;

import org.testng.annotations.Test;

import com.api.core.BaseTest;
import com.api.core.HttpDriver;
import com.api.utils.Checker;
import com.api.utils.ReadPro;

public class SkulistTest extends BaseTest{
	Checker check= null;
	public void sku(int goodsId) throws Exception {
		String url = ReadPro.getPropValue("BaseUrl")+ReadPro.getPropValue("sku");
		String para = "goodsId="+ goodsId;
		String content = HttpDriver.doGet(url, para);
		System.out.println(content);
		check = new Checker(content);
	}
	public void sku(String goodsId) throws Exception {
		String url = ReadPro.getPropValue("BaseUrl")+ReadPro.getPropValue("sku");
		String para = "goodsId="+ goodsId;
		String content = HttpDriver.doGet(url, para);
		System.out.println(content);
		check = new Checker(content);
	}
	@Test(priority=0)
	public void skulist1() throws Exception{
		sku(null);
		check.verifyXpath("code", "200");
		
	}
	@Test(priority=1)
	public void skulist2() throws Exception{
		sku(1);
		check.verifyXpath("code", "200");
		
	}
//	@Test(priority=2)
//	public void skulist3() throws Exception{
//		sku(2147483648);
//		check.verifyXpath("code", "400");
//		
//	}
	@Test(priority=2)
	public void skulist4() throws Exception{
		sku(9999);
		check.verifyXpath("code", "201");
		
	}
	@Test(priority=3)
	public void skulist5() throws Exception{
		sku("1");
		check.verifyXpath("code", "400");
		
	}
//	@Test(priority=5)
//	public void skulist6() throws Exception{
//		sku(abc1);
//		check.verifyXpath("code", "400");
//		
//	}
}
