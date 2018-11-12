package impl;

import dao.UsuarioDAO;
import java.sql.ResultSet;
import controlador.Conexion;
import dao.Usuario;
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
        Usuario usuario = new Usuario();
        try{
            this.conectar();
            st = this.conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sqlQuery);
            rs.next();
            usuario.setIdUser(rs.getString("id_user"));
            usuario.setPass(rs.getString("pass"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setApellido1(rs.getString("apellido1"));
            usuario.setApellido2(rs.getString("apellido2"));
            usuario.setCorreo(rs.getString("correo"));
            System.out.println(rs.getString("publisher"));
            // por alguna razon rs.getString retorna "t" o "f"
            usuario.setPublisher(rs.getString("publisher").equals("t"));
            // usuario.set(rs.getIdDepart("id_depart"));
        } catch(Exception e){
             Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            this.desconectar();
        }
        return usuario;
    }
}
