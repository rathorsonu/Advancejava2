<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: cyne">
	<%@include file="Headerview.jsp"%>
	<center>
		<h1>Registration Form</h1>
		<form action="RegistrationCtl" method="post">
			<table>
				<tr>
					<font color="Green">
						<h4>
							<%
								String name = (String) request.getAttribute("Success");
								if (name != null) {
							%>
							<%=name%>
							<%
								}
							%>


						</h4>
					</font>

					<td>Name<input type="text" name="name"> <font
						color="red"> <%
 	String error = (String) request.getAttribute("error1");
 	if (error != null) {
 %> <%=error%> <%
 	}
 %> <%
 	String error2 = (String) request.getAttribute("error2");
 	if (error2 != null) {
 %> <%=error2%> <%
 	}
 %>
					</font>
					</td>
				</tr>

				<tr>
					<td>Surname<input type="text" name="surname"><font
						color="red"> <%
 	String error3 = (String) request.getAttribute("error3");
 	if (error3 != null) {
 %> <%=error3%> <%
 	}
 %> <%
 	String error4 = (String) request.getAttribute("error4");
 	if (error4 != null) {
 %> <%=error4%> <%
 	}
 %>

					</font></td>

				</tr>
				<tr>
					<td>Gender<input type="radio" name="gender" value="male">Male
						<input type="radio" name="gender" value="female">Female <%
						String error5 = (String) request.getAttribute("error5");
						if (error5 != null) {
					%> <%=error5%> <%
 	}
 %>

					</td>
				</tr>
				<tr>
					<td>Date of birth <input type="date" name="dob"> <font
						color="red">
							<h4>
								<%
									String error6 = (String) request.getAttribute("error6");
									if (error6 != null) {
								%>
								<%=error6%>
								<%
									}
								%>
							</h4>
					</font>
					</td>
				</tr>
				<tr>
					<td>Moblie NO <input type="text" name="moblie"> <font
						color="red"> <%
 	String error7 = (String) request.getAttribute("error7");
 	if (error7 != null) {
 %> <%=error7%> <%
 	}
 %> <%
 	String error8 = (String) request.getAttribute("error8");
 	if (error8 != null) {
 %> <%=error8%> <%
 	}
 %>

					</font>
					</td>
				</tr>
				<tr>
					<td>Email<input type="email" name="email"> <font
						color="red"> <%
 	String error9 = (String) request.getAttribute("error9");
 	if (error9 != null) {
 %> <%=error9%> <%
 	}
 %> <%
 	String error10 = (String) request.getAttribute("error10");
 	if (error10 != null) {
 %> <%=error10%> <%
 	}
 %>

					</font>
					</td>
				</tr>
				<tr>


					<td>password<input type="password" name="pwd"> <font
						color="red"> <%
 	String error11 = (String) request.getAttribute("error11");
 	if (error11 != null) {
 %> <%=error11%> <%
 	}
 %> <%
 	String error12 = (String) request.getAttribute("error12");
 	if (error12 != null) {
 %> <%=error12%> <%
 	}
 %>

					</font>
					</td>
				</tr>
				<tr>
					<td><input type="submit" name="login"></td>
				</tr>
			</table>
	</center>

	</form>
	<%@ include file="Footerview.jsp"%>
</body>
</html>