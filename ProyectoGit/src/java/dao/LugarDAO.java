package dao;

import clases.Lugar;
import java.util.List;

public interface LugarDAO {
        
    public String buscarEdificio(String id_place) throws Exception;
    public String buscarAula(String id_place) throws Exception;
    public List<String> listarAulas(String edificio) throws Exception;
    public List<String> listarEdificios() throws Exception;
    public List<String> listarId() throws Exception;
    public List<Lugar> listarLugares() throws Exception;
    public Lugar buscarId(String id) throws Exception;
}