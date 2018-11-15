<%@page import="java.sql.Date"%>
<%@page import="clases.Evento"%>
<%@page import="dao.LugarDAO"%>
<%@page import="clases.Lugar"%>
<%@page import="impl.InteresaDAOImpl"%>
<%@page import="dao.InteresaDAO"%>
<%@page import="impl.EventoDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="impl.LugarDAOImpl"%>
<%@page import="dao.LugarDAO"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="impl.EventoDAOImpl"%>
<%@page import="dao.EventoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eventos Disponibles</title>
        <style>
            .notfirst:hover {
                    background-color: #b8d1f3;
        }            
        </style>
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
    <center><h1>Eventos Disponibles</h1></center>
    <%
        List<Evento> events = (List<Evento>) request.getAttribute("eventos");
        int numEventos = events.size();   
    %>
            <h2 align="center">
            <%=numEventos%> Eventos
            </h2>            
    <div class="container">
            <table class="table table-striped table-bordered" >
                <thead>
                    <th scope="col">Nombre</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Lugar</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </thead>
                <tbody>
                   <%
                       for(Evento event: events ){
                           String nombre = event.getNombre();
                           Date fecha = event.getFecha();
                           String id_lugar = event.getLugar();
                    %>                    
                    <tr>                       
                        <td> <%=nombre %> </td>
                        <td> <%=fecha %> </td>
                        <%
                            LugarDAO ldao = new LugarDAOImpl();
                        Lugar lugar = ldao.buscarId(id_lugar);
                        %>
                        <td><%=lugar.getEdificio() + " - " + lugar.getAula()%></td>
                        <td><a href="InfoEvento.jsp?id_event=<%=event.getID()%>" class="btn btn-info" role="button">Ver Información</a></td>
                        
                        
 
                        <td> <form action ="interesa.do" method="post">
                                        <div class="form-row" type="hidden">
                                            <input type="hidden" name="txtId" value="<%=event.getID()%>">
                                        </div>
                                            <%  String textoBoton, colorBoton;
                                                int idEvento = event.getID();
                                                InteresaDAO idao = new InteresaDAOImpl();
                                                if(idao.interesado((request.getSession().getAttribute("id").toString()), idEvento) == true){
                                                    textoBoton = "No me interesa";
                                                    colorBoton = "btn btn-danger";
                                                }
                                                else{
                                                    textoBoton = "Me interesa";
                                                    colorBoton = "btn btn-primary";
                                                }
                                                %>             
                                     <input type="submit" class="<%=colorBoton%>" value="<%=textoBoton%>">
                            </form> 
                        </td>
                    </tr>
                    <%}%>                  
                </tbody>
            </table>         
    <a class="btn btn-success" role="button" href="EventosDisponibles.jsp" >Volver...</a>            
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

