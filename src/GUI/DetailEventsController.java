/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.EventListController.PBevent;
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
import  com.lynden.gmapsfx.service.directions. * ;
import  java.net.URL ;
import  java.util.ResourceBundle ;
import  javafx.beans.property.SimpleStringProperty ;
import  javafx.beans.property.StringProperty ;
import  javafx.event.ActionEvent ;
import  javafx.fxml.FXML ;
import  javafx.fxml.Initializable ;
import javafx.scene.control.Label;
import  javafx.scene.control.TextField ;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author ThinkPad
 */
public class DetailEventsController implements Initializable , MapComponentInitializedListener , DirectionsServiceCallback {

    protected DirectionsService directionsService;
    protected DirectionsPane directionsPane;

    protected StringProperty from = new SimpleStringProperty();
    protected StringProperty to = new SimpleStringProperty();
    
    @FXML
    private TextField fromTextField;
    @FXML
    private TextField toTextField;
    @FXML
    private GoogleMapView mapView;
    @FXML
    private ImageView image;
    @FXML
    private Label title;
    @FXML
    private Label description;
    @FXML
    private Label tel;
    @FXML
    private Label price;
    @FXML
    private Label site;
   // private Label adresse;

    
    @FXML
    private void toTextFieldAction(ActionEvent event) {
        DirectionsRequest request = new DirectionsRequest(from.get(), to.get(), TravelModes.DRIVING);
        directionsService.getRoute(request, this, new DirectionsRenderer(true, mapView.getMap(), directionsPane));
    }

    @Override
    public void directionsReceived(DirectionsResult results, DirectionStatus status) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mapView.addMapInializedListener(this);
       toTextField.setText(PBevent.getCity());
        to.bindBidirectional(toTextField.textProperty());
        
        from.bindBidirectional(fromTextField.textProperty());
        
        title.setText(PBevent.getTitle() );
        description.setText(PBevent.getDescription());
        tel.setText(PBevent.getTelnumber()+"");
        price.setText(PBevent.getPrice()+"");
        site.setText(PBevent.getSiteUrl());
       // adresse.setText(PBevent.getCity());
        image.setImage(new Image("http://localhost/bpPI/web/images/"+PBevent.getNom_image(),200,200,true,true));
        
    }

    @Override
    public void mapInitialized() {
        MapOptions options = new MapOptions();

        options.center(new LatLong(36.907309999999995, 10.1893467))
                .zoomControl(true)
                .zoom(8)
                .overviewMapControl(false)
                .mapType(MapTypeIdEnum.ROADMAP);
        GoogleMap map = mapView.createMap(options);
        directionsService = new DirectionsService();
        directionsPane = mapView.getDirec();
    }
}