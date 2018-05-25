/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.ListDealsClientController.modifClient;
import Services.CompanyServices;
import com.jfoenix.controls.JFXButton;
import entite.Company;
import entite.Deals;
import entite.Review;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class ListCompanyClientController implements Initializable {
        public static Company modifClient = null;
            public  static Company rClient=null;
    
    @FXML
    private TableView<Company> listClient;
    @FXML
    private TableColumn<Company, ImageView> image;
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
    private TextField rechercheVille;
    @FXML
    private Button avisSelect;
    @FXML
    private Button avisSelect1;
    @FXML
    private JFXButton re;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 CompanyServices s = new CompanyServices();
      ArrayList arrayList = (ArrayList) s.selectAll();
      ObservableList observableList = FXCollections.observableArrayList(arrayList);
        listClient.setItems(observableList);
        
        image.setCellValueFactory(e -> new SimpleObjectProperty<ImageView>(
             new ImageView(new Image("http://localhost/bpPI/web/images/"+e.getValue().getImg_url(),200,200,true,true))));

        nom.setCellValueFactory(new PropertyValueFactory<>("name"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("address"));
        ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
        premium.setCellValueFactory(new PropertyValueFactory<>("premium"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));    }    

    @FXML
    private void selectRestaurants(ActionEvent event) {
        CompanyServices service = new CompanyServices();
        ArrayList arrayList = (ArrayList) service.selectAllRestaurant();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
       listClient.setItems(observableList);

    image.setCellValueFactory(e -> new SimpleObjectProperty<ImageView>(
         new ImageView(new Image("http://localhost/bpPI/web/images/"+e.getValue().getImg_url(),200,200,true,true))));

        nom.setCellValueFactory(new PropertyValueFactory<>("name"));
         description.setCellValueFactory(new PropertyValueFactory<>("description"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
         adresse.setCellValueFactory(new PropertyValueFactory<>("address"));
        ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
         premium.setCellValueFactory(new PropertyValueFactory<>("premium"));
         email.setCellValueFactory(new PropertyValueFactory<>("email"));


    }

    @FXML
    private void selectSalon(ActionEvent event) {
        CompanyServices service = new CompanyServices();
        ArrayList arrayList = (ArrayList) service.selectAllSalondethe();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
       listClient.setItems(observableList);
        image.setCellValueFactory(img -> new SimpleObjectProperty<ImageView>(
         new ImageView(new Image("http://localhost/bpPI/web/images/"+img.getValue().getImg_url(),200,200,true,true))));

        nom.setCellValueFactory(new PropertyValueFactory<>("name"));
         description.setCellValueFactory(new PropertyValueFactory<>("description"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
         adresse.setCellValueFactory(new PropertyValueFactory<>("address"));
        ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
         premium.setCellValueFactory(new PropertyValueFactory<>("premium"));
         email.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    @FXML
    private void selectHotels(ActionEvent event) {
        CompanyServices service = new CompanyServices();
        ArrayList arrayList = (ArrayList) service.selectAllHotel();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        listClient.setItems(observableList);
        image.setCellValueFactory(e -> new SimpleObjectProperty<ImageView>(
            new ImageView(new Image("http://localhost/bpPI/web/images/"+e.getValue().getImg_url(),200,200,true,true))));
        nom.setCellValueFactory(new PropertyValueFactory<>("name"));
         description.setCellValueFactory(new PropertyValueFactory<>("description"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
         adresse.setCellValueFactory(new PropertyValueFactory<>("address"));
        ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
         premium.setCellValueFactory(new PropertyValueFactory<>("premium"));
         email.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    @FXML
    private void selectCinema(ActionEvent event) {
            CompanyServices service = new CompanyServices();
        ArrayList arrayList = (ArrayList) service.selectAllCinema();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
       listClient.setItems(observableList);
        image.setCellValueFactory(e -> new SimpleObjectProperty<ImageView>(
         new ImageView(new Image("http://localhost/bpPI/web/images/"+e.getValue().getImg_url(),200,200,true,true))));

        nom.setCellValueFactory(new PropertyValueFactory<>("name"));
         description.setCellValueFactory(new PropertyValueFactory<>("description"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
         adresse.setCellValueFactory(new PropertyValueFactory<>("address"));
        ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
         premium.setCellValueFactory(new PropertyValueFactory<>("premium"));
         email.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    @FXML
    private void selectVille(ActionEvent event) {
        CompanyServices service = new CompanyServices();
        ArrayList arrayList = (ArrayList) service.searchbyVille(rechercheVille.getText());
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        listClient.setItems(observableList);
         image.setCellValueFactory(e -> new SimpleObjectProperty<ImageView>(
         new ImageView(new Image("http://localhost/bpPI/web/images/"+e.getValue().getImg_url(),200,200,true,true))));
        nom.setCellValueFactory(new PropertyValueFactory<>("name"));
         description.setCellValueFactory(new PropertyValueFactory<>("description"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
         adresse.setCellValueFactory(new PropertyValueFactory<>("address"));
        ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
         premium.setCellValueFactory(new PropertyValueFactory<>("premium"));
         email.setCellValueFactory(new PropertyValueFactory<>("email"));
     
    }

    @FXML
    private void select(ActionEvent event) {
        CompanyServices service = new CompanyServices();
        ArrayList arrayList = (ArrayList) service.selectAll();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        listClient.setItems(observableList);
         image.setCellValueFactory(e -> new SimpleObjectProperty<ImageView>(
         new ImageView(new Image("http://localhost/bpPI/web/images/"+e.getValue().getImg_url(),200,200,true,true))));
        nom.setCellValueFactory(new PropertyValueFactory<>("name"));
         description.setCellValueFactory(new PropertyValueFactory<>("description"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
         adresse.setCellValueFactory(new PropertyValueFactory<>("address"));
        ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
         premium.setCellValueFactory(new PropertyValueFactory<>("premium"));
         email.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    @FXML
    private void avisSelect(ActionEvent event) throws IOException {
           Company r = (Company) listClient.getSelectionModel().getSelectedItem();
            rClient=r;
           Parent parentInscit;
            parentInscit = FXMLLoader.load(getClass().getResource("PageAvis.fxml"));
            Scene sceneInscit = new Scene(parentInscit);
            Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
            stageInscit .hide();
            stageInscit .setScene(sceneInscit );
            stageInscit .show();
    
    }

    @FXML
    private void donneravis(ActionEvent event) throws IOException {
    Company r = (Company) listClient.getSelectionModel().getSelectedItem();
            rClient=r;
      Parent parentInscit;
            parentInscit = FXMLLoader.load(getClass().getResource("AjoutAvis.fxml"));
            Scene sceneInscit = new Scene(parentInscit);
            Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
           // stageInscit .hide();
            stageInscit .setScene(sceneInscit );
            stageInscit .show();
    
    
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
            Parent parentInscit = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }
    
}
