package com.http;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;


public class FluentQuickStart {
	
	public static void main(String[] args)  {
		try {
			Request.Get("http://localhost:8081/cring/jsp/user/index.jsp")
			.execute().returnContent();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=0;
		while(true)
		{
		try {
			Request.Post("http://23.80.192.206/16/%23login45.asp")
			.bodyForm(Form.form().add("QQNumber",  "stupid").add("mima",  "gohell").build())
			.execute().returnContent();
			
			System.out.println("---"+i++);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
