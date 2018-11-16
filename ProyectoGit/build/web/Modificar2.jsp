<%-- 
    Document   : Modificar2
    Created on : 06-11-2018, 18:27:53
    Author     : despi
--%>

<%@page import="clases.Lugar"%>
<%@page import="impl.LugarDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="dao.LugarDAO"%>
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
                <div class="col-lg-2">
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
                <% if(session.getAttribute("publisher").equals(true) ){ %>
                <div class="col-lg-3">                    
                    <a class="btn btn-secondary btn-lg btn-block" href="crearEvento.jsp">Crear</a>
                </div>
                   <%          }      %>  
                <%
                    if (session.getAttribute("usuario") != null) {
                %>
                <div class="col-lg-2">
                    <a class="btn btn-secondary btn-lg btn-block" href="crearEvento.jsp">Logout</a>
                </div>
                <%
                    } else {
                %>
                <div class="col-lg-2">
                    <a class="btn btn-secondary btn-lg btn-block" href="login.html">Login</a>
                </div>
                <%
                    }
                %>  
            </div>
        </nav>
    
        
        <% if(Integer.parseInt(request.getParameter("id_event"))!=0&&request.getParameter("nombre")!=null&&request.getParameter("fecha")!=null&&request.getParameter("es_en")!=null&&request.getParameter("hora_ini")!=null&&request.getParameter("hora_fin")!=null)
        
        {    
                        int id_ev = Integer.parseInt(request.getParameter("id_event"));
                        session.setAttribute("id_evento",id_ev);
                     
                        
                    
        
        %>
       
        
       
        <center><h1>Modificar Evento</h1></center>
        <div class="container">
            <form action ="mod.do" method="post">
               
                   <div class="center">
                    <div class="col-md-6">
                            <label for="txtNombre">Nombre Evento: <%=request.getParameter("nombre")%></label>
                    </div>
                           <div class="col-md-6">
                        <input type="String" class="form-control" name="txtNombre" required value="<%=request.getParameter("nombre")%>" required >
                                    
                        <br>
                <div class="form-row">
                    <div class="col-md-6 ">
                        <label for="txtFecha">Fecha:</label>
                    </div>
                    <div class="col-md-6">
                        <input type="date" class="form-control" name="txtFecha" required value="<%=request.getParameter("fecha")%>" required>
                    </div>
                </div>
                    <br>    
                <div class="form-row">
                    <div class="col-md-6 mb-3">
                        
                        <label for="txtHoraInicio">Hora de Inicio:</label>
                    </div>
                    <div class="col-md-6 mb-3">
                        <input type="time" class="form-control" name="txtHoraInicio" required value="<%=request.getParameter("hora_ini")%>" required>
                    </div>
                </div>
                    <br>
                <div class="form-row">
                    <div class="col-md-6 mb-3">
                        <label for="txtHoraTermino">Hora de Término:</label>
                    </div>
                    <div class="col-md-6 mb-3">
                        <input type="time" class="form-control" name="txtHoraTermino" required value="<%=request.getParameter("hora_fin")%>" required>
                    </div>
                </div>
              
                <div class="form-row">
                    <div class="col-md-6 mb-3">
                        <label for="txtLugar">Lugar:</label>
                    </div>
                     <div class="col-md-6 mb-3">
                        <select class="custom-select" name="txtLugar" required>
                            <%  LugarDAO daol = new LugarDAOImpl();
                                String id_place = request.getParameter("es_en");
                                String lugar_actual = daol.buscarEdificio(id_place) +"-"+daol.buscarAula(id_place);
                            %>
                            <option selected value="<%=id_place%>"><%=lugar_actual%></option>
                            <%
                                try {
                                    LugarDAO ldao = new LugarDAOImpl();
                                    List<Lugar> lista = ldao.listarLugares();
                                    for (Lugar lugar: lista) {
                                        if(!lugar.getId().equals(id_place)){                                       
                                        %><option value="<%=lugar.getId()%>" required><%=lugar.getEdificio() + " - " + lugar.getAula()%></option><%
                                        }
                                    }
                                }
                                catch(Exception e){
                                    out.println(e.getMessage().toString());
                                }
                            %>

                        </select>
                    </div>

                </div>
                <input type ="submit" value ="Modificar" class="btn btn-primary"/>
                <a class="btn btn-secondary" href="modificarEvento.jsp">Cancelar</a>
                <br/>
            </form>
                            <% } %>
    </body>
</html>
