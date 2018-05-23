/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import interfaces.CategorieInterface;
import entite.Categorie;
import utils.DataSource;

/**
 *
 * @author Nassreddine
 */
public class CategorieService implements CategorieInterface {
    Connection connection = null;

    public CategorieService() {
        connection = DataSource.getInstance().getConnection();
    }



    public void addCategorie(Categorie cat) {
        String request = "insert into proposition SET name=?";
        try {
           PreparedStatement ps = connection.prepareStatement(request);
           ps.setString(1, cat.getName());
           ps.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    @Override
    public void deleteCategorie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> selectAllCategorie() {
        ArrayList<String> array = new ArrayList<String>(); 
        try{
            String request = "SELECT * FROM categorie ";
            PreparedStatement st;
            st = connection.prepareStatement(request);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
               String s = rs.getString(2);
               array.add(s);
            }
       
        }catch(Exception ex){
        }
        return array;
    }
    @Override
    public int nbProp(){
      int nb = 0;
      try{
         String request = "SELECT count(*) FROM categorie ";
            PreparedStatement st;
            st = connection.prepareStatement(request);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
               nb = rs.getInt(1);
            }
            
      }catch(Exception ex){
        
      }
      return nb;
    }

    
}
