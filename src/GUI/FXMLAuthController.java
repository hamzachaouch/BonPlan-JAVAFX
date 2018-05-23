/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import entite.Admin;
import entite.Client;
import entite.User;

import Services.UserService;
import utils.StaticValues;

/**
 * FXML Controller class
 *
 * @author Nassreddine
 */
public class FXMLAuthController implements Initializable {

   
    @FXML
    private JFXTextField txtLog;
    @FXML
    private JFXPasswordField txtPass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           
    }    

    @FXML
    private void logAction(ActionEvent event) throws IOException {
         
    }
    
   

   

    @FXML
    private void inscritAction(ActionEvent event) throws IOException {
         Parent parentInscit = FXMLLoader.load(getClass().getResource("AjoutEntreprise.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }

    @FXML
    private void loginAction(ActionEvent event) throws IOException {
        String l = txtLog.getText();
        String p = txtPass.getText();
        UserService us = new UserService();
        User check = us.Authentification(l,p);
        StaticValues.user=check;
        
        if(check!=null){
          if( check.getRole().equals("a:0:{}")){
              Client c = (Client) us.Authentification(l,p);
              StaticValues.client=c;
               Parent parentInscit = FXMLLoader.load(getClass().getResource("Compt.fxml"));
        
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
        stageInscit .hide();
        
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
        
          }
        else{
              Admin a = (Admin) us.Authentification(l,p);
              StaticValues.admin=a;
              Parent parentInscit = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
        stageInscit .hide();
        
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
                }
        }
        else{
          JOptionPane d = new JOptionPane();
              d.showMessageDialog( null, "Nom utilisateur ou mot de pass incorrecte", 
               "le titre", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
