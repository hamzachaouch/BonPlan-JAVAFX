/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 *
 * @author Nassreddine
 */
public class Client extends User
{
    int note;

    public Client(int id, String username, String email, String password, 
            String role) {
        super(id, username, email, password, role);
    }

    public Client(String username, String email, String password ) {
        super(username, email, password);
    }

    
}

