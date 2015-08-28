<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.comics.app.Model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<br>
	<a href="ComicServlet?action=listComic">Lista de Comics</a>
	<br>
	<a href="PersonServlet?action=listPerson">Lista de Personas</a>
	<br>
	<a href="LoanServlet?action=listLoan">Lista de Prestamos</a>
	<br>
	<%
		Usuario UsLog = (Usuario) session.getAttribute("UsuarioLog");
		if (UsLog != null && UsLog.getRole().getNameRole().equals("ADMIN")) {
	%>
	<a href="RoleServlet?action=listRole">Lista de Roles</a>
	<br>
	<br>
	<%
		}
		if (UsLog != null && UsLog.getRole().getNameRole().equals("ADMIN")) {
	%>
	<br>
	<a href="UsuarioServlet?action=listUsuario">Lista de Usuarios</a>
	<%
		}
	%>
	<br>
	<br>
	<br>
	<%
		if (UsLog == null) {
	%>
	<a href="Login.jsp">log in</a>
	<%
		} else {
	%>
	<a href="LoginServlet?action=salir">salir</a>
	<%
		}
	%>
</body>
</html>