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
    private int note;
    private int nbAvis;
    
    public Client(String username, int cin, String prenom, String usernameCan, String email, String emailCan, 
            int enabled, String salt, String password, String lastLogin, String passwordAt, String role, int telphone,
            InputStream photoprofilpath, int note, int nbAvis) {
        super(username, cin, prenom, usernameCan, email, emailCan, enabled, salt, password, lastLogin, passwordAt, role,
                telphone, photoprofilpath);
        this.note=note;
        this.nbAvis=nbAvis;
    }
    public Client(String username, int cin, String prenom, String usernameCan, String email, String emailCan, 
            int enabled, String salt, String password, String lastLogin, String passwordAt, String role, int telphone,
            FileInputStream photoprofilpath) {
        super(username, cin, prenom, usernameCan, email, emailCan, enabled, salt, password, lastLogin, passwordAt, role,telphone,photoprofilpath);
    }
    public Client(int id,String username,String prenom, String email,String role, int telephone, InputStream photoprofilpath,int note){
       super(id,username,prenom,email,role,telephone,photoprofilpath);
        this.note=note;
    }

    public Client(String username, String prenom, String email, String password, int telphone, InputStream photoprofilpath) {
        super(username, prenom, email, password, telphone, photoprofilpath);
    }
    
    @Override
    public String toString() {
        return super.toString()+ "Client{" + "note=" + note + ", nbAvis=" + nbAvis + '}';
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getNbAvis() {
        return nbAvis;
    }

    public void setNbAvis(int nbAvis) {
        this.nbAvis = nbAvis;
    }
    
    
}

