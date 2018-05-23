/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entite.Event;
import interfaces.iEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author ThinkPad
 */

public class EventService implements iEvent{
    
    Connection connection = null;

    public EventService() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void insert(Event e) {
        
         String req = "INSERT INTO `event`( `title`, `description`,`type`,`city`,`telnumber`, `price`, `siteUrl` , `longitude`, `latitude`,`nom_image` ,`date`)"
                 + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedstatement = connection.prepareStatement(req);
            preparedstatement.setString(1, e.getTitle());
            preparedstatement.setString(2, e.getDescription());
            preparedstatement.setString(3, e.getType());
            preparedstatement.setString(4, e.getCity());
            preparedstatement.setInt(5, e.getTelnumber());
            preparedstatement.setDouble(6, e.getPrice());
            preparedstatement.setString(7, e.getSiteUrl());
                       
            preparedstatement.setDouble(8, e.getLongitude());
            preparedstatement.setDouble(9, e.getLatitude());
             preparedstatement.setString(10, e.getNom_image());

            preparedstatement.setDate(11, e.getDate());
           // preparedstatement.setInt(12, e.getId_Company());
                        

            
                                                      

            preparedstatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    

      
     
      
        
    @Override
    public List<Event> selectAll() {
         List<Event> events = new ArrayList<Event>();

        String req = "SELECT * FROM `event`ORDER BY date DESC ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
           
                       
                 Event e = new Event(
                       resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getFloat(8),
                        resultSet.getString(9),

                        resultSet.getDouble(10),
                        resultSet.getDouble(11),
                         resultSet.getString(12)


                    
                       
                 );
                       
                
                events.add(e);
               
				
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return events;

    }

    @Override
    public ArrayList<Event> eventClient() {
 //List<Event> events = new ArrayList<Event>();
 ArrayList<Event> events = new ArrayList<Event>();	
        String req = "SELECT * FROM `event` WHERE date>= CURDATE()  ORDER BY date DESC ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
                Event e = new Event(
                      
                       resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getFloat(8),
                        resultSet.getString(9),

                        resultSet.getDouble(10),
                        resultSet.getDouble(11),
                         resultSet.getString(12))
                     
                        
                       ;
                    
                        
                events.add(e);
               
				
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return events;
    }

    @Override
    public List<Event> Soire() {
        List<Event> events = new ArrayList<Event>();
 	
	

        String req = "SELECT * FROM `event` WHERE  type='Soire' AND date>= CURDATE() ORDER BY date ASC  ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
                Event e = new Event(
                        
                       
                 
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getFloat(8),
                        resultSet.getString(9),

                        resultSet.getDouble(10),
                        resultSet.getDouble(11),
                         resultSet.getString(12)
                      
                        
                
                );
                events.add(e);
               
				
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return events;
    }

    @Override
    public List<Event> Voyage() {
         List<Event> events = new ArrayList<Event>();
 	
	

        String req = "SELECT * FROM `event` WHERE  type='Voyage' AND date>= CURDATE() ORDER BY date ASC  ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
                Event e = new Event(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getFloat(8),
                        resultSet.getString(9),

                        resultSet.getDouble(10),
                        resultSet.getDouble(11),
                         resultSet.getString(12)
                       
                );
                events.add(e);
               
				
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return events;
    }

    @Override
    public void supprimerevenement(int id ) {
  String query = "delete from `event` where id = ?";
     try {
      PreparedStatement preparedStmt = connection.prepareStatement(query);
      preparedStmt.setInt(1, id);

      preparedStmt.execute();
     }catch(SQLException ex){
        Logger.getLogger(DealsServices.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @Override
    public int notification24() {
        int nb=0;
         String query = " SELECT count(*) FROM `event` WHERE date - CURDATE()=1";
         
         try {
      PreparedStatement preparedStmt = connection.prepareStatement(query);
      
       preparedStmt.execute();
          ResultSet resultSet = preparedStmt.executeQuery();
         
            while(resultSet.next()){
                
            nb= resultSet.getInt(1);
            
            }
       
     }catch(SQLException ex){
        Logger.getLogger(DealsServices.class.getName()).log(Level.SEVERE, null, ex);
       }
        return nb ;
       
    }

    @Override
    public ArrayList<Event> eventAdmin() {
 //List<Event> events = new ArrayList<Event>();
 ArrayList<Event> events = new ArrayList<Event>();	
        String req = "SELECT * FROM `event`  ORDER BY date DESC ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
                Event e = new Event(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getFloat(8),
                        resultSet.getString(9),
                        resultSet.getDouble(10),
                        resultSet.getDouble(11),
                        resultSet.getString(12))
                        
                       ;
                    
                        
                events.add(e);
               
				
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return events;
    }

    @Override
    public List<Event> Foire() {
     List<Event> events = new ArrayList<Event>();
 	
	

        String req = "SELECT * FROM `event` WHERE  type='Foire' AND date>= CURDATE() ORDER BY date ASC  ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
                Event e = new Event(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getFloat(8),
                        resultSet.getString(9),

                        resultSet.getDouble(10),
                        resultSet.getDouble(11),
                         resultSet.getString(12)
                       
                );
                events.add(e);
               
				
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return events;
    }

    @Override
    public List<Event> Theatre() {
     List<Event> events = new ArrayList<Event>();
 	
	

        String req = "SELECT * FROM `event` WHERE  type='theatre' AND date>= CURDATE() ORDER BY date ASC   ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
                Event e = new Event(
                         resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getFloat(8),
                        resultSet.getString(9),

                        resultSet.getDouble(10),
                        resultSet.getDouble(11),
                         resultSet.getString(12)
                       
                );
                events.add(e);
               
				
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return events;
    }

    @Override
    public List<Event> Randone() {
 List<Event> events = new ArrayList<Event>();
 	
	

        String req = "SELECT * FROM `event` WHERE  type='Randone' AND date>= CURDATE() ORDER BY date ASC  ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
                Event e = new Event(
                       resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getFloat(8),
                        resultSet.getString(9),

                        resultSet.getDouble(10),
                        resultSet.getDouble(11),
                         resultSet.getString(12)
                       
                );
                events.add(e);
               
				
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return events;
    
    }

    @Override
    public List<Event> Notif24() {
List<Event> events = new ArrayList<Event>();
 	
	

        String req = "SELECT * FROM `event`   WHERE date - CURDATE()=1 ORDER BY date ASC  ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
                Event e = new Event(
                       resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getFloat(8),
                        resultSet.getString(9),

                        resultSet.getDouble(10),
                        resultSet.getDouble(11),
                         resultSet.getString(12)
                       
                );
                events.add(e);
               
				
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return events;
    
    }
/*
    @Override
    public ArrayList<Event> selectByCompany(int id) {
         List<Event> events = new ArrayList<Event>();

        String req = "SELECT * FROM `event` WHERE id_Company=? ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
           
                       
                 Event e = new Event(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getFloat(8),
                        resultSet.getString(9),
                        resultSet.getDouble(10),
                        resultSet.getDouble(11),
                        resultSet.getString(12));
                 
                events.add(e);
               
				
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return events;

    }

    @Override
    public void edit(Event e) {

    }

        
    */

    @Override
    public ArrayList<Event> recherche(String v,float p) {
  ArrayList<Event> events = new ArrayList<Event>();
 	
	

        String req = "SELECT * FROM `event` WHERE  date >= CURDATE() AND  city LIKE'"+v+"'and price<='"+p+"' ORDER BY date DESC " ;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while(resultSet.next()){
                      
                 Event e = new Event(
                       resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getFloat(8),
                        resultSet.getString(9),

                        resultSet.getDouble(10),
                        resultSet.getDouble(11),
                         resultSet.getString(12)
                );
                events.add(e);
               
				
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return events;
    
    }

 
    
}

 


    
 