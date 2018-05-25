/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entite.Ads;
import entite.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;
import interfaces.IAds;
//import GUI.AuthController;
import utils.StaticVariables;

/**
 *
 * @author ghaz Nada
 */
public class AdsService implements IAds<Ads> {
    Connection connection = DataSource.getInstance().getConnection();

    Statement stm;
    ResultSet rs;
//constructeur
//    public AdsService() {
//        connection = DataSource.getInstance().getConnection();
//    }

    @Override
    //l'Ajout
    public void insert(Ads A) {
        String req = "INSERT INTO  `ads` ( `status` , `date_begin` , `date_end` , `views` , `publicite_payee` , `titre`, `img_url` , `description` , `ville`,`companyid`)  VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            //de jawaher pour recuperer date
            java.util.Date utiledate = new java.util.Date();
            java.sql.Date datnow = new java.sql.Date(utiledate.getTime());
            PreparedStatement preparedstatement = connection.prepareStatement(req);
            preparedstatement.setString(1, A.getStatus());
            preparedstatement.setDate(2, A.getDateBegin());
            preparedstatement.setDate(3, A.getDateEnd());
            preparedstatement.setInt(4, A.getViews());
            preparedstatement.setInt(5, A.getPublicitePayee());
            preparedstatement.setString(6, A.getTitre());
            preparedstatement.setString(7, A.getImgUrl());
            preparedstatement.setString(8, A.getDescription());
            preparedstatement.setString(9, A.getVille());
            preparedstatement.setInt(10, A.getCompanyId());

            preparedstatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AdsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Ads> selectAll() {
        String req = "SELECT * FROM ads";
        ArrayList<Ads> ads = new ArrayList<>();
        Ads ad = null;
        try {
            PreparedStatement statement = connection.prepareStatement(req);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                ad = new Ads();
                ad.setId(rs.getInt("id"));
                ad.setTitre(rs.getString("titre"));          
                ad.setVille(rs.getString("ville"));
                ad.setDateBegin(rs.getDate("date_begin"));
                ad.setDateEnd(rs.getDate("date_end"));
                ad.setDescription(rs.getString("description"));
                ad.setViews(rs.getInt("views"));
                ad.setImgUrl(rs.getString("img_url"));
                ad.setCompanyId(rs.getInt("companyId"));

                 
                ads.add(ad);
            }
            rs.close();
            statement.execute(req);
        } catch (SQLException ex) {
            Logger.getLogger(AdsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ads;
    }

    @Override
    public boolean delete(Ads a) {
        boolean test = false;
        String req = "DELETE FROM ads WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(req);
            st.setInt(1, a.getId());
            st.executeUpdate();
            test = true;

        } catch (SQLException ex) {
            Logger.getLogger(AdsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return test;
    }

    @Override
    public boolean update(Ads a) {
        String req = "UPDATE ads SET titre = ?  ,img_url = ?  , description = ?   ,ville = ?, date_begin = ?,date_end = ? WHERE id ="+StaticVariables.selectedAdsCompany.getId();
        boolean test = false;
        try {
            PreparedStatement ps = connection.prepareStatement(req);

            ps.setString(1, a.getTitre());
            ps.setString(2, a.getImgUrl());
            ps.setString(3, a.getDescription());
            ps.setString(4, a.getVille());
            ps.setDate(5, a.getDateBegin());
            ps.setDate(6, a.getDateEnd());
            ps.executeUpdate();
            test = true;
        } catch (SQLException ex) {
            Logger.getLogger(AdsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return test;
    }
    
    public void updateViews(Ads a){
        String req = "update ads SET views=views+1 where id ="+a.getId();
         try {
             PreparedStatement ps = connection.prepareStatement(req);
             ps.executeUpdate();
         }catch (SQLException ex) {
            Logger.getLogger(AdsService.class.getName()).log(Level.SEVERE, null, ex);
        }  
   }

    @Override
    public Ads Rechercher(int id) {
        Ads a = null;
        try {
            stm = connection.createStatement();
            String querry = "select * from ads where id=" + id;
            rs = stm.executeQuery(querry);

            while (rs.next()) {

                a = new Ads();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return a;

    }
    
    
     public ArrayList<Ads> selectAllAdsCompany() {
        String req = "select ads * from ads";
        ArrayList<Ads> ads = new ArrayList<>();
        Ads ad = null;
        try {
            PreparedStatement statement = connection.prepareStatement(req);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                ad = new Ads();
                ad.setId(rs.getInt("id"));
                ad.setTitre(rs.getString("titre"));          
                ad.setVille(rs.getString("ville"));
                ad.setDateBegin(rs.getDate("date_begin"));
                ad.setDateEnd(rs.getDate("date_end"));
                ad.setViews(rs.getInt("views"));
                ad.setImgUrl(rs.getString("img_url"));
                ad.setDescription(rs.getString("description"));

                ads.add(ad);
            }
            rs.close();
            statement.execute(req);
        } catch (SQLException ex) {
            Logger.getLogger(AdsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ads;
    }
     
     
      public ArrayList<Ads> selectNoneValidateAds() {
        String req = "select * from ads where status=0";
        ArrayList<Ads> ads = new ArrayList<>();
        Ads ad = null;
        try {
            PreparedStatement statement = connection.prepareStatement(req);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                ad = new Ads();
                ad.setId(rs.getInt("id"));
                ad.setTitre(rs.getString("titre"));          
                ad.setVille(rs.getString("ville"));
                ad.setDateBegin(rs.getDate("date_begin"));
                ad.setDateEnd(rs.getDate("date_end"));
                ad.setViews(rs.getInt("views"));
                ad.setImgUrl(rs.getString("img_url"));
                ad.setDescription(rs.getString("description"));

                ads.add(ad);
            }
            rs.close();
            statement.execute(req);
        } catch (SQLException ex) {
            Logger.getLogger(AdsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ads;
    }
      
      //validation par l'admin
      public boolean validerAds(Ads obj){
      
          boolean test = false;
            
           String req = "update ads SET status = 1 where id ="+obj.getId();
         try {
             PreparedStatement ps = connection.prepareStatement(req);
             ps.executeUpdate();
             test = true;
         }catch (SQLException ex) {
            Logger.getLogger(AdsService.class.getName()).log(Level.SEVERE, null, ex);
        }  
          return test;
      }
      
      
      
       public boolean RefuserAds(Ads obj){
      
          boolean test = false;
            
           String req = "delete * from  ads where id ="+obj.getId();
         try {
             PreparedStatement ps = connection.prepareStatement(req);
             ps.executeUpdate();
             test = true;
         }catch (SQLException ex) {
            Logger.getLogger(AdsService.class.getName()).log(Level.SEVERE, null, ex);
        }  
          return test;
      }
     

}
