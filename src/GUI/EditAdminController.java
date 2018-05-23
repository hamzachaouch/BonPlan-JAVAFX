/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.UserService;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entite.Admin;
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
public class EditAdminController implements Initializable {

    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField nomm;
    @FXML
    private JFXTextField mail;
    
    @FXML
    private JFXTextField tel;
    @FXML
    private Button but;
     public static FileInputStream fff;
    @FXML
    private JFXPasswordField piss;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nom.setText(StaticValues.admin.getUsername());
        nomm.setText(StaticValues.admin.getPrenom());
        mail.setText(StaticValues.admin.getEmail());
        piss.setText(StaticValues.admin.getPassword());
        String t = Integer.toString(StaticValues.admin.getTelphone());
        tel.setText(t);
        // TODO
    }    

    @FXML
    private void retourAction(ActionEvent event) throws IOException {
           UserService us = new UserService();
        String use = StaticValues.admin.getUsername();
         Admin c = us.FindAdmintById(use);
         StaticValues.admin=c;
        Parent parentInscit = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
        stageInscit .hide();
        
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }

    @FXML
    private void slectImg(ActionEvent event) {
        FileChooser fc = new FileChooser();
           FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(*.jpg)","*.JPG");
           FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("PNG files(*.png)","*.PNG");
           fc.getExtensionFilters().addAll(ext1,ext2);
           File file = fc.showOpenDialog(new Stage());
            BufferedImage bf;
            try {
                bf = ImageIO.read(file);
                
                fff = new FileInputStream(file);
            }catch(Exception ex){
              System.out.println("zzzzeeeeeeeerrrrrrrrrrtttttttt");
            }
    }

    @FXML
    private void updateAction(ActionEvent event) throws IOException {
        UserService us = new UserService();
        String n = nom.getText();
        String nn = nomm.getText();
        String m = mail.getText();
        String p = piss.getText();
        int t =Integer.parseInt(tel.getText());
        
        StaticValues.admin.setUsername(n);
        StaticValues.admin.setPrenom(nn);
        StaticValues.admin.setEmail(m);
        StaticValues.admin.setPassword(p);
        StaticValues.admin.setTelphone(t);
        if(but.isPressed()){
        StaticValues.admin.getPhotoprofilpath();
        }else{
          StaticValues.admin.setPhotoprofilpath(fff);
        }
        
        us.updateUserAdmin(StaticValues.admin); 
        
        Admin a = (Admin) us.Authentification(n,p);
              StaticValues.admin=a;
               Parent parentInscit = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
        stageInscit .hide();
        
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
        
    }
    

    @FXML
    private void annulAction(ActionEvent event) {
         nom.setText(StaticValues.admin.getUsername());
        nomm.setText(StaticValues.admin.getPrenom());
        mail.setText(StaticValues.admin.getEmail());
        piss.setText(StaticValues.admin.getPassword());
        String t = Integer.toString(StaticValues.admin.getTelphone());
        tel.setText(t);
    }
    
}
