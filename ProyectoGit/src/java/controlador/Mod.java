/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.EventoDAO;
import impl.EventoDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author despi
 */
public class Mod extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, Exception {
         DateFormat df = new SimpleDateFormat("HH:mm");
       
         HttpSession session = request.getSession();
        int id =  (int) session.getAttribute("id_evento");  
        String nombre = request.getParameter("txtNombre");        
        Date fecha = Date.valueOf(request.getParameter("txtFecha"));
        Time horaInicio = new Time(df.parse(request.getParameter("txtHoraInicio")).getTime());
        Time horaFinal =  new Time(df.parse(request.getParameter("txtHoraTermino")).getTime());
        String lugar = request.getParameter("txtLugar");    
      
        
        
        modificarEventoEnBase(nombre,fecha,horaInicio,horaFinal,lugar,id);
        request.getRequestDispatcher("exitoCrearEvento.jsp").forward(request, response); 
    }
    public void modificarEventoEnBase(String nombre, Date fecha, Time horaInicio, Time horaFinal, String lugar,int id) throws Exception{
         EventoDAO dao = new EventoDAOImpl();
        
        try {
             dao.modificarEvento( nombre, fecha, horaInicio, horaFinal, lugar, id);
        }
        catch(SQLException e){
            
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
            Logger.getLogger(Mod.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Mod.class.getName()).log(Level.SEVERE, null, ex);
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
