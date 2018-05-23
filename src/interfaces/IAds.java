/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import java.util.List;

/**
 *
 * @author Seif Bejaoui
 */
//int générique:car il a T c est un param
public interface IAds<T> {
    public void insert(T obj);
    public boolean delete(T obj);
    public boolean update(T obj);
    public T  Rechercher(int id);
    public List<T> selectAll();

}
