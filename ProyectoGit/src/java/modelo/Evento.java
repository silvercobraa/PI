/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author despi
 */
public class Evento {
    
    private int id_event;
    private String nombre;
    private Date fecha;
    private Time hora_ini;
    private Time hora_fin;
    private String descrip;
    private String es_en;
    private String publicador;
    private Date fecha_publicacion;
    private String id_cat;

    
    
    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora_ini(Time hora_ini) {
        this.hora_ini = hora_ini;
    }

    public void setHora_fin(Time hora_fin) {
        this.hora_fin = hora_fin;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public void setEs_en(String es_en) {
        this.es_en = es_en;
    }

    public void setPublicador(String publicador) {
        this.publicador = publicador;
    }

    public void setFecha_publicacion(Date fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public void setId_cat(String id_cat) {
        this.id_cat = id_cat;
    }

    public int getId_event() {
        return id_event;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHora_ini() {
        return hora_ini;
    }

    public Time getHora_fin() {
        return hora_fin;
    }

    public String getDescrip() {
        return descrip;
    }

    public String getEs_en() {
        return es_en;
    }

    public String getPublicador() {
        return publicador;
    }

    public Date getFecha_publicacion() {
        return fecha_publicacion;
    }

    public String getId_cat() {
        return id_cat;
    }
    
    
    
}
