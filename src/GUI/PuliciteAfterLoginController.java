/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Ads;
import entite.User;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.AdsService;
import utils.StaticVariables;

/**
 * FXML Controller class
 *
 * @author ghaz Nada
 */
public class PuliciteAfterLoginController implements Initializable {

    @FXML
    private Label nomUser;
    @FXML
    private Button logout;
    @FXML
    private TableColumn<Ads, String> titre;
    @FXML
    private TableColumn<Ads, Date> debut;
    @FXML
    private TableColumn<Ads, Date> fin;
    @FXML
    private TableColumn<Ads, String> ville;
    @FXML
    private TableColumn<Ads, Integer> vue;
    @FXML
    private Button ajoutPub;
    @FXML
    private TableView<Ads> tablePub;

      AdsService service = new AdsService();
       ArrayList<Ads> listAds = service.selectAllAdsCompany();
       ObservableList observableList = FXCollections.observableArrayList(listAds);
    @FXML
    private Label noticeDetail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       

       tablePub.setItems(observableList);
       titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
       debut.setCellValueFactory(new PropertyValueFactory<>("dateBegin"));
       fin.setCellValueFactory(new PropertyValueFactory<>("dateEnd"));
       ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
       vue.setCellValueFactory(new PropertyValueFactory<>("views"));
    }    

    @FXML
    private void logOutAction(ActionEvent event) throws IOException {
        AuthController.connected = null;
        ((Node) event.getSource()).getScene().getWindow().hide(); 
                    Parent pa = FXMLLoader.load(getClass().getResource("/gui/Authentification.fxml"));
                    Stage stage = new Stage();
                    Scene sce = new Scene(pa);
                    stage.setScene(sce);
                    stage.setTitle("à plutôt tard");
                    stage.show();
    }

    @FXML
    private void ajoutPubAction(ActionEvent event) throws IOException {
                ((Node) event.getSource()).getScene().getWindow().hide(); 
                    Parent pa = FXMLLoader.load(getClass().getResource("/gui/Ajouter.fxml"));
                    Stage stage = new Stage();
                    Scene sce = new Scene(pa);
                    stage.setScene(sce);
                    stage.setTitle("à plutôt tard");
                    stage.show();
    }

    @FXML
    private void DetailAction(ActionEvent event) throws IOException {
        
         StaticVariables.selectedAdsCompany = tablePub.getSelectionModel().getSelectedItem();
         if (StaticVariables.selectedAdsCompany == null ){
             noticeDetail.setText("il faut choisir une publicité");
         }else {
         
         ((Node) event.getSource()).getScene().getWindow().hide(); 
         Parent pa = FXMLLoader.load(getClass().getResource("/gui/DetailAdsCompany.fxml"));
         Stage stage = new Stage();
         Scene sce = new Scene(pa);
         stage.setScene(sce);
         stage.setTitle("welcome to back");
         stage.show();
    }
    }
}
