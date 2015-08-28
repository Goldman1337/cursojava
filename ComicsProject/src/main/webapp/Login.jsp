<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<form name="frmLogin" method="POST" action="LoginServlet">
		<table>
			<tr>
				<td><span>UserName:</span></td>
				<td><input type="text" name="UserName"></td>
			</tr>
			<tr>
				<td><span>Password:</span></td>
				<td><input type="Password" name="Pass"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	<%
		String messages = "";
		if (request.getAttribute("messages") != null) {
			messages = request.getAttribute("messages").toString();
		}
	%>
	<br>
	<span><%=messages%></span>
	<br>
	<br>
	<a href="Index.jsp">Volver</a>
</body>
</html>