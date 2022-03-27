<%@page import="com.refer.api.TistoryBlog"%>
<%@page import="com.refer.service.BBSService"%>
<%@page import="com.refer.jdbc.CommonDao"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- <jsp:useBean id="DBHelper" class="crud.db.DBHelper" scope="page"/> --%>   
<jsp:useBean id="CommonDao" class="com.refer.api.TistoryBlog" scope="page"/> 
<p>
	테스트1: 	<%=CommonDao.getBlogInfo(TistoryBlog.ACCESS_TOKEN)%>
</p>
<br/>
<br/>
<br/>
<br/>
<p>
<%-- 테스트2: 	<%=CommonDao.getPostList("itstupid", "1")%> --%>
</p>