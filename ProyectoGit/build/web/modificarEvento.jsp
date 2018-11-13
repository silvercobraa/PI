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
                <div class="col-lg-3">
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
                <div class="col-lg-2">
                    <a class="btn btn-secondary btn-lg btn-block" href="crearEvento.jsp">Crear</a>
                </div>
                
               
            </div>
        </nav> 
    
    <center><h1>Eventos </h1></center>
    
      <%  
            String id = session.getAttribute("id").toString();
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
                    
                    
   
        <%  rs = user.eventosCreados(id);
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
                        <th scope="col">ID</th>
                       
                        
                    </thead>
                    
                    <tbody>
                    <%  try{
                            rs.beforeFirst();
                            while(rs.next()){%>
                    <tr>
                    
                        <td><%=rs.getString("nombre")%></td>
                        <td><%=rs.getString("fecha")%></td>
                        <td><%=rs.getString("es_en")%></td>
                        <td><%=rs.getString("hora_ini")%></td>
                        <td><%=rs.getString("hora_fin")%></td>
                        <td><%=rs.getString("id_event")%></td>
                        <td><a href="Modificar2.jsp?id_event=<%=rs.getString("id_event")%>&&nombre=<%=rs.getString("nombre")%>&&fecha=<%=rs.getString("fecha")%>&&es_en=<%=rs.getString("es_en")%>&&hora_ini=<%=rs.getString("hora_ini")%>&&hora_fin=<%=rs.getString("hora_fin")%>">Modficar</a></td> 

                    </tr>
                    
                    
                    <%      }
                        }  catch(Exception e){
                            out.println(e.getMessage().toString());
                            }
                        }
                    %>
                    </tbody>
            </table>
    
                    
 
                    <%--<center><h1>Change</h1></center>
        <div class="container">
            <form action ="modificar" method="post">
                  <div class="form-row">
                    <div class="col-md-6 mb-3">
                        <label for="txtNombre">Nombre:</label>
                    </div>
                    <div class="col-md-6 mb-3">
                        <select class="custom-select" name="txtNombre">
                            <option selected>Open this select menu</option>
                            <%
                                try {
                                    UsuarioDAO udao = new UsuarioDAOImpl();
                                    List<String> lista1 = udao.listarEventos(id);
                                    for (String s: lista1) {
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
                <input type ="submit" value ="Modificar" class="btn btn-primary"/> <br/>
            </form> --%>