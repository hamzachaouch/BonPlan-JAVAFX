/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entite.Review;
import java.util.List;

/**
 *
 * @author Hamza
 */
public interface IReview {
    
    public void insert(Review r);
    public List<Review> selectAll();
    public void supprimer(int id);
    public List<Review> rechAvecId(Review r);
    public void update(Review p) ;

    
    
    
    
    
    
    
    
    
}
