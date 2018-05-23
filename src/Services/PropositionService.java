package Services;
import entite.Proposition;
import interfaces.PropositionInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utils.DataSource;

public class PropositionService implements PropositionInterface{

    Connection connection = null;

    public PropositionService() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void insertPropsition(Proposition p) {
       String sq= "insert into proposition SET name=?,"
                + "categorie=?,autre=?,city=?,date_v=?,site=?,description=?,img_url=?,id_cli=?";
          try {
            
            int i = 17;
            PreparedStatement ps = connection.prepareStatement(sq);
            ps.setString(1, p.getName());
            ps.setString(2, p.getCategorie());
            ps.setString(3, p.getAutre());
            ps.setString(4, p.getCity()); 
            ps.setString(5, p.getDateV());
            ps.setString(6, p.getSite());
            ps.setString(7, p.getDescription());
            ps.setString(8, p.getImg()); 
             ps.setInt(9,p.getIdCli());
            
           
            
             ps.executeUpdate();
          JOptionPane d = new JOptionPane();
              d.showMessageDialog( null, "Ajout avec succée", 
               "le titre", JOptionPane.ERROR_MESSAGE);


        } catch (Exception ex) {
           
            JOptionPane d = new JOptionPane();
              d.showMessageDialog( null, "erreur", 
               "le titre", JOptionPane.ERROR_MESSAGE);    
        } 
    }

    @Override
    public void deleatePrposition(int id) {
        try {
              String request = "delete from proposition where id=?";
         
               PreparedStatement  st = connection.prepareStatement(request);
               st.setInt(1,id);
               st.executeUpdate();
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
    }

    @Override
    public void UpdateProposition(Proposition p) {
        String req = "update proposition set name=?,categorie=?,autre=?,city=?,date_v=?,site=?"
                + ",description=?,img_url=?,id_cli=? where id=?";
        try {
            PreparedStatement stm = connection.prepareStatement(req);
            
            stm.setString(1,  p.getName());
            stm.setString(2,  p.getCategorie());
            stm.setString(3,  p.getAutre());
            stm.setString(4,  p.getCity());
            stm.setString(5,  null);
            stm.setString(6,  p.getSite());
            stm.setString(7,  p.getDescription());
            stm.setString(8,  null);
            stm.setInt(9, p.getIdCli());
            stm.setInt(10, p.getId() );
            stm.executeUpdate();
            System.out.println("ajout ok");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }     
    }
    

    @Override
    public ArrayList<Proposition> selectAllProposition() {
                     Proposition p = null;
                     ArrayList<Proposition> lp = new ArrayList<Proposition>(); 
    try {
      String request = "SELECT * FROM `proposition`";
        PreparedStatement st;
        st = connection.prepareStatement(request);
        
        
        ResultSet rs = st.executeQuery();
       
        while(rs.next()){
          p= new Proposition(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(7),rs.getString(8)); 
          lp.add(p);
       }
    } catch (SQLException ex) {
        System.out.println("Exception "+ ex);
    }
       
        return lp;
    }

    @Override
    public ArrayList<Proposition> findPropById(int id) {
        ArrayList<Proposition> arrayList = new ArrayList<Proposition>();
        Proposition p = null;
        try {
      String request = "SELECT * FROM `proposition` WHERE id_cli=?";
        PreparedStatement st;
        st = connection.prepareStatement(request);
        st.setInt(1,id);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            
           p = new Proposition(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)
                   ,rs.getString(5),rs.getString(7),rs.getString(8),rs.getInt(10));
           arrayList.add(p);
        }
    }
    catch(Exception ex ){
        System.out.println("pijava.services.PropositionService.findPropById()"+ex);
    }
        return arrayList;
    }

    @Override
    public ArrayList<String> findCategorie() {
       Proposition p = null;
       
       ArrayList<String> arrayList = new ArrayList<String>();
        try{
           String request = "SELECT * FROM `proposition` WHERE categorie<>?";
           PreparedStatement st;
           
           st = connection.prepareStatement(request);
           st.setString(1,"Aucun");
           
            ResultSet rs = st.executeQuery();
            
         int i = 0; 
        while(rs.next()){
            p = new Proposition(rs.getString(3));
            arrayList.add(p.getCategorie());
           
       }
    }
        catch(Exception ex ){
            System.out.println("Exeption = "+ex);
        }
        
        return arrayList;
    }
    @Override
     public boolean rechercherEtudiant(String nom,ArrayList<String> lst) {
       for(String i :lst){
          if(i.equals(nom))
              return true;
        }
       return false;
    }

    @Override
    public boolean existProposition(String name,String categorie,String city) {
         boolean exist = false;
         //Proposition p =null;
        try{
            String request = "SELECT * FROM proposition "
                           + "WHERE name=? ";
            PreparedStatement st;
            st = connection.prepareStatement(request);
            st.setString(1,name);
            
             ResultSet rs = st.executeQuery();
             
             while(rs.next()){
                 if(rs.getString(3).equals(categorie)){
                     System.out.println("rs.getString(3) "+rs.getString(3));
                     System.out.println("rs.getString() "+rs.getString(5));
                       if(rs.getString(5).equals(city)){
                         System.out.println("rs.getString() "+rs.getString(5));
                        exist = true;
                     }
                 }
                    
                     
                    
                 
            }        
        }
        catch(Exception ex){
            System.out.println("Exception ex");
        }
        
        return exist;
    }

    @Override
    public int nbPropo() {
       int nb=0;
       String request = "SELECT count(*) FROM proposition ";
       try{
          PreparedStatement st;
            st = connection.prepareStatement(request);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
               nb = rs.getInt(1);
            }
            
       }catch(Exception ex){
           System.out.println(""+ex);
       }
       return nb;
    }

    @Override
    public double avgMoyRestaurant() {
        double moy = 0;
         double nb = 0; 
        String request = "SELECT count(*) FROM proposition WHERE categorie=?  ";
        try{PreparedStatement st;
            st = connection.prepareStatement(request);
            st.setString(1,"Restaurant");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
               nb = rs.getInt(1);
                
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
            int nbTot = nbPropo();
          
        return  moy =(nb/nbTot)*100;
    }

    @Override
    public double avgMoyCafé() {
         double moy = 0;
         double nb = 0;
        String request = "SELECT COUNT(*) FROM proposition WHERE categorie=?  ";
        try{PreparedStatement st;
            st = connection.prepareStatement(request);
            st.setString(1,"Café");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
               nb = rs.getInt(1);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        int nbTot = nbPropo();
        return  moy =(nb/nbTot)*100;
    }

    @Override
    public double avgMoyHot() {
         double moy = 0;
         double nb = 0;
        String request = "SELECT COUNT(*) FROM proposition WHERE categorie=?  ";
        try{PreparedStatement st;
            st = connection.prepareStatement(request);
            st.setString(1,"Hotel");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
               nb = rs.getInt(1);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
       int nbTot = nbPropo();
          
        return  moy =(nb/nbTot)*100;
    }

    @Override
    public double avgMoyCinéma() {
         double moy = 0;
         double nb = 0;
        String request = "SELECT COUNT(*) FROM proposition WHERE categorie=?  ";
        try{PreparedStatement st;
            st = connection.prepareStatement(request);
            st.setString(1,"Cinéma");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
               nb = rs.getInt(1);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
       int nbTot = nbPropo();
          
        return  moy =(nb/nbTot)*100;
    }

    @Override
    public double avgMoyCategorie(String cat) {
        double moy = 0;
         double nb = 0;
        String request = "SELECT COUNT(*) FROM proposition WHERE categorie=?  ";
        try{PreparedStatement st;
            st = connection.prepareStatement(request);
            st.setString(1,"Cinéma");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
               nb = rs.getInt(1);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
       int nbTot = nbPropo();
          
        return  moy =(nb/nbTot)*100;
    }

  

     
}
