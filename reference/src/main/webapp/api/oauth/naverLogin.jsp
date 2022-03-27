<%@page import="com.refer.api.NaverApi"%>
<%@page import="com.refer.api.ApiContants"%>
<%@page import="java.math.BigInteger"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.security.SecureRandom"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
  <head>
    <title>네이버로그인</title>
  </head>
  <body>
  <%
    //session.setAttribute("state", state);
 %>
  <a href="<%=NaverApi.getAuthorizationCodeURL()%>"><img height="50" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a>
  </body>
</html>
