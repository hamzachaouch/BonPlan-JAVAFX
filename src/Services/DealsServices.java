/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entite.Deals;
import interfaces.IDeals;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author Hamza
 */
public class DealsServices implements IDeals{
     
    Connection connection = null;

    public DealsServices() {
        connection = DataSource.getInstance().getConnection();
    
    }
   
    @Override
    public void insert(Deals d) {
             String req = "INSERT INTO `deals`( `name`, `description`,`price`,`datedebut`,`datefin`"
                     + ",`address`,`categorie`,`imgUrl`,`programme`,`telephone`,`horraire`,`nbrclients`,`note`,`idCompany`)"
                     + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      
        try {
            PreparedStatement preparedstatement = connection.prepareStatement(req);
            preparedstatement.setString(1, d.getName());
            preparedstatement.setString(2, d.getDescription());
            preparedstatement.setInt(3, d.getPrice());
            preparedstatement.setDate(4, (Date) d.getDateDebut());
            preparedstatement.setDate(5, (Date) d.getDateFin());
            preparedstatement.setString(6, d.getAddress());
            preparedstatement.setString(7, d.getCategorie());
            preparedstatement.setString(8, d.getImgUrl());
            preparedstatement.setString(9, d.getProgramme());
            preparedstatement.setString(10, d.getTelephone());
            preparedstatement.setString(11, d.getHorraire());
            preparedstatement.setInt(12, d.getNbrClients());
            preparedstatement.setInt(13, d.getNote());
            preparedstatement.setInt(14, d.getIdCompany());
                                                      
            preparedstatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DealsServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Deals> selectAll() {
        List<Deals> listDeals = new ArrayList<Deals>();

        String req = "SELECT * FROM `deals` WHERE datedebut >= CURDATE() ORDER BY datedebut DESC  ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
                int id=resultSet.getInt(1);
                String name=resultSet.getString(2);
                String descr=resultSet.getString(3);
                int price=resultSet.getInt(4);
                Date datedeb=resultSet.getDate(5);
                Date datefin=resultSet.getDate(6);
                String ad=resultSet.getString(7);
                String cat=resultSet.getString(8);
                String img=resultSet.getString(9);   
                String prog=resultSet.getString(10);
                String tel=resultSet.getString(11); 
                String horr=resultSet.getString(12);
                int nbrclients=resultSet.getInt(13);
                int note=resultSet.getInt(14);
                int  idcompany=resultSet.getInt(15);
                Deals p = new Deals(id, price, nbrclients, note, idcompany, name, descr, ad, cat, img, prog, tel, horr, datedeb, datefin);
                listDeals.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DealsServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listDeals;
        
        
    }

    @Override
    public void supprimer(int id) {
      String query = "delete from deals where id = ?";
     try {
      PreparedStatement preparedStmt = connection.prepareStatement(query);
      preparedStmt.setInt(1, id);

      preparedStmt.execute();
     }catch(SQLException ex){
        Logger.getLogger(DealsServices.class.getName()).log(Level.SEVERE, null, ex);
       }
     }

    
  
    @Override
    public List<Deals> rechAvecId(Deals d) {
        List<Deals> listDeals = new ArrayList<Deals>();

        String req = "select * from deals where WHERE datedebut >= CURDATE() and id ="+d.getId();
        try {
          //  PreparedStatement preparedStmt = connection.prepareStatement(req);
          //  preparedStmt.setInt(1, id);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
                String name=resultSet.getString(2);
                String descr=resultSet.getString(3);
                int price=resultSet.getInt(4);
                Date datedeb=resultSet.getDate(5);
                Date datefin=resultSet.getDate(6);
                String ad=resultSet.getString(7);
                String cat=resultSet.getString(8);
                String img=resultSet.getString(9);   
                String prog=resultSet.getString(10);
                String tel=resultSet.getString(11); 
                String horr=resultSet.getString(12);
                int nbrclients=resultSet.getInt(13);
                int note=resultSet.getInt(14);
                int  idcompany=resultSet.getInt(15);
                Deals r = new Deals(d.getId(), price, nbrclients, note, idcompany, name, descr, ad, cat, img, prog, tel, horr, datedeb, datefin);
                listDeals.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DealsServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listDeals;
        
        
   
    }

    @Override
    public void update(Deals p) {
        
         String req = "UPDATE `deals` SET "
                 + " name = ? ,"
                 + " description = ? ,"
                 + " price = ? ,"
                 + " datedebut = ? ,"
                 + " datefin= ? ,"
                 + "address = ? ,"
                 + "categorie = ? ,"
                 + "imgUrl = ? ,"
                 + " programme = ? ,"
                 + "telephone = ? , "
                 + " horraire = ? ,"
                 + " nbrclients = ? ,"
                 + " note = ? ,"
                 + " idCompany = ? "
                 + " WHERE id = ? ";

        try {
            PreparedStatement ps = connection.prepareStatement(req);

            ps.setString(1, p.getName());
            ps.setString(2, p.getDescription());
            ps.setInt(3, p.getPrice());

            ps.setDate(4,new java.sql.Date(System.currentTimeMillis()) );
            ps.setDate(5,new java.sql.Date(System.currentTimeMillis()) );
            ps.setString(6, p.getAddress());
            ps.setString(7, p.getCategorie());
            ps.setString(8, p.getImgUrl());
            ps.setString(9, p.getProgramme());
            ps.setString(10, p.getTelephone());
            ps.setString(11, p.getHorraire());
            ps.setInt(12, p.getNbrClients());
            ps.setInt(13, p.getNote() );
            ps.setInt(14, p.getIdCompany());
            ps.setInt(15, p.getId());
             
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReviewServices.class.getName()).log(Level.SEVERE, null, ex);
        }








    }


    public List<Deals> rechAvecPrice(float p) {
        List<Deals> listDeals = new ArrayList<Deals>();

        String req = "select * from deals where datedebut >= CURDATE() and price <="+(int)p;
        try {
          //  PreparedStatement preparedStmt = connection.prepareStatement(req);
          //  preparedStmt.setInt(1, id);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
                int id =resultSet.getInt(1);
                String name=resultSet.getString(2);
                String descr=resultSet.getString(3);
                int price=resultSet.getInt(4);
                Date datedeb=resultSet.getDate(5);
                Date datefin=resultSet.getDate(6);
                String ad=resultSet.getString(7);
                String cat=resultSet.getString(8);
                String img=resultSet.getString(9);   
                String prog=resultSet.getString(10);
                String tel=resultSet.getString(11); 
                String horr=resultSet.getString(12);
                int nbrclients=resultSet.getInt(13);
                int note=resultSet.getInt(14);
                int  idcompany=resultSet.getInt(15);
                Deals r = new Deals(id, price, nbrclients, note, idcompany, name, descr, ad, cat, img, prog, tel, horr, datedeb, datefin);
                listDeals.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DealsServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listDeals;
        
        
   

    }


    
    
    
    
    
    
    
  
    
    
    
}
