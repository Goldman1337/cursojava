<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.comics.app.Model.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuarios</title>
</head>
<body>
<h1>Usuarios</h1>
<table border=1>
<thead>
<tr>
<th>Nombre</th>
<th>Contraseña</th>
<th>Rol</th>
</tr>
</thead>
<tbody>
<% Usuario UsLog = (Usuario) session.getAttribute("UsuarioLog");
List<Usuario> Lista = (List<Usuario>) request.getAttribute("usuarios");
for(Usuario us : Lista){
	if(us.getIdUser()!=UsLog.getIdUser()){
%>
<tr>
<td><%=us.getUserName() %></td>
<td><%=us.getPassword() %></td>
<td><%=us.getRole().getNameRole() %></td>
<td><a href="UsuarioServlet?action=edit&UsuarioId=<%=us.getIdUser() %>">Editar</a></td>
<td><a href="UsuarioServlet?action=delete&UsuarioId=<%=us.getIdUser()%>">Eliminar</a></td>
<%} }%>
</tr>
</tbody>
</table>
<p><a href="UsuarioServlet?action=insert">Agregar Usuario</a></p>
<br>
<br><a href="Index.jsp">Inicio</a>
</body>
</html>