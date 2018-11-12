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
        <% 
           int id = Integer.parseInt(request.getParameter("id_event"));
           ResultSet rs = null;
           EventoDAO dao = new EventoDAOImpl();
           rs = dao.InfoEvento(id) ;
           rs.beforeFirst();
           rs.next();
        %>
        
        
        <h1>  </h1>
        <div class="table-responsive">
        <table class="table table-bordered table-sm center" style="margin-left: 10%;margin-right: 10%; width: 70%;">
            <tr>
                <td class="table-secondary">Nombre</td>
                <td><%=rs.getString("nombre")%></td>
            </tr>
            <tr>
                <td class="table-secondary">Fecha</td>
                <td><%=rs.getString("fecha")%></td>
            </tr>
            <tr>
                <td class="table-secondary">Hora de Inicio</td>
                <td><%=rs.getString("hora_ini")%></td>
            </tr>
            <tr>
                <td class="table-secondary">Hora de Termino</td>
                <td><%=rs.getString("hora_fin")%></td>
            </tr>
            <tr>
                <td class="table-secondary">Descripcion</td>
                <td><%=rs.getString("descrip")%></td>
            </tr>
            <tr>
                <td class="table-secondary">Lugar</td>
                <td><%=rs.getString("es_en")%></td>
            </tr>
            <tr>
                <td class="table-secondary">Categoria</td>
                <td><%=rs.getString("id_cat")%></td>
            </tr>
        </table>
        </div>
    </body>
</html>
