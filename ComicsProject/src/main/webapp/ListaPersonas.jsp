<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.comics.app.Model.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personas</title>
</head>
<body>
<h1>Personas</h1>
<table border=1>
<thead>
<tr>
<th>Nombre</th>
<th>Telefono</th>
</tr>
</thead>
<tbody>
<% List<Person> Lista = (List<Person>) request.getAttribute("persons");
for(Person per : Lista){
%>
<tr>
<td><%=per.getNamePerson() %></td>
<td><%=per.getTelephonePerson() %></td>
<td><a href="PersonServlet?action=edit&PersonId=<%=per.getIdPerson() %>">Editar</a></td>
<td><a href="PersonServlet?action=delete&PersonId=<%=per.getIdPerson()%>">Eliminar</a></td>
<%} %>
</tr>
</tbody>
</table>
<p><a href="PersonServlet?action=insert">Agregar persona</a></p>
<img alt="En Construccion" src="http://www.iebosquesdepinares.edu.co/PAGINA.jpg" width="400">
</body>
</html>