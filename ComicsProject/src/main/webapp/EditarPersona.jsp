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
Integer PersonaId=0;
String NombrePersona="";
String Telefono="";
if(PersonaEdit!=null){
	PersonaId=PersonaEdit.getIdPerson();
	NombrePersona=PersonaEdit.getNamePerson();
	Telefono=PersonaEdit.getTelephonePerson();
}%>
<form method="POST" action="PersonServlet" name="frmAddPerson">
<input type="Hidden" name="PersonId" value="<%=PersonaId %>">
Nombre:<br><input required type="Text" name="Nombre" value="<%=NombrePersona%>"><br>
Telefono:<br><input type="Text" name="Tel" value="<%=Telefono %>"><br>
<br><input type="submit" value="Submit">
<%String messages="";
if(request.getAttribute("messages")!=null){
messages=request.getAttribute("messages").toString();	
}
%>
<br><span><%=messages  %></span>
<br>
<br><a href="PersonServlet?action=listPerson">Volver</a>
<br>
<br>
<%Usuario UsLog = (Usuario) session.getAttribute("UsuarioLog");
if(UsLog!=null){ %>
<a href="LoginServlet?action=salir">salir</a>
<%} %>
</form>
</body>
</html>