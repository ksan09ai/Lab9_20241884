<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Lista de libros</title>
</head>
<body>

<jsp:include page="navbar.jsp"/>

<h2>Lista de libros</h2>

<table border="1">
    <tr>
        <th>Título</th>
        <th>Autor</th>
        <th>Año de publicación</th>
        <th>Acción</th>
    </tr>

    <c:forEach var="libro" items="${listaLibros}">
        <tr>
            <td>${libro.titulo}</td>
            <td>${libro.autor}</td>
            <td>${libro.anioPublicacion}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
