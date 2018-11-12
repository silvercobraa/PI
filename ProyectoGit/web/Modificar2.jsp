<%-- 
    Document   : Modificar2
    Created on : 06-11-2018, 18:27:53
    Author     : despi
--%>

<%@page import="impl.LugarDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="dao.LugarDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <% if(Integer.parseInt(request.getParameter("id_event"))!=0&&request.getParameter("nombre")!=null&&request.getParameter("fecha")!=null&&request.getParameter("es_en")!=null&&request.getParameter("hora_ini")!=null&&request.getParameter("hora_fin")!=null)
        
        {    
                        int id_ev = Integer.parseInt(request.getParameter("id_event"));
                        session.setAttribute("id_evento",id_ev);
                        
                    
        
        %>
       
        
        
        <center><h1>Change</h1></center>
        <div class="container">
            <form action ="mod.do" method="post">
               
                <div class="form-row">
                    <div class="col-md-6 mb-3">
                        <label for="txtNombre">Nombre Evento:<%=request.getParameter("nombre")%></label>
                    </div>
                           <div class="col-md-6 mb-3">
                        <input type="String" class="form-control" name="txtNombre" required value="<%=request.getParameter("nombre")%>" required >

                </div>
                <div class="form-row">
                    <div class="col-md-6 mb-3">
                        <label for="txtFecha">Fecha:</label>
                    </div>
                    <div class="col-md-6 mb-3">
                        <input type="date" class="form-control" name="txtFecha" required value="<%=request.getParameter("fecha")%>" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-6 mb-3">
                        <label for="txtHoraInicio">Hora de Inicio:</label>
                    </div>
                    <div class="col-md-6 mb-3">
                        <input type="time" class="form-control" name="txtHoraInicio" required value="<%=request.getParameter("hora_ini")%>" required>
                    </div>
                </div>
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
            </form>
                            <% } %>
    </body>
</html>
