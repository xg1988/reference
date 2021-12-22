<%@page import="java.io.File"%>
<%@page import="net.sourceforge.tess4j.TesseractException"%>
<%@page import="net.sourceforge.tess4j.Tesseract"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="Selenium" class="com.refer.selenium.Selenium" scope="page"/> 
<%

Tesseract tesseract = new Tesseract();
tesseract.setDatapath("C:\\Users\\MT00542\\git\\reference\\Reference\\resource");
tesseract.setLanguage("kor");

String result = "";
try {
	result = tesseract.doOCR(new File("C:\\Users\\MT00542\\Desktop\\event_cont_02_double_1124_2.jpg"));
} catch (TesseractException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println(result);
%>

<%=result%>