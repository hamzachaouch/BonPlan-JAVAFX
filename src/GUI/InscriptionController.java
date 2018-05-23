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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import utils.StaticValues;


/**
 * FXML Controller class
 *
 * @author Nassreddine
 */
public class InscriptionController implements Initializable {

    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField pre;
    @FXML
    private JFXTextField mail;
    @FXML
    private JFXTextField cin;
    @FXML
    private JFXPasswordField pass;
    @FXML
    private JFXTextField tel;
    public static FileInputStream f; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        // TODO
    }    

    @FXML
    private void image(ActionEvent event) {
           FileChooser fc = new FileChooser();
           FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(*.jpg)","*.JPG");
           FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("PNG files(*.png)","*.PNG");
           fc.getExtensionFilters().addAll(ext1,ext2);
           File file = fc.showOpenDialog(new Stage());
            BufferedImage bf;
            try {
                bf = ImageIO.read(file);
                
                f = new FileInputStream(file);
            }catch(Exception ex){
              System.out.println("zzzzeeeeeeeerrrrrrrrrrtttttttt");
            }
    }

    @FXML
    private void Auth(ActionEvent event) throws IOException {
        Parent parentInscit = FXMLLoader.load(getClass().getResource("Auth.fxml"));
        
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
        stageInscit .hide();
        
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        UserService us = new UserService();
        String n = name.getText();
        String p = pre.getText();
        String m = mail.getText();
        int ci = Integer.parseInt(cin.getText());
        int t =Integer.parseInt(tel.getText());
        String pas = pass.getText();
        
        Client client = 
         new Client(n, ci, p, n, m, m, 1, null, pas,null, null,"",
                t,f);
        us.adduser(client);
         StaticValues.client=client;
         client =  us.FindClientById(n);
             
        
               Parent parentInscit = FXMLLoader.load(getClass().getResource("Compt.fxml"));
        
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
        stageInscit .hide();
        
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }

    @FXML
    private void annul(ActionEvent event) {
        pass.setText("");
     name.setText("");
     pre.setText("");
     mail.setText("");
    cin.setText("");
    tel.setText("");
    }
    
}
