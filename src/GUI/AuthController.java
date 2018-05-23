/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.CompanyServices;
import Services.UserService;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entite.Admin;
import entite.Client;
import entite.Company;
import entite.User;
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
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import utils.StaticValues;
import utils.StaticVariables;

/**
 * FXML Controller class
 *
 * @author Nassreddine
 */
public class AuthController implements Initializable {

    static Object connected;

    @FXML
    private JFXTextField log;
    @FXML
    private JFXPasswordField pas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sinscrireAction(ActionEvent event) throws IOException {
         Parent parentInscit = FXMLLoader.load(getClass().getResource("Intermidiére.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }

    @FXML
    private void conect(ActionEvent event) throws IOException {
        String l = log.getText();
        String p = pas.getText();
        UserService us = new UserService();
        User check = us.Authentification(l,p);
        StaticValues.user=check;
        
        if(check!=null){
          if( check.getRole().equals("a:1:{i:0;s:11:\"ROLE_ADMIN\";}")){
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
              Parent parentInscit = FXMLLoader.load(getClass().getResource("AdminCompt.fxml"));
        
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
        stageInscit .hide();
        
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
                }
        }
        else{
                    CompanyServices cs = new CompanyServices();
                    StaticVariables.company =cs.selectBylogin(l);
                   
       Parent parentInscit = FXMLLoader.load(getClass().getResource("CompteEntreprise.fxml"));
        
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
        stageInscit .hide();
        
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
        }
    }
    
}
