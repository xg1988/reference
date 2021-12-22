<%@page import="java.io.File"%>
<%@page import="net.sourceforge.tess4j.TesseractException"%>
<%@page import="net.sourceforge.tess4j.Tesseract"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="Selenium" class="com.refer.selenium.Selenium" scope="page"/> 
<%
Selenium.crawl();
%>