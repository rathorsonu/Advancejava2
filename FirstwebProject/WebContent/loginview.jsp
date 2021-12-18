<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Headerview.jsp"%>
    <center>
        <form action="LoginCtl" method="post">
            <h1>Login</h1>
            
            <table>
               <H2>
                <font color="red">
                 <tr>
                <% String error=(String)request.getAttribute("error");
                if(error!=null){
                  %>
                  <%=error %>
                  <%} %>
                 
                  </font>
                  </H2>
                 <th>LoginId*</th>
                    <td><input type="text" name="login" size=30><span id="logincheck" style="color: red;"></span>

                    </td>
                </tr>
                <tr>
                    <th>Password*</th>
                    <td><input type="password" name="pwd" size=30><span id="passcheck" style="color: red;"></span>

                    </td>
                </tr>
                <tr>
                    <th></th>
                    <td colspan="2"><input type="submit" value="SignIn" onclick="return validate(this.form)"> &nbsp;

                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <a href="Registration.jsp"><b>Create An Account</b></a> |
                        <a href="ForgetView.jsp"><b>Forget my password</b></a>&nbsp;
                    </td>
                </tr>
            </table>
        </form>
    </center>
    <HR>
    <CENTER>
    <%@ include file="Footerview.jsp"%>
	</body>
</html>