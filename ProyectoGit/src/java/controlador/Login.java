package controlador;
import clases.Usuario;
import dao.UsuarioDAO;
import impl.UsuarioDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Login", urlPatterns = {"/login.do"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Frameset//EN\" \"http://www.w3.org/TR/html4/frameset.dtd\">");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usu = request.getParameter("usuario");
        String pass = request.getParameter("password");
        HttpSession session = request.getSession();
        UsuarioDAO udao = new UsuarioDAOImpl();
        Usuario usuario = null;
        try {
            usuario = udao.buscarPorId(usu);
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(usuario != null){
            if(pass.equals(usuario.getPass())){
                session.setAttribute("usuario", usu);
                session.setAttribute("id", usuario.getIdUser());
                session.setAttribute("publisher", usuario.getPublisher());
                session.setAttribute("id_depart",usuario.getIdDepart());
                response.sendRedirect("index.jsp");
            }else{
                response.sendRedirect("loginFallo.jsp");
            }   
        }else{
          response.sendRedirect("loginFallo.jsp");  
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
