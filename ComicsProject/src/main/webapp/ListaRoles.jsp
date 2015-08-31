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
<title>Roles</title>
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
	<div class="container" style="padding-top:50px">
	<h1>Roles</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Agregar Comics</th>
				<th>Editar Comics</th>
				<th>Eliminar Comics</th>
				<th>Agregar Personas</th>
				<th>Editar Personas</th>
				<th>Eliminar Personas</th>
				<th>Agregar Prestamos</th>
				<th>Editar Prestamos</th>
				<th>Eliminar Prestamos</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<Role> Lista = (List<Role>) request.getAttribute("roles");
				for (Role rols : Lista) {
					if (rols.getIdRole() != 1) {
			%>
			<tr>
				<td><%=rols.getNameRole()%></td>
				<td><%=rols.getComicAdd()%></td>
				<td><%=rols.getComicEdit()%></td>
				<td><%=rols.getComicDelete()%></td>
				<td><%=rols.getPersonAdd()%></td>
				<td><%=rols.getPersonEdit()%></td>
				<td><%=rols.getPersonDelete()%></td>
				<td><%=rols.getLoanAdd()%></td>
				<td><%=rols.getLoanEdit()%></td>
				<td><%=rols.getLoanDelete()%></td>
				<td><a class="btn btn-default"
					href="RoleServlet?action=edit&RoleId=<%=rols.getIdRole()%>">Editar</a></td>
				<td><a class="btn btn-default"
					href="RoleServlet?action=delete&RoleId=<%=rols.getIdRole()%>">Eliminar</a></td>
				<%
					}
					}
				%>
			</tr>
		</tbody>
	</table>
<br>
<br>
		<a class="btn btn-default" href="RoleServlet?action=insert">Agregar Rol</a>
	</div>
</body>
</html>