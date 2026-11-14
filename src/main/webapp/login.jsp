<%--
  Created by IntelliJ IDEA.
  User: juan-
  Date: 11/13/2026
  Time: 7:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String mensaje = (String) session.getAttribute("mensaje");
    String error = (String) request.getAttribute("error");

    session.removeAttribute("mensaje");
%>

<html>
<head>
    <title>Iniciar Sesion</title>
</head>
<body>

<% if (mensaje != null) { %>
<p><%= mensaje %></p>
<% } %>

<% if (error != null) { %>
<p><%= error %></p>
<% } %>

<form action="<%= request.getContextPath()%>/LoginServlet" method="post">

    <label>Correo: </label>
    <input type="email" name="email" required>
    <br><br>

    <label>Contraseña: </label>
    <input type="password" name="password" required>
    <br><br>

    <button type="submit">Iniciar sesion</button>

<p>
    <a href="<%= request.getContextPath() %>/RegistroServlet">
        Crear cuenta
    </a>
</p>


</form>










</body>
</html>
