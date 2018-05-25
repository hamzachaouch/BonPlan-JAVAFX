/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.EventService;
import com.jfoenix.controls.JFXButton;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import utils.StaticValues;

/**
 * FXML Controller class
 *
 * @author ThinkPad
 */
public class AcceuilController implements Initializable {

    @FXML
    private ImageView imm;
    @FXML
    private Label pre;
    @FXML
    private Label mail;
    @FXML
    private Label tel;
    @FXML
    private Button idbut;
    @FXML
    private VBox vb;
    @FXML
    private ImageView accueil;
    @FXML
    private JFXButton prop;
    @FXML
    private JFXButton mesq;
    @FXML
    private JFXButton form;
    @FXML
    private JFXButton group;
    @FXML
    private JFXButton exit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pre.setText(StaticValues.client.getUsername());
        mail.setText(StaticValues.client.getEmail());
         
      
    }    

    @FXML
    private void goToAcc(ActionEvent event) {
    }

    @FXML
    private void gotoGestion(ActionEvent event) throws IOException {
          Parent parentInscit = FXMLLoader.load(getClass().getResource("Proposition.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }

    @FXML
    private void goToUpdate(ActionEvent event) throws IOException {
           Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLEditProfCli.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
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
    private void goToEvent(ActionEvent event) throws IOException {
        Parent parentInscit = FXMLLoader.load(getClass().getResource("EventList.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }

    @FXML
    private void NotAction(ActionEvent event) throws IOException {
          Parent parentInscit = FXMLLoader.load(getClass().getResource("Notif24.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }

    @FXML
    private void goToCompany(ActionEvent event) throws IOException {
            Parent parentInscit = FXMLLoader.load(getClass().getResource("ListCompanyClient.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }

    @FXML
    private void goToDeals(ActionEvent event) throws IOException {
              Parent parentInscit = FXMLLoader.load(getClass().getResource("ListDealsClient.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }
    
}
