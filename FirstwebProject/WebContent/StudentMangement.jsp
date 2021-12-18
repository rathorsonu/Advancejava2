<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Student Management</h2>
<form action="Studentmgtctl" method="get">
Id<input type="text" name="Id" ><br><br>
 RollNO<input type="text" name="RollNo" ><br><br>
 FirstName <input type="text" name="FirstName" ><br><br>
 LastName<input type="text" name="LastName" ><br><br>
 Session<input type="text" name="Session" ><br><br>
 
 <input type="submit" value="Add"   name="opration" >
<input type="submit" value="Delete"  name="opration" >
<input type="submit" value="Modify" name="opration" >
</form>
</body>
</html>