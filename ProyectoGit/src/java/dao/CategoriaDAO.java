package dao;

import java.util.List;

public interface CategoriaDAO {
    
    public List<String> buscarCategorias() throws Exception;
    public List<String> buscarCategoriaEvento(String id_event) throws Exception;
    public List<String> listarId() throws Exception;
}
