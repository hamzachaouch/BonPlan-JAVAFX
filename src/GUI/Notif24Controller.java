/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.EventListController.PBevent;
import Services.EventService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entite.Event;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import static org.bouncycastle.asn1.x500.style.RFC4519Style.name;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author ThinkPad
 */
public class Notif24Controller implements Initializable {

     @FXML
    private TableColumn<Event, ImageView> image;
    @FXML
    private TableColumn<Event, String> title;
    @FXML
    private TableColumn<Event, String> description;
    @FXML
    private TableColumn<Event,String> type;
    @FXML
    private TableColumn<Event,String> city;
    @FXML
    private TableColumn<Event,Float> price;
    @FXML
    private TableColumn<Event, Date> date;
    @FXML
    private Rectangle pane;
    @FXML
    private TableView<?> tabp;
    
    public static Event PBevent=null;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       EventService eventService = new EventService();
      ArrayList arrayList = (ArrayList) eventService.Notif24();
      ObservableList observableList = FXCollections.observableArrayList(arrayList);
        tabp.setItems(observableList);

       image.setCellValueFactory(c -> new SimpleObjectProperty<ImageView>(new ImageView(new Image("http://localhost/bpPI/web/images/"+c.getValue().getNom_image(),200,200,true,true))));
// image.setCellValueFactory(new PropertyValueFactory<>("images"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
         description.setCellValueFactory(new PropertyValueFactory<>("description"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
         city.setCellValueFactory(new PropertyValueFactory<>("city"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
         date.setCellValueFactory(new PropertyValueFactory<>("date"));
    }    

   
           
    
   

    @FXML
    private void Detailsevents(MouseEvent event) throws IOException {
        
        PBevent = (Event) tabp.getSelectionModel().getSelectedItem();
         Parent parentInscit = FXMLLoader.load(getClass().getResource("DetailEvents.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
        
    }


  

    

    private void ListEvent(ActionEvent event) {
          EventService eventService = new EventService();
      ArrayList arrayList = (ArrayList) eventService.eventClient();
      ObservableList observableList = FXCollections.observableArrayList(arrayList);
        tabp.setItems(observableList);

       image.setCellValueFactory(c -> new SimpleObjectProperty<ImageView>(new ImageView(new Image("http://localhost/bpPIDEV/web/images/"+c.getValue().getNom_image(),200,200,true,true))));
// image.setCellValueFactory(new PropertyValueFactory<>("images"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
         description.setCellValueFactory(new PropertyValueFactory<>("description"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
         city.setCellValueFactory(new PropertyValueFactory<>("city"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
         date.setCellValueFactory(new PropertyValueFactory<>("date"));
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
