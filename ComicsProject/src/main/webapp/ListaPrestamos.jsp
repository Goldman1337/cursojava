<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.comics.app.Model.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prestamos</title>
</head>
<body>
<h1>Prestamos</h1>
<table border=1>
<thead>
<tr>
<th>Fecha</th>
<th>Comic</th>
<th>Persona</th>
</tr>
</thead>
<tbody>
<% List<Loan> Lista = (List<Loan>) request.getAttribute("loans");
for(Loan loan : Lista){
%>
<tr>
<td><%=loan.getDate() %></td>
<td><%=loan.getComic().getNameComic() %></td>
<td><%=loan.getPerson().getNamePerson() %></td>
<td><a href="LoanServlet?action=edit&LoanId=<%=loan.getIdLoan() %>">Editar</a></td>
<td><a href="LoanServlet?action=delete&LoanId=<%=loan.getIdLoan()%>">Eliminar</a></td>
<%} %>
</tr>
</tbody>
</table>
<p><a href="LoanServlet?action=insert">Agregar Prestamo</a></p>
<img alt="En Construccion" src="http://www.iebosquesdepinares.edu.co/PAGINA.jpg" width="400">
</body>
</html>