<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.comics.app.Model.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="js/bootstrap.min.js"></script>
<title>Usuarios</title>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="Index.jsp">ComicsProject</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="ComicServlet?action=listComic">Lista de
							Comics</a></li>
					<li><a href="PersonServlet?action=listPerson">Lista de
							Personas</a></li>
					<li><a href="LoanServlet?action=listLoan">Lista de
							Prestamos</a></li>
					<%
						Usuario UsLog = (Usuario) session.getAttribute("UsuarioLog");
						if (UsLog != null && UsLog.getRole().getNameRole().equals("ADMIN")) {
					%>
					<li><a href="RoleServlet?action=listRole">Lista de Roles</a></li>
					<%
						}
						if (UsLog != null && UsLog.getRole().getNameRole().equals("ADMIN")) {
					%>
					<li><a href="UsuarioServlet?action=listUsuario">Lista de
							Usuarios</a></li>
					<li></li>
					<li></li>
					<%
						}
						if (UsLog == null) {
					%>
					<li><a href="Login.jsp">Log In</a></li>
					<%
						} else {
					%>
					<li><a href="LoginServlet?action=salir">Salir</a></li>
					<%
						}
					%>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container" style="padding-top: 50px">
		<h1>Usuarios</h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Contraseña</th>
					<th>Rol</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<Usuario> Lista = (List<Usuario>) request.getAttribute("usuarios");
					for (Usuario us : Lista) {
						if (us.getIdUser() != UsLog.getIdUser()) {
				%>
				<tr>
					<td><%=us.getUserName()%></td>
					<td><%=us.getPassword()%></td>
					<td><%=us.getRole().getNameRole()%></td>
					<td><a class="btn btn-default"
						href="UsuarioServlet?action=edit&UsuarioId=<%=us.getIdUser()%>">Editar</a></td>
					<td><a class="btn btn-default"
						href="UsuarioServlet?action=delete&UsuarioId=<%=us.getIdUser()%>">Eliminar</a></td>
					<%
						}
						}
					%>
				</tr>
			</tbody>
		</table>
		<br> <br> <a class="btn btn-default" href="UsuarioServlet?action=insert">Agregar
			Usuario</a>
	</div>
</body>
</html>