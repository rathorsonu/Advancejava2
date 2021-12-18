<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table width="100%" border="0">
		<tr>
			
			<a href="welcome.jsp">Welcome</b></a>
			<td></td>
			<td rowspan="2">
				<h1 align="Right">
					<img src="skd.png" height="150">
				</h1>
			</td>
		</tr>
		<tr>
			<td>
				<%
					String bean = (String) session.getAttribute("user");
					if (bean != null) {
				%> hi,<%=bean%> <a href="logoutview.jsp">logout</b></a> |



			</td>
		</tr>
		<tr>
			<td colspan="2"><a href="GetMarksheet.html">Get Marksheet</b></a> |
				<a href="MarksheetMeritList.html">Marksheet Merit List</b>
			</a> | <a href="MyProfile.html">MyProfile</b></a> | <a
				href="Change password.html">Change Password</b></a> | <a
				href="NotFound.html">Java Doc</b></a> | <a href="Marksheet.html">Add
					Marksheet</b>
			</a> | <a href="MarksheetList.html">Marksheet List</b></a> | <a
				href="NotFound.html">Add User</b></a> | <a href="NotFound.html">User
					List</b>
			</a> | <a href="NotFound.html">Add College</b></a> | <a href="NotFound.html">College
					List</b>
			</a> | <a href="NotFound.html">Add Student</b></a> | <a href="NotFound.html">Student
					List</b>
			</a> | <a href="NotFound.html">Add Role</b></a> | <a href="NotFound.html">Role
					List</b>
			</a> | |</td>
		</tr>
		<%
			} else {
				
		%>
		<a href="loginview.jsp">login</b></a>|
		<%="hi,guest"%>
		<%
			}
		%>


	</table>
	<hr>
</body>

</html>