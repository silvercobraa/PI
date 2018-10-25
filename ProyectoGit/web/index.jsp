<%-- 
    Document   : index
    Created on : 25-oct-2018, 16:45:26
    Author     : Conchetumare
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%
    if (session.getAttribute("usuario") != null) {
        
%>
<t:base>
    <h1>Bienvenido.</h1>
</t:base>
<%
    }
    else {
%>
<t:base>
    <h1>Inicie sesión para continuar.</h1>
</t:base>
<%
    }
%>

