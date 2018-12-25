package com.api.core;
import java.io.IOException;



import org.apache.http.client.CookieStore;

import com.api.utils.ReadPro;

import net.sf.json.JSONObject;



public class Common {

	public static CookieStore getLoginCookie() throws IOException, Exception {

		JSONObject user = new JSONObject();

		user.element("phoneArea", "86");

		user.element("phoneNumber", "20000000000");

		user.element("password", "netease123");

		CookieStore cookie = HttpDriver.doPostgetCookie(ReadPro.getPropValue("BaseUrl") + "/common/fgadmin/login", user);

		return cookie;

	}



}