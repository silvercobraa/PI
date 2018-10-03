package DAO;

public class Departamento {
    String id_depart;
    String nombre;
    
    public Departamento(String id, String name){
        this.id_depart = id;
        this.nombre = name;
    }
    
    public String getNombre(){
        return this.nombre;
    }
}
