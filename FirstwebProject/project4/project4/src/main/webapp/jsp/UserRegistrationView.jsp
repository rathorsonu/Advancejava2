<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/png"
	href=""/img/logo.png" sizes="16*16" />
</head>
<body>

	<link rel="stylesheet"href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="/resources/demos/style.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	<form action="" method="post">

	
		<script type="text/javascript" src="./js/calendar.js"></script>
		

		<center>
			<h1>User Registration</h1>

			<H2>
				<font color="green"> 
				</font>
			</H2>
			<H2>
				<font color="red"> 
				</font>
			</H2>

			<input type="hidden" name="id" value="">
			 <inputtype="hidden" name="createdBy" value="">
			   <input type="hidden" name="modifiedBy"value=""> 
				<input type="hidden"name="createdDatetime"value="">
			     <input type="hidden" name="modifiedDatetime"value="">


			<table>

				<tr>
					<th align="left">First Name <span style="color: red">*</span></th>
					<td><input type="text" name="firstName"
						placeholder="First name is required" size="25"
						value=""></td>
					<td style="position: fixed"><font color="red"></font></td>
				</tr>
				<tr>
					<th align="left">Last Name <span style="color: red">*</span></th>
					<td><input type="text" name="lastName"
						placeholder="Last name is required" size="25"
						value=""></td>
					<td style="position: fixed"><font color="red"></font></td>
				</tr>
				<tr>
					<th align="left">LoginId <span style="color: red">*</span></th>
					<td><input type="text" name="login"
						placeholder="Must be Email ID" size="25"
						value=""></td>
					<td style="position: fixed"><font color="red"></font></td>
				</tr>
				<tr>
					<th align="left">Password <span style="color: red">*</span></th>
					<td><input type="password" name="password"
						placeholder="Password is required" size="25"
						value=""></td>
					<td style="position: fixed"><font color="red"> </font></td>
				</tr>
				<tr>
					<th align="left">Confirm Password <span style="color: red">*</span></th>
					<td><input type="password" name="confirmPassword"
						placeholder="Confirm Password is required" size="25"
						value=""></td>
					<td style="position: fixed"><font color="red"></font></td>
				</tr>
				<tr>
					<th align="left">Gender <span style="color: red">*</span></th>
					<td>

					<td style="position: fixed"><font color="red"> </font></td>
				</tr>

				<tr>
					<th align="left">Date Of Birth (mm/dd/yyyy) <span
						style="color: red">*</span></th>
					<td><input type="text" name="dob" readonly="readonly"
						id="datepicker" size="25" placeholder="Date of Birth is required"
						value="">
			           </td>
					<td style="position: fixed"><font color="red"></font></td>
				</tr>
				<tr>
					<th></th>
					<td colspan="2">&nbsp; &nbsp; <input type="submit"
						name="operation" value="">
						&nbsp;<input type="submit" name="operation"
						value="">
					</td>
				</tr>
			</table>
	</form>
	</center>
	
</body>

</body>
</html>