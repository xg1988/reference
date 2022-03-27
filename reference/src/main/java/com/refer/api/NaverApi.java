package com.refer.api;

import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.refer.http.HttpCmmn;

public class NaverApi {
	public NaverApi() throws Exception {
		// TODO Auto-generated constructor stub
		//NaverApi.setSSL();
	}
	
	private static String getState() {
		return new BigInteger(130, new SecureRandom()).toString();
	}
	
	public static String getAuthorizationCodeURL() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append(ApiContants.OAUTH_NAVER_URL_GETAUTH);
		sb.append("&client_id=" 	+ ApiContants.OAUTH_NAVER_CLIENTID);
		sb.append("&redirect_uri=" 	+ URLEncoder.encode(ApiContants.OAUTH_NAVER_CALLBACK_APPNM, "UTF-8"));
		sb.append("&state=" 		+ getState());
		return sb.toString();
	}

	public static JSONObject getNaverAuthCodeObj(String code, String state) throws Exception {
		StringBuilder sb = new StringBuilder();
	    sb.append(ApiContants.OAUTH_NAVER_URL_GETTOKEN);
	    sb.append("client_id=" + ApiContants.OAUTH_NAVER_CLIENTID);
	    sb.append("&client_secret=" + ApiContants.OAUTH_NAVER_CLIENTSECRET);
	    sb.append("&redirect_uri=" + URLEncoder.encode(ApiContants.OAUTH_NAVER_CALLBACK_APPNM, "UTF-8"));
	    sb.append("&code="+code);
	    sb.append("&state="+state);
	    return (JSONObject) new JSONParser().parse( new HttpCmmn().getHttpURLConnection(sb.toString()
	    																				, null) );
	}
	
	public static JSONObject getNaverProfileObj(String outToken) throws Exception {
		Map<String, String> requestHeaders = new HashMap<>();
	    requestHeaders.put("Authorization", "Bearer " + outToken);
		return (JSONObject) new JSONParser().parse( new HttpCmmn().getHttpURLConnection(ApiContants.OAUTH_NAVER_URL_GETPROF
																						, requestHeaders));
	}

}
