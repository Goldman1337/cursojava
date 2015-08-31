<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
    <%@page import="com.comics.app.Model.*" %>
    <%@page import="com.comics.app.Controller.*" %>
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
<title>Nuevo/Editar Usuario</title>
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
<h1>Nuevo/Editar</h1>
<% Usuario UsuarioEdit =(Usuario) request.getAttribute("usuario");
Integer UsuarioId =0;
List<Role> listaRole = new RoleController().getAll();
Integer RoleId=0;
String UserName = "";
String Password="";
if(UsuarioEdit!=null){
	UsuarioId=UsuarioEdit.getIdUser();
	RoleId=UsuarioEdit.getRole().getIdRole();
	UserName=UsuarioEdit.getUserName();
	Password=UsuarioEdit.getPassword();
}%>
<form method="POST" action="UsuarioServlet" name="frmAddUsuario">
<input type="Hidden" name="UsuarioId" value="<%=UsuarioId %>">
<div class="form-group">
<label for="NombreUsuario">Nombre de usuario</label>
<input required type="Text" id="NombreUsuario" class="form-control"
 placeholder="Username" maxlength="45" name="UserName" value="<%=UserName %>">
</div>
<div class="form-group">
<label for="PassUsuario">Contraseña</label>
<input required class="form-control" id="PassUsuario" placeholder="Password"
 type="Text" maxlength="45" name="Pass" value="<%=Password %>">
</div>
<div class="form-group">
<label for="RolUsuario">Rol</label>
<select required class="form-control" name="RoleId" id="RolUsuario">
	<%for(Role rol : listaRole){%>
	<%if(!rol.getNameRole().equalsIgnoreCase("ADMIN")){ %>
 	<%if(rol.getIdRole()==RoleId){%>
 	<option value="<%=rol.getIdRole()%>" selected> <%=rol.getNameRole() %></option>
 	<%}else{%>
	<option value="<%=rol.getIdRole()%>"> <%=rol.getNameRole() %></option>
	<%} %>
	<%} %>
	<%} %>
</select>
</div>
<input type="submit" class="btn btn-default" value="Submit">
<%String messages="";
if(request.getAttribute("messages")!=null){
messages=request.getAttribute("messages").toString();	
}
%>
<br><span><%=messages  %></span>
</form>
</div>
</body>
</html>