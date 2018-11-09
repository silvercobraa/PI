
package impl;

import controlador.Conexion;
import dao.InteresaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

 public class InteresaDAOImpl  extends Conexion implements InteresaDAO{
     
     String idUser;
     String idEvent;
     
     public InteresaDAOImpl(){
     }
     
     
     public void setIdUser(String idUser){
         this.idUser = idUser;
     }
     
     public void setIdEvent(String idEvent){
         this.idEvent = idEvent;
     }
     
     public String getIdUser(){
         return idUser;
     }
     
     public String getIdEvent(){
         return idEvent;
     }

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
    
     @Override
    public Boolean interesado(String idUser, int idEvento) throws Exception{
        String sqlQuery = "SELECT * FROM pi.interesa WHERE id_user = ? AND id_event = ?";
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            this.conectar();
            st = this.conexion.prepareStatement(sqlQuery);
            st.setString(1,idUser);
            st.setInt(2,idEvento);
            rs = st.executeQuery();
            this.desconectar();
            if(rs.next()){
                return true;
            }
            else{
                return false;
            }
        } catch(Exception e){
            Logger.getLogger(InteresaDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}
