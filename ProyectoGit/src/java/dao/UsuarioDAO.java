package dao;

import java.sql.Connection;
import java.sql.ResultSet;

public interface UsuarioDAO {
    public ResultSet entregarDatos();
    public ResultSet eventosSeguidos();
    public ResultSet posiblesEventos();
}
