<%@page import="com.refer.service.BBSService"%>
<%@page import="com.refer.jdbc.CommonDao"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- <jsp:useBean id="DBHelper" class="crud.db.DBHelper" scope="page"/> --%>   
<jsp:useBean id="CommonDao" class="com.refer.service.BBSService" scope="page"/> 
<%

		List<Map<String,Object>> list = BBSService.selectRecord();
		for(int i = 0; i< list.size(); i++){
%>
		<%=list.get(i).toString() %><br/>
<%			
		}
%>