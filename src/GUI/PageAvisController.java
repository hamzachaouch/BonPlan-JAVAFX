/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.ListCompanyClientController.rClient;
import Services.EventService;
import Services.ReviewServices;
import entite.Review;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class PageAvisController implements Initializable {

    @FXML
    private TableView<?> tabp;
    @FXML
    private TableColumn<Review, ImageView> image;
    @FXML
    private TableColumn<Review, String> title;
    @FXML
    private TableColumn<Review, String> description;
    @FXML
    private TableColumn<Review, String> city;
    @FXML
    private Rectangle pane;
    @FXML
    private Button Ajouter;
    @FXML
    private Button Modifier;
    @FXML
    private Button Supprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ReviewServices eventService = new ReviewServices();
      ArrayList arrayList = (ArrayList) eventService.selectAllById(rClient.getId());
      ObservableList observableList = FXCollections.observableArrayList(arrayList);
        tabp.setItems(observableList);

       image.setCellValueFactory(c -> new SimpleObjectProperty<ImageView>(new ImageView(new Image("http://localhost/bpPI/web/images/"+rClient.getImg_url(),200,200,true,true))));
// image.setCellValueFactory(new PropertyValueFactory<>("images"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
         description.setCellValueFactory(new PropertyValueFactory<>("content"));
         city.setCellValueFactory(new PropertyValueFactory<>("service"));
    }    

    @FXML
    private void Ajouter(ActionEvent event) {
    }

    @FXML
    private void Modifier(ActionEvent event) {
    }

    @FXML
    private void supprimer(ActionEvent event) {
    }
    
}
