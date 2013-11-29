package com.http;

import java.io.InputStream;

import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	StringEntity myEntity = new StringEntity("范德萨分", 
    			   ContentType.create("text/plain", "UTF-8"));
    	 		
    			InputStream is = myEntity.getContent();
    			is.close();
    			System.out.println(myEntity.getContentType());
    			System.out.println(myEntity.getContentLength());
    			System.out.println(myEntity.getContent());
    			System.out.println(EntityUtils.toByteArray(myEntity).length);
    }
}
