<%@page import="modelo.EventoDAOImpl"%>
<%@page import="modelo.EventoDAO"%>
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
    <%  int numEventos = 0;
        ResultSet rs = null; 
        EventoDAO dao = new EventoDAOImpl();
        rs = dao.obtenerEventosDeAquiAFuturo();
    %>
    <table width ="600" border ="0" align="center">
        <tr>
            <%  while(rs.next()){
                    numEventos = numEventos+1;
                }
            %>
            Eventos.(<%=numEventos%>) Eventos
            </h2>
            <table class="table">
                <thead>
                    <th scope="col">Nombre</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Lugar</th>
                </thead>
                <tbody>
                    <%  try{
                            rs.beforeFirst();
                            while(rs.next()){%>
                    <tr>
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
    </body>
</html>
