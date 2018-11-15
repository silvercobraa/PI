
<%@page import="impl.CategoriaDAOImpl"%>
<%@page import="impl.CategoriaDAOImpl"%>
<%@page import="dao.CategoriaDAO"%>
<%@page import="clases.Lugar"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.LugarDAO"%>
<%@page import="impl.LugarDAOImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
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
        
        <div class="container">
            <% if (session.getAttribute("usuario") != null) { %>
            <!-- Aunque se esté logueado, solo se muestra el formulario si es un usuario publicador -->
            <!-- <h1><%=session.getAttribute("publisher").toString()%></h1> -->
            <% if ("false".equals(session.getAttribute("publisher").toString())) { %>
            <center><h1> Usted no es usuario publicador </h1></center>
            <% } else { %>
            <center><h1>Crear Evento</h1></center>
            <form action ="creadorevento.do" method="post">
                
               <!-- 
                <div class="form-row">
                    <div class="col-md-6 mb-3">
                       <label for="txtID">ID:</label>
                    </div>
                    <div class="col-md-6 mb-3">
                        <input type="text" class="form-control" name="txtID" required>
                    </div>
                </div>
                -->
                <div class="form-row">
                    <div class="col-md-6 mb-3">
                        <label for="txtNombre">Nombre:</label>
                    </div>
                    <div class="col-md-6 mb-3">
                        <input type="text" class="form-control" name="txtNombre" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-6 mb-3">
                        <label for="txtFecha">Fecha:</label>
                    </div>
                    <div class="col-md-6 mb-3">
                        <input type="date" class="form-control" name="txtFecha" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-6 mb-3">
                        <label for="txtHoraInicio">Hora de Inicio:</label>
                    </div>
                    <div class="col-md-6 mb-3">
                        <input type="time" class="form-control" name="txtHoraInicio" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-6 mb-3">
                        <label for="txtHoraTermino">Hora de Término:</label>
                    </div>
                    <div class="col-md-6 mb-3">
                        <input type="time" class="form-control" name="txtHoraTermino" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-6 mb-3">
                        <label for="txtDescripcion">Descripción:</label>
                    </div>
                    <div class="col-md-6 mb-3">
                        <textarea class="form-control" name="txtDescripcion"></textarea>
                    </div>
                </div>
                
                <div class="form-row">
                    <div class="col-md-6 mb-3">
                        <input type="hidden" name="txtPublicador" value="<%=session.getAttribute("id")%>">
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-6 mb-3">
                        <label for="txtLugar">Lugar:</label>
                    </div>
                    <div class="col-md-6 mb-3">
                        <select class="custom-select" name="txtLugar">
                            <option disabled selected value> -- seleccione una opción -- </option>
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
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-6 mb-3">
                        <label for="txtCategoria">Categoria:</label>
                    </div>
                    <div class ="col-md-6 mb-3">
                        <select class="custom-select" name="txtCategoria">
                            <option disabled selected value> -- seleccione una opción -- </option>
                            <%
                                try {
                                    CategoriaDAO ldao = new CategoriaDAOImpl();
                                    List<String> lista = ldao.listarId();
                                    for (String s: lista) {
                                        %><option value="<%=s%>" required><%=s%></option><%
                                    }
                                }
                                catch(Exception e){
                                    out.println(e.getMessage().toString());
                                }
                            %>
                        </select>
                    </div>
                </div>
                <input type ="submit" value ="Crear" class="btn btn-primary"/> <br/>
            </form>
            <script>
                $(function(){
                    $('[type="date"]').prop('min', function(){
                        return new Date().toJSON().split('T')[0];
                    });
                });
            </script>
        </div>
        <% } } else { %>
        <center><h1>Inicie sesión para continuar</h1></center>
        <% } %>
    </body>
</html>
