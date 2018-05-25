/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utils.DataSource;
import interfaces.UserInterface;
import entite.Admin;
import entite.Client;
import entite.User;
import utils.BCrypt;

/**
 *
 * @author Nassreddine
 */
public class UserService implements UserInterface{
  
     Connection connection = null;
    public UserService(){
     connection = DataSource.getInstance().getConnection();
    }

    @Override
    public Client FindClientById(String id) {
            Client c = null;
    try {
      String request = "SELECT * FROM `fos_user` where username=?";
        PreparedStatement st;
        st = connection.prepareStatement(request);
        st.setString(1,id);
        
        ResultSet rs = st.executeQuery();
       
        while(rs.next()){
         if(rs.getString(12).equals("a:0:{}")){
                        
                        c = new Client(
                                rs.getInt(1),
                                rs.getString(2),
                              //  rs.getString(13),
                               
                                rs.getString(4),
                                rs.getString(8),
                                rs.getString(12)
                                
                        );
                                
                    }
                     
                   
       }
    } catch (SQLException ex) {
        System.out.println("Exception "+ ex);
    }
       
        return c;

    }

    @Override
    public Admin FindAdmintById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User Authentification(String login, String password) {
           User c = null;
           try {
      String request = "SELECT * FROM `fos_user` where username=?";
        PreparedStatement st;
        st = connection.prepareStatement(request);
        st.setString(1,login);
         
        ResultSet rs = st.executeQuery();
          while(rs.next()){
                if(BCrypt.checkpw(password,rs.getString(8))==true){
                    if(rs.getString(12).equals("a:0:{}")){
                                    

                           c = new Client(
                                   rs.getInt(1),
                                   rs.getString(2),
                                   rs.getString(4),
                                rs.getString(8),
                                rs.getString(12)
                                
                        );
                    }else
                     
                    c = new Admin(rs.getInt(1),
                                rs.getString(2),
                                
                              
                                rs.getString(4),
                                rs.getString(8),
                                rs.getString(12)
                               
                        );
                    
                }
            
        }
         }catch(Exception ex ){
                System.err.println(" erreur : " +ex);
         }
           return c;
    }

    @Override
    public void adduser(Client c) {
         String request = "insert into `fos_user` SET username=?,username_canonical=?,email=?,email_canonical=?,enabled=?,"
                + "salt=?,password=?,last_login=?,confirmation_token=?,password_requested_at=?,roles=?";
    try {
        String passwd = BCrypt.hashpw(c.getPassword(),BCrypt.gensalt(13));
        PreparedStatement st = connection.prepareStatement(request);
        st.setString(1,c.getUsername());
        st.setString(2,c.getUsername());
        st.setString(3,c.getEmail());
        st.setString(4,c.getEmail());
        st.setInt(5,1);
        st.setString(6,null);
         st.setString(7,passwd);
        st.setString(8,null );
        st.setString(9,null );
         st.setString(10,null );
        st.setString(11, "a:0:{}");
        
       
        //st.setString(15, c.getPhotoprofilpath());

        st.executeUpdate();
        JOptionPane d = new JOptionPane();
              d.showMessageDialog( null, "Vous avez une compt", 
               "le titre", JOptionPane.ERROR_MESSAGE);
        
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane d = new JOptionPane();
              d.showMessageDialog( null, "Pas de root", 
               "le titre", JOptionPane.ERROR_MESSAGE);
    }  
        
    
    }

    @Override
    public List<User> selectAllUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUserClient(Client c) {
         String request = "UPDATE `fos_user` SET username=?,username_canonical=?,email=?,email_canonical=?,enabled=?,"
                + "salt=?,password=?,last_login=?,confirmation_token=?,password_requested_at=?,"
               + "roles=? WHERE id=?";
    try {
        PreparedStatement st = connection.prepareStatement(request);
        
      String passwd = BCrypt.hashpw(c.getPassword(),BCrypt.gensalt(13));
       
        st.setString(1,c.getUsername());
        st.setString(2,c.getUsername());
        st.setString(3,c.getEmail());
        st.setString(4,c.getEmail());
        st.setInt(5,1);
        st.setString(6,null);
         st.setString(7,passwd);
        st.setString(8,null );
        st.setString(9,null );
         st.setString(10,null );
        st.setString(11, "a:0:{}");
        st.setInt(12, c.getId());
        
       
        st.executeUpdate();
        JOptionPane d = new JOptionPane();
              d.showMessageDialog( null, "update ok", 
               "le titre", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane d = new JOptionPane();
              d.showMessageDialog( null, "Pas de root", 
               "le titre", JOptionPane.ERROR_MESSAGE);
    }
  
    }

    @Override
    public void updateUserAdmin(Admin c) {
            String request = "UPDATE `fos_user` SET username=?,username_canonical=?,email=?,email_canonical=?,enabled=?,"
                + "salt=?,password=?,last_login=?,confirmation_token=?,password_requested_at=?,"
               + "roles=? WHERE id=?";
    try {
        PreparedStatement st = connection.prepareStatement(request);
        
      String passwd = BCrypt.hashpw(c.getPassword(),BCrypt.gensalt(13));
       
        st.setString(1,c.getUsername());
        st.setString(2,c.getUsername());
        st.setString(3,c.getEmail());
        st.setString(4,c.getEmail());
        st.setInt(5,1);
        st.setString(6,null);
         st.setString(7,passwd);
        st.setString(8,null );
        st.setString(9,null );
         st.setString(10,null );
        st.setString(11, "a:1:{i:0;s:10:\"ROLE_ADMIN\";}");
        
//        st.setString(15, c.getPhotoprofilpath());
        st.setInt(12,c.getId());
        st.executeUpdate();
        JOptionPane d = new JOptionPane();
              d.showMessageDialog( null, "update ok", 
               "le titre", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane d = new JOptionPane();
              d.showMessageDialog( null, "Pas de root", 
               "le titre", JOptionPane.ERROR_MESSAGE);
    }
    }
/*
    @Override
    public Company auth(String login, String password) {
        Company  c = null;
        try {
      String request = "SELECT * FROM `Company` where username=?";
        PreparedStatement st;
        st = connection.prepareStatement(request);
        st.setString(1,login);
        
        ResultSet rs = st.executeQuery();
          while(rs.next()){
          
                
                    if(rs.getString(3).equals(password)){
                           c = new Company(rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4));
                                
                    }
                    
               
            
        }
         }catch(Exception ex ){
                System.err.println(" erreur : " +ex);
         }
        return c;
    }
  */  

   

    
}
