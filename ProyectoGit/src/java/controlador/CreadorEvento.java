package controlador;

import impl.EventoDAOImpl;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.EventoDAO;

public class CreadorEvento extends HttpServlet {            

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        DateFormat df = new SimpleDateFormat("HH:mm");
        
        String id = request.getParameter("txtID");
        String nombre = request.getParameter("txtNombre");        
        Date fecha = Date.valueOf(request.getParameter("txtFecha"));
        Time horaInicio = new Time(df.parse(request.getParameter("txtHoraInicio")).getTime());
        Time horaFinal =  new Time(df.parse(request.getParameter("txtHoraTermino")).getTime());
        String descripcion = request.getParameter("txtDescripcion");
        String lugar = request.getParameter("txtLugar");
        String publicador = request.getParameter("txtPublicador");
        
        insertarEventoEnBase(id, nombre, fecha, horaInicio, horaFinal, descripcion, lugar, publicador);
        request.getRequestDispatcher("exitoCrearEvento.jsp").forward(request, response);        
    }
    
    public void insertarEventoEnBase(String id, String nombre, Date fecha, Time horaInicio, Time horaFinal, String descripcion, String lugar, String publicador) throws Exception{
        EventoDAO dao = new EventoDAOImpl();
        try {
             dao.insertarEvento(id, nombre, fecha, horaInicio, horaFinal, descripcion, lugar, publicador);
        }
        catch(SQLException e){
            
        }
       
    
    
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CreadorEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CreadorEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
