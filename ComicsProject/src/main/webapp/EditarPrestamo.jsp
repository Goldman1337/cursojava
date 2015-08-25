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
String PrestamoId ="";
List<Person> listaPersona = new personController().getAll();
List<Comic> listaComic = new comicController().getAll();
String ComicId="";
String PersonaId="";
String FechaPrestamo = "";
if(PrestamoEdit!=null){
	PersonaId=String.valueOf(PrestamoEdit.getPerson());
	ComicId=String.valueOf(PrestamoEdit.getComic().getIdComic());
	FechaPrestamo=PrestamoEdit.getDate();
}%>
<form method="POST" action="LoanServlet" name="frmAddPrestamo">
<input type="Hidden" name="LoanId" value="<%=PrestamoId %>">
Persona:<br>
<select name="PersonId">
<%for(Person per : listaPersona){
%>
	<option value="<%=per.getIdPerson()%>" > <%=per.getNamePerson() %></option>
<%} %>
</select><br>
<!--<input type="Text" name="Nombre" value=""><br> -->
Comic:<br>
<select name="ComicId">
<%for(Comic com : listaComic){
%>
	<option value="<%=com.getIdComic()%>" > <%=com.getNameComic() %></option>
<%} %>
</select><br>
<!-- <input type="Text" name="Tel" value=""><br> -->
Fecha:<br><input type="date" name="Date" value="<%=FechaPrestamo %>"><br>
<br><input type="submit" value="Submit">
</form>
</body>
</html>