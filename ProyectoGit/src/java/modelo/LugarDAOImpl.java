package modelo;

import controlador.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LugarDAOImpl extends Conexion implements LugarDAO{

    @Override
    public String buscarEdificio(String id_place) throws Exception {
        String edificio = null;
        String sqlQuery = "SELECT * FROM pi.lugar WHERE id_place =  '"+id_place+"'  ;";        
        PreparedStatement st = null;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sqlQuery);
            ResultSet rs = st.executeQuery();
            rs.next();
            edificio = rs.getString("edificio");
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
        return edificio;        
    }

    @Override
    public String buscarAula(String id_place) throws Exception {
        String aula = null;
        String sqlQuery = "SELECT * FROM pi.lugar WHERE id_place =  '"+id_place+"'  ;";        
        PreparedStatement st = null;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sqlQuery);
            ResultSet rs = st.executeQuery();
            rs.next();
            aula = rs.getString("aula");
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
        return aula;   
    }

    @Override
    public List<String> listarAulas(String edificio) throws Exception {
        List<String> list = new ArrayList<String>();
        String sqlQuery = "SELECT * FROM pi.lugar WHERE edificio = '?'";
        PreparedStatement st = null;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sqlQuery);
            st.setString(1, edificio);            
            ResultSet rs = st.executeQuery();            
            while(rs.next()){
                System.out.println(rs.getString("aula"));
                list.add(rs.getString("aula"));
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

    @Override
    public List<String> listarEdificios() throws Exception {
        List<String> list = new ArrayList<String>();
        String sqlQuery = "SELECT * FROM pi.lugar;";
        PreparedStatement st = null;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sqlQuery);
            ResultSet rs = st.executeQuery();            
            while(rs.next()){
                list.add(rs.getString("edificio"));
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
    @Override
    public List<String> listarId() throws Exception {
        List<String> list = new ArrayList<String>();
        String sqlQuery = "SELECT * FROM pi.lugar;";
        PreparedStatement st = null;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sqlQuery);
            ResultSet rs = st.executeQuery();            
            while(rs.next()){
                list.add(rs.getString("id_place"));
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
