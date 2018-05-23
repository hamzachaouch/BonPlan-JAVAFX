/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.NoteMetier;
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
import utils.StaticVariables;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class CompteEntreprise implements Initializable {

    @FXML
    private Pane pane;
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
    @FXML
    private JFXButton pub;
    @FXML
    private Rating rate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     //   double x =(double) NoteMetier.calculNote(1) ;
   //     rate.ratingProperty().setValue(x);
         pre.setText(StaticVariables.company.getName());

        lblMail.setText(StaticVariables.company.getEmail());
        lBlTel.setText(StaticVariables.company.getAddress());

    }    


    @FXML
    private void EditProfil(ActionEvent event) {
  
    }

    @FXML
    private void deconectAction(ActionEvent event) {
   
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
    private void event(ActionEvent event) throws IOException {
          Parent parentInscit = FXMLLoader.load(getClass().getResource("MesEvenemnts.fxml"));
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
    
}
