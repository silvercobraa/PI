package DAO;

import java.util.List;

public interface DepartamentoDAO {

   //public void insertar(Departamento dep) throws Exception;
   //public void borrar(Departamento dep) throws Exception;
   //public void actualizar(Departamento dep) throws Exception;
   public Departamento buscar(String id_dep) throws Exception;   
   public List<Departamento> listar() throws Exception;       

}
