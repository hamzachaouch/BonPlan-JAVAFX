/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.DealsServices;
import Services.EventService;
import Services.ReviewServices;
import entite.Deals;
import entite.Review;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class ListDealsController implements Initializable {
    public static Deals modif = null;
   
    @FXML
    private TableView<Deals> tabp;
    @FXML
    private TableColumn<Deals,ImageView> image;
    @FXML
    private TableColumn<Deals,String> name;
    @FXML
    private TableColumn<Deals,String> description;
    @FXML
    private TableColumn<Deals,String> lieux;
    @FXML
    private TableColumn<Deals,Integer> price;
    @FXML
    private TableColumn<Deals,Date> dateDeb;
    @FXML
    private TableColumn<Deals,Date> dateFin;
    @FXML
    private Rectangle pane;
    @FXML
    private Button Ajouter;
    @FXML
    private Button Modifier;
    @FXML
    private Button Supprimer;
    @FXML
    private Button recherche;
    @FXML
    private TextField x;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          DealsServices service = new DealsServices();
      ArrayList arrayList = (ArrayList) service.selectAll();
      ObservableList observableList = FXCollections.observableArrayList(arrayList);
        tabp.setItems(observableList);
        //image.setCellValueFactory(new PropertyValueFactory<>("imgUrl"));
        image.setCellValueFactory(c -> new SimpleObjectProperty<ImageView>(
             new ImageView(new Image("http://localhost/bpPI/web/images/"+c.getValue().getImgUrl(),200,200,true,true))));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        lieux.setCellValueFactory(new PropertyValueFactory<>("address"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        if (true) {
            
        
        dateDeb.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        dateFin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
    } 
    }   

    @FXML
    private void Ajouter(ActionEvent event) throws IOException {
        Parent parentInscit = FXMLLoader.load(getClass().getResource("AjoutDeal.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }

    @FXML
    private void Modifier(ActionEvent event) throws IOException {
        Deals c = tabp.getSelectionModel().getSelectedItem();
         if(c==null)
         {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ATTENTION");
            alert.setContentText("Verifier votre choix!");
            alert.showAndWait();
         }
         else
         {
            modif=tabp.getSelectionModel().getSelectedItem();
            Parent parentInscit = FXMLLoader.load(getClass().getResource("ModifDeal.fxml"));
            Scene sceneInscit = new Scene(parentInscit);
            Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
           // stageInscit .hide();
            stageInscit .setScene(sceneInscit );
            stageInscit .show();
         } 
        
    }

    @FXML
    private void supprimer(ActionEvent event) {
            Deals c = tabp.getSelectionModel().getSelectedItem();
         if(c==null)
         {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ATTENTION");
           
            alert.setContentText("Verifier votre choix!");
            alert.showAndWait();
         }
         else
         {
             DealsServices s =new DealsServices();
             s.supprimer(c.getId());
             refrachTable();
         } 
    }
       public  void refrachTable()
    {   
        DealsServices service = new DealsServices();
        ArrayList arrayList = (ArrayList) service.selectAll();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        tabp.setItems(observableList);
        image.setCellValueFactory(new PropertyValueFactory<>("imgUrl"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        lieux.setCellValueFactory(new PropertyValueFactory<>("address"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        dateDeb.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        dateFin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        
    
    }

    @FXML
    private void recherche(ActionEvent event) {
        DealsServices service = new DealsServices();
        ArrayList arrayList = (ArrayList) service.rechAvecPrice(Float.parseFloat(x.getText()));
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        tabp.setItems(observableList);
         image.setCellValueFactory(c -> new SimpleObjectProperty<ImageView>(
             new ImageView(new Image("http://localhost/bpPI/web/images/"+c.getValue().getImgUrl(),200,200,true,true))));
      name.setCellValueFactory(new PropertyValueFactory<>("name"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        lieux.setCellValueFactory(new PropertyValueFactory<>("address"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        dateDeb.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        dateFin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        
    
    
    }

  
}
