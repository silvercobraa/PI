<<<<<<< HEAD
package dao;


public interface InteresaDAO {
    
    public void usuarioInteresaEvento(String idUser, int idEvento);
}

package dao;


public interface InteresaDAO {
    
    public void usuarioInteresaEvento(String idUser, int idEvento);
    public void usuarioYaNoInteresaEvento(String idUser, int idEvento);
    public Boolean interesado(String idUser,int idEvent) throws Exception;
}
>>>>>>> master
