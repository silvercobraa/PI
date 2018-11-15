
package clases;

import java.sql.Date;
import java.sql.Time;

public class Evento {
    private int id;
    private String nombre;
    private Date fecha;
    private Time horaInicio;
    private Time horaFinal;
    private String descripcion;
    private String id_lugar;
    private String publicador;
    private String id_cat;
    
    public Evento(int id,String nombre,Date fecha, Time horaIni, Time horaFin, String descrip, String id_lug,String publi, String id_cat){
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.horaInicio = horaIni;
        this.horaFinal = horaFin;
        this.descripcion = descrip;
        this.id_lugar = id_lug;
        this.publicador = publi;
        this.id_cat = id_cat;
    }
    
    public Integer getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
     
    public Time getHoraIni() {
        return horaInicio;
    }
    
    public void setHoraIni(Time hora) {
        this.horaInicio = hora;
    }
    
    public Time getHoraFin() {
        return horaFinal;
    }
    
    public void setHoraFin(Time hora) {
        this.horaFinal = hora;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String texto) {
        this.descripcion = texto;
    }   

    public String getLugar() {
        return id_lugar;
    }

    public void setLugar(String lugar) {
        this.id_lugar = lugar;
    }
    
    public String getPublicador() {
        return publicador;
    }

    public void setPublicado(String publi) {
        this.publicador = publi;
    }
    
    public String getCategoria() {
        return id_cat;
    }

    public void setCategoria(String cat) {
        this.id_cat = cat;
    }
}
