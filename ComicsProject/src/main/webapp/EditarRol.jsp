<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.comics.app.Model.*" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo/Editar Rol</title>
</head>
<body>
<h1>Nuevo/Editar</h1>
<% Role RoleEdit =(Role) request.getAttribute("role");
Integer RolId=0;
String NombreRol="";
boolean ComicAdd=false;
boolean ComicEdit=false;
boolean ComicDelete=false;
boolean PersonAdd=false;
boolean PersonEdit=false;
boolean PersonDelete=false;
boolean LoanAdd=false;
boolean LoanEdit=false;
boolean LoanDelete=false;
if(RoleEdit!=null){
	RolId=RoleEdit.getIdRole();
	NombreRol=RoleEdit.getNameRole();
	ComicAdd=RoleEdit.getComicAdd();
	ComicEdit=RoleEdit.getComicEdit();
	ComicDelete=RoleEdit.getComicDelete();
	PersonAdd=RoleEdit.getPersonAdd();
	PersonEdit=RoleEdit.getPersonEdit();
	PersonDelete=RoleEdit.getPersonDelete();
	LoanAdd=RoleEdit.getLoanAdd();
	LoanEdit=RoleEdit.getLoanEdit();
	LoanDelete=RoleEdit.getLoanDelete();
}%>
<form method="POST" action="RoleServlet" name="frmAddRol">
<input type="Hidden" name="RoleId" value="<%=RolId %>">
Nombre:<br><input required type="Text" name="Nombre" value="<%=NombreRol%>"><br>
<input type="checkbox" name="ComicAdd" value="<%=ComicAdd %>">Puede Agregar Comics?<br>
<input type="checkbox" name="ComicEdit" value="<%=ComicEdit %>">Puede Editar Comics?<br>
<input type="checkbox" name="ComicDelete" value="<%=ComicDelete %>">Puede Borrar Comics?<br>
<input type="checkbox" name="PersonAdd" value="<%=PersonAdd %>">Puede Agregar Personas?<br>
<input type="checkbox" name="PersonEdit" value="<%=PersonEdit %>">Puede Editar Personas?<br>
<input type="checkbox" name="PersonDelete" value="<%=PersonDelete %>">Puede Borrar Personas?<br>
<input type="checkbox" name="LoanAdd" value="<%=LoanAdd %>">Puede Agregar Personas?<br>
<input type="checkbox" name="LoanEdit" value="<%=LoanEdit %>">Puede Editar Personas?<br>
<input type="checkbox" name="LoanDelete" value="<%=LoanDelete %>">Puede Borrar Personas?<br>
<br><input type="submit" value="Submit">
<br>
<br><a href="RoleServlet?action=listRole">Volver</a>
</form>
</body>
</html>