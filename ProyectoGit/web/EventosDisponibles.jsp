


<%@page import="java.util.List"%>
<%@page import="impl.LugarDAOImpl"%>
<%@page import="dao.LugarDAO"%>

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
    <!--    
  botones por categoria      
-->
<div class="row" style="width: 98%;margin: 15px">
    <div class="col-lg-3">
                    <a class="btn btn-primary btn-lg btn-block" href="EventosCategoria.jsp?id_cat=Deportes">Deportes</a>
                </div>
    <div class="col-lg-3">
                    <a class="btn btn-primary btn-lg btn-block" href="EventosCategoria.jsp">Cientificos</a>
                </div>
    <div class="col-lg-3">
                    <a class="btn btn-primary btn-lg btn-block" href="EventosCategoria.jsp">Politica</a>
                </div>
    <div class="col-lg-3">
                    <a class="btn btn-primary btn-lg btn-block" href="EventosCategoria.jsp">Entretenimiento</a>
                </div>
    
</div>
    <center><h1>Eventos Disponibles</h1></center>
    <%  int numEventos = 0;
        ResultSet rs = null; 
        EventoDAO dao = new EventoDAOImpl();
        rs = dao.obtenerEventosDeAquiAFuturo();
    %>

                           
   
            <%  while(rs.next()){

                    numEventos = numEventos+1;
                }
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
              <!--  <label for="HIni">Hora inicio</label>
                <input type="time" name="HIni" class="form-control">
                <label for="Hter">Hora termino</label>
                <input type="time" name="Hter" class="form-control">
                <label for="Cat">Categoria</label>
                    <select class="custom-select" name="Cat">
                        <option selected>Elija una categoria...</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
              -->
                <label for="Lugar">Lugar</label>
                <select class="custom-select" name="Lugar" value="">
                            <option selected></option>
                            <%
                                try {
                                    LugarDAO ldao = new LugarDAOImpl();
                                    List<String> lista = ldao.listarId();
                                    for (String s: lista) {
                                        %><option value="<%=s%>"><%=s%></option><%
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
                <table class="table ">
                <thead>
                    <th scope="col">Nombre</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Lugar</th>
                </thead>
                <tbody>
                    <%  try{
                            rs.beforeFirst();
                            while(rs.next()){%>
                            <tr class="clickable-row notfirst" data-href="index.html">
                        <td><%=rs.getString("nombre")%></td>
                        <td><%=rs.getString("fecha")%></td>
                        <td><%=rs.getString("es_en")%></td>
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
