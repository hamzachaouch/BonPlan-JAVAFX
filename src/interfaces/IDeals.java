/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entite.Deals;
import java.util.List;

/**
 *
 * @author Hamza
 */
public interface IDeals {
 
    public void insert(Deals d);
    public List<Deals> selectAll();
    public void supprimer(int id);
    public List<Deals> rechAvecId(Deals d);
    public void update(Deals p) ;

}
