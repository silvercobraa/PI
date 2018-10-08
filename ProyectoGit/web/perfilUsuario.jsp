<%-- 
    Document   : perfilUsuario
    Created on : 05-10-2018, 22:38:53
    Author     : capro
--%>

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
                <div class="col-lg-3">
                    <a class="navbar-brand" >
                        <img src=".\top_izquierdainfoa.png" >
                    </a>
                </div>
                <div class="col-lg-3">
                    <a class="btn btn-secondary btn-lg btn-block" href="perfilUsuario.jsp">Usuario</a>
                </div>
                <div class="col-lg-3">
                    <a class="btn btn-secondary btn-lg btn-block" href="EventosDisponibles.jsp">Eventos</a>
                </div>
                <div class="col-lg-3">
                    <a class="btn btn-secondary btn-lg btn-block" href="crearEvento.jsp">Crear</a>
                </div>
            </div>
        </nav>       
        
        
        
        <center><h1>Mi Perfil</h1></center>
        <% 
            String id = "cscholtz";
            UsuarioDAOImpl user = new UsuarioDAOImpl();
            ResultSet rs = user.entregarDatos(id);
            String nombre = null;
            String correo = null;
            %>
            <table width ="600" border ="0" align="left">
                <tr>
                    <% while(rs.next()){
                        nombre = rs.getString("nombre") + " " + rs.getString("apellido1") + " " + rs.getString("apellido2");
                        correo = rs.getString("correo");
                    }
                    %>
                <TABLE BORDER>
                    <tr><th>Nombre</th>
                        <td> <%=nombre%> </td></tr>
                    <tr><th>Correo</th>
                        <td><%=correo%></td></tr>
                    </TABLE>
            </tr>
    </table>
        <center><h1>Eventos Seguidos</h1></center>
        <%  rs = user.eventosSeguidos(id);
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
                    </thead>
                    <tbody>
                    <%  try{
                            rs.beforeFirst();
                            while(rs.next()){%>
                    <tr>
                        <td><%=rs.getString("nombre")%></td>
                        <td><%=rs.getString("fecha")%></td>
                        <td><%=rs.getString("es_en")%></td>
                    </tr>
                    <%      }
                        }  catch(Exception e){
                            out.println(e.getMessage().toString());
                            }
                        }
                    %>
                    </tbody>
                    </table>                    
            </tr>
            </table>
        <center><h1>Te podria interesar:</h1></center>
        <%  rs = user.posiblesEventos(id);
            int totalIntereses = 0;
            %>
        <table width="600" border="0" align ="center">
            <tr>
                <%
                    while(rs.next()){
                        totalIntereses = totalIntereses + 1;
                    }
                    if(totalIntereses == 0){
                    %>
                    <table class="table">
                        <thead>
                        <th scope="col">No tenemos nada para recomendar... Por ahora.</th>
                        </thead>
                    </table>
                    <%
                        }
                        else{
                    %>
                    <table class="table">
                    <thead>
                        <th scope="col">Nombre</th>
                        <th scope="col">Fecha</th>
                        <th scope="col">Lugar</th>
                    </thead>
                    <tbody>
                    <%  try{
                            rs.beforeFirst();
                            while(rs.next()){%>
                    <tr>
                        <td><%=rs.getString("nombre")%></td>
                        <td><%=rs.getString("fecha")%></td>
                        <td><%=rs.getString("es_en")%></td>
                    </tr>
                    <%      }
                        } 
                            catch(Exception e){
                            out.println(e.getMessage().toString());
                            }
                        }
                    %>
                    </tbody>
                    </table>
    </body>
</html>
