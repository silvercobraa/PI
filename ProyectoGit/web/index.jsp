<%-- 
    Document   : index
    Created on : 25-oct-2018, 16:45:26
    Author     : César
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%
    if (session.getAttribute("usuario") != null) {
        
%>
<t:base>
    <div class="container">
        <h1>Bienvenido.</h1>
    </div>
</t:base>
<%
    }
    else {
%>
<t:base>
    <div class="container">
        <h1>Inicie sesión para continuar.</h1>
    </div>
</t:base>
<%
    }
%>

