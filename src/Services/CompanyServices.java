/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import entite.Admin;
import entite.Client;
import interfaces.CompanyInterface;
import entite.Company;
import entite.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utils.BCrypt;
import utils.DataSource;

/**
 *
 * @author HP
 */
public class CompanyServices implements CompanyInterface {
    
    Connection connection = null;
    
    public CompanyServices() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void insert(Company c) {
        String req = 
   "INSERT INTO `company` (`login`,`password`,`name`,`description`,`address`,`type`,"
                + "`img_url`,`email`,`budget`,`ville`,`premium`,`etat`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, c.getLogin());
            preparedStatement.setString(2, c.getPassword());
            preparedStatement.setString(3, c.getName());
            preparedStatement.setString(4, c.getDescription());
            preparedStatement.setString(5, c.getAddress());
            preparedStatement.setString(6, c.getType());
            preparedStatement.setString(7, c.getImg_url());
            preparedStatement.setString(8, c.getEmail());
            preparedStatement.setInt(9, c.getBudget());
            preparedStatement.setString(10, c.getVille());
            preparedStatement.setBoolean(11, true); 
            preparedStatement.setInt(12,0);
            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(CompanyServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public List<Company> selectAll() {
            List<Company> companies = new ArrayList<Company>();
            String req = "SELECT * FROM `company`";
             try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
                
                        int id = resultSet.getInt(1);
                        String login=resultSet.getString(2);
                        String password=resultSet.getString(3);
                        String name=resultSet.getString(4);
                        String description=resultSet.getString(5);
                        String address=resultSet.getString(6);
                        String type=resultSet.getString(7);
                        String img_url=resultSet.getString(8);
                        String email=resultSet.getString(9);
                        int budget=resultSet.getInt(10);
                        String ville=resultSet.getString(11);
                        Boolean premium=resultSet.getBoolean(12);
                        int etat=resultSet.getInt(13);
         Company c = new Company(id,login,password,name,description,address,type,img_url,email,budget,ville,premium,etat);
         companies.add(c);
                       
                
            }
             } catch (SQLException ex) {
            Logger.getLogger(CompanyServices.class.getName()).log(Level.SEVERE, null, ex);
        }
            return companies;

    }
    
 @Override
    public void delete(int idCompany) {
        String req = "DELETE  FROM company WHERE id=?";
        try {
            PreparedStatement st = connection.prepareStatement(req);
            st.setInt(1,idCompany);
            st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CompanyServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    @Override
    public void update(Company c) {
        String req = "UPDATE `company` SET"
                 + " login = ? , "
                 + " password = ? , "
                + " name = ? , "
                + "description = ? ,"
                + "address = ? ,"
                + " type = ?,"
                + " img_url = ?"
                + " email = ? , "
                + "budget = ?  ,"
                + " ville = ? "
                + " premium = ?"
                + " etat = ?"
                + "   WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(req);
            
            ps.setString(1, c.getLogin());
            ps.setString(2, c.getPassword());
            ps.setString(3, c.getName());
            ps.setString(4, c.getDescription());
            ps.setString(5, c.getAddress());
            ps.setString(6, c.getType());
            ps.setString(7, c.getImg_url());
            ps.setString(8, c.getEmail());
            ps.setInt(9, c.getBudget());
            
            ps.setString(10, c.getVille());
            ps.setBoolean(11, true);
            ps.setInt(12, 0);
            
            
            
            ps.setInt(13, c.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompanyServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 

    @Override
    public List<Company> selectAllRestaurant() {
        String req = "SELECT * FROM `company` WHERE type='Restaurant'";  
        PreparedStatement preparedStatement;
        List<Company> companies = new ArrayList<Company>();
    try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
                Company c = new Company (resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getInt(10),
                        resultSet.getString(11),
                        resultSet.getBoolean(12),
                resultSet.getInt(13));
                companies.add(c);
            }
             } catch (SQLException ex) {
            Logger.getLogger(CompanyServices.class.getName()).log(Level.SEVERE, null, ex);
        }
            return companies;
    }

    @Override
    public List<Company> selectAllHotel() {
          String req = "SELECT * FROM `company` WHERE type='Hotel'";  
              PreparedStatement preparedStatement;
        List<Company> companies = new ArrayList<Company>();
    try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
                Company c = new Company (resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getInt(10),
                        resultSet.getString(11),
                        resultSet.getBoolean(12),
                        resultSet.getInt(13)
);
                companies.add(c);
            }
             } catch (SQLException ex) {
            Logger.getLogger(CompanyServices.class.getName()).log(Level.SEVERE, null, ex);
        }
            return companies;
    }

    @Override
    public List<Company> selectAllSalondethe() {
       String req = "SELECT * FROM `company` WHERE type='Salon de thé'";  
       PreparedStatement preparedStatement;
        List<Company> companies = new ArrayList<Company>();
    try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
                Company c = new Company (
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getInt(10),
                        resultSet.getString(11),
                        resultSet.getBoolean(12),
                        resultSet.getInt(13)
);
                companies.add(c);
            }
             } catch (SQLException ex) {
            Logger.getLogger(CompanyServices.class.getName()).log(Level.SEVERE, null, ex);
        }
            return companies;
    }

    @Override
    public List<Company> selectAllRandonnee() {
        String req = "SELECT * FROM `company` WHERE type='Randonnée'"; 
        PreparedStatement preparedStatement;
        List<Company> companies = new ArrayList<Company>();
    try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
                Company c = new Company (resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getInt(10),
                        resultSet.getString(11),
                        resultSet.getBoolean(12),
                        resultSet.getInt(13)
);
                companies.add(c);
            }
             } catch (SQLException ex) {
            Logger.getLogger(CompanyServices.class.getName()).log(Level.SEVERE, null, ex);
        }
            return companies;
    }

    @Override
    public List<Company> selectAllCinema() {
        String req = "SELECT * FROM `company` WHERE type='Cinema'";
        PreparedStatement preparedStatement;
        List<Company> companies = new ArrayList<Company>();
    try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
                Company c = new Company (resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getInt(10),
                        resultSet.getString(11),
                        resultSet.getBoolean(12),
                        resultSet.getInt(13)
);
                companies.add(c);
            }
             } catch (SQLException ex) {
            Logger.getLogger(CompanyServices.class.getName()).log(Level.SEVERE, null, ex);
        }
            return companies;
    }

  

    @Override
    public List<Company> searchbyType(Company c) {
        List<Company> companies = new ArrayList<Company>();
            String req = "SELECT * FROM `company` WHERE type =" +c.getType();
            
            PreparedStatement preparedStatement;
            try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
                
                String login=resultSet.getString(2);
                String password=resultSet.getString(3);
                String name=resultSet.getString(4);
                String description=resultSet.getString(5);
                String address=resultSet.getString(6);
                String type=resultSet.getString(7);
                String img_url=resultSet.getString(8);
                String email=resultSet.getString(9);
                int budget =resultSet.getInt(10);
                String ville=resultSet.getString(11);
                Boolean premium=resultSet.getBoolean(12);
                int etat=resultSet.getInt(13);
               Company e = new Company (c.getId(),login,password,name,description,address,type,img_url,email,budget,ville,premium,etat);
               companies.add(e);
            }
             } catch (SQLException ex) {
            Logger.getLogger(CompanyServices.class.getName()).log(Level.SEVERE, null, ex);
        }
            return companies;    }

    @Override
    public List<Company> searchbyVille(String v) {
                List<Company> companies = new ArrayList<Company>();

            String req = "SELECT * FROM `company` WHERE ville LIKE 'a%'";
            PreparedStatement preparedStatement;
            try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
                Company c = new Company(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getInt(10),
                        resultSet.getString(11),
                        resultSet.getBoolean(12)
                        
                );
            }
             } catch (SQLException ex) {
            Logger.getLogger(CompanyServices.class.getName()).log(Level.SEVERE, null, ex);
        }
            return companies;        }

    @Override
    public Company selectById(int id) {
        Company company = null;
         String req = "SELECT * FROM `company` WHERE id=?" ;
         try{
             PreparedStatement st = connection.prepareStatement(req);
             st.setInt(1, id);
             ResultSet resultSet=st.executeQuery();
             while(resultSet.next()){
             company = new Company(
             resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getInt(10),
                        resultSet.getString(11),
                        resultSet.getBoolean(12));
             resultSet.getInt(13);
             }
         }catch(Exception ex){
             
         }
         return company;
        }

    @Override
    public Company Authentification(String login, String password) {
        Company c = null;
    try {
      String request = "SELECT * FROM `company` where login=?";
        PreparedStatement st;
        st = connection.prepareStatement(request);
        st.setString(1,login);
        
        ResultSet rs = st.executeQuery();
       
        while(rs.next()){
                if (rs.getString(3).equals(password)){
                c = new Company(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getBoolean(12),
                rs.getInt(13));
                
                    }
        }
    } catch (SQLException ex) {
        System.out.println("Exception "+ ex);
    }
       
        return c;
    }

    @Override
    public void debloquer(Company c) {
        String req = "UPDATE `company` SET"
                 + " login = ? , "
                 + " password = ? , "
                + " name = ? , "
                + "description = ? ,"
                + "address = ? ,"
                + " type = ?,"
                + " img_url = ?"
                + ", email = ? , "
                + "budget = ?  ,"
                + " ville = ? "
                + ", premium = ?"
                + ", etat = ?"
                + "   WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(req);
            
            ps.setString(1, c.getLogin());
            ps.setString(2, c.getPassword());
            ps.setString(3, c.getName());
            ps.setString(4, c.getDescription());
            ps.setString(5, c.getAddress());
            ps.setString(6, c.getType());
            ps.setString(7, c.getImg_url());
            ps.setString(8, c.getEmail());
            ps.setInt(9, c.getBudget()); 
            ps.setString(10, c.getVille());
            ps.setBoolean(11, true);
            ps.setInt(12,1);
            ps.setInt(13, c.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CompanyServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Company selectBylogin(String s) {
        Company company = null;
         String req = "SELECT * FROM `company` WHERE login="+s ;
         try{
             PreparedStatement st = connection.prepareStatement(req);
             ResultSet resultSet=st.executeQuery();
             while(resultSet.next()){
             company = new Company(
             resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getInt(10),
                        resultSet.getString(11),
                        resultSet.getBoolean(12));
             resultSet.getInt(13);
             }
         }catch(Exception ex){
             
         }
         return company;
        }
   
}

   
   
    
    

 
