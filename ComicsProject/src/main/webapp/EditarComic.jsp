<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.comics.app.Model.*" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo/Editar Comic</title>
</head>
<body>
<h1>Nuevo/Editar</h1>
<%
Comic ComicEdit =(Comic) request.getAttribute("comic");
Integer ComicId=0;
String NombreComic="";
String Compañia="";
int Cantidad=0;
String Review="";
if(ComicEdit!=null){
	ComicId=ComicEdit.getIdComic();
	NombreComic=ComicEdit.getNameComic();
	Compañia=ComicEdit.getCompanyComic();
	Cantidad=ComicEdit.getQuantityComic();
	Review=ComicEdit.getReviewComic();
}%>
<form method="POST" action="ComicServlet" name="frmAddComic">
<input type="Hidden" name="ComicId" value="<%=ComicId %>">
Nombre:<br><input required type="Text" maxlength="44" name="Nombre" value="<%=NombreComic%>"><br>
Compañia:<br><input type="Text" maxlength="45" name="Comp" value="<%=Compañia %>"><br>
Cantidad: <br><input required type="Number" min="0" max="999999" name="Cantidad" value ="<%=Cantidad %>"><br>
Review: <br><textarea rows="4" cols="50" maxlength="500" name="Review"><%=Review%></textarea>
<br><input type="submit" value="Submit">
<%String messages="";
if(request.getAttribute("messages")!=null){
messages=request.getAttribute("messages").toString();	
}
%>
<br><span><%=messages  %></span>
<br>
<br><a href="ComicServlet?action=listComic">Volver</a>
<br>
<br>
<%Usuario UsLog = (Usuario) session.getAttribute("UsuarioLog");
if(UsLog!=null){ %>
<a href="LoginServlet?action=salir">salir</a>
<%} %>
</form>
</body>
</html>