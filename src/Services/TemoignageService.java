/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entite.Temoignage;
import interfaces.IAds;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import GUI.AuthController;
import utils.DataSource;
import utils.StaticVariables;

/**
 *
 * @author ghaz Nada
 */
public class TemoignageService implements IAds<Temoignage>{

        Connection connection = DataSource.getInstance().getConnection();

    Statement stm;
    ResultSet rs;
    
    @Override
    public void insert(Temoignage obj) {
          String req = "INSERT INTO temoignage (avis,adsId) VALUES (?,?)";
          PreparedStatement preparedstatement;
            try {
                preparedstatement = connection.prepareStatement(req);
                preparedstatement.setString(1, obj.getAvis());
                preparedstatement.setInt(2, StaticVariables.selectedAds.getId());
                preparedstatement.execute();
            } catch (SQLException ex) {
                Logger.getLogger(TemoignageService.class.getName()).log(Level.SEVERE, null, ex);
            }
    }


    public boolean delete(String a) {
     boolean test = false;
        String req = "DELETE FROM temoignage WHERE avis = ?";
        try {
            PreparedStatement st = connection.prepareStatement(req);
            st.setString(1, a);
            st.executeUpdate();
            test = true;

        } catch (SQLException ex) {
            Logger.getLogger(AdsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return test;
        
    }

    @Override
    public boolean update(Temoignage obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Temoignage Rechercher(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Temoignage>selectAll() {
        String req = "select temoignage.* from temoignage,ads where temoignage.adsId = ads.id AND ads.id="+StaticVariables.selectedAds.getId();

        ArrayList<Temoignage> t = new ArrayList<>();
        Temoignage temoign = null;
        try {
            PreparedStatement statement = connection.prepareStatement(req);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                temoign = new Temoignage();
                temoign.setId(rs.getInt("id"));
                temoign.setAvis(rs.getString("avis"));  
                temoign.setId(rs.getInt("adsId"));
  
                t.add(temoign);
            }
            rs.close();
            statement.execute(req);
        } catch (SQLException ex) {
            Logger.getLogger(AdsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    
    }
    
    
    public List<Temoignage> selectTemoignageCompany() {
        String req = "select temoignage.* from temoignage,ads where temoignage.adsId = ads.id AND ads.id="+StaticVariables.selectedAdsCompany.getId();
        ArrayList<Temoignage> t = new ArrayList<>();
        Temoignage temoign = null;
        try {
            PreparedStatement statement = connection.prepareStatement(req);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                temoign = new Temoignage();
                temoign.setId(rs.getInt("id"));
                temoign.setAvis(rs.getString("avis"));  
                temoign.setId(rs.getInt("adsId"));
  
                t.add(temoign);
            }
            rs.close();
            statement.execute(req);
        } catch (SQLException ex) {
            Logger.getLogger(AdsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    
    }

    @Override
    public boolean delete(Temoignage obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
