package controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    protected Connection conexion;
    private final String JDBC_DRIVER = "org.postgresql.Driver";
    private final String DB_URL = "jdbc:postgresql://dieespinoza.inf.udec.cl/pi";
    private final String USER = "pi";
    private final String PASS = "pi4321";
    
    public void conectar() throws Exception{
        try{
            Class.forName(JDBC_DRIVER);
            conexion = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("BD Conectada");
        }
        catch(ClassNotFoundException | SQLException e){
            throw e;            
        }
    }    
    public void desconectar() throws SQLException{
        if(conexion != null){
            if(!conexion.isClosed()){
                conexion.close();
                System.out.println("BD Desconectada");        
            }
        }
    }    
}
