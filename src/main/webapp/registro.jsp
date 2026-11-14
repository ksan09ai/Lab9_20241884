<%--
  Created by IntelliJ IDEA.
  User: juan-
  Date: 11/13/2026
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String error = (String) request.getAttribute("error");
%>
<html>
<head>
    <title>Registro de usuario</title>
</head>
<body>

<h2>Registro de usuario</h2>

<% if (error != null) { %>
<p><%= error %></p>
<% } %>

<form action="<%= request.getContextPath() %>/RegistroServlet" method="post">

    <label>Nombres:</label>
    <input type="text" name="nombres" required>
    <br><br>

    <label>Apellidos:</label>
    <input type="text" name="apellidos" required>
    <br><br>

    <label>Correo:</label>
    <input type="email" name="email" required>
    <br><br>

    <label>Contraseña:</label>
    <input type="password" name="password" required>
    <br><br>

    <button type="submit">Registrarse</button>

</form>

<p>
    Ya tienes cuenta?
    <a href="<%= request.getContextPath() %>/login.jsp">
        Iniciar sesion
    </a>
</p>

</body>
</html>
