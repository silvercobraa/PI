package modelo;

import controlador.Conexion;
import java.sql.PreparedStatement;

public class EventoDAOImpl extends Conexion implements EventoDAO{

    @Override
    public void insertarEvento(String id, String nombre, String fecha, String horaInicio, String horaFin, String descripcion, String lugar, String publicador) throws Exception {
        String sqlUpdate = "INSERT INTO pi.evento(id_event,nombre,fecha,hora_ini,hora_fin,descrip,es_en,publicador) VALUES (?,?,?,?,?,?,?,?,?,?,?);";        
        PreparedStatement st = null;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sqlUpdate);
            st.setString(1, id);            
            st.setString(2, nombre);            
            st.setString(3, fecha);            
            st.setString(4, horaInicio);            
            st.setString(5, horaFin);            
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
            return;  
           
    }
    
}
