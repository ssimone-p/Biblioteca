package org.Bibliotech.DAO;
import org.Bibliotech.Model.Utente;

public interface UtenteDao {
    public boolean checkLogin(String username, String password);
    public boolean addUser(String username, String password);
}
