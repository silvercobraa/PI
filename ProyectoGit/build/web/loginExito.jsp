

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Exitoso</h1>
        <h3>session.getAttribute("id"): <%=session.getAttribute("id")%></h3>
        <h3>session.getAttribute("usuario"): <%=session.getAttribute("usuario")%></h3>
        <h3>session.getAttribute("publisher"): <%=session.getAttribute("publisher")%></h3>
    </body>
</html>
