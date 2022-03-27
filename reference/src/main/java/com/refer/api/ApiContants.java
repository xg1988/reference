package com.refer.api;

public class ApiContants {
	public static final String OAUTH_NAVER_URL_GETAUTH = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
	public static final String OAUTH_NAVER_URL_GETTOKEN = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
	public static final String OAUTH_NAVER_URL_GETPROF = "https://openapi.naver.com/v1/nid/me";
	
	public static final String OAUTH_NAVER_CLIENTID = "ofu6EbSCCL_tyqi3UXNk";
	public static final String OAUTH_NAVER_CLIENTSECRET = "LlAw4_20D2";
	public static final String OAUTH_NAVER_CALLBACK_APPNM = "http://localhost:8080/Reference/api/oauth/naverLoginCallback.jsp";
}
