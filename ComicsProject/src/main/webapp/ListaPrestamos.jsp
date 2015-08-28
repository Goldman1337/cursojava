<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.comics.app.Model.*"%>
<%@page import="java.util.*"%>
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
				<th>Persona</th>
				<th>Comic</th>
			</tr>
		</thead>
		<tbody>
			<%
				Usuario UsLog = (Usuario) session.getAttribute("UsuarioLog");
				List<Loan> Lista = (List<Loan>) request.getAttribute("loans");
				for (Loan loan : Lista) {
			%>
			<tr>
				<td><%=loan.getDate()%></td>
				<td><%=loan.getPerson().getNamePerson()%></td>
				<td><%=loan.getComic().getNameComic()%></td>
				<%
					if (UsLog != null) {
							if (UsLog.getRole().getLoanEdit()) {
				%>
				<td><a
					href="LoanServlet?action=edit&LoanId=<%=loan.getIdLoan()%>">Editar</a></td>
				<%
					}
							if (UsLog.getRole().getLoanDelete()) {
				%>
				<td><a
					href="LoanServlet?action=delete&LoanId=<%=loan.getIdLoan()%>">Eliminar</a></td>
				<%
					}
						}
					}
				%>
			</tr>
		</tbody>
	</table>
	<%
		if (UsLog != null) {
			if (UsLog.getRole().getLoanAdd()) {
	%>
	<p>
		<a href="LoanServlet?action=insert">Agregar Prestamo</a>
	</p>
	<%
		}
		}
	%>
	<br>
	<br>
	<a href="Index.jsp">Inicio</a>
</body>
</html>