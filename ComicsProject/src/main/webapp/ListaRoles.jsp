<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.comics.app.Model.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Roles</title>
</head>
<body>
<h1>Roles</h1>
<table border=1>
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
<% List<Role> Lista = (List<Role>) request.getAttribute("roles");
for(Role rols : Lista){
%>
<tr>
<td><%=rols.getNameRole() %></td>
<td><%=rols.getComicAdd() %></td>
<td><%=rols.getComicEdit() %></td>
<td><%=rols.getComicDelete() %></td>
<td><%=rols.getPersonAdd() %></td>
<td><%=rols.getPersonEdit() %></td>
<td><%=rols.getPersonDelete() %></td>
<td><%=rols.getLoanAdd() %></td>
<td><%=rols.getLoanEdit() %></td>
<td><%=rols.getLoanDelete() %></td>
<td><a href="RoleServlet?action=edit&RoleId=<%=rols.getIdRole() %>">Editar</a></td>
<td><a href="RoleServlet?action=delete&RoleId=<%=rols.getIdRole()%>">Eliminar</a></td>
<%} %>
</tr>
</tbody>
</table>
<p><a href="RoleServlet?action=insert">Agregar comic</a></p>
<br>
<br><a href="Index.jsp">Inicio</a>
</body>
</html>