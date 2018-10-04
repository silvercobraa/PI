
package modelo;

public interface EventoDAO {
    
    public void insertarEvento(String id, String nombre, String fecha, String horaInicio, String horaFin, String descripcion, String lugar, String publicador) throws Exception;
    
}
