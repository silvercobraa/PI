package TestingDAOImpl;

import clases.Usuario;
import impl.UsuarioDAOImpl;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class TestingUsuarioDAOImpl {
    protected Connection conexion;
    private final String JDBC_DRIVER = "org.postgresql.Driver";
    private final String DB_URL = "jdbc:postgresql://dieespinoza.inf.udec.cl/pi";
    private final String USER = "pi";
    private final String PASS = "pi4321";
    private String user = "testUser";
    private String pass = "123456";
    private String nombre = "Tester";
    private String apellido1 = "Teston";
    private String apellido2 = "Testudo";
    private String correo = "tester@test.cl";
    private boolean publi = true;
    private String depa = "d1";

   
    @Before
    public void setUp() throws SQLException, ClassNotFoundException {
        try{
            Class.forName(JDBC_DRIVER);
            conexion = DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement st = conexion.prepareStatement("INSERT INTO pi.usuario(id_user,pass,nombre,apellido1,apellido2,correo,publisher,id_depart) values (?,?,?,?,?,?,?,?)");
            st.setString(1, user);            
            st.setString(2, pass);
            st.setString(3, nombre);            
            st.setString(4, apellido1);            
            st.setString(5, apellido2);           
            st.setString(6, correo);            
            st.setBoolean(7, publi); 
            st.setString(8, depa); 
            st.executeUpdate();
            
            st = conexion.prepareStatement("INSERT INTO pi.evento(id_event,nombre,fecha,hora_ini,hora_fin,descrip,es_en,publicador,id_cat) values (999499,'eventoTest','2018-11-12','06:00','7:00','descripcion test','id_lug1',?,null)");
            st.setString(1, user);
            st.executeUpdate();
            
            st = conexion.prepareStatement("INSERT INTO pi.interesa(id_user,id_event) VALUES (?,999499)");
            st.setString(1, user);
            st.executeUpdate();
        }
        catch(Exception e){
            throw e;            
        }       
    }
    
    @After
    public void tearDown() throws SQLException {
        
        try {
            PreparedStatement st = conexion.prepareStatement("DELETE FROM pi.interesa WHERE pi.interesa.id_user = ?; DELETE FROM pi.usuario WHERE pi.usuario.id_user = ?; DELETE FROM pi.evento WHERE id_event = 999499;");
            st.setString(1, user);
            st.setString(2, user);
            st.executeUpdate();
            
        } catch (Exception ex) {
            throw ex;
        }
        finally{
            if(conexion != null){
                if(!conexion.isClosed()){
                    conexion.close(); 
            }
        }
        }   
    }
    
    @Test
    public void testBuscarPorId() throws Exception {
        UsuarioDAOImpl instance = new UsuarioDAOImpl();
        Usuario result = instance.buscarPorId(user);        
        assertEquals(user, result.getIdUser());
        assertEquals(nombre, result.getNombre());
        assertEquals(pass, result.getPass());
        assertEquals(apellido1, result.getApellido1());
        assertEquals(apellido2, result.getApellido2());
        assertEquals(correo, result.getCorreo());
        assertEquals(publi, result.getPublisher());
        assertEquals(depa, result.getIdDepart());
        System.out.println("buscarPorId Completo");
    }
    
    @Test
    public void testDepartamentoUsuario() throws Exception {
        UsuarioDAOImpl instance = new UsuarioDAOImpl();        
        String result = instance.departamentoUsuario(user);
        assertEquals(depa, result);
        System.out.println("DepartamentoUsuario Completo");
    }


    @Test
    public void testEventosSeguidos() throws Exception {
        UsuarioDAOImpl instance = new UsuarioDAOImpl();
        ResultSet result = instance.eventosSeguidos(user);
        result.next();        
        assertEquals("eventoTest", result.getString("nombre"));
        assertEquals(Date.valueOf("2018-11-12"), result.getDate("fecha"));
        assertEquals("id_lug1",result.getString("es_en"));
        System.out.println("eventosSeguidos Completo");
    }
/*
    @Test
    public void testPosiblesEventos() throws Exception {
        System.out.println("posiblesEventos");
        String id = "";
        UsuarioDAOImpl instance = new UsuarioDAOImpl();
        ResultSet expResult = null;
        ResultSet result = instance.posiblesEventos(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
 */



  
}
