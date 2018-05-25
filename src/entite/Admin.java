/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.InputStream;

/**
 *
 * @author Nassreddine
 */
public class Admin extends User {
 public Admin(int id, String username, String usernameCan, String email, String emailCan,
            int enabled, String salt, String password, String lastLogin, String passwordAt, String role) {
        super(id, username, usernameCan, email, emailCan, enabled, salt, password, 
                lastLogin, passwordAt, role);
    }

   

   

   

    public Admin(int id, String username,  String email, String password, String role) {
        super(id, username,  email, password, role);
    }

    public Admin(int id, String username,  String email, String password) {
        super(id, username, email, password);
    }
}
