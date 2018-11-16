<%-- 
    Document   : borrarE
    Created on : 15-11-2018, 19:10:49
    Author     : despi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
          
 <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">¿Esta seguro que quiere eliminar el evento "<%=request.getParameter("nombre")%> " ? </h4>
        </div>
        <div class="modal-body">
          <p>Este cambio no podra ser revertido</p>
        </div>
        <div class="modal-footer">
            
            <form action ="borrarEvento.do" method="post">
                
          
            
            <input type ="submit" value ="Aceptar" class="btn btn-primary"/>
            <a type="button" class="btn btn-default" data-dismiss="modal" href="modificarEvento.jsp">Cancelar</a>
            </form>
        </div>
      </div>
      
    </div>
  
    <% if(Integer.parseInt(request.getParameter("id_event"))!=0&&request.getParameter("nombre")!=null)
        
        {    
                        int id_ev = Integer.parseInt(request.getParameter("id_event"));
                        session.setAttribute("id_evento",id_ev);
                        
                       
                     
                        
        }
        
        %>

  <%--                        
                                        
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>   
        </button>
      </div>
      <div class="modal-body">
          ¿Esta seguro que desea eliminar el evento  " ? :O 
       
   
   
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
         
        <form action ="borrarEvento.do" method="post">   
           
        <input type ="submit" value ="Aceptar" class="btn btn-primary "/>
        </form>
      </div>
    </div>
  </div>
</div>

  --%>
        <form action ="borrarEvento.do" method="post">
       
        </form>
    </body>
</html>
