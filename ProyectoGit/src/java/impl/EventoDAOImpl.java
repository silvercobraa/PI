package impl;

import dao.EventoDAO;
import controlador.Conexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;

public class EventoDAOImpl extends Conexion implements EventoDAO{
    private String nombre;
    private Date fecha;
    private String lugar;
     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    @Override
    public void insertarEvento(String id, String nombre, Date fecha, Time horaInicio, Time horaFin, String descripcion, String lugar, String publicador) throws Exception {
        String sqlUpdate = "INSERT INTO pi.evento(id_event,nombre,fecha,hora_ini,hora_fin,descrip,es_en,publicador) VALUES (?,?,?,?,?,?,?,?);";        
        PreparedStatement st = null;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sqlUpdate);
            st.setString(1, id);            
            st.setString(2, nombre);            
            st.setDate(3, fecha);
            st.setTime(4, horaInicio);            
            st.setTime(5, horaFin);            
            st.setString(6, descripcion);           
            st.setString(7, lugar);            
            st.setString(8, publicador);            
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
<<<<<<< HEAD:ProyectoGit/src/java/modelo/EventoDAOImpl.java
 
=======

    @Override
    public ResultSet obtenerEventosDeAquiAFuturo() throws Exception{
       String sqlQuery = "SELECT p.* FROM pi.evento as p WHERE p.fecha >= CURRENT_DATE";
       Statement st = null;
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
>>>>>>> master:ProyectoGit/src/java/impl/EventoDAOImpl.java
}


