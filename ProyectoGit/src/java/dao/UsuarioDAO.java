package dao;

import clases.Usuario;
import java.sql.ResultSet;

public interface UsuarioDAO {
    public ResultSet eventosSeguidos(String id) throws Exception;
    public ResultSet posiblesEventos(String id) throws Exception;
    public ResultSet eventosCreados(String id) throws Exception;
    public Usuario buscarPorId(String id) throws Exception;
    public String departamentoUsuario(String id) throws Exception;
}
