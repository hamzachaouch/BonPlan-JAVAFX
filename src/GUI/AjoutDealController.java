/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.DealsServices;
import entite.Deals;
import java.io.File;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static jdk.nashorn.internal.objects.NativeDate.getTime;
import utils.Upload;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class AjoutDealController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField lieux;
    @FXML
    private TextField tel;
    @FXML
    private TextArea description;
    @FXML
    private DatePicker dateFin;
    //private TextField image;
    @FXML
    private TextField Programme;
    @FXML
    private TextField price;
    @FXML
    private TextField horraire;
    @FXML
    private DatePicker dateDeb;
    @FXML
    private Button Btn_Clear_Event;
    @FXML
    private Label loc1a;
    @FXML
    private Label loc1l;
    
    private File file;
    private Image image;
    private String pic;
    @FXML
    private TextField path;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AnnulerEvent_onClick(ActionEvent event) throws IOException {
         Parent parentInscit = FXMLLoader.load(getClass().getResource("ListDeals.fxml"));
            Scene sceneInscit = new Scene(parentInscit);
            Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
           // stageInscit .hide();
            stageInscit .setScene(sceneInscit );
            stageInscit .show();
    }

    @FXML
    private void Ajouter(ActionEvent event) throws IOException {
        Deals d1 = new Deals();
        if (name.getText().isEmpty()||price.getText().isEmpty()||dateDeb.getValue().toString().isEmpty()
                ||dateFin.getValue().toString().isEmpty()||Programme.getText().isEmpty()
                ||horraire.getText().isEmpty()||lieux.getText().isEmpty()
                ||tel.getText().isEmpty()||path.getText().isEmpty()||description.getText().isEmpty())
        {
              Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ATTENTION");
            alert.setContentText("Verifier vos champs!");
            alert.showAndWait();
            
        
        
       
    }else{
         
        d1.setAddress(lieux.getText());
        d1.setCategorie("haha");
        d1.setDescription(description.getText());
     
       if (dateDeb.getValue().compareTo(dateFin.getValue())>0) {
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur Date");
            alert.setContentText("la Date de fin doit etre obligatoirement superieur à celle du debut!");
            alert.showAndWait(); 
            
            
            }else   {
                
            
        d1.setDateDebut(java.sql.Date.valueOf(dateDeb.getValue()));
        d1.setDateFin(java.sql.Date.valueOf(dateFin.getValue()));
        }
        
        
        
        
        
        d1.setHorraire(horraire.getText());
       // d1.setId(14);
        d1.setIdCompany(1);
        d1.setImgUrl(pic);
        d1.setName(name.getText());
        d1.setNbrClients(1);
        d1.setNote(11);
         if ( Integer.valueOf(price.getText())<=0) {
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("Prix négatif");
            alert.showAndWait(); 
            
            
            }else   {
             d1.setPrice( Integer.valueOf(price.getText()));
        
            
        }
        d1.setProgramme(Programme.getText());
         if ( tel.getText().length()>8) {
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("vérifier le numéro de telephone ");
            alert.showAndWait(); 
            
            
            }else   {
        d1.setTelephone(tel.getText());
            
        }
        

        
         
        DealsServices service = new DealsServices();
        service.insert(d1);
          Parent parentInscit = FXMLLoader.load(getClass().getResource("ListDeals.fxml"));
            Scene sceneInscit = new Scene(parentInscit);
            Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
           // stageInscit .hide();
            stageInscit .setScene(sceneInscit );
            stageInscit .show();
        }
    }

    @FXML
    private void imageUpload(ActionEvent event) throws IOException {
         FileChooser fileChooser = new FileChooser();
            file= fileChooser.showOpenDialog(null);
             FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

            path.setText("File:"+file);
            pic=(file.toURI().toString());
         //  pic=new Upload().upload(file,"uimg");
           pic=new Upload().upload(file,"images");
            System.out.println(pic);
       //  image= new Image("http://localhost/uimg/"+pic);
           image= new Image("http://localhost/bpPI/web/images"+pic);
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
            Parent parentInscit = FXMLLoader.load(getClass().getResource("ListDeals.fxml"));
            Scene sceneInscit = new Scene(parentInscit);
            Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
           // stageInscit .hide();
            stageInscit .setScene(sceneInscit );
            stageInscit .show();
    }
    
}
