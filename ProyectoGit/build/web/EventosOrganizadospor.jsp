<%-- 
    Document   : EventosOrganizadospor
    Created on : 11-11-2018, 17:50:25
    Author     : Cristian
--%>
<%@page import="clases.Lugar"%>
<%@page import="dao.Organizado_porDAO"%>
<%@page import="impl.Organizado_porDAOImpl"%>
<%@page import="impl.DepartamentoDAOImpl"%>
<%@page import="dao.DepartamentoDAO"%>
<%@page import="dao.EventoDAO"%>
<%@page import="impl.EventoDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="impl.LugarDAOImpl"%>
<%@page import="dao.LugarDAO"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .notfirst:hover {
                    background-color: #b8d1f3;
        }            
        </style>
    </head>
    
    <body>
        <nav class="navbar navbar-dark bg-primary">
            <div class="row" style="width: 100%">
                <div class="col-lg-2">
                    <a class="navbr-brand" >
                        <img src=".\top_izquierdainfoa.png" >
                    </a>
                </div>
                <div class="col-lg-2">
                    <a class="btn btn-secondary btn-lg btn-block" href="perfilUsuario.jsp">Usuario</a>
                </div>
                <div class="col-lg-2">
                    <a class="btn btn-secondary btn-lg btn-block" href="EventosDisponibles.jsp">Eventos</a>
                </div>
                <% if(session.getAttribute("publisher").equals(true) ){ %>
                <div class="col-lg-2">                    
                    <a class="btn btn-secondary btn-lg btn-block" href="crearEvento.jsp">Crear</a>
                </div>
                   <%          }      %>  
                <%
                    if (session.getAttribute("usuario") != null) {
                %>
                <div class="col-lg-2">
                    <a class="btn btn-secondary btn-lg btn-block" href="crearEvento.jsp">Logout</a>
                </div>
                <%
                    } else {
                %>
                <div class="col-lg-2">
                    <a class="btn btn-secondary btn-lg btn-block" href="login.html">Login</a>
                </div>
                <%
                    }
                %>  
            </div>
        </nav>  
        <%
            DepartamentoDAO daodep = new DepartamentoDAOImpl();
            String depid = request.getParameter("id_depart");
            String depart = daodep.buscar(depid);
        %>
        
    <center><h1>Eventos de <%=depart%> Disponibles</h1></center>
   
    <%
        ResultSet rs = null; 
        Organizado_porDAO dao = new Organizado_porDAOImpl();
        rs = dao.eventosOrganizadospor(depid);
        rs.last();
        int numEventos = rs.getRow();
    %>
        <h2 align="center">
        <%=numEventos%> Eventos
        </h2>  
    
    <div class="content" style="margin-left: 20px; margin-right: 20px;">
       
            <table class="table " >
                <thead>
                    <th scope="col">Nombre</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Lugar</th>
                    
                </thead>
                <tbody>
                <%  try{
                            rs.beforeFirst();
                            while(rs.next()){%>
                    
                    <tr class="clickable-row notfirst" data-href="InfoEvento.jsp?id_event=<%=rs.getString("id_event")%>">
                        
                        <td> <%=rs.getString("nombre")%> </td>
                        <td> <%=rs.getString("fecha")%>  </td>
                        <%LugarDAO ldao = new LugarDAOImpl();
                        Lugar lugar = ldao.buscarId(rs.getString("es_en"));%>
                        <td><%=lugar.getEdificio() + " - " + lugar.getAula()%></td>
                    </tr> 
                  <%  }
                        } 
                        catch(Exception e){
                            out.println(e.getMessage().toString());
                        }%>
                </tbody>
            </table>
        
    
       
    <a href="EventosDisponibles.jsp" >volver...</a>            
    </div>
   
    </body>
    <script> 
jQuery(document).ready(function($) {
    $(".clickable-row").click(function() {
        window.location = $(this).data("href");
    });
});
</script>
</html>
