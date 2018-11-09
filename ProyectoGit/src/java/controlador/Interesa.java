
package controlador;

import dao.InteresaDAO;
import impl.EventoDAOImpl;
import impl.InteresaDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import dao.EventoDAO;
import static java.lang.System.out;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author capro
 */
@WebServlet(name = "Interesa", urlPatterns = {"/interesa.do"})
public class Interesa extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        String user = request.getSession().getAttribute("id").toString();
        String lugar = request.getParameter("txtLugar");
        String nombreEvento = request.getParameter("txtNombre");
        Date fecha = Date.valueOf(request.getParameter("txtFecha"));
        usuarioInteresaEvento(user, nombreEvento, fecha, lugar);
        request.getRequestDispatcher("EventosDisponibles.jsp").forward(request, response); 
        }
    public void usuarioInteresaEvento(String idUser, String nombreEvento, Date fecha, String lugar) throws Exception{
        InteresaDAO dao = new InteresaDAOImpl();
        EventoDAO evento = new EventoDAOImpl();
        int idEvento = evento.buscarIdEvento(nombreEvento, fecha, lugar);
        try{
            dao.usuarioInteresaEvento(idUser, idEvento);
        } catch(Exception e){
            out.println(e);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Interesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Interesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
