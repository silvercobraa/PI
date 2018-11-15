<%-- 
    Document   : perfilUsuario
    Created on : 05-10-2018, 22:38:53
    Author     : capro
--%>

<%@page import="impl.InteresaDAOImpl"%>
<%@page import="dao.InteresaDAO"%>
<%@page import="impl.EventoDAOImpl"%>
<%@page import="dao.EventoDAO"%>
<%@page import="clases.Lugar"%>
<%@page import="impl.LugarDAOImpl"%>
<%@page import="dao.LugarDAO"%>
<%@page import="clases.Usuario"%>
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
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="#"><img src=".\top_izquierdainfoa.png" ></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                  <a class="nav-link" href="perfilUsuario.jsp">Usuario</a>
                </li>
                <li class="nav-item dropdown active">
                <a class="nav-link dropdown-toggle" href="EventosDisponibles.jsp" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Eventos Disponibles
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                  <a class="dropdown-item" href="EventosDisponibles.jsp">Todos</a>
                  <a class="dropdown-item" href="EventosCategoria.jsp?id_cat=Deportes">Deportes</a>
                  <a class="dropdown-item" href="EventosCategoria.jsp?id_cat=Cientifico">Científicos</a>
                  <a class="dropdown-item" href="EventosCategoria.jsp?id_cat=Politica">Política</a>
                  <a class="dropdown-item" href="EventosCategoria.jsp?id_cat=Entretenimiento">Entretenimiento</a>
                  <a class="dropdown-item" href="EventosOrganizadospor.jsp?id_depart=<%=session.getAttribute("id_depart")%>">Mi departamento</a>
                </div>
                <% if(session.getAttribute("publisher").equals(true) ){ %>
                <li class="nav-item active">
                  <a class="nav-link disabled" href="crearEvento.jsp">Crear Evento</a>
                </li>
                <% } %>
                
              </ul>
              <% if(session.getAttribute("usuario") != null) { %>
                <span class="navbar-item bg-primary">
                    <a class="nav-link" style="color: #eff0f1" href="login.html">Logout</a>
                </span>
                <% } %>
            </div>
        </nav>

        <center><h1>Mi Perfil</h1></center>
        <% 
            String id = request.getSession().getAttribute("id").toString();
            UsuarioDAOImpl user = new UsuarioDAOImpl();
            Usuario usuario = user.buscarPorId(id);
            String nombre = usuario.getNombre()+" "+usuario.getApellido1()+" "+usuario.getApellido2();
            String correo = usuario.getCorreo();
          
        %>
        <table class="table">
            <tbody>
                <tr>
                    <th>Nombre:</th>
                    <td><%=nombre%></td>
                </tr>
                <tr>
                    <th>Correo:</th>
                    <td><%=correo%></td>
                </tr>
            </tbody>
        </table>
        <center><h1>Eventos Seguidos</h1></center>
        <%  ResultSet rs = user.eventosSeguidos(id);
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
                        <th></th>
                        <th></th>
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
                        <td><a href="InfoEvento.jsp?id_event=<%=rs.getString("id_event")%>" class="btn btn-info" role="button">Ver Información</a></td>
                                <td> <form action ="interesa.do" method="post">
                                        <div class="form-row" type="hidden">
                                            <input type="hidden" name="txtId" value="<%=rs.getString("id_event")%>">
                                        </div>
                                            <% 
                                                EventoDAO evento = new EventoDAOImpl();
                                                int idEvento = rs.getInt("id_event");
                                                InteresaDAO idao = new InteresaDAOImpl();
                                                if(idao.interesado((request.getSession().getAttribute("id").toString()), idEvento) == true){
                                                    %>
                                                    <input type="submit" class="btn btn-danger" value="No me interesa">
                                                    <%
                                                }
                                                else{
%>
                                                 <input type="submit" class="btn btn-primary" value="me interesa">
                                                    <%
                                                }
                                                %>
               
                                     
                            </form> </td>
                        
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
    </body>
</html>
