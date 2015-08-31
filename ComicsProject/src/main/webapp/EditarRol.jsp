<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.comics.app.Model.*"%>
<!DOCTYPE html >
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
<title>Nuevo/Editar Rol</title>
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
		<h1>Nuevo/Editar</h1>
		<%
			Role RoleEdit = (Role) request.getAttribute("role");
			Integer RolId = 0;
			String NombreRol = "";
			boolean ComicAdd = false;
			boolean ComicEdit = false;
			boolean ComicDelete = false;
			boolean PersonAdd = false;
			boolean PersonEdit = false;
			boolean PersonDelete = false;
			boolean LoanAdd = false;
			boolean LoanEdit = false;
			boolean LoanDelete = false;
			if (RoleEdit != null) {
				RolId = RoleEdit.getIdRole();
				NombreRol = RoleEdit.getNameRole();
				ComicAdd = RoleEdit.getComicAdd();
				ComicEdit = RoleEdit.getComicEdit();
				ComicDelete = RoleEdit.getComicDelete();
				PersonAdd = RoleEdit.getPersonAdd();
				PersonEdit = RoleEdit.getPersonEdit();
				PersonDelete = RoleEdit.getPersonDelete();
				LoanAdd = RoleEdit.getLoanAdd();
				LoanEdit = RoleEdit.getLoanEdit();
				LoanDelete = RoleEdit.getLoanDelete();
			}
		%>
		<form method="POST" action="RoleServlet" name="frmAddRol">
			<input type="Hidden" name="RoleId" value="<%=RolId%>">
			<div class="form-group">
				<label for="NombreRol">Nombre</label> <input required id="NombreRol"
					placeholder="Nombre" type="Text" class="form-control"
					maxlength="45" name="Nombre" value="<%=NombreRol%>">
			</div>
			<div class="checkbox">
				<label> <input type="checkbox" name="ComicAdd" value="true"
					<%if (ComicAdd) {%> checked <%}%>>Puede Agregar Comics?
				</label>
			</div>
			<div class="checkbox">
				<label> <input type="checkbox" name="ComicEdit" value="true"
					<%if (ComicEdit) {%> checked <%}%>>Puede Editar Comics?
				</label>
			</div>
			<div class="checkbox">
				<label> <input type="checkbox" name="ComicDelete" value="true" 
					<%if (ComicDelete) {%> checked <%}%>>Puede Borrar Comics?
				</label>
			</div>
			<div class="checkbox">
				<label> <input type="checkbox" name="PersonAdd" value="true"
					<%if (PersonAdd) {%> checked <%}%>>Puede Agregar Personas?
				</label>
			</div>
			<div class="checkbox">
				<label> <input type="checkbox" name="PersonEdit" value="true"
					 <%if (PersonEdit) {%> checked <%}%>>Puede Editar Personas?
				</label>
			</div>
			<div class="checkbox">
				<label> <input type="checkbox" name="PersonDelete" value="true"
					 <%if (PersonDelete) {%> checked <%}%>>Puede Borrar Personas?
				</label>
			</div>
			<div class="checkbox">
				<label> <input type="checkbox" name="LoanAdd" value="true"
					<%if (LoanAdd) {%> checked <%}%>>Puede Agregar Prestamos?
				</label>
			</div>
			<div class="checkbox">
				<label> <input type="checkbox" name="LoanEdit" value="true"
					<%if (LoanEdit) {%> checked <%}%>>Puede Editar Prestamos?
				</label>
			</div>
			<div class="checkbox">
				<label> <input type="checkbox" name="LoanDelete" value="true"
					<%if (LoanDelete) {%> checked <%}%>>Prestamos Borrar Personas?
				</label>
			</div>
			<input type="submit" class="btn btn-default" value="Submit">
		</form>
		<%
			String messages = "";
			if (request.getAttribute("messages") != null) {
				messages = request.getAttribute("messages").toString();
			}
		%>
		<br> <span><%=messages%></span>
	</div>
</body>
</html>