/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.CategorieService;
import Services.PropositionService;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
//import org.jfree.data.category.DefaultCategoryDataset;

/**
 * FXML Controller class
 *
 * @author Nassreddine
 */
public class StatestiqueController implements Initializable {

    @FXML
    private PieChart pil1;
    @FXML
    private PieChart pile2;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       /* PropositionService ps = new PropositionService();
           DefaultCategoryDataset dcd = new  DefaultCategoryDataset();
           CategorieService cs = new CategorieService();
           ArrayList<String> arrayCat = cs.selectAllCategorie();
           String cat = null; 
           double d = 0.0;
           int nb = cs.nbProp();
           double tab[] = null; */
           
    }    

    @FXML
    private void AddCatAction(ActionEvent event) {
    }
    
}
