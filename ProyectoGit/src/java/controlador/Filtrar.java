package controlador;
import clases.Evento;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import impl.EventoDAOImpl;

public class Filtrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, Exception {
        String filtro_nombre = "";
        String filtro_lugar = "";
        String filtro_fecha = "current_date";        
        String Nom = request.getParameter("BNom");
        String fechaIni = request.getParameter("FIni");
        String lugar = request.getParameter("Lugar");
                   
        if (!Nom.equals("")) {
            filtro_nombre = Nom;
        }
            
        if (!lugar.equals("")) {
            filtro_lugar = lugar;
        }
            
        if (!fechaIni.equals("")) {
            filtro_fecha = "'" + fechaIni + "'";
        }
        
        List<Evento> eventos = new LinkedList<>();
        EventoDAOImpl eventosFiltrar = new EventoDAOImpl();        
        ResultSet rs = eventosFiltrar.filtrarEventos(filtro_nombre,filtro_fecha,filtro_lugar);          
        try {
            Evento evento;
            while(rs.next()){                
                int id = Integer.parseInt(rs.getString("id_event"));
                String nombre = rs.getString("nombre");
                Date fecha = rs.getDate("fecha");
                Time horaInicio = rs.getTime("hora_ini");
                Time horaFinal = rs.getTime("hora_fin");
                String descripcion = rs.getString("descrip");
                String id_lugar = rs.getString("es_en");
                String publicador = rs.getString("publicador");
                String id_cat = rs.getString("id_cat");
                
                evento = new Evento(id, nombre, fecha, horaInicio, horaFinal, descripcion, id_lugar, publicador, id_cat);
                eventos.add(evento);
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
            request.setAttribute("eventos", eventos);
            request.getRequestDispatcher("EventosDisponiblesFiltrados.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Filtrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Filtrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
