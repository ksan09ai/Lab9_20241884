<%--
  Created by IntelliJ IDEA.
  User: juan-
  Date: 11/13/2026
  Time: 8:13 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.pucp.lab9_20241884.beans.Usuario" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String contexto = request.getContextPath();
%>


<a href="<%= contexto %>/LibroServlet">Libros</a>


<a href="<%= contexto %>/LogoutServlet">
    Cerrar sesión
</a>

<hr>

