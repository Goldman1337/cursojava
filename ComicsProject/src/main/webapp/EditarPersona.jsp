<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.comics.app.Model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nueva/Editar Personas</title>
</head>
<body>
<h1>Nueva/Editar</h1>
<% Person PersonaEdit =(Person) request.getAttribute("person");
String PersonaId="";
String NombrePersona="";
String Telefono="";
if(PersonaEdit!=null){
	PersonaId=String.valueOf(PersonaEdit.getIdPerson());
	NombrePersona=PersonaEdit.getNamePerson();
	Telefono=PersonaEdit.getTelephonePerson();
}%>
<form method="POST" action="PersonServlet" name="frmAddPerson">
<input type="Hidden" name="PersonId" value="<%=PersonaId %>">
Nombre:<br><input required type="Text" name="Nombre" value="<%=NombrePersona%>"><br>
Telefono:<br><input type="Text" name="Tel" value="<%=Telefono %>"><br>
<br><input type="submit" value="Submit">
</form>
</body>
</html>