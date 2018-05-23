/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entite.Categorie;
import java.util.ArrayList;

/**
 *
 * @author Nassreddine
 */
public interface CategorieInterface {
   public void addCategorie(Categorie cat);
    public void deleteCategorie();
    public ArrayList<String> selectAllCategorie();
    public int nbProp(); 
}
