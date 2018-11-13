package impl;

import dao.EventoDAO;
import controlador.Conexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public class EventoDAOImpl extends Conexion implements EventoDAO{

    @Override
    public void insertarEvento(String nombre, Date fecha, Time horaInicio, Time horaFin, String descripcion, String lugar, String publicador, String categoria) throws Exception {
        String sqlUpdate = "INSERT INTO pi.evento(nombre,fecha,hora_ini,hora_fin,descrip,es_en,publicador,id_cat) VALUES (?,?,?,?,?,?,?,?);";        
        PreparedStatement st = null;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sqlUpdate);            
            st.setString(1, nombre);            
            st.setDate(2, fecha);
            st.setTime(3, horaInicio);            
            st.setTime(4, horaFin);            
            st.setString(5, descripcion);           
            st.setString(6, lugar);            
            st.setString(7, publicador); 
            st.setString(8, categoria);
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
    public ResultSet obtenerEventosDeAquiAFuturo() throws Exception{
       String sqlQuery = "SELECT p.* FROM pi.evento as p WHERE p.fecha >= CURRENT_DATE order BY p.fecha";
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
    @Override
    public ResultSet EventosCat(String Cat) throws Exception{
        ResultSet rs=null;
        try{
            this.conectar();
            String query = "SELECT p.nombre, p.fecha, p.es_en, p.id_event FROM pi.evento as p WHERE p.id_cat='" + Cat+"'";
            System.out.println(query);
            Statement stm = this.conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(query);
        }
        catch(SQLException e) {
            throw e;
        }
        finally{
            this.desconectar();
        }
        return rs;
    }
    @Override
    public ResultSet filtrarEventos(String filtro_nombre, String filtro_fecha, String filtro_lugar) throws Exception {
        ResultSet rs = null;
        try{
            this.conectar();
            String query = "SELECT * FROM pi.evento as p WHERE p.nombre LIKE '%" + filtro_nombre + "%' AND p.fecha >= " + filtro_fecha + " AND p.es_en LIKE '%" + filtro_lugar +"%'";
            System.out.println(query);
            Statement stm = this.conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(query);
        } 
        catch(SQLException e) {
            throw e;
        }
        finally {
            this.desconectar();
        }
        return rs;
    }
    public ResultSet InfoEvento(int ID) throws Exception{
        ResultSet rs = null;
        try{
            this.conectar();
            String query = "SELECT * FROM pi.evento as p WHERE p.id_event='"+ID+"'";
            System.out.println(query);
            Statement stm = this.conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(query);
        } 
        catch(SQLException e) {
            throw e;
        }
        finally {
            this.desconectar();
        }
        return rs;
    

    }
    
    @Override
    public int buscarIdEvento(String nombre, Date fecha, String lugar) throws Exception{
        int idEvento = 0;
        String sqlQuery = "SELECT * FROM pi.evento WHERE nombre =  ? AND fecha = ? AND es_en = ? ;";        
        PreparedStatement st = null;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sqlQuery);
            st.setString(1,nombre);
            st.setDate(2,fecha);
            st.setString(3, lugar);
            ResultSet rs = st.executeQuery();
            rs.next();
            idEvento = rs.getInt("id_event");
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

        return idEvento; 
    }



@Override
    public void modificarEvento(String nombre, Date fecha, Time horaInicio, Time horaFin, String lugar, int id) throws Exception {
        String sqlUpdate = "UPDATE pi.evento SET nombre=?,fecha=?, hora_ini=?, hora_fin=?, es_en=?  where id_event =?";        
        PreparedStatement st = null;    
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sqlUpdate);
            
            st.setString(1,nombre);
            st.setDate(2, fecha);
            st.setTime(3, horaInicio);            
            st.setTime(4, horaFin);                       
            st.setString(5, lugar);
              st.setInt(6, id);
            st.executeUpdate();
        }
        catch(SQLException e){
            throw e;
        }
        finally {
            if( st != null) {
                st.close();
            }
            this.desconectar();
        }
    }
}