/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import entite.Company;
import java.util.List;

/**
 *
 * @author HP
 */
public interface CompanyInterface {
    public void insert(Company c);
    public List<Company> selectAll();   
    public List<Company> selectAllRestaurant();
    public List<Company> selectAllHotel();
    public List<Company> selectAllSalondethe();
    public List<Company> selectAllRandonnee();
    public List<Company> selectAllCinema();
    public void update(Company c);
    public void delete (int idCompany);
    public List<Company> searchbyVille(String v);
    public List<Company> searchbyType(Company c);
    public Company selectById(int id);
    public Company Authentification(String login , String password);
    public void debloquer(Company c);

}
