<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.comics.app.Model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo/Editar Comic</title>
</head>
<body>
<h1>Nuevo/Editar</h1>
<% Comic ComicEdit =(Comic) request.getAttribute("comic");
String ComicId="";
String NombreComic="";
String Compañia="";
int Cantidad=0;
String Review="";
if(ComicEdit!=null){
	ComicId=String.valueOf(ComicEdit.getIdComic());
	NombreComic=ComicEdit.getNameComic();
	Compañia=ComicEdit.getCompanyComic();
	Cantidad=ComicEdit.getQuantityComic();
	Review=ComicEdit.getReviewComic();
}%>
<form method="POST" action="ComicServlet" name="frmAddComic">
<input type="Hidden" name="ComicId" value="<%=ComicId %>">
Nombre:<br><input type="Text" name="Nombre" value="<%=NombreComic%>"><br>
Compañia:<br><input type="Text" name="Comp" value="<%=Compañia %>"><br>
Cantidad: <br><input type="Text" name="Cantidad" value ="<%=Cantidad %>"><br>
Review: <br><textarea rows="4" cols="50" name="Review" value="<%=Review%>"></textarea>
<br><input type="submit" value="Submit">
</form>
</body>
</html>