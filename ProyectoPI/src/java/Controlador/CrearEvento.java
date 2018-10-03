package Controlador;

import DAO.EventoDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CrearEvento extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException {
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
            EventoDAOImpl evento = new EventoDAOImpl(id, nombre,fecha,horaInicio,horaFinal,descripcion,lugar,publicador);
            request.getSession().setAttribute("EventoNuevo", evento);
            insertarEventoEnBase(evento.getId(),evento.getNombre(),evento.getFecha(), evento.getHoraInicio(), evento.getHoraFin(),evento.getDescripcion(), evento.getLugar(), evento.getPublicador());
            request.getRequestDispatcher("exitoCrearEvento.jsp").forward(request, response);
        }
    }
    
    public void insertarEventoEnBase(String id, String nombre, String fecha, String horaInicio, String horaFin, String descripcion, String lugar, String publicador) throws SQLException{
        Connection con = null;
        String urlDatabase =  "jdbc:postgresql://plop.inf.udec.cl/bdi2017d";
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(urlDatabase,  "bdi2017d", "bdi2017d");
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println("Ocurrio un error : "+e.getClass().getName() + " " + e.getMessage());
        }
        PreparedStatement stmt = con.prepareStatement("INSERT INTO proyecto.evento VALUES (?,?,?,?,?,?,?,?)");
        String idEvento = id; 
        String nombreEvento = nombre;
        String fechaEvento = fecha;
        String horaInicioEvento = horaInicio;
        String horaFinEvento = horaFin;
        String descripcionEvento = descripcion;
        String lugarEvento = lugar;
        String publicadorEvento = publicador;
        stmt.setString(1, idEvento);
        stmt.setString(2, nombreEvento);
        stmt.setString(3, fechaEvento);
        stmt.setString(4, horaInicioEvento);
        stmt.setString(5, horaFinEvento);
        stmt.setString(6, descripcionEvento);
        stmt.setString(7, lugarEvento);
        stmt.setString(8, publicadorEvento);
        stmt.executeUpdate();
        con.close();
        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CrearEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CrearEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
