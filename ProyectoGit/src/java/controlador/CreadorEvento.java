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
import dao.Organizado_porDAO;
import dao.UsuarioDAO;
import impl.Organizado_porDAOImpl;
import impl.UsuarioDAOImpl;
import java.sql.ResultSet;
import javax.servlet.http.HttpSession;

public class CreadorEvento extends HttpServlet {            

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        DateFormat df = new SimpleDateFormat("HH:mm");        
        String nombre = request.getParameter("txtNombre");        
        Date fecha = Date.valueOf(request.getParameter("txtFecha"));
        Time horaInicio = new Time(df.parse(request.getParameter("txtHoraInicio")).getTime());
        Time horaFinal =  new Time(df.parse(request.getParameter("txtHoraTermino")).getTime());
        String descripcion = request.getParameter("txtDescripcion");
        String lugar = request.getParameter("txtLugar");
        String publicador = request.getParameter("txtPublicador");
        String categoria = request.getParameter("txtCategoria");
        
        insertarEventoEnBase(nombre, fecha, horaInicio, horaFinal, descripcion, lugar, publicador, categoria);
        request.getRequestDispatcher("exitoCrearEvento.jsp").forward(request, response);        
    }
    
    public void insertarEventoEnBase(String nombre, Date fecha, Time horaInicio, Time horaFinal, String descripcion, String lugar, String publicador, String categoria) throws Exception{
        UsuarioDAO daou = new UsuarioDAOImpl();
        EventoDAO dao = new EventoDAOImpl();
        Organizado_porDAO daorg = new Organizado_porDAOImpl();       
        try {
            dao.insertarEvento(nombre, fecha, horaInicio, horaFinal, descripcion, lugar, publicador, categoria);
            int idEvento = dao.buscarIdEvento(nombre, fecha, lugar);
            String id_depart  = daou.departamentoUsuario(publicador);
            daorg.insertarOrganizado_por(id_depart,idEvento);
        }
        catch(SQLException e){
            throw e;
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
