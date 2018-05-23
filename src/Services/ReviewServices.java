/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entite.Review;
import interfaces.IReview;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author Hamza
 */
public class ReviewServices implements  IReview{
    Connection connection = null;

    public ReviewServices() {
        connection = DataSource.getInstance().getConnection();
    
    }
    
    
    @Override
    public void insert(Review d) {
      String req = "INSERT INTO `review`( `id_Company`, `id_Client`,`content`,`title`,`quality_price`"
                     + ",`service`,`satisfaction`,`global_mark`,`date_of_visit`,`img_url`)"
                     + " VALUES (?,?,?,?,?,?,?,?,?,?)";
      
        try {
            PreparedStatement preparedstatement = connection.prepareStatement(req);
            preparedstatement.setInt(1, d.getIdCompany());
            preparedstatement.setInt(2, d.getIdClient());
            preparedstatement.setString(3, d.getContent());
            preparedstatement.setString(4, d.getTitle());
            preparedstatement.setInt(5, d.getQualitePrix());
            preparedstatement.setInt(6, d.getService());
            preparedstatement.setInt(7, d.getSatisfaction());
            preparedstatement.setInt(8, d.getGlobalMark());
            preparedstatement.setDate(9, new java.sql.Date(System.currentTimeMillis()));
            preparedstatement.setString(10, d.getImgUrl());
                                                   
            preparedstatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DealsServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Review> selectAll() {
          List<Review> listReviews = new ArrayList<Review>();

        String req = "SELECT * FROM `review`";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
                int id=resultSet.getInt(1);
                int idcompany=resultSet.getInt(2);
                int idclient=resultSet.getInt(3);
                String content=resultSet.getString(4);
                Date date=resultSet.getDate(10);
                String title=resultSet.getString(5);
                int qualityprice=resultSet.getInt(6);
                int service=resultSet.getInt(7);   
                int satisfaction=resultSet.getInt(8); 
                int globalmark=resultSet.getInt(9); 
                String imgurl=resultSet.getString(10);
                Review r = new Review(id, idcompany, idclient, qualityprice, service, satisfaction, globalmark, content, title, imgurl, date);
                
                listReviews.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DealsServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listReviews;
      
    }
    
    public List<Review> selectAllById(int x) {
          List<Review> listReviews = new ArrayList<Review>();

        String req = "SELECT * FROM `review` where id_Company = "+x;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
                int id=resultSet.getInt(1);
                int idcompany=resultSet.getInt(2);
                int idclient=resultSet.getInt(3);
                String content=resultSet.getString(4);
                Date date=resultSet.getDate(10);
                String title=resultSet.getString(5);
                int qualityprice=resultSet.getInt(6);
                int service=resultSet.getInt(7);   
                int satisfaction=resultSet.getInt(8); 
                int globalmark=resultSet.getInt(9); 
                String imgurl=resultSet.getString(10);
                Review r = new Review(id, idcompany, idclient, qualityprice, service, satisfaction, globalmark, content, title, imgurl, date);
                
                listReviews.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DealsServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listReviews;
      
    }
    
    @Override
    public void supprimer(int id) {
        String query = "delete from review where id = ?";
     try {
      PreparedStatement preparedStmt = connection.prepareStatement(query);
      preparedStmt.setInt(1, id);

      preparedStmt.execute();
     }catch(SQLException ex){
        Logger.getLogger(DealsServices.class.getName()).log(Level.SEVERE, null, ex);
       }
     }

    
    @Override
    public List<Review> rechAvecId(Review r) {
          List<Review> listReviews = new ArrayList<Review>();

        String req = "select * from review where id ="+r.getId();
        try {
          //  PreparedStatement preparedStmt = connection.prepareStatement(req);
          //  preparedStmt.setInt(1, id);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
                int id=resultSet.getInt(1);
                int idcompany=resultSet.getInt(2);
                int idclient=resultSet.getInt(3);
                String content=resultSet.getString(4);
                Date date=resultSet.getDate(10);
                String title=resultSet.getString(5);
                int qualityprice=resultSet.getInt(6);
                int service=resultSet.getInt(7);   
                int satisfaction=resultSet.getInt(8); 
                int globalmark=resultSet.getInt(9); 
                String imgurl=resultSet.getString(10);
                Review d = new Review(id, idcompany, idclient, qualityprice, service, satisfaction, globalmark, content, title, imgurl, date);
                listReviews.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DealsServices.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return listReviews;
        
    

    }

    @Override
    public void update(Review p) {

         String req = "UPDATE `review` SET id_Company = ? , id_Client = ? , content = ? , title = ? ,quality_price= ? ,service = ? ,satisfaction = ? ,global_mark = ? , date_of_visit = ? ,img_url = ?  WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, p.getIdCompany());
            ps.setInt(2, p.getIdClient());
            ps.setString(3, p.getContent());
            ps.setString(4, p.getTitle());
            ps.setInt(5, p.getQualitePrix());
            ps.setInt(6, p.getService());
            ps.setInt(7, p.getSatisfaction());
            ps.setInt(8, p.getGlobalMark());
            ps.setDate(9, new java.sql.Date(System.currentTimeMillis()));
            ps.setString(10, p.getImgUrl());
            ps.setInt(11, p.getId());
             
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReviewServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   


}
    
  



