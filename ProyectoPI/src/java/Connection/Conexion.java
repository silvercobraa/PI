package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    protected Connection conexion;
    private final String JDBC_DRIVER = "org.postgresql.Driver";
    private final String DB_URL = "jdbc:postgresql://plop.inf.udec.cl/bdi2017d";
    private final String USER = "bdi2017d";
    private final String PASS = "bdi2017d";
    
    public void conectar() throws Exception{
        try{
            conexion = DriverManager.getConnection(DB_URL,USER,PASS);
            Class.forName(JDBC_DRIVER);          
        }
        catch(ClassNotFoundException | SQLException e){
            throw e;
        }
    }    
    public void desconectar() throws SQLException{
        if(conexion != null){
            if(!conexion.isClosed()){
                conexion.close();
            }
        }
    }    
}
