/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import entite.Temoignage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.AdsService;
import services.TemoignageService;
import utils.StaticVariables;

/**
 * FXML Controller class
 *
 * @author chupa
 */
public class DetailAdsController implements Initializable {

    @FXML
    private Label titreAds;
    @FXML
    private Label debutAds;
    @FXML
    private Label finAds;
    @FXML
    private Label inputTitre;
    @FXML
    private Label InputVille;
    @FXML
    private Label inputDateDebut;
    @FXML
    private Label InputDateFin;
    @FXML
    private Label inputDescription;
    @FXML
    private ImageView image;

    File f ;
    @FXML
    private TextArea avisField;
    @FXML
    private ListView<Temoignage> listAvis;
    
    private ObservableList listtemoign;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listtemoign = FXCollections.observableArrayList();
        TemoignageService service = new TemoignageService();
        f = new File("src/Image/" + StaticVariables.selectedAds.getImgUrl());
        Image img = new Image(f.toURI().toString());
        image.setImage(img);
        inputTitre.setText(StaticVariables.selectedAds.getTitre());
        titreAds.setText(StaticVariables.selectedAds.getTitre());
        InputVille.setText(StaticVariables.selectedAds.getVille());
        inputDateDebut.setText(""+StaticVariables.selectedAds.getDateBegin());
        InputDateFin.setText(""+StaticVariables.selectedAds.getDateEnd());
        inputDescription.setText(StaticVariables.selectedAds.getDescription());
        
        List l = service.selectAll();
        
        
          for(Object c:l){
            if (c instanceof Temoignage){
                listtemoign.add(((Temoignage) c).getAvis());
            }
        }
        listAvis.setItems(listtemoign);
        
        // TODO
    }    

    @FXML
    private void Retour(MouseEvent event) throws IOException {
        
         ((Node) event.getSource()).getScene().getWindow().hide(); 
         Parent pa = FXMLLoader.load(getClass().getResource("/gui/Lister.fxml"));
         Stage stage = new Stage();
         Scene sce = new Scene(pa);
         stage.setScene(sce);
         stage.setTitle("Liste des publicité d'entreprise");
         stage.show();
    }

    @FXML
    private void ajoutAvisAction(ActionEvent event) throws IOException {
        TemoignageService service = new TemoignageService();
        Temoignage t = new Temoignage(avisField.getText());
        
        service.insert(t);
        
            ((Node) event.getSource()).getScene().getWindow().hide(); 
            Parent pa = FXMLLoader.load(getClass().getResource("/gui/Lister.fxml"));
            Stage stage = new Stage();
            Scene sce = new Scene(pa);
            stage.setScene(sce);
            stage.setTitle("Liste des publicité");
            stage.show();
        
    }
    
}
