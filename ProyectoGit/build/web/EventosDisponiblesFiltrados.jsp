<%-- 
    Document   : EventosDisponiblesFiltrados
    Created on : 05-10-2018, 15:52:20
    Author     : jorge
--%>
<<<<<<< HEAD


<%@page import="java.sql.Date"%>
<%@page import="clases.Evento"%>
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
    <center><h1>Eventos Disponibles</h1></center>
    
    <%int numEventos = 0;%>
    <%
        List<Evento> events = (List<Evento>) request.getAttribute("eventos");
        numEventos = events.size();
        System.out.print("Num eventos:"+numEventos);
        
    %>
   

    <div class="content" style="margin-left: 20px; margin-right: 20px;">
            <table class="table table-striped" >
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
                         EventoDAOImpl dao = new EventoDAOImpl();
                         String nombre = event.getNombre(); 
                         Date fecha = event.getFecha(); 
                         String lugar = event.getLugar(); 
                         Integer id_event = dao.buscarIdEvento(nombre, fecha, lugar);
                    %>
                    
<<<<<<< HEAD
                    <tr class="clickable-row notfirst" data-href="InfoEvento.jsp?id_event=<%=id_event%>">
                        
                        <td> <%=nombre %> </td>
                        <td> <%=fecha%> </td>
                        <td> <%=lugar%> </td>
=======
                    <tr>
                        
                        <td> <%=event.getNombre() %> </td>
                        <td> <%=event.getFecha() %> </td>
                        <td> <%=event.getLugar() %> </td>
                        <td><a href="InfoEvento.jsp?id_event=<%=event.getid_event()%>" class="btn btn-info" role="button">Ver Información</a></td>
                        
                        
                        
                        
                        <td> <form action ="interesa.do" method="post">
                                        <div class="form-row" type="hidden">
                                            <input type="hidden" name="txtId" value="<%=event.getid_event()%>">
                                        </div>
                                            <%  String textoBoton, colorBoton;
                                                EventoDAO evento = new EventoDAOImpl();
                                                int idEvento = event.getid_event();
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
                            </form> </td>
>>>>>>> master
                    </tr>
                    <%}%>
                   
                </tbody>
            </table>
        
    
    
                
    <a class="btn btn-success" role="button" href="EventosDisponibles.jsp" >volver...</a>            
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

