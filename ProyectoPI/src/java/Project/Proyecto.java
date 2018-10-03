package Project;

import DAO.DepartamentoDAO;
import DAO.DepartamentoDAOImpl;
        
public class Proyecto {
    
    public static void main(String... mitocode){
        
        try {
            DepartamentoDAO dao = new DepartamentoDAOImpl();
            System.out.println(dao.buscar("DIICC"));            
            System.out.println("////");            
            System.out.println(dao.listar().iterator());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }    
}
