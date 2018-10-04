
package clases;


public class Evento {
    private String id;
    private String nombre;
    private String fecha;
    private String horaInicio;
    private String horaFinal;
    private String descripcion;
    private String lugar;
    private String publicador;
        
    public Evento( String id,String nombre,String fecha,String horaInicio,String horaFinal,String descripcion,String lugar,String publicador){
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.publicador = publicador;       
}

    public String getId() {
        return id;
    }
    public String getFecha() {
        return fecha;
    }
    public String getHoraInicio() {
        return horaInicio;
    }
    public String getHoraFin() {
        return horaFinal;
    }
    public String getLugar() {
        return lugar;
    }
    public String getPublicador() {
        return publicador;
    }
    public String getNombre() {
        return nombre;
    }    
    public String getDescripcion() {
        return descripcion;
    }   
    
}
