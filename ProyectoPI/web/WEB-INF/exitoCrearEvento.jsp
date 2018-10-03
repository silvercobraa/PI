<%-- 
    Document   : exitoCrearEvento
    Created on : 02-10-2018, 21:26:20
    Author     : capro
--%>

<%@page import="Modelo.Evento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
Evento ev = (Evento) request.getSession().getAttribute("EventoNuevo");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Evento creado</h1>
        <a href="index.jsp" > Menu Principal /a>
    </body>
</html>
