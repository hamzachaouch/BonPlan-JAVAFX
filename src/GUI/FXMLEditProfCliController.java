/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.UserService;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entite.Client;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
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
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import utils.StaticValues;

/**
 * FXML Controller class
 *
 * @author Nassreddine
 */
public class FXMLEditProfCliController implements Initializable {

    @FXML
    private JFXTextField mail;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField tel;
    @FXML
    private JFXTextField user;
    @FXML
    private JFXPasswordField pass;
    @FXML
    private Button but;
     public static FileInputStream ff;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user.setText(StaticValues.client.getUsername());
    
        mail.setText(StaticValues.client.getEmail());
        pass.setText(StaticValues.client.getPassword());
      
        // TODO
    }    

    @FXML
    private void select(ActionEvent event) {
           FileChooser fc = new FileChooser();
           FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(*.jpg)","*.JPG");
           FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("PNG files(*.png)","*.PNG");
           fc.getExtensionFilters().addAll(ext1,ext2);
           File file = fc.showOpenDialog(new Stage());
            BufferedImage bf;
            try {
                bf = ImageIO.read(file);
                
                ff = new FileInputStream(file);
            }catch(Exception ex){
              System.out.println("zzzzeeeeeeeerrrrrrrrrrtttttttt");
            }
    }

    @FXML
    private void update(ActionEvent event) throws IOException {
        UserService us = new UserService();
        
        String n = user.getText();
        String nn = nom.getText();
        String m = mail.getText();
        String p = pass.getText();
        int t =Integer.parseInt(tel.getText());
        
        StaticValues.client.setUsername(n);
      
        StaticValues.client.setEmail(m);
        StaticValues.client.setPassword(p);
      
   
        us.updateUserClient(StaticValues.client); 
        
        Client c = (Client) us.Authentification(n,p);
              StaticValues.client=c;
               Parent parentInscit = FXMLLoader.load(getClass().getResource("Compt.fxml"));
        
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
        stageInscit .hide();
        
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }

    @FXML
    private void anul(ActionEvent event) {
    }

    @FXML
    private void compt(ActionEvent event) throws IOException {
         String n = user.getText();
        String nn = nom.getText();
        String m = mail.getText();
        String p = pass.getText();
        UserService us = new UserService();
        Client c = (Client) us.Authentification(n,p);
              StaticValues.client=c;
               Parent parentInscit = FXMLLoader.load(getClass().getResource("Compt.fxml"));
        
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
        stageInscit .hide();
        
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }
    
}
