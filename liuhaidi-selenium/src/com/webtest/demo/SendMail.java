 package com.webtest.demo;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.utils.ReadPro;
import com.webtest.mail.Sendmail;


public class SendMail {
	@Test
	public void send() throws IOException, Exception {
		Sendmail send = new Sendmail();
		send.sendMail_TuWen(ReadPro.getPropertyValue("myEmailAccount"), ReadPro.getPropertyValue("myEmailPassword"),
	                        ReadPro.getPropertyValue("myEmailSMTPHost"), ReadPro.getPropertyValue("receiveMailAccount"), 
	                        ReadPro.getPropertyValue("mail_title"), ReadPro.getPropertyValue("mail_text"),
	                        ReadPro.getPropertyValue("mail_picture"), ReadPro.getPropertyValue("mail_fujian"));
	}

}
