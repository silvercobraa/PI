package Project;

import DAO.Departamento;
import DAO.DepartamentoDAO;
import DAO.DepartamentoDAOImpl;
        
public class Proyecto {
    
    public static void main(String... mitocode){
        Departamento dep;
        try {
            DepartamentoDAO dao = new DepartamentoDAOImpl();
            dep = dao.buscar("DIICC");
            System.out.println(dep.getNombre());           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }    
}
