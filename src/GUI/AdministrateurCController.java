/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ThinkPad
 */
public class AdministrateurCController implements Initializable {

    @FXML
    private ImageView ima;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goToAcc(ActionEvent event) {
    }

    @FXML
    private void goToCom(ActionEvent event) throws IOException {
          Parent parentInscit = FXMLLoader.load(getClass().getResource("ListCompanyAdmin.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }

    @FXML
    private void gogestionEvent(ActionEvent event) throws IOException {
         Parent parentInscit = FXMLLoader.load(getClass().getResource("EvenementAdmin.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }

    @FXML
    private void gotoGestionAvis(ActionEvent event) throws IOException {
          Parent parentInscit = FXMLLoader.load(getClass().getResource("ListDeals.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
        
    }

    @FXML
    private void goToPro(ActionEvent event) throws IOException {
             Parent parentInscit = FXMLLoader.load(getClass().getResource("PropositionAdmin.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }

    @FXML
    private void gogestionAds(ActionEvent event) throws IOException {
                 ((Node) event.getSource()).getScene().getWindow().hide(); 
                    Parent pa = FXMLLoader.load(getClass().getResource("ValiderAds.fxml"));
                    Stage stage = new Stage();
                    Scene sce = new Scene(pa);
                    stage.setScene(sce);
                    stage.setTitle("welcome to back");
                    stage.show(); 
                            }
    

    @FXML
    private void deconect(ActionEvent event) throws IOException {
                Parent parentInscit = FXMLLoader.load(getClass().getResource("Auth.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }

    @FXML
    private void goUpdt(ActionEvent event) throws IOException {
         Parent parentInscit = FXMLLoader.load(getClass().getResource("EditAdmin.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }
    
}
