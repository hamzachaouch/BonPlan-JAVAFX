/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ThinkPad
 */
public class NewController implements Initializable {

    @FXML
    private AnchorPane bigAnchor;
    @FXML
    private AnchorPane ancho1;
    @FXML
    private Label SignIn;
    @FXML
    private JFXTextField pseudo;
    @FXML
    private JFXPasswordField passwd;
    @FXML
    private JFXButton log;
    @FXML
    private JFXButton forgotPass;
    @FXML
    private AnchorPane anchro2;
    @FXML
    private Label keep;
    @FXML
    private JFXButton sgUp;
    @FXML
    private JFXButton admin;
    @FXML
    private Label output;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onclickedProfilUser(ActionEvent event) {
    }

    @FXML
    private void onclickedRecupererPass(ActionEvent event) {
    }

    @FXML
    private void onclickedInscription(ActionEvent event) {
    }

    @FXML
    private void onclickedEspaceAdmin(ActionEvent event) {
    }
    
}
