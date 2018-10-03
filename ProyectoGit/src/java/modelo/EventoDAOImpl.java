/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author cprovoste
 */
public class EventoDAOImpl implements EventoDAO{
    
    private String id;
    private String nombre;
    private String fecha;
    private String horaInicio;
    private String horaFin;
    private String descripcion;
    private String lugar;
    private String publicador;
    private String fechaPublicacion;

    public EventoDAOImpl(String id, String nombre, String fecha, String horaInicio, String horaFin, String descripcion, String lugar, String publicador) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.publicador = publicador;
        this.fechaPublicacion = fechaPublicacion;
    }

    
    
    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getFecha() {
        return fecha;
    }

    @Override
    public String getHoraInicio() {
        return horaInicio;
    }

    @Override
    public String getHoraFin() {
        return horaFin;
    }

    @Override
    public String getLugar() {
        return lugar;
    }

    @Override
    public String getPublicador() {
        return publicador;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }
    
}
