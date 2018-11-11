package dao;

import java.sql.ResultSet;

public interface Organizado_porDAO {
    
    public void insertarOrganizado_por(String id_depart, int id_event) throws Exception;
    public ResultSet eventosOrganizadospor(String id_depart) throws Exception;    
}
