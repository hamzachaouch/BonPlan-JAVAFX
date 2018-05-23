/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entite.Admin;
import entite.Client;
import entite.User;
import java.util.List;

/**
 *
 * @author Nassreddine
 */
public interface UserInterface {
   public Client FindClientById(String id);
    public Admin FindAdmintById(String id);
    public   User Authentification(String login , String password);
    void adduser(Client c);
    public List<User> selectAllUser();
    void updateUserClient(Client c);
    void updateUserAdmin(Admin a); 
}
