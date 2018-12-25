package com.api.core;


import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.api.mail.Sendmail;
import com.api.utils.Log;
import com.api.utils.ReadPro;



public class ApiListener extends TestListenerAdapter{
	@Override
	public void onTestFailure(ITestResult tr) {
		Log.error(tr.getInstance()+tr.getName()+"‘À–– ß∞‹");
	}
	@Override
	public void onFinish(ITestContext testContext) {
		Sendmail send = new Sendmail();
		try {
			send.sendMail_TuWen(ReadPro.getPropValue("myEmailAccount"), ReadPro.getPropValue("myEmailPassword"),
					            ReadPro.getPropValue("myEmailSMTPHost"), ReadPro.getPropValue("receiveMailAccount"), 
					            ReadPro.getPropValue("mail_title"), ReadPro.getPropValue("mail_text"),
					            ReadPro.getPropValue("mail_picture"), ReadPro.getPropValue("mail_fujian"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


