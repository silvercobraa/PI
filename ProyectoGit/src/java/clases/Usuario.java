package clases;


public class Usuario {
    private String id_user;
    private String pass;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String correo;
    private boolean publisher;
    private String id_depart;
    
    public Usuario(String id, String pass, String nombre, String apellido1, String apellido2, String correo, boolean  publi,String depa) {
        this.id_user = id;
        this.pass = pass;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
        this.publisher = publi;
        this.id_depart = depa;
    }
    
    public String getIdUser() {
        return id_user;
    }

    public void setIdUser(String id_user) {
        this.id_user = id_user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean getPublisher() {
        return publisher;
    }

    public void setPublisher(boolean publisher) {
        this.publisher = publisher;
    }

    public String getIdDepart() {
        return id_depart;
    }

    public void setIdDepart(String id_depart) {
        this.id_depart = id_depart;
    }
}
