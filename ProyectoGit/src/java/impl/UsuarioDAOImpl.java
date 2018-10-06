
package impl;

import dao.UsuarioDAO;
import java.sql.ResultSet;
import controlador.Conexion;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAOImpl extends Conexion implements UsuarioDAO{

    public UsuarioDAOImpl() {
    }

    
    
    
    @Override
    public ResultSet entregarDatos() {
        String datos = "SELECT nombre,apellido1, apellido2,correo FROM pi.usuario WHERE id_user = 'cscholtz'";
        Statement st = null;
        ResultSet rs = null;
        try{
            this.conectar();
            st = this.conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(datos);
            this.desconectar();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    @Override
    public ResultSet eventosSeguidos() {
        ResultSet rs = null;
        String sqlConsulta = "SELECT e.nombre, e.fecha, e.es_en FROM pi.evento as e, pi.usuario as u, pi.interesa as i WHERE u.id_user = i.id_user AND e.id_event = i.id_event AND e.fecha >= current_date";
        Statement st = null;
        try{
            this.conectar();
            st = this.conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sqlConsulta);
            this.desconectar();
        } catch(Exception e){
             Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return rs;
    }

    @Override
    public ResultSet posiblesEventos() {
        ResultSet rs = null;
        String sqlConsulta = "SELECT DISTINCT e.nombre, e.fecha, e.es_en FROM pi.evento as e, pi.usuario as u, pi.organizado_por as o WHERE u.id_depart = o.id_depart AND e.id_event = o.id_event AND e.fecha >= current_date";
        Statement st = null;
        try{
            this.conectar();
            st = this.conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sqlConsulta);
            this.desconectar();
        } catch(Exception e){
             Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return rs;
    }
    
    
}
