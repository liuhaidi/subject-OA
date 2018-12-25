package com.api.test;

import org.testng.annotations.Test;

import com.api.core.BaseTest;
import com.api.core.HttpDriver;
import com.api.utils.Checker;
import com.api.utils.ReadPro;


public class GetfeeTest extends BaseTest{
	Checker check = null;
	public void getFee(int id,String addressDetail) throws Exception {
		String url = ReadPro.getPropValue("BaseUrl")+ReadPro.getPropValue("fee");
		String ad = "id="+id+"&addressDetail="+addressDetail;
		String content=HttpDriver.doGet(url, ad);
		System.out.println(content);
		check = new Checker(content);
	
	}
	public void getFee(String id,String addressDetail) throws Exception {
		String url = ReadPro.getPropValue("BaseUrl")+ReadPro.getPropValue("fee");
		String ad = "id="+id+"&addressDetail="+addressDetail;
		String content=HttpDriver.doGet(url, ad);
		check = new Checker(content);
	
	}
	@Test(priority=0)
	public void getfee1() throws Exception {
		getFee("1","�㽭ʡ_������_������");
		check.verifyXpath("code", "400");
		
	}
	@Test(priority=1)
	public void getfee2() throws Exception {
		getFee(2,"�㽭ʡ_������_������");
		check.verifyXpath("code", "200");
		
	}
	@Test(priority=2)
	public void getfee3() throws Exception {
		getFee(3,"�㽭ʡ_������_ԣ����");
		check.verifyXpath("code", "400");
		
	}
	@Test(priority=3)
	public void getfee4() throws Exception {
		getFee(4,null);
		check.verifyXpath("code", "401");
		
	}
	

}
