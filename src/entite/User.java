/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.InputStream;
import java.util.Objects;

/**
 *
 * @author Nassreddine
 */
public class User {
     private int id;
    private String username;
    private int cin;
    private String prenom;
    private String usernameCan;
    private String email;
    private String emailCan;
    private int enabled;
    private String salt;
    private String password;
    private String lastLogin;
    private String passwordAt;
    private String role;
    private int telphone;
    private InputStream photoprofilpath;

    public User(int id, String username, int cin, String prenom, String usernameCan, String email, String emailCan, 
            int enabled, String salt, String password, String lastLogin, String passwordAt, String role, int telphone, InputStream photoprofilpath) {
        this.id = id;
        this.username = username;
        this.cin = cin;
        this.prenom = prenom;
        this.usernameCan = usernameCan;
        this.email = email;
        this.emailCan = emailCan;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.lastLogin = lastLogin;
        this.passwordAt = passwordAt;
        this.role = role;
        this.telphone = telphone;
        this.photoprofilpath = photoprofilpath;
    }

    public User(int id,String username,String prenom, String email,String role, int telephone, InputStream photoprofilpath) {
        this.id = id;
        this.username = username;
        this.prenom = prenom;
        this.email=email;
        this.role = role;
        this.telphone=telephone;
        this.photoprofilpath = photoprofilpath;
    }
     public User(int id){
        this.id=id;
     }
  
      
    public User(String username, int cin, String prenom, String usernameCan, String email, String emailCan, int enabled, String salt,
            String password, String lastLogin, String passwordAt, String role, int telphone, InputStream photoprofilpath) {
        this.username = username;
        this.cin = cin;
        this.prenom = prenom;
        this.usernameCan = usernameCan;
        this.email = email;
        this.emailCan = emailCan;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.lastLogin = lastLogin;
        this.passwordAt = passwordAt;
        this.role = role;
        this.telphone = telphone;
        this.photoprofilpath = photoprofilpath;
    }

    public User(String username, String prenom, String email, String password, int telphone, InputStream photoprofilpath) {
        this.username = username;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.telphone = telphone;
        this.photoprofilpath = photoprofilpath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsernameCan() {
        return usernameCan;
    }

    public void setUsernameCan(String usernameCan) {
        this.usernameCan = usernameCan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailCan() {
        return emailCan;
    }

    public void setEmailCan(String emailCan) {
        this.emailCan = emailCan;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getPasswordAt() {
        return passwordAt;
    }

    public void setPasswordAt(String passwordAt) {
        this.passwordAt = passwordAt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getTelphone() {
        return telphone;
    }

    public void setTelphone(int telphone) {
        this.telphone = telphone;
    }

    public InputStream getPhotoprofilpath() {
        return photoprofilpath;
    }

    public void setPhotoprofilpath(InputStream photoprofilpath) {
        this.photoprofilpath = photoprofilpath;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.cin != other.cin) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", cin=" + cin + ", prenom=" + prenom + ", usernameCan=" + usernameCan +
                ", email=" + email + ", emailCan=" + emailCan + ", enabled=" + enabled + ", salt=" + salt + ", password=" + password + ""
                + ", lastLogin=" + lastLogin + ", passwordAt=" + passwordAt + ", role=" + role + ", telphone=" + telphone + ", "
                + "photoprofilpath=" + photoprofilpath + '}';
    }
}
