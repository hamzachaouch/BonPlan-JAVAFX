/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entite.Review;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Hamza
 */
public class NoteMetier {
    public static int moy=0,satis=0,global=0,qp=0,ser=0;
    
    public static int calculNote (int x){
    int  i=1;  
 
       ReviewServices service = new ReviewServices();
       ArrayList array = (ArrayList) service.selectAllById(x);
       ArrayList res = new ArrayList() ;

       for (Iterator it = array.iterator(); it.hasNext();) {
            Review obj = (Review) it.next();
           
            qp=qp+obj.getQualitePrix();
            ser=ser+obj.getService();
            satis= satis+obj.getSatisfaction();
            global=global+obj.getGlobalMark();
        }
            global=global/array.size();
            qp=qp/array.size();
            ser=ser/array.size();
            satis= satis/ array.size();
          
            res.add(global);
            res.add(qp);
            res.add(ser);
            res.add(satis);
            return global;
   } 

   
}
