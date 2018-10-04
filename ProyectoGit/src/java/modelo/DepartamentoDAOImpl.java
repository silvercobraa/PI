package modelo;

import controlador.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAOImpl extends Conexion implements DepartamentoDAO {

    @Override
    public String buscar(String id_dep) throws Exception {
        String nombre = null;
        String sqlQuery = "SELECT * FROM pi.departamento WHERE id_depart =  '"+id_dep+"'  ;";        
        PreparedStatement st = null;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sqlQuery);
            ResultSet rs = st.executeQuery();
            rs.next();
            nombre = rs.getString("nombre");
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
        return nombre;        
    }

    @Override
    public List<String> listar() throws Exception {
        List<String> list = new ArrayList<String>();
        String sqlQuery = "SELECT * FROM pi.departamento";
        PreparedStatement st = null;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sqlQuery);
            ResultSet rs = st.executeQuery();            
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
                list.add(rs.getString("nombre"));
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
