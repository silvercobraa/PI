package impl;

import clases.Usuario;
import java.sql.ResultSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UsuarioDAOImplTest {
    
    private Usuario user;
    
    @Before
    public void setUp() {
        user = new Usuario();
        user.setIdUser("usuarioTest");
        user.setPass("password");
        user.setNombre("usuarioTester");
        user.setApellido1("apellido1");
        user.setApellido2("apellido2");
        user.setCorreo("usertest@test.cl");
        user.setIdDepart("d1");
        user.setPublisher(true);
    }
    
    @After
    public void tearDown() {
        
        
    }

    @Test
    public void testEntregarDatos() throws Exception {
        
        
    }

    @Test
    public void testEventosSeguidos() throws Exception {

    }

    @Test
    public void testPosiblesEventos() throws Exception {

    }

    @Test
    public void testBuscarPorId() throws Exception {

    }

    @Test
    public void testDepartamentoUsuario() throws Exception {

    }
    
}
