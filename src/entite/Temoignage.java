/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author chupa
 */
public class Temoignage {
    private int id ;
    private String avis;

    public Temoignage(int id, String avis) {
        this.id = id;
        this.avis = avis;
    }

    public Temoignage() {
    }

    
    
    public Temoignage(String avis) {
        this.avis = avis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvis() {
        return avis;
    }

    public void setAvis(String avis) {
        this.avis = avis;
    }
    
    
    
}
