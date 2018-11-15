package impl;
import controlador.Conexion;
import dao.Organizado_porDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Organizado_porDAOImpl extends Conexion implements Organizado_porDAO {

    @Override
    public void insertarOrganizado_por(String id_depart, int id_event) throws Exception {
        String sqlUpdate = "INSERT INTO pi.organizado_por(id_depart,id_event) VALUES (?,?);";        
        PreparedStatement st = null;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sqlUpdate);            
            st.setString(1, id_depart);            
            st.setInt(2, id_event);
            st.executeUpdate();
        }
        catch(Exception e){
            throw e;
        }
        finally {
            if( st != null) {
                st.close();
            }
            this.desconectar();
        }           
    }

    @Override
    public ResultSet eventosOrganizadospor(String id_depart) throws Exception {
       String sqlQuery = "SELECT * FROM pi.evento WHERE id_event in (SELECT id_event FROM pi.organizado_por WHERE id_depart like '"+id_depart+"') ;";
       Statement st;
       ResultSet rs = null;
       try{
           this.conectar();
           st = this.conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           rs = st.executeQuery(sqlQuery);
       }
       catch (Exception e){
           throw e;
       }
       finally {
           this.desconectar();  
       }       
       return rs;
    }    
}
