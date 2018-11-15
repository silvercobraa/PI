package impl;
import controlador.Conexion;
import dao.CategoriaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOImpl extends Conexion implements CategoriaDAO{

    @Override
    public List<String> buscarCategorias() throws Exception {
        List<String> list = new ArrayList<String>();
        String sqlQuery = "SELECT * FROM pi.categoria ;";        
        PreparedStatement st = null;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sqlQuery);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(rs.getString("nombre"));
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

    @Override
    public List<String> buscarCategoriasEvento(String id_event) throws Exception {
        List<String> list = new ArrayList<String>();
        String sqlQuery = "SELECT c.* FROM pi.categoria as c NATURAL JOIN pi.en_cat as d WHERE d.id_event = ?;";        
        PreparedStatement st = null;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sqlQuery);
            st.setString(1, id_event);
            ResultSet rs = st.executeQuery();            
            while(rs.next()){
               list.add(rs.getString("nombre"));
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
    
        @Override
    public List<String> listarId() throws Exception {
        List<String> list = new ArrayList<String>();
        String sqlQuery = "SELECT * FROM pi.categoria;";
        PreparedStatement st = null;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sqlQuery);
            ResultSet rs = st.executeQuery();            
            while(rs.next()){
                list.add(rs.getString("id_cat"));
            }            
        } catch (Exception e) {
            throw e;
        }
        finally {
            if(st != null){
                st.close();
            }
            this.desconectar();
        }        
        return list;     
    }
}
