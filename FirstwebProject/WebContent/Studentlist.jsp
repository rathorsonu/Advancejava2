<%@page import="com.raystech.firstproject.Studentbean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Studentbean bean =(Studentbean)request.getAttribute("serch"); 
if(bean!=null){
%>
<%=bean.getId() %>
<%=bean.getRollNo()%>
<%=bean.getFirstName() %>
<%=bean.getLastName() %>
<%=bean.getSession() %>
<%} %>
</body>
</html>