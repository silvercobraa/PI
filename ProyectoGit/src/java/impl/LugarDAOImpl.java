package impl;

import dao.LugarDAO;
import clases.Lugar;
import controlador.Conexion;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LugarDAOImpl extends Conexion implements LugarDAO{

    @Override
    public String buscarEdificio(String id_place) throws Exception {
        String edificio = null;
        String sqlQuery = "SELECT * FROM pi.lugar WHERE id_place = '?' ;";        
        PreparedStatement st = null;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sqlQuery);
            st.setString(1,id_place);
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
        String sqlQuery = "SELECT * FROM pi.lugar WHERE id_place =  '?'  ;";        
        PreparedStatement st = null;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sqlQuery);
            st.setString(1,id_place);
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
    @Override
    public List<Lugar> listarLugares() throws Exception {
        List<Lugar> list = new ArrayList<Lugar>();
        String sqlQuery = "SELECT * FROM pi.lugar;";
        PreparedStatement st = null;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sqlQuery);
            ResultSet rs = st.executeQuery();            
            while(rs.next()){
                String id = rs.getString("id_place");
                String edificio = rs.getString("edificio");
                String aula = rs.getString("aula");
                Lugar lugar = new Lugar(id, edificio, aula);
                list.add(lugar);
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
    public Lugar buscarId(String id) throws Exception {
        ResultSet rs = null;
        String sqlQuery = "SELECT * FROM pi.lugar WHERE id_place = '"+id+"'";
        Statement st = null;
        Lugar lugar = null;
        try{
            this.conectar();
            st = this.conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sqlQuery);
            rs.next();
            lugar = new Lugar(rs.getString("id_place"), rs.getString("edificio"), rs.getString("aula"));
        } catch(Exception e){
             Logger.getLogger(LugarDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            this.desconectar();
        }
        return lugar;
    }
}
