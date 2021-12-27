<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form>
		<jsp:useBean id="bean" class="in.co.sunrays.bean.MarksheetBean"
			scope="request"></jsp:useBean>
		<center>

			<input type="hidden" name="id" value=""> <input type="hidden"
				name="createdBy" value=""> <input type="hidden"
				name="modifiedBy" value=""> <input type="hidden"
				name="createdDatetime" value=""> <input type="hidden"
				name="modifiedDatetime" value="">

			<table>
				<tr>
					<th align="left">RoleNo<span style="color: red">*</span></th>
					<td><input type="text" name="" value="">
					<td style="position: fixed;"><font color="red"></font>
					<td>
					<td>
				</tr>

				<tr>
					<th align="left">Name<span style="color: red">*</span></th>
					<td><input type="text" name="" value="">
					<td style="position: fixed;"><font color="red"></font>
					<td>
					<td>
				</tr>

				<tr>
					<th align="left">Physics<span style="color: red">*</span></th>
					<td><input type="text" name="" value="">
					<td style="position: fixed;"><font color="red"></font>
					<td>
					<td>
				</tr>


				<tr>
					<th align="left">Chemistry<span style="color: red">*</span></th>
					<td><input type="text" name="" value="">
					<td style="position: fixed;"><font color="red"></font>
					<td>
					<td>
				</tr>
				<tr>
					<th align="left">Maths<span style="color: red">*</span></th>
					<td><input type="text" name="" value="">
					<td style="position: fixed;"><font color="red"></font>
					<td>
					<td>
				</tr>
				<tr>
				
				<td>
				<input type="submit" name="operation" value="">
				<input type="submit" name="operation" value="">
				</td>
				<td>
				<input type="submit" name="operation" value="">
				<input type="submit" name="operation" value="">
				</td>
				</tr>
				
				
			</table>
		</center>
	</form>

</body>
</html>