package DAO;

import java.util.List;

public interface LugarDAO {
        
    public String buscarEdificio(String id_place) throws Exception;
    public String buscarAula(String id_place) throws Exception;
    public List<String> listarAulas(String edificio) throws Exception;
    public List<String> listarEdificios() throws Exception;
    
}