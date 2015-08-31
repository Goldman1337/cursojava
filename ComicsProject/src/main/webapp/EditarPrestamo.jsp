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
<title>Nuevo/Editar Prestamo</title>
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
<% Loan PrestamoEdit =(Loan) request.getAttribute("loan");
Integer PrestamoId =0;
List<Person> listaPersona = new personController().getAll();
List<Comic> listaComic = new comicController().getAll();
Integer ComicId=0;
Integer PersonaId=0;
String FechaPrestamo = "";
if(PrestamoEdit!=null){
	PrestamoId=PrestamoEdit.getIdLoan();
	PersonaId=PrestamoEdit.getPerson().getIdPerson();
	ComicId=PrestamoEdit.getComic().getIdComic();
	FechaPrestamo=PrestamoEdit.getDate();
}%>
<form method="POST" action="LoanServlet" name="frmAddPrestamo">
<input type="Hidden" name="LoanId" value="<%=PrestamoId %>">
<div class="form-group">
<label for="PersonaPrestamo">Persona</label>
<select required name="PersonId" class="form-control" id="PersonaPrestamo">
<%for(Person per : listaPersona){%>
 	<%if(per.getIdPerson()==PersonaId){%>
 	<option value="<%=per.getIdPerson()%>" selected> <%=per.getNamePerson() %></option>
 	<%}else{%>
	<option value="<%=per.getIdPerson()%>"> <%=per.getNamePerson() %></option>
	<%} %>
	<%} %>
</select>
</div>
<div class="form-group">
<label for="ComicPrestamo">Comic</label>
<select required name="ComicId" class="form-control" id="ComicPrestamo">
	<%for(Comic com : listaComic){%>
 	<%if(com.getIdComic()==ComicId){%>
 	<option value="<%=com.getIdComic()%>" selected> <%=com.getNameComic() %></option>
 	<%}else{%>
	<option value="<%=com.getIdComic()%>"> <%=com.getNameComic() %></option>
	<%} %>
	<%} %>
</select>
</div>
<div class="form-group">
<label for="FechaPrestamo">Fecha</label>
<input required class="form-control" id="FechaPrestamo"
 type="date" name="Date" value="<%=FechaPrestamo %>">
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