/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import dao.InteresaDAO;
import impl.InteresaDAOImpl;
import java.io.IOException;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "Seguidos", urlPatterns = {"/seguidos.do"})
public class Seguidos extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        String user = request.getSession().getAttribute("id").toString();
        String idEventoaux = request.getParameter("txtId");
        int idEvento = Integer.parseInt(idEventoaux);
        usuarioNoInteresaEvento(user, idEvento);        
        request.getRequestDispatcher("eventosSeguidos.jsp").forward(request, response); 
        }
    
    public void usuarioNoInteresaEvento(String idUser, int idEvento) throws Exception{
        InteresaDAO dao = new InteresaDAOImpl();
        try{
            dao.usuarioYaNoInteresaEvento(idUser, idEvento);          
        } catch(Exception e){
            out.println(e);
        }        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Interesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Interesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
