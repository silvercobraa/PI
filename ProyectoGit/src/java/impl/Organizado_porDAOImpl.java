package impl;

import controlador.Conexion;
import dao.Organizado_porDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> eventosOrganizadospor(String id_depart) throws Exception {
        List<Integer> list = new ArrayList<Integer>();
        String sqlQuery = "SELECT * FROM pi.organizado_por WHERE id_depart like '?';";        
        PreparedStatement st = null;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sqlQuery);
            st.setString(1,id_depart);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(rs.getInt("id_event"));
            }
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            if( st != null) {
                st.close();
            }
            this.desconectar();
        }       
        return list;  
    }

    
    
}
