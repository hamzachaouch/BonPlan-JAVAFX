/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.EventService;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ThinkPad
 */
public class FXMLnotifController implements Initializable {

   // private Label idLab;
    @FXML
    private JFXButton idbut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EventService ev = new EventService();
        int nb = ev.notification24();
        String nnb = Integer.toString(nb);
        idbut.setText(nnb);
       // idLab.setText(nnb);
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
    }
    

