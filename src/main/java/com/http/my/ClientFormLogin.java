/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */
package com.http.my;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * A example that demonstrates how HttpClient APIs can be used to perform
 * form-based logon.
 */
public class ClientFormLogin {

    public static void main(String[] args) throws Exception {
    	
    	 ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

             public String handleResponse(
                     final HttpResponse response) throws ClientProtocolException, IOException {
                 int status = response.getStatusLine().getStatusCode();
                 System.out.println(response.getStatusLine());
                 if (status >= 200 && status < 303) {
                     HttpEntity entity = response.getEntity();
                     
                     return entity != null ? EntityUtils.toString(entity) : null;
                 } else {
                     throw new ClientProtocolException("Unexpected response status: " + status);
                 }
             }

         };
    	
    	
    	    
    	
        BasicCookieStore cookieStore = new BasicCookieStore();
//        
//        BasicClientCookie cookieJSESSIONID = new BasicClientCookie("JSESSIONID", "3FD927DC6911B719E4492E7473897FBA");
//        cookieJSESSIONID.setVersion(0);
//        cookieJSESSIONID.setDomain("218.75.79.230");
//        cookieJSESSIONID.setPath("/");
//        System.out.println("Initial set of cookies:");
//        cookieStore.addCookie(cookieJSESSIONID);
        
        
        
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
       // HttpProtocolParams.setUserAgent(httpclient.getParams(), "Mozilla/5.0 (Windows; U; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 2.0.50727)");

        
        try {
         
           // HttpPost httpost = new HttpPost("http://localhost:8081/cring/jsp/user/userLogin.do?method=login");
            HttpPost loginpost = new HttpPost("http://134.96.41.47/ecommunications_chs/start.swe");
            //HttpGet loginGet = new HttpGet("http://134.96.41.47/ecommunications_chs/start.swe");
           // HttpGet loginGet = new HttpGet("http://www.baidu.com");
            List <NameValuePair> nvps = new ArrayList <NameValuePair>();
            nvps.add(new BasicNameValuePair("SWEUserName","nili"));
            nvps.add(new BasicNameValuePair("SWEPassword","nili7788"));
            nvps.add(new BasicNameValuePair("SWEFo","SWEEntryForm"));
            nvps.add(new BasicNameValuePair("SWENeedContext","false"));
            nvps.add(new BasicNameValuePair("SWECmd","ExecuteLogin"));
            nvps.add(new BasicNameValuePair("W","t"));
            nvps.add(new BasicNameValuePair("SWEC","0"));
            nvps.add(new BasicNameValuePair("SWEBID","-1"));
            nvps.add(new BasicNameValuePair("SWETS","1385712482625"));
            
            /**
             *  SWEUserName:111111
				SWEPassword:222222
				SWEFo:SWEEntryForm
				SWENeedContext:false
				SWECmd:ExecuteLogin
				W:t
				SWESPNR:
				SWESPNH:
				SWEH:
				SWEC:0
				SWEW:
				SWEBID:-1
				SWETS:1385712482625
				SWEWN:
             */
            loginpost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
//            CloseableHttpResponse response =  httpclient.execute(loginpost);
           // HttpEntity httpEntity =  response.getEntity();
            CloseableHttpResponse responseGet =  httpclient.execute(loginpost);
            HttpEntity httpEntityGet =  responseGet.getEntity();
            System.out.println("statusLine: "+responseGet.getStatusLine());
            System.out.println("ContentType: "+httpEntityGet.getContentType());
            System.out.println("ContentLength: "+httpEntityGet.getContentLength());
          
          //  httpEntityGet.get
            System.out.println("loginGet: "+EntityUtils.toString(httpEntityGet));
           /* try {

                System.out.println("Post logon cookies:");
                List<Cookie> cookies = cookieStore.getCookies();
                if (cookies.isEmpty()) {
                    System.out.println("None");
                } else {
                    for (int i = 0; i < cookies.size(); i++) {
                        System.out.println("- " + cookies.get(i).toString());
                    }
                }
                
                
                
                HttpPost modifypost = new HttpPost("http://localhost:8081/cring/jsp/user/corpUserController.do?method=modifyPwd");
                List <NameValuePair> modifynvps = new ArrayList <NameValuePair>();
                modifynvps.add(new BasicNameValuePair("newPwd","111111"));
                modifypost.setEntity(new UrlEncodedFormEntity(modifynvps, Consts.UTF_8));
               
                CloseableHttpResponse modifyresponse = httpclient.execute(modifypost);
               System.out.println("modifyresponse : "+modifyresponse.getStatusLine()); 
                
                
                
            } finally {
                //response2.close();
            }*/
        } finally {
            httpclient.close();
        }
    }
}