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

@WebServlet(name = "Interesa", urlPatterns = {"/interesa.do"})
public class Interesa extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        String user = request.getSession().getAttribute("id").toString();
        String idEventoaux = request.getParameter("txtId");
        int idEvento = Integer.parseInt(idEventoaux);
        usuarioInteresaEvento(user, idEvento);
        
        request.getRequestDispatcher("EventosDisponibles.jsp").forward(request, response); 
        }
    public void usuarioInteresaEvento(String idUser, int idEvento) throws Exception{
        InteresaDAO dao = new InteresaDAOImpl();
        try{
            if(dao.interesado(idUser, idEvento) == false){
                dao.usuarioInteresaEvento(idUser, idEvento);
            }
            else{
                dao.usuarioYaNoInteresaEvento(idUser, idEvento);
            }
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
