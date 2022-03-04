<%@page import="com.refer.api.NaverApi"%>
<%@page import="java.util.HashMap"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.Map"%>
<%@page import="javax.net.ssl.HttpsURLConnection"%>
<%@page import="javax.net.ssl.SSLSession"%>
<%@page import="javax.net.ssl.HostnameVerifier"%>
<%@page import="java.security.SecureRandom"%>
<%@page import="javax.net.ssl.SSLContext"%>
<%@page import="java.security.cert.X509Certificate"%>
<%@page import="javax.net.ssl.X509TrustManager"%>
<%@page import="javax.net.ssl.TrustManager"%>
<%@page import="com.refer.api.ApiContants"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

  <%
	String code = request.getParameter("code");
    String state = request.getParameter("state");
    JSONObject jsonObj= NaverApi.getNaverAuthCodeObj(code, state);
	
    String outToken = (String)jsonObj.get("access_token");
    jsonObj = NaverApi.getNaverProfileObj(outToken);
    
    out.println(jsonObj.toJSONString());
    response.setContentType("application/json");
  %>
