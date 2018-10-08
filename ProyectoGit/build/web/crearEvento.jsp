
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
      
      
      
      
        <center><h1>Crear Evento</h1></center>
        <div class="container">
            <form action ="creadorevento.do" method="post">
                <div class="form-row">
                    <div class="col-md-6 mb-3">
                       <label for="txtID">ID:</label>
                    </div>
                    <div class="col-md-6 mb-3">
                        <input type="text" class="form-control" name="txtID" required>
                    </div>
                </div>
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
                        <label for="txtPublicador">Publicador:</label>
                    </div>
                    <div class="col-md-6 mb-3">
                        <input type="text" class="form-control" name="txtPublicador" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-6 mb-3">
                        <label for="txtLugar">Lugar:</label>
                    </div>
                    <div class="col-md-6 mb-3">
                        <select class="custom-select" name="txtLugar">
                            <option selected>Open this select menu</option>
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
    </body>
</html>
