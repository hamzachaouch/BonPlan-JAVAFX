/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pitest2018;

import Services.EventService;
import Services.NoteMetier;
import Services.ReviewServices;
import entite.Review;
import entite.Event;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author ThinkPad
 */

public class Pitest2018 {
  
    public static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
       System.out.println(NoteMetier.calculNote(1));
       
  
       

 }       
    
}
