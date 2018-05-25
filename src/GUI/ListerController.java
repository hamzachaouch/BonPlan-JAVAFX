/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import entite.Ads;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.AdsService;
import utils.StaticVariables;
/**
 * FXML Controller class
 *
 * @author ghaz Nada
 */
public class ListerController implements Initializable {


    @FXML
    private ImageView imgPub;
    
   
    @FXML
    private TableView<Ads> listPub;
    @FXML
    private TableColumn<Ads, Date> dateDebut;
    @FXML
    private TableColumn<Ads, Date> dateFin;
    @FXML
    private TableColumn<Ads, String> ville;
    @FXML
    private TableColumn<Ads, Integer> vue;
    @FXML
    private TableColumn<Ads, String> titre;
    @FXML
    private AnchorPane listeAds;
    

        AdsService service = new AdsService();
       ArrayList<Ads> listAds = service.selectAll();
        ObservableList observableList = FXCollections.observableArrayList(listAds);
    @FXML
    private Label noticeSelection;
       
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
        // TODO
        listPub.setItems(observableList);
       titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
       dateDebut.setCellValueFactory(new PropertyValueFactory<>("dateBegin"));
       dateFin.setCellValueFactory(new PropertyValueFactory<>("dateEnd"));
       ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
       vue.setCellValueFactory(new PropertyValueFactory<>("views"));
       
    }    



    @FXML
    private void DetailAction(ActionEvent event) throws IOException {
        StaticVariables.selectedAds = listPub.getSelectionModel().getSelectedItem();
        
        if (StaticVariables.selectedAds == null){
            noticeSelection.setText("Il faut selection une publicité!");
        }else{
            
        service.updateViews(StaticVariables.selectedAds);
         ((Node) event.getSource()).getScene().getWindow().hide();
         Parent pa = FXMLLoader.load(getClass().getResource("/gui/DetailAds.fxml"));
         Stage stage = new Stage();
         Scene sce = new Scene(pa);
         stage.setScene(sce);
         stage.setTitle("welcome to back");
         stage.show();
        }
    }

    

    }    
    

