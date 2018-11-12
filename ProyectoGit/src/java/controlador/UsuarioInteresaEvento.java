
package controlador;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.PreparedStatement;


public class UsuarioInteresaEvento extends Conexion{
    
    public UsuarioInteresaEvento(){
        
    }
    
    public void usuarioInteresa(String idUser, String idEvento) throws Exception{
        String sqlUpdate = "INSERT INTO pi.interesa(id_user, id_event) VALUES(?,?)";
        PreparedStatement st = null;
        try{
            this.conectar();
            st = this.conexion.prepareStatement(sqlUpdate);   
            st.setString(1,idUser);
            st.setString(2, idEvento);
            st.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
