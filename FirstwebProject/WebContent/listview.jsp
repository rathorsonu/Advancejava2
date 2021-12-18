<%@page import="com.raystech.firstproject.Studentbean"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form >
<% Studentbean fn=(Studentbean)request.getAttribute("list");
if(fn!=null){
%>
<%=fn.getId() %>
<%=fn.getFirstName() %>
<%=fn.getLastName() %>
<%=fn.getSession() %>
<%} %>
</form>
</body>
</html>