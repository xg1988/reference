package com.refer.tistory;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.refer.http.HttpCmmn;

public class TistoryBlog {
	static final Logger logger = Logger.getLogger(TistoryBlog.class.getName());
	
	private static String ACCESS_TOKEN = "785112b5245fd942f58ff21317dff666_1c2b8fd64e88dd09c2e7a9f435b0eee1";
	private static String DOMAIN = "https://www.tistory.com";
	private static String INFO = "/apis/blog/info"; 
	private static String LIST = "/apis/post/list";
	
	public static void main(String[] args){
		try {
			TistoryBlog.setSSL();
			
			TistoryBlog.getBlogInfo(ACCESS_TOKEN);
			
			TistoryBlog.getPostList("itstupid", "1");
		}catch(Exception e) {
			logger.log(Level.INFO,"e: "+e);
			e.printStackTrace();
		}
	}

	public static void setSSL() throws NoSuchAlgorithmException, KeyManagementException {
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		} };
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new SecureRandom());
		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
			@Override
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		});
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	}
	
	public static String getBlogInfo(String token) throws Exception {
		String rtnStr = "";
		
		String url = DOMAIN + INFO;
		
		HashMap<String, Object> inputMap = new HashMap<String, Object>();
		inputMap.put("access_token", token);
		inputMap.put("output", "json");

		HttpCmmn http = new HttpCmmn();
		//System.out.println(http.sendGet(url, inputMap));
		logger.log(Level.INFO, "result: "+http.sendGet(url, inputMap));
		return rtnStr;
	}
	
	public static String getPostList(String blogName, String pageNumber) throws Exception {
		String rtnStr = "";
		
		String url = DOMAIN + LIST;
		
		HashMap<String, Object> inputMap = new HashMap<String, Object>();
		inputMap.put("access_token", ACCESS_TOKEN);
		inputMap.put("output", "json");
		inputMap.put("blogName", blogName);
		inputMap.put("page", pageNumber);
		
		HttpCmmn http = new HttpCmmn();
		//System.out.println("result: "+http.sendGet(url, inputMap));
		rtnStr = http.sendGet(url, inputMap);
		logger.log(Level.INFO, "result: "+rtnStr);
		logger.log(Level.INFO, "TEST END");
		return rtnStr;
	}
	
}
