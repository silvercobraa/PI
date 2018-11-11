package dao;

import java.util.List;

public interface Organizado_porDAO {
    
    public void insertarOrganizado_por(String id_depart, int id_event) throws Exception;
    public List<Integer> eventosOrganizadospor(String id_depart) throws Exception;
    
}
