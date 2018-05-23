/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import utils.StaticValues;

/**
 * FXML Controller class
 *
 * @author Nassreddine
 */
public class AdminComptController implements Initializable {

    @FXML
    private ImageView ima;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          if(StaticValues.admin.getPhotoprofilpath()!=null){
          BufferedImage bf = null;
        try {
            bf = ImageIO.read(StaticValues.admin.getPhotoprofilpath());
        } catch (IOException ex) {
            Logger.getLogger(ComptController.class.getName()).log(Level.SEVERE, null, ex);
        }
          Image im = SwingFXUtils.toFXImage(bf, null);
        ima.setImage(im);
        }
    }    

    @FXML
    private void goToAcc(ActionEvent event) {
        //Acceuil
    }

    @FXML
    private void goToCom(ActionEvent event) {
        //gestion admin
    }


    @FXML
    private void goToPro(ActionEvent event) throws IOException {
        Parent parentInscit = FXMLLoader.load(getClass().getResource("PropositionAdmin.fxml"));
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
    private void goUpdt(ActionEvent event) throws IOException {
        Parent parentInscit = FXMLLoader.load(getClass().getResource("EditAdmin.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }

    @FXML
    private void gogestionEvent(ActionEvent event) throws IOException {
         Parent parentInscit = FXMLLoader.load(getClass().getResource("EvenementAdmin.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }

    @FXML
    private void gotoGestionAvis(ActionEvent event) throws IOException {
         Parent parentInscit = FXMLLoader.load(getClass().getResource("ListDeals.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }

    @FXML
    private void gogestionAds(ActionEvent event) throws IOException {
         ((Node) event.getSource()).getScene().getWindow().hide(); 
                    Parent pa = FXMLLoader.load(getClass().getResource("/gui/ValiderAds.fxml"));
                    Stage stage = new Stage();
                    Scene sce = new Scene(pa);
                    stage.setScene(sce);
                    stage.setTitle("welcome to back");
                    stage.show(); 
                            }
        
    }
    

