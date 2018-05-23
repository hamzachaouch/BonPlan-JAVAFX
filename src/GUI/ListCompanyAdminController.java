/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.CompanyServices;
import entite.Company;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ListCompanyAdminController implements Initializable {
    public static Company modifier = null;

    @FXML
    private TableView<Company> listCompany;
    @FXML
    private TableColumn<Company, String> nom;
    @FXML
    private TableColumn<Company, String> description;
    @FXML
    private TableColumn<Company, String> type;
    @FXML
    private TableColumn<Company, String> adresse;
    @FXML
    private TableColumn<Company, String> ville;
    @FXML
    private TableColumn<Company, Boolean> premium;
    @FXML
    private TableColumn<Company, String> email;
     @FXML
    private Button ajouterCompany;
     @FXML
    private Button supprimer;
    @FXML
    private TableColumn<Company, ImageView> image;
    @FXML
    private TableColumn<Company, Integer> etat;
    @FXML
    private Button debloquer;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      CompanyServices s = new CompanyServices();
      ArrayList arrayList = (ArrayList) s.selectAll();
      ObservableList observableList = FXCollections.observableArrayList(arrayList);
        listCompany.setItems(observableList);
         image.setCellValueFactory(e -> new SimpleObjectProperty<ImageView>(
         new ImageView(new Image("http://localhost/bpPI/web/images/"+e.getValue().getImg_url(),200,200,true,true))));
        nom.setCellValueFactory(new PropertyValueFactory<>("name"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
           
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
         adresse.setCellValueFactory(new PropertyValueFactory<>("address"));
        ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
         premium.setCellValueFactory(new PropertyValueFactory<>("premium"));
        email.setCellValueFactory(new PropertyValueFactory<>("email")); 
       
        etat.setCellValueFactory(new PropertyValueFactory<>("etat"));

        
    }    
 

    @FXML
    private void ajouterCompany (ActionEvent event) throws IOException {
        Parent parentInscit = FXMLLoader.load(getClass().getResource("AjoutEntreprise.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
   
    }
    
    @FXML
    private void debloquer(ActionEvent event) throws IOException {
        Company c = listCompany.getSelectionModel().getSelectedItem();
         if(c==null)
         {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ATTENTION");
           
            alert.setContentText("Verifier votre choix!");
            alert.showAndWait();
         }
         else
         {
            modifier=listCompany.getSelectionModel().getSelectedItem();
            Parent parentInscit = FXMLLoader.load(getClass().getResource("ModifierEntreprise.fxml"));
            Scene sceneInscit = new Scene(parentInscit);
            Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
            stageInscit .setScene(sceneInscit );
            stageInscit .show();
         } 
        
    }
    @FXML
     private void supprimer(ActionEvent event) throws IOException {
            Company c = listCompany.getSelectionModel().getSelectedItem();
         if(c==null)
         {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ATTENTION");
           
            alert.setContentText("Verifier votre choix!");
            alert.showAndWait();
         }
         else
         {
             CompanyServices supprimer =new CompanyServices();
             supprimer.delete(c.getId());
            
         } 
         Parent parentInscit = FXMLLoader.load(getClass().getResource("ListCompanyAdmin.fxml"));
            Scene sceneInscit = new Scene(parentInscit);
            Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
            stageInscit .setScene(sceneInscit );
            stageInscit .show();
    }
}
