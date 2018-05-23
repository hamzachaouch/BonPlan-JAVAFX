/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.ListDealsController.modif;
import Services.DealsServices;
import com.jfoenix.controls.JFXSlider;
import entite.Deals;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class ListDealsClientController implements Initializable {

    public static Deals modifClient = null;

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
    private AnchorPane s;
    @FXML
    private JFXSlider slider;

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
        dateDeb.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        dateFin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));    }    

    @FXML
    private void showDetailDeal(MouseEvent event) throws IOException {
            Deals c = (Deals) tabp.getSelectionModel().getSelectedItem();
            modifClient=c;
            Parent parentInscit;
            parentInscit = FXMLLoader.load(getClass().getResource("DealPage.fxml"));
            Scene sceneInscit = new Scene(parentInscit);
            Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
           // stageInscit .hide();
            stageInscit .setScene(sceneInscit );
            stageInscit .show();
    }
   

    /*

    @FXML
    private void recherche(MouseEvent event) {
      DealsServices service = new DealsServices();
        ArrayList arrayList;
        arrayList = (ArrayList) service.rechAvecPrice((float)(slider.getValue()));
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
*/
    @FXML
    private void recherche(ActionEvent event) {
         DealsServices service = new DealsServices();
        ArrayList arrayList;
        arrayList = (ArrayList) service.rechAvecPrice((float)(slider.getValue()));
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
