<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.comics.app.Model.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comics</title>
</head>
<body>
<h1>Comics</h1>
<table border=1>
<thead>
<tr>
<th>Nombre</th>
<th>Compañia</th>
<th>Cantidad</th>
<th>Review</th>
</tr>
</thead>
<tbody>
<% List<Comic> Lista = (List<Comic>) request.getAttribute("comics");
for(Comic coms : Lista){
%>
<tr>
<td><%=coms.getNameComic() %></td>
<td><%=coms.getCompanyComic() %></td>
<td><%=coms.getQuantityComic() %></td>
<td><%=coms.getReviewComic() %></td>
<td><a href="ComicServlet?action=edit&ComicId=<%=coms.getIdComic() %>">Editar</a></td>
<td><a href="ComicServlet?action=delete&ComicId=<%=coms.getIdComic()%>">Eliminar</a></td>
<%} %>
</tr>
</tbody>
</table>
<p><a href="ComicServlet?action=insert">Agregar comic</a></p>
<img alt="En Construccion" src="http://www.iebosquesdepinares.edu.co/PAGINA.jpg" width="400">
</body>
</html>