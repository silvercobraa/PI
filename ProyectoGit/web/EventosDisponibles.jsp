

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center><h1>Eventos Disponibles</h1></center>
    <%int numEventos = 0;%>
    <%ResultSet rs = null; %>
    <%
        try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://dieespinoza.inf.udec.cl/pi", "pi", "pi4321");
            Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery("SELECT p.nombre, p.fecha, p.es_en FROM pi.evento as p WHERE p.fecha >= current_date");
        } catch(Exception e){
            System.out.println(e.getMessage().toString());
        }
    %>
    <table width ="600" border ="0" align="center">
        <tr>
            <%
                while(rs.next()){
                    numEventos = numEventos+1;
                }
            %>
        <td align="center"><p align="center"><b> Eventos.
                    (<%=numEventos%>) Eventos</b></p></td>
    </tr>
    <tr>
        <td>
            <p style="margin-top: 0; margin-bottom: 0">&nbsp;</p>
            <table width="60" border="1" align="center" style="font-family: Tahoma; font-size: 8pt">
                <%
                    try{
                %>
                <tr>
                    <td width="100" align="center"><b>Nombre</b></td>
                    <td width="100" align="center"><b>Fecha</b></td>
                    <td width="100" align="center"><b>Lugar</b></td>
                </tr>
                <%
                    rs.beforeFirst();
                    while(rs.next()){
                %>
                <tr>
                    <td width="100" align="center"><%=rs.getString(1)%></td>
                    <td width="100" align="center"><%=rs.getString(2)%></td>
                    <td width="100" align="center"><%=rs.getString(3)%></td>
                </tr>
                <%
                    }
                } catch(Exception e){
                    out.println(e.getMessage().toString());
                }
                %>
            </table>
    </body>
</html>
