package impl;
import dao.UsuarioDAO;
import java.sql.ResultSet;
import controlador.Conexion;
import clases.Usuario;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAOImpl extends Conexion implements UsuarioDAO{

    @Override
    public ResultSet eventosSeguidos(String id) throws Exception {
        ResultSet rs = null;
        String sqlQuery = "SELECT e.nombre, e.fecha, e.es_en, e.id_event FROM pi.evento as e, pi.usuario as u, pi.interesa as i WHERE u.id_user = '"+id+"' AND u.id_user = i.id_user AND e.id_event = i.id_event AND e.fecha >= current_date";
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
        String sqlQuery = "SELECT DISTINCT e.nombre, e.fecha, e.es_en, e.id_event FROM pi.evento as e, pi.usuario as u, pi.organizado_por as o WHERE u.id_user = '"+id+"' AND u.id_depart = o.id_depart AND e.id_event = o.id_event AND e.fecha >= current_date";
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
    public ResultSet eventosCreados(String id) throws Exception {
        ResultSet rs = null;
        String sqlQuery = "SELECT e.id_event, e.nombre, e.fecha,e.hora_ini, e.hora_fin ,e.descrip , e.es_en, e.publicador FROM pi.evento as e, pi.usuario as u WHERE u.id_user = '"+id+"' AND u.id_user = e.publicador AND e.fecha >= current_date";
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
    public Usuario buscarPorId(String id) throws Exception {
        ResultSet rs = null;
        String sqlQuery = "SELECT * FROM pi.usuario WHERE id_user = '"+id+"'";
        Statement st = null;
        Usuario usuario = null;
        try{
            this.conectar();
            st = this.conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sqlQuery);
            rs.next();
            String id_user = rs.getString("id_user");
            String pass = rs.getString("pass");
            String nombre = rs.getString("nombre");
            String apellido1 = rs.getString("apellido1");
            String apellido2 = rs.getString("apellido2");
            String correo = rs.getString("correo");
            boolean publisher = rs.getString("publisher").equals("t");
            String id_depart = rs.getString("id_depart");
            usuario = new Usuario(id_user, pass, nombre, apellido1, apellido2, correo, publisher, id_depart);   
        } catch(Exception e){
             Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            this.desconectar();
        }
        return usuario;
    }
    
    @Override
    public String departamentoUsuario(String id) throws Exception {
        String sqlQuey = "SELECT id_depart FROM pi.usuario WHERE id_user = '"+id+"'";
        Statement st = null;
        ResultSet rs = null;
        String id_depart = null;
        try{
            this.conectar();
            st = this.conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sqlQuey);
            rs.next();
            id_depart = rs.getString("id_depart");
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            this.desconectar();
        }       
        return id_depart;
    }
}
