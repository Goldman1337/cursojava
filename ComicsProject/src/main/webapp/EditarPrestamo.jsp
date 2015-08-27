<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
    <%@page import="com.comics.app.Model.*" %>
    <%@page import="com.comics.app.Controller.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo/Editar Prestamo</title>
</head>
<body>
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
Persona:<br>
<select name="PersonId">
<%for(Person per : listaPersona){%>
 	<%if(per.getIdPerson()==PersonaId){%>
 	<option value="<%=per.getIdPerson()%>" selected> <%=per.getNamePerson() %></option>
 	<%}else{%>
	<option value="<%=per.getIdPerson()%>"> <%=per.getNamePerson() %></option>
	<%} %>
	<%} %>
</select><br>
Comic:<br>
<select name="ComicId">
	<%for(Comic com : listaComic){%>
 	<%if(com.getIdComic()==ComicId){%>
 	<option value="<%=com.getIdComic()%>" selected> <%=com.getNameComic() %></option>
 	<%}else{%>
	<option value="<%=com.getIdComic()%>"> <%=com.getNameComic() %></option>
	<%} %>
	<%} %>
</select><br>
Fecha:<br><input required type="date" name="Date" value="<%=FechaPrestamo %>"><br>
<br><input type="submit" value="Submit">
<%String messages="";
if(request.getAttribute("messages")!=null){
messages=request.getAttribute("messages").toString();	
}
%>
<br><span><%=messages  %></span>
<br>
<br><a href="LoanServlet?action=listLoan">Volver</a>
</form>
</body>
</html>