/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author ThinkPad
 */
public class EtablissementController implements Initializable {

    @FXML
    private Pane pane;
    @FXML
    private JFXButton pub;
    @FXML
    private Rating rate;
    @FXML
    private Label pre;
    @FXML
    private Label lblNot;
    @FXML
    private ImageView iimm;
    @FXML
    private Label lblMail;
    @FXML
    private Label lBlTel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void review(ActionEvent event) throws IOException {
                 Parent parentInscit = FXMLLoader.load(getClass().getResource("ListDeals.fxml"));
            Scene sceneInscit = new Scene(parentInscit);
            Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
            stageInscit .setScene(sceneInscit );
            stageInscit .show();
    }

    @FXML
    private void EditProfil(ActionEvent event) {
    }

    @FXML
    private void event(ActionEvent event) throws IOException {
            Parent parentInscit = FXMLLoader.load(getClass().getResource("MesEvenements.fxml"));
            Scene sceneInscit = new Scene(parentInscit);
            Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
            stageInscit .setScene(sceneInscit );
            stageInscit .show();
    }

    @FXML
    private void publicité(ActionEvent event) throws IOException {
               Parent parentInscit = FXMLLoader.load(getClass().getResource("publiciteAfterLogin.fxml"));
            Scene sceneInscit = new Scene(parentInscit);
            Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
            stageInscit .setScene(sceneInscit );
            stageInscit .show();
    }

    @FXML
    private void deconectAction(ActionEvent event) throws IOException {
            Parent parentInscit = FXMLLoader.load(getClass().getResource("Auth.fxml"));
            Scene sceneInscit = new Scene(parentInscit);
            Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
            stageInscit .setScene(sceneInscit );
            stageInscit .show();
    }
    
}
