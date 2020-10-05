package com.trung.portlet;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestUtil {
	private static int TIME_OUT = 300 * 1000;
	public static void main(String[] args) throws Exception {
		System.out.println(callRestURL("http://idm.vnu.edu.vn:8083/getDanhMucDonvi", "GET", 0));
	}
	public static String callRestURL(String surl , String postType , int encodeNum)throws Exception {
		HttpURLConnection connection = null ;
		InputStream inStream = null;
		BufferedReader bfReader = null;
		
		try {

			if(connection != null )
			  connection.disconnect();
			  URL url = new URL(surl) ;
			  connection = (HttpURLConnection) url.openConnection();
			  connection.setConnectTimeout(TIME_OUT);
			  connection.setReadTimeout(TIME_OUT);
			  connection.setDoOutput(true);
			  connection.setRequestMethod(postType);
			  connection.setUseCaches(false);
			  connection.setRequestProperty("content-type", "application/json");
			  connection.connect();
				inStream = connection.getInputStream();
				int responseCode = connection.getResponseCode();
				if (responseCode >= 200 && responseCode <= 299) {
					bfReader = new BufferedReader(new InputStreamReader(inStream)); // 读取结果
					StringBuffer sb = new StringBuffer();
					String line;
					while ((line = bfReader.readLine()) != null) {
						if (encodeNum >= 1) line = StringUtil.getURLDecoder(line) ;
						if (encodeNum >= 2) line = StringUtil.getURLDecoder(line) ;
						sb.append(line);
					}
					bfReader.close();
					connection.disconnect();
					
					return sb.toString();
				} else {
					connection.disconnect();
					throw new Exception(responseCode + "-" + connection.getResponseMessage());
				}
			  
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		
		
		return null ;
	}

}
