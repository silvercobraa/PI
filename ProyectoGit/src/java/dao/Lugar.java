package dao;

public class Lugar {
    private String id;
    private String edificio;
    private String aula;
    public Lugar(String id, String edificio, String aula) {
        this.id = id;
        this.edificio = edificio;
        this.aula = aula;
    }
    public String getId() {
        return this.id;
    }
    public String getEdificio() {
        return this.edificio;
    }
    public String getAula() {
        return this.aula;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }
    
}
