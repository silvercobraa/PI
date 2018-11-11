package impl;

import controlador.Conexion;
import dao.InteresaDAO;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

 public class InteresaDAOImpl  extends Conexion implements InteresaDAO{

    @Override
    public void usuarioInteresaEvento(String idUser, int idEvento) {
        String sqlUpdate = "INSERT INTO pi.interesa(id_user,id_event) VALUES (?,?)";
        PreparedStatement st = null;
        try{
            this.conectar();
            st = this.conexion.prepareStatement(sqlUpdate);            
            st.setString(1, idUser);            
            st.setInt(2, idEvento);
            st.executeUpdate();
            this.desconectar();
        } catch (Exception ex) {
            Logger.getLogger(InteresaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
