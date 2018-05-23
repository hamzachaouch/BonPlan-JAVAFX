/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Ads;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;
import services.AdsService;
import utils.StaticVariables;

/**
 * FXML Controller class
 *
 * @author ghaz Nada
 */
public class ValiderAdsController implements Initializable {

    @FXML
    private TableView<Ads> tableAds;
 
    @FXML
    private TableColumn<Ads, String> titreColum;
    @FXML
    private TableColumn<Ads, Date> dateDebutColumn;
    @FXML
   private TableColumn<Ads, Date> dateFinColumn;
    @FXML
    private TableColumn<Ads, String> villeColumn;

    
    AdsService service = new AdsService();
    ArrayList<Ads> listAds = service.selectNoneValidateAds();
    ObservableList observableList = FXCollections.observableArrayList(listAds);
    @FXML
    private Label noticeSelection;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rbf) {
        // TODO
         tableAds.setItems(observableList);

       titreColum.setCellValueFactory(new PropertyValueFactory<>("titre"));
       dateDebutColumn.setCellValueFactory(new PropertyValueFactory<>("dateBegin"));
       dateFinColumn.setCellValueFactory(new PropertyValueFactory<>("dateEnd"));
       villeColumn.setCellValueFactory(new PropertyValueFactory<>("ville"));
    }    

    @FXML
    private void logout(ActionEvent event) throws IOException {
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
    private void ValiderAds(ActionEvent event) throws IOException {
        StaticVariables.AdsNoneValidated = tableAds.getSelectionModel().getSelectedItem();
         if (StaticVariables.AdsNoneValidated == null ){
             noticeSelection.setText("il faut choisir une publicité");
         }else {
             service.validerAds(StaticVariables.AdsNoneValidated);
                                  showMessageDialog(null, "confirmer la validation");


        ((Node) event.getSource()).getScene().getWindow().hide(); 
         Parent pa = FXMLLoader.load(getClass().getResource("/gui/ValiderAds.fxml"));
         Stage stage = new Stage();
         Scene sce = new Scene(pa);
         stage.setScene(sce);
         stage.setTitle("welcome to back");
         stage.show();
         }
        
    }
    
    
      @FXML
    private void refuserAds(ActionEvent event) throws IOException {
        StaticVariables.AdsNoneValidated = tableAds.getSelectionModel().getSelectedItem();
         if (StaticVariables.AdsNoneValidated == null ){
             noticeSelection.setText("il faut choisir une publicité");
         }else {
             service.delete(StaticVariables.AdsNoneValidated);
                     showMessageDialog(null, "confirmer la supression");


        ((Node) event.getSource()).getScene().getWindow().hide(); 
         Parent pa = FXMLLoader.load(getClass().getResource("/gui/ValiderAds.fxml"));
         Stage stage = new Stage();
         Scene sce = new Scene(pa);
         stage.setScene(sce);
         stage.setTitle("welcome to back");
         stage.show();
         }
        
    }
    
}
