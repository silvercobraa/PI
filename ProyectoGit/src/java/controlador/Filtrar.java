/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.util.Collections.list;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.EventoDAOImpl;

/**
 *
 * @author jorge
 */
public class Filtrar extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        String Nom = request.getParameter("BNom");
       /** String aux = request.getParameter("FIni");
        Date FInicio = null;
        if(!"".equals(aux)){
        FInicio = Date.valueOf(aux);
        }
        String horaAux = request.getParameter("HIni");
        DateFormat df = new SimpleDateFormat("HH:mm");
        Time horaInicio = new Time(df.parse(horaAux).getTime());
        String horaAux2 = request.getParameter("HFin");
        Time horaFinal = new Time(df.parse(horaAux2).getTime());
        String Categoria = request.getParameter("Cat");
        String lugar = request.getParameter("Lugar");
        **/
        if (!Nom.equals("")){
            List<EventoDAOImpl> Eventos = new LinkedList<>();
            ResultSet rs = null;
            try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://dieespinoza.inf.udec.cl/pi", "pi", "pi4321");
            Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            System.out.print("nombre:"+Nom);
            String query = "SELECT p.nombre, p.fecha, p.es_en FROM pi.evento as p WHERE p.nombre LIKE '%"+ Nom +"%'";
            rs = stm.executeQuery(query);
            EventoDAOImpl evento;
            while(rs.next()){
                evento = new EventoDAOImpl();
                evento.setNombre(rs.getString("nombre"));
                evento.setFecha(rs.getDate("fecha"));
                evento.setLugar(rs.getString("es_en"));
                System.out.print("nombre evento:"+evento.getNombre());
                Eventos.add(evento);
            }
            
        } catch(Exception e){
            System.out.println(e.getMessage().toString());
        }
            
            request.setAttribute("eventos", Eventos);
            request.getRequestDispatcher("EventosDisponiblesFiltrados.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("EventosDisponibles.jsp").forward(request, response);
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
        } catch (ParseException ex) {
            Logger.getLogger(Filtrar.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(Filtrar.class.getName()).log(Level.SEVERE, null, ex);
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
