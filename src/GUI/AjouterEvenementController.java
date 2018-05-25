/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.DirectionsPane;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.InfoWindowOptions;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.service.directions.DirectionStatus;
import com.lynden.gmapsfx.service.directions.DirectionsRenderer;
import com.lynden.gmapsfx.service.directions.DirectionsRequest;
import com.lynden.gmapsfx.service.directions.DirectionsResult;
import com.lynden.gmapsfx.service.directions.DirectionsService;
import com.lynden.gmapsfx.service.directions.DirectionsServiceCallback;
import com.lynden.gmapsfx.service.directions.TravelModes;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import Services.EventService;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import entite.Event;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.DirectionsPane;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.service.directions.DirectionStatus;
import com.lynden.gmapsfx.service.directions.DirectionsResult;
import com.lynden.gmapsfx.service.directions.DirectionsService;
import com.lynden.gmapsfx.service.directions.DirectionsServiceCallback;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import static java.util.Date.from;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import org.controlsfx.control.textfield.TextFields;
import com.lynden.gmapsfx.GoogleMapView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import  com.lynden.gmapsfx.GoogleMapView ;
import  com.lynden.gmapsfx.MapComponentInitializedListener ;
import  com.lynden.gmapsfx.javascript.object. * ;
import  com.lynden.gmapsfx.service.geocoding.GeocoderStatus ;
import  com.lynden.gmapsfx.service.geocoding.GeocodingResult ;
import  com.lynden.gmapsfx.service.geocoding.GeocodingService ;
import  java.net.URL ;
import  java.util.ResourceBundle ;
import  javafx.beans.property.SimpleStringProperty ;
import  javafx.beans.property.StringProperty ;
import  javafx.event.ActionEvent ;
import  javafx.fxml.FXML ;
import  javafx.fxml.Initializable ;
import  javafx.scene.control.Alert ;
import  javafx.scene.control.TextField ;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.restfb.util.DateUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.internet.MailDateFormat;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.PrefixSelectionChoiceBox;
import org.joda.time.DateTime;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import utils.Upload;



/**
 * FXML Controller class
 *
 * @author ThinkPad
 */
public class AjouterEvenementController implements Initializable, MapComponentInitializedListener  {
    ObservableList<String> typeList = FXCollections.observableArrayList("Soire","Randonee","Voyage","Foire","Theatre");

    //@FXML
  //  private TextField title;
    private JFXTextField  fromTextField;

   /* @FXML
    private TextField city;
    @FXML
    private TextField price;
    @FXML
    private TextField tel;
    
    @FXML
    private TextArea description;
    
    @FXML
    private ChoiceBox typeBox;
   // @FXML
   // private DatePicker date;
    //@FXML
    //private TextField image;
   // @FXML
 //   private TextField site;
    
    */
    @FXML
    private Button Btn_Clear_Event;
    
    public static double longi ; 
    public static double lat ; 
    
     @FXML
    private Label loc1a;
        @FXML
    private Label loc1l;
    @FXML
        private GoogleMapView mapView;
    
      protected DirectionsService directionsService;

    protected DirectionsPane directionsPane;
    
    private GoogleMap map;
    
    private GeocodingService geocodingService;

    private StringProperty address = new SimpleStringProperty();
      private MarkerOptions markerOptions;
   // @FXML
    //private TextField path;
      private File file;
    private Image image;
    String pic;
    @FXML
    private JFXDatePicker date;
    @FXML
    private JFXTextField title;
    @FXML
    private JFXTextField site;
    @FXML
    private JFXTextField price;
    @FXML
    private JFXTextField city;
    @FXML
    private JFXTextField tel;
    @FXML
    private JFXTextField path;
    @FXML
    private JFXTextArea description;
    @FXML
    private PrefixSelectionChoiceBox typeBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          typeBox.setItems(typeList);
        typeBox.setValue("Soire");
         mapView.addMapInializedListener(this);
        address.bind(city.textProperty());
        
    
        
    }    

    @FXML
    private void Ajouter(ActionEvent event) throws IOException {
         Event e1 = new Event();
         if (title.getText().isEmpty()){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Vous devez entrez un titre");
        alert.showAndWait();
        }
       
                 
        else if(description.getText().isEmpty()){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Vous devez entrez une description");
        alert.showAndWait();
        }
           
        else if(site.getText().isEmpty()){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Vous devez entrez un site");
        alert.showAndWait();
        }
        else if(typeBox.getSelectionModel().isEmpty()){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Vous devez entrez un type");
        alert.showAndWait();
        }
                                  
        else if(city.getText().isEmpty()){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Vous devez entrez une adresse");
        alert.showAndWait();
        }
                         else if(tel.getText().isEmpty()){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Vous devez entrez une numéro Telephone");
        alert.showAndWait();
     

        
        
        }           
                                 else if(price.getText().isEmpty()){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Vous devez entrez un prix");
        alert.showAndWait();
        }
              else if(path.getText().isEmpty()){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Vous devez choisir une photo");
        alert.showAndWait();
        }
              
              else if(date.getValue().compareTo(LocalDate.now()) <0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Vous devez choisir une date supérieure ou égale à la date d'aujoud'hui");
        alert.showAndWait();
           }
            else     
                e1.setTitle(title.getText());
                e1.setDescription(description.getText());
                e1.setType((String) typeBox.getSelectionModel().getSelectedItem());
                e1.setDate(java.sql.Date.valueOf(date.getValue()));
                e1.setCity(city.getText());
                e1.setTelnumber( Integer.valueOf(tel.getText()));
                e1.setPrice(   Float.valueOf(price.getText()));
                e1.setSiteUrl(site.getText());
                //e1.setLongitude(Float.valueOf(longitude.getText()));
                //e1.setLatitude(Float.valueOf(latitude.getText()));
                e1.setLatitude(lat);
                e1.setLongitude(longi);
                e1.setNom_image(pic);
             
                e1.setId_Company(1);
                 EventService eventservice = new EventService();
                 eventservice.insert(e1);
                // new SmsServices().sendSms(new Sms("+216"+tel.getText(), "acount confirmation !! "));
                
                  String title = "Ajout Réussi";
        String message = "Evenement ajoutée avec Succes";
        
        TrayNotification tray = new TrayNotification();
        
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setAnimationType(AnimationType.POPUP);
        tray.setNotificationType(NotificationType.NOTICE);
        tray.showAndDismiss(Duration.seconds(5));
  
          Parent parentInscit = FXMLLoader.load(getClass().getResource("MesEvenements.fxml"));
            Scene sceneInscit = new Scene(parentInscit);
            Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
            stageInscit .hide();
            stageInscit .setScene(sceneInscit );
            stageInscit .show();
            
    }
    public void mapInitialized() {
        geocodingService = new GeocodingService();
        MapOptions mapOptions = new MapOptions();
        
        
        mapOptions.center(new LatLong(36.907309999999995, 10.1893467))  
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .zoom(10);
        

        map = mapView.createMap(mapOptions);

 

        
    }
    
  /*  
 @FXML
    public void addressTextFieldAction(ActionEvent event) {
        geocodingService.geocode(address.get(), (GeocodingResult[] results, GeocoderStatus status) -> {
            
            LatLong latLong = null;
            
            if( status == GeocoderStatus.ZERO_RESULTS) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No matching address found");
                alert.show();
                return;
            } else if( results.length > 1 ) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Multiple results found, showing the first one.");
                alert.show();
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
            } else {
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
            }
            
            map.setCenter(latLong);

        });
    }*/
           @FXML
    public void addressTextFieldAction(ActionEvent event) {
        geocodingService.geocode(address.get(), (GeocodingResult[] results, GeocoderStatus status) -> {
            
            LatLong latLong = null;

            
            if( status == GeocoderStatus.ZERO_RESULTS) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No matching address found");
                alert.show();
                return;
            } else if( results.length > 1 ) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Multiple results found, showing the first one.");
                alert.show();
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
                
AddMarker(latLong,address.get());
            } else {
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
                AddMarker(latLong,address.get());
            }
            System.out.println("result LG "+latLong.getLongitude()+ "   " +latLong.getLatitude());
            longi = latLong.getLongitude() ; 
            lat = latLong.getLatitude() ; 
            map.setCenter(latLong);
            
        });
    }
    
    private void AddMarker(LatLong l, String address) {

        Marker myMarker = null;
        markerOptions = new MarkerOptions();
        markerOptions.position(l)
                .title("My new Marker")
                .visible(true);

        myMarker = new Marker(markerOptions);
        InfoWindowOptions infoOptions = new InfoWindowOptions();
        infoOptions.content(address)
                .position(l);

        InfoWindow window = new InfoWindow(infoOptions);
        window.open(map, myMarker);
        map.addMarker(myMarker);
    }
    @FXML
    private void AnnulerEvent_onClick(ActionEvent event) throws IOException {
    Parent parentInscit = FXMLLoader.load(getClass().getResource("MesEvenements.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }
    

   
 

    @FXML
    private void imageUpload(ActionEvent event) throws IOException {
          
        FileChooser fileChooser = new FileChooser();
            file= fileChooser.showOpenDialog(null);
             FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

            path.setText("File:"+file);
            pic=(file.toURI().toString());
         //  pic=new Upload().upload(file,"uimg");
           pic=new Upload().upload(file,"images");
            System.out.println(pic);
       //  image= new Image("http://localhost/uimg/"+pic);
           image= new Image("http://localhost/bpPI/web/images"+pic);
          
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
           Parent parentInscit = FXMLLoader.load(getClass().getResource("MesEvenements.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }
    
}
