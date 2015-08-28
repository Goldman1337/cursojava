<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.comics.app.Model.*"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo/Editar Rol</title>
</head>
<body>
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
		Nombre:<br>
		<input required type="Text" name="Nombre" value="<%=NombreRol%>"><br>
		<input type="checkbox" name="ComicAdd" value="true" <%if (ComicAdd) {%>
			checked <%}%>>Puede Agregar Comics?<br> <input
			type="checkbox" name="ComicEdit" value="true" <%if (ComicEdit) {%>
			checked <%}%>>Puede Editar Comics?<br> <input
			type="checkbox" name="ComicDelete" value="true" <%if (ComicDelete) {%>
			checked <%}%>>Puede Borrar Comics?<br> <input
			type="checkbox" name="PersonAdd" value="true" <%if (PersonAdd) {%>
			checked <%}%>>Puede Agregar Personas?<br> <input
			type="checkbox" name="PersonEdit" value="true" <%if (PersonEdit) {%>
			checked <%}%>>Puede Editar Personas?<br> <input
			type="checkbox" name="PersonDelete" value="true"
			<%if (PersonDelete) {%> checked <%}%>>Puede Borrar Personas?<br>
		<input type="checkbox" name="LoanAdd" value="true" <%if (LoanAdd) {%>
			checked <%}%>>Puede Agregar Personas?<br> <input
			type="checkbox" name="LoanEdit" value="true" <%if (LoanEdit) {%>
			checked <%}%>>Puede Editar Personas?<br> <input
			type="checkbox" name="LoanDelete" value="true" <%if (LoanDelete) {%>
			checked <%}%>>Puede Borrar Personas?<br> <br>
		<input type="submit" value="Submit"> <br> <br>
		<a href="RoleServlet?action=listRole">Volver</a>
	</form>
	<%String messages="";
if(request.getAttribute("messages")!=null){
messages=request.getAttribute("messages").toString();	
}
%>
<br><span><%=messages  %></span>
<br>
<br>
<%Usuario UsLog = (Usuario) session.getAttribute("UsuarioLog");
if(UsLog!=null){ %>
<a href="LoginServlet?action=salir">salir</a>
<%} %>
</body>
</html>