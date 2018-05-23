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

    @Override
    public String toString() {
        return super.toString()+"Admis{" + '}';
    }
    
    public Admin(int id, String username, int cin, String prenom, String usernameCan, String email, String emailCan, int enabled, String salt, 
            String password, String lastLogin, String passwordAt, String role, int telphone, InputStream photoprofilpath) {
        super(id, username, cin, prenom, usernameCan, email, emailCan, enabled, salt, password, lastLogin, passwordAt, role, telphone, photoprofilpath);
    }
     public Admin(int id,String username,String prenom, String email,String role, int telephone,InputStream photoprofilpath) {
         super(id,username,prenom,email,role,telephone,photoprofilpath);
       
    }
}
