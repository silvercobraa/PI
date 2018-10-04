
package modelo;

import java.sql.Date;
import java.sql.Time;

public interface EventoDAO {
    
    public void insertarEvento(String id, String nombre, Date fecha,Time horaInicio, Time horaFin, String descripcion, String lugar, String publicador) throws Exception;
    
    //public List<String> obtenerEventos
        
}
