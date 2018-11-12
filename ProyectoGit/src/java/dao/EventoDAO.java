package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;

public interface EventoDAO {
    
    public void insertarEvento(String nombre, Date fecha,Time horaInicio, Time horaFin, String descripcion, String lugar, String publicador, String categoria) throws Exception;
   
    public ResultSet obtenerEventosDeAquiAFuturo() throws Exception;   
    
    public ResultSet filtrarEventos(String Nom, String fechaIni, String lugar) throws Exception;
    
    public ResultSet EventosCat(String Cat) throws Exception;
    
    public ResultSet InfoEvento(int ID) throws Exception;
    
    public int buscarIdEvento(String nombre, Date fecha, String lugar) throws Exception;
}
