<%-- 
    Document   : EventosDisponiblesFiltrados
    Created on : 05-10-2018, 15:52:20
    Author     : jorge
--%>


<%@page import="java.util.List"%>
<%@page import="modelo.LugarDAOImpl"%>
<%@page import="modelo.LugarDAO"%>
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
    </head>
    <body>

    <center><h1>Eventos Disponibles</h1></center>
    <%int numEventos = 0;%>
    <%ResultSet rs = null; %>
    <%
        try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://dieespinoza.inf.udec.cl/pi", "pi", "pi4321");
            Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            rs = stm.executeQuery("SELECT p.nombre, p.fecha, p.es_en FROM pi.evento as p WHERE p.fecha >= current_date");
        } catch(Exception e){
            System.out.println(e.getMessage().toString());
        }
    %>
  
    
   

            <%
                while(rs.next()){
                    numEventos = numEventos+1;
                }
            %>
        <h2 align="center">
            Eventos.(<%=numEventos%>) Eventos
            </h2>
        <div class="row" style="margin-left: 15px;margin-right: 15px">
            <div class="col-md-3">
                <h3> filtros </h3>
                <form action="filtrar.do" method="post">
                <label for="BNom">Nombre</label>
                <input type="text" name="BNom" class="form-control">
                <label for="FIni">Fecha inicio</label>
                <input type="date" name="FIni" class="form-control">
                <label for="HIni">Hora inicio</label>
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
                <label for="Lugar">Lugar</label>
                <select class="custom-select" name="Lugar">
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
                <a class="btn btn-primary btn-lg btn-block" style="margin-top: 10px" href="EventosDisponiblesFiltrados.jsp">Filtrar</a>
                </form>
            </div>
            <div class="col-md-9">
            <table class="table table-striped">
                <thead>
                    <th scope="col">Nombre</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Lugar</th>
                </thead>
                <tbody>
                    <%
                        try{
                    %>
                    <%
                        rs.beforeFirst();
                        while(rs.next()){
                    %>
                    <tr>
                        <td><%=rs.getString(1)%></td>
                        <td><%=rs.getString(2)%></td>
                        <td><%=rs.getString(3)%></td>
                    </tr>
                    <%
                            }
                        } catch(Exception e){
                            out.println(e.getMessage().toString());
                        }
                    %>
                </tbody>
            </table>
        </div>
                </div>
                
                
                    
    </body>
</html>

