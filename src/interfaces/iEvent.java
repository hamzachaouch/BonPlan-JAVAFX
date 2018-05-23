/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import entite.Event;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ThinkPad
 */
public interface iEvent {
     public void insert(Event e);
   //  public void edit(Event e);

    public void supprimerevenement (int id);
    public int notification24 ();
    
        public List<Event> selectAll();
  //  public ArrayList<Event> selectByCompany(int id);

        public ArrayList<Event> eventClient();
          public ArrayList<Event> eventAdmin();
    
       public List<Event> Soire();
       public List<Event> Voyage();
        public List<Event> Foire();
       public List<Event> Theatre();
       public List<Event> Randone();
        public List<Event> Notif24();
        public ArrayList<Event> recherche(String v,float p);

          
         
        
       

}
