package clases;

import dao.*;
import impl.*;
import java.util.Iterator;
import java.util.List;


public class Prueba {
    
    public static void main(String[] args) throws Exception {
        List<String> p;
        CategoriaDAO dao = new CategoriaDAOImpl();
        p = dao.buscarCategoriasEvento("e2");
        for (Iterator<String> iterator = p.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            System.out.println(next);
        }
        
        
    }
    
    
}
