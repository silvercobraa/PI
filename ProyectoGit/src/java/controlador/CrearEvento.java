package controlador;

import modelo.EventoDAOImpl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.EventoDAO;

public class CrearEvento extends HttpServlet {  
          

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        String id = request.getParameter("txtID");
        String nombre = request.getParameter("txtNombre");
        String fecha = request.getParameter("txtFecha");
        String horaInicio = request.getParameter("txtHoraInicio");
        String horaFinal = request.getParameter("txtHoraTermino");
        String descripcion = request.getParameter("txtDescripcion");
        String lugar = request.getParameter("txtLugar");
        String publicador = request.getParameter("txtPublicador");
        
        
        if(publicador.equals("") || nombre.equals("") || descripcion.equals("") || id.equals("") || fecha.equals("") || horaInicio.equals("") || horaFinal.equals("") || lugar.equals("")){
            request.getRequestDispatcher("errorCrearEvento.jsp").forward(request, response);
        }
        else{
            insertarEventoEnBase(id, nombre, fecha, horaInicio, horaFinal, descripcion, lugar, publicador);
            request.getRequestDispatcher("exitoCrearEvento.jsp").forward(request, response);
        }
    }
    
       public void insertarEventoEnBase(String id, String nombre, String fecha, String horaInicio, String horaFinal, String descripcion, String lugar, String publicador) throws Exception{
        EventoDAO dao = new EventoDAOImpl();
        dao.insertarEvento(id, nombre, fecha, horaInicio, horaFinal, descripcion, lugar, publicador);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CrearEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CrearEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
