package dao;

import java.sql.ResultSet;

public interface UsuarioDAO {
    public ResultSet entregarDatos(String id) throws Exception;
    public ResultSet eventosSeguidos(String id) throws Exception;
    public ResultSet posiblesEventos(String id) throws Exception;
}
