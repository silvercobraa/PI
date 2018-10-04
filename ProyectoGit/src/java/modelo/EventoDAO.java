
package modelo;

import java.sql.Date;

public interface EventoDAO {
    
    public void insertarEvento(String id, String nombre, Date fecha, String horaInicio, String horaFin, String descripcion, String lugar, String publicador) throws Exception;
    
    //public List<String> obtenerEventos
        
}
