package com.api.test;

import org.testng.annotations.Test;

import com.api.mail.Sendmail;
import com.api.utils.ReadPro;

public class sendmail {
	@Test
	public void send() throws Exception {
		Sendmail send = new Sendmail();
		send.sendMail_TuWen(ReadPro.getPropValue("myEmailAccount"), ReadPro.getPropValue("myEmailPassword"),
				            ReadPro.getPropValue("myEmailSMTPHost"), ReadPro.getPropValue("receiveMailAccount"), 
				            ReadPro.getPropValue("mail_title"), ReadPro.getPropValue("mail_text"),
				            ReadPro.getPropValue("mail_picture"), ReadPro.getPropValue("mail_fujian"));
	}

}
