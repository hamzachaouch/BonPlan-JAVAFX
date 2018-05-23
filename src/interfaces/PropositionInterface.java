/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entite.Proposition;
import java.util.ArrayList;

/**
 *
 * @author Nassreddine
 */
public interface PropositionInterface {
    public void insertPropsition(Proposition p);
     public void deleatePrposition(int id);
     public void UpdateProposition(Proposition p);
     public ArrayList<Proposition> selectAllProposition();
     public ArrayList<Proposition> findPropById(int id);
     public ArrayList<String> findCategorie();
     public boolean rechercherEtudiant(String nom,ArrayList<String> lst);
     public boolean existProposition(String name,String categorie,String city);
     public int nbPropo();
     public double avgMoyRestaurant();
     public double avgMoyCafé();
     public double avgMoyHot();
     public double avgMoyCinéma();
     public double avgMoyCategorie(String cat);
}
