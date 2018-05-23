/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.util.Objects;

/**
 *
 * @author Nassreddine
 */
public class Proposition {
     private int id;
    private String name;
    private String categorie;
    private String autre;
    private String city;
    private String dateV;
    private String site;
    private String description;
    private String img;
    private int idCli;
  public Proposition(String categorie){this.categorie=categorie;}

    public Proposition(String name, String categorie, String city) {
        this.name = name;
        this.categorie = categorie;
        this.city = city;
    }
    public Proposition(String name, String categorie, String autre, String city, String dateV, String site,
            String description,String img) {
        this.name = name;
        this.categorie = categorie;
        this.autre = autre;
        this.city = city;
        this.dateV = dateV;
        this.site = site;
        this.description = description;
        this.img = img;
        
    }
     public Proposition(String name, String categorie, String autre, String city, String site,
            String description) {
        this.name = name;
        this.categorie = categorie;
        this.autre = autre;
        this.city = city;
        this.site = site;
        this.description = description;
       
    }
    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }
    
       public Proposition(int id, String name, String categorie, String autre, String city, String dateV, String site,String description, String img) {
        this.id = id;
        this.name = name;
        this.categorie = categorie;
        this.autre = autre;
        this.city = city;
        this.dateV = dateV;
        this.site = site;
        this.description = description;
        this.img = img;
    }
       public Proposition( String name, String categorie, String autre, String city,
               String dateV, String site,String description, String img, int idCli) {
        this.name = name;
        this.categorie = categorie;
        this.autre = autre;
        this.city = city;
        this.dateV = dateV;
        this.site = site;
        this.description = description;
        this.img = img;
        this.idCli=idCli;
    }

    public Proposition(int id, String name, String categorie, String autre, String city, String site, String description, int idCli) {
        this.id = id;
        this.name = name;
        this.categorie = categorie;
        this.autre = autre;
        this.city = city;
        this.site = site;
        this.description = description;
        this.idCli = idCli;
    }

    public Proposition(int id, String name, String categorie, String autre, String city, String dateV,
            String site, String description, String img, int idCli) {
        this.id = id;
        this.name = name;
        this.categorie = categorie;
        this.autre = autre;
        this.city = city;
        this.dateV = dateV;
        this.site = site;
        this.description = description;
        this.img = img;
        this.idCli = idCli;
    }

    public Proposition(int id, String name, String categorie, String autre, String city, String site, String description) {
        this.id = id;
        this.name = name;
        this.categorie = categorie;
        this.autre = autre;
        this.city = city;
        this.site = site;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getAutre() {
        return autre;
    }

    public void setAutre(String autre) {
        this.autre = autre;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDateV() {
        return dateV;
    }

    public void setDateV(String dateV) {
        this.dateV = dateV;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Proposition other = (Proposition) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.categorie, other.categorie)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Proposition{" + "id=" + id + ", name=" + name + ", categorie=" + categorie + ", autre=" + autre + ", city=" + city + ""
                + ", dateV=" + dateV + ", site=" + site + ", description=" + description + ", img=" + img + '}';
    }

   
}
