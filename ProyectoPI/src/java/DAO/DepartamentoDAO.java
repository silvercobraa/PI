package DAO;

import java.util.List;

public interface DepartamentoDAO {

   public String buscar(String id_dep) throws Exception;   
   public List<String> listar() throws Exception;       

}
