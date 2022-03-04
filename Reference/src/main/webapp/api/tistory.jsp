<%@page import="com.refer.api.TistoryBlog"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="CommonDao" class="com.refer.api.TistoryBlog" scope="page"/>     
<%	
	String cmd = request.getParameter("cmd");
	String resultString = "";
	
	if("blog_info".equals(cmd)){
		resultString = CommonDao.getBlogInfo();
	}else if("post_list".equals(cmd)){
		String blogName = request.getParameter("blogName");
		String pageNumber = request.getParameter("pageNumber");
		resultString =  CommonDao.getPostList(blogName, pageNumber);
	}
%>
<%=resultString%>