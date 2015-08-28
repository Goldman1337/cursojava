<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
    <%@page import="com.comics.app.Model.*" %>
    <%@page import="com.comics.app.Controller.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo/Editar Usuario</title>
</head>
<body>
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
Nombre de usuario:<br><input required type="Text" maxlength="45" name="UserName" value="<%=UserName %>"><br>
Contraseña:<br><input required type="Text" maxlength="45" name="Pass" value="<%=Password %>"><br>
Rol:<br>
<select name="RoleId">
	<%for(Role rol : listaRole){%>
	<%if(!rol.getNameRole().equalsIgnoreCase("ADMIN")){ %>
 	<%if(rol.getIdRole()==RoleId){%>
 	<option value="<%=rol.getIdRole()%>" selected> <%=rol.getNameRole() %></option>
 	<%}else{%>
	<option value="<%=rol.getIdRole()%>"> <%=rol.getNameRole() %></option>
	<%} %>
	<%} %>
	<%} %>
</select><br>
<br><input type="submit" value="Submit">
<%String messages="";
if(request.getAttribute("messages")!=null){
messages=request.getAttribute("messages").toString();	
}
%>
<br><span><%=messages  %></span>
<br>
<br><a href="LoanServlet?action=listLoan">Volver</a>
<br>
<br>
<%Usuario UsLog = (Usuario) session.getAttribute("UsuarioLog");
if(UsLog!=null){ %>
<a href="LoginServlet?action=salir">salir</a>
<%} %>
</form>
</body>
</html>