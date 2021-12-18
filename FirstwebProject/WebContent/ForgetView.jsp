<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<form action="ForgetCtl" method="post">
<%@include file="Headerview.jsp"%>
<table>
<tr>
<th> Email Id</th>
<td> <input type="email" name="email" required></input>
</td>
</tr>
<tr>

<td> <input type="submit" value="send">
<input type="reset" value="cancel">
</td>
</tr>

</form>
</center>

</table>
<%@ include file="Footerview.jsp"%>
</body>
</html>