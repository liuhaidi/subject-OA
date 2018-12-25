package com.api.test;

import java.net.URLEncoder;

import org.testng.annotations.Test;

import com.api.core.BaseTest;
import com.api.utils.Checker;
import com.api.utils.ReadPro;

import net.sf.json.JSONObject;

import com.api.core.HttpDriver;

public class GetJsonDemo1 extends BaseTest{
	Checker check=null;
	public void sku(int goodsId) throws Exception {
		String url = ReadPro.getPropValue("BaseUrl")+ReadPro.getPropValue("sku");
		String para = "goodsId="+ goodsId;
		String content = HttpDriver.doGet(url, para);
		System.out.println(content);
		check = new Checker(content);
		
	}
	@Test
	public void skuSuccess() throws Exception {
		sku(1);
		
		check.verifyXpath("code", "200");
	}
	@Test
	public void skuFail() throws Exception {
        sku(1000);
		
		check.verifyXpath("code", "200");
	}

}
