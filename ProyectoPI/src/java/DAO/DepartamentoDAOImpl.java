package DAO;

import Connection.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DepartamentoDAOImpl extends Conexion implements DepartamentoDAO {

    @Override
    public Departamento buscar(String id_dep) throws Exception {
        Departamento dep = null;
        PreparedStatement st = null;
        String nombre = null;
        String sqlQuery = "SELECT id_depart, nombre FROM proyecto.departamento WHERE id_depart =  '"+id_dep+"'  ;";        
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sqlQuery);
            ResultSet rs = st.executeQuery();
            rs.next();
            nombre = rs.getString("nombre");            
            dep = new Departamento(id_dep, nombre);
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
        return dep;        
    }

    @Override
    public List<Departamento> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
