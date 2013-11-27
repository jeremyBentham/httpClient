package com.http;

import org.apache.http.impl.cookie.BasicClientCookie;

public class ClientCookie
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		BasicClientCookie netscapeCookie = new BasicClientCookie("name", "value");
		netscapeCookie.setVersion(0);
		netscapeCookie.setDomain(".mycompany.com");
		netscapeCookie.setPath("/");

	}

}
