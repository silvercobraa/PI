    <%@page import="clases.Lugar"%>
<%@page import="clases.Usuario"%>
<%-- 
       Document   : modificarEvento
    Created on : 
    Author     : despi
--%>

<%@page import="dao.UsuarioDAO"%>
<%@page import="java.util.List"%>
<%@page import="impl.LugarDAOImpl"%>
<%@page import="dao.LugarDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="impl.UsuarioDAOImpl"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-primary">
            <div class="row" style="width: 100%">
                <div class="col-lg-2">
                    <a class="navbar-brand" >
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
    
    <center><h1>Eventos </h1></center>
        <%  String id = session.getAttribute("id").toString();
            UsuarioDAOImpl user = new UsuarioDAOImpl();
            ResultSet rs = user.eventosCreados(id);
            int totalEventos = 0;
            %>
        <table width="600" border="0" align ="center">
            <tr>
                <%
                    while(rs.next()){
                        totalEventos = totalEventos + 1;
                    }
                    if(totalEventos == 0){
                    %>
                    <table class="table">
                        <thead>
                        <th scope="col">No hay eventos seguidos</th>
                        </thead>
                    </table>
                    <%  }
                        else{
                    %>
                    <table class="table">
                    <thead>
                        <th scope="col">Nombre</th>
                        <th scope="col">Fecha</th>
                        <th scope="col">Lugar</th>
                        <th scope="col">Hora ini</th>
                        <th scope="col">Hora Fin</th>
                        <th scope="col"></th>
                        
                    </thead>
                    
                    <tbody>
                    <%  try{
                            rs.beforeFirst();
                            while(rs.next()){%>
                    <tr>
                    
                        <td><%=rs.getString("nombre")%></td>
                        <td><%=rs.getString("fecha")%></td>
                        <%LugarDAO ldao = new LugarDAOImpl();
                        Lugar lugar = ldao.buscarId(rs.getString("es_en"));%>
                        <td><%=lugar.getEdificio() + " - " + lugar.getAula()%></td>
                        <td><%=rs.getString("hora_ini")%></td>
                        <td><%=rs.getString("hora_fin")%></td>
                        <td><a href="Modificar2.jsp?id_event=<%=rs.getString("id_event")%>&&nombre=<%=rs.getString("nombre")%>&&fecha=<%=rs.getString("fecha")%>&&es_en=<%=rs.getString("es_en")%>&&hora_ini=<%=rs.getString("hora_ini")%>&&hora_fin=<%=rs.getString("hora_fin")%>">Modificar</a></td> 

                    </tr>                    
                    <%      }
                        }  catch(Exception e){
                            out.println(e.getMessage().toString());
                            }
                        }
                    %>
                    </tbody>
            </table>