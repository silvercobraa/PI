package impl;

import dao.UsuarioDAO;
import java.sql.ResultSet;
import controlador.Conexion;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAOImpl extends Conexion implements UsuarioDAO{

    @Override
    public ResultSet entregarDatos(String id) throws  Exception {
        String sqlQuey = "SELECT * FROM pi.usuario WHERE id_user = '"+id+"'";
        Statement st = null;
        ResultSet rs = null;
        try{
            this.conectar();
            st = this.conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sqlQuey);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            this.desconectar();
        }
        return rs;
    }

    @Override
    public ResultSet eventosSeguidos(String id) throws Exception {
        ResultSet rs = null;
        String sqlQuery = "SELECT e.nombre, e.fecha, e.es_en FROM pi.evento as e, pi.usuario as u, pi.interesa as i WHERE u.id_user = '"+id+"' AND u.id_user = i.id_user AND e.id_event = i.id_event AND e.fecha >= current_date";
        Statement st = null;
        try{
            this.conectar();
            st = this.conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sqlQuery);
        } catch(Exception e){
             Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            this.desconectar();
        }
        return rs;
    }

    @Override
    public ResultSet posiblesEventos(String id) throws Exception {
        ResultSet rs = null;
        String sqlQuery = "SELECT DISTINCT e.nombre, e.fecha, e.es_en FROM pi.evento as e, pi.usuario as u, pi.organizado_por as o WHERE u.id_user = '"+id+"' AND u.id_depart = o.id_depart AND e.id_event = o.id_event AND e.fecha >= current_date";
        Statement st = null;
        try{
            this.conectar();
            st = this.conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sqlQuery);
        } catch(Exception e){
             Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            this.desconectar();
        }
        return rs;
    }    
}
