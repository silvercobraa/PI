<%@page import="impl.UsuarioDAOImpl"%>
<%@page import="dao.UsuarioDAO"%>
<%@page import="impl.InteresaDAOImpl"%>
<%@page import="dao.InteresaDAO"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.List"%>
<%@page import="impl.LugarDAOImpl"%>
<%@page import="dao.LugarDAO"%>
<%@page import="clases.Lugar"%>
<%@page import="impl.EventoDAOImpl"%>
<%@page import="dao.EventoDAO"%>
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
        ResultSet rs = null; 
        EventoDAO dao = new EventoDAOImpl();
        rs = dao.obtenerEventosDeAquiAFuturo();
        rs.last();
        int numEventos = rs.getRow();
    %>
        <h2 align="center">
            <%=numEventos%> Eventos
            </h2>
        <div class="row" style="margin-left: 15px;margin-right: 15px">
            <div class="col-md-3">
                <h3> filtros </h3>
                <form action="filtrar.do" method="post">
                <label for="BNom">Nombre</label>
                <input type="text" name="BNom" class="form-control" value="">
                <label for="FIni">Fecha inicio</label>
                <input type="date" name="FIni" class="form-control" value="">
                <label for="Lugar">Lugar</label>
                <select class="custom-select" name="Lugar" value="">
                            <option selected></option>
                            <%
                                try {
                                    LugarDAO ldao = new LugarDAOImpl();
                                    List<Lugar> lista = ldao.listarLugares();
                                    for (Lugar lugar: lista) {
                                        %><option value="<%=lugar.getId()%>" required><%=lugar.getEdificio() + " - " + lugar.getAula()%></option><%
                                    }
                                }
                                catch(Exception e){
                                    out.println(e.getMessage().toString());
                                }
                            %>
                        </select> 
                <input type="submit" class="btn btn-primary btn-lg btn-block" style="margin-top: 10px" value="Filtrar">
            </form>
            </div>
            <div class="col-md-9">
                <table class="table table-striped">
                <thead>
                    <th scope="col">Nombre</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Lugar</th>
                    <th scope="col"></th>
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
                        <td><a href="InfoEvento.jsp?id_event=<%=rs.getString("id_event")%>" class="btn btn-info" role="button">Ver Información</a></td>
                                <td> <form action ="interesa.do" method="post">
                                        <div class="form-row" type="hidden">
                                            <input type="hidden" name="txtId" value="<%=rs.getString("id_event")%>">
                                        </div>
                                            <%  String textoBoton, colorBoton;
                                                int idEvento = rs.getInt("id_event");
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
                    </tr>
                    <%  }
                        } 
                        catch(Exception e){
                            out.println(e.getMessage().toString());
                        }%>
                </tbody>
                </table>
            </div>
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
