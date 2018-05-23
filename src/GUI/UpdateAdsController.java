/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import entite.Ads;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.AdsService;
import utils.StaticVariables;

/**
 * FXML Controller class
 *
 * @author ghaz Nada
 */
public class UpdateAdsController implements Initializable {

    @FXML
    private Label titreAds;
    @FXML
    private TextField titreField;
    @FXML
    private TextField villeField;
    @FXML
    private DatePicker debutDate;
    @FXML
    private DatePicker finDate;
    @FXML
    private TextArea descField;
    @FXML
    private Button ajouterImage;
    
    public File dest ;
    public String source;
    String path;
    File selectedFile;
     boolean verificationImage=true;
    @FXML
    private ImageView imageGet;
    @FXML
    private Label labelImage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        titreAds.setText(StaticVariables.selectedAdsCompany.getTitre());
        titreField.setText(StaticVariables.selectedAdsCompany.getTitre());
        villeField.setText(StaticVariables.selectedAdsCompany.getVille());
        debutDate.setValue(StaticVariables.selectedAdsCompany.getDateBegin().toLocalDate());
        finDate.setValue(StaticVariables.selectedAdsCompany.getDateEnd().toLocalDate());
        descField.setText(StaticVariables.selectedAdsCompany.getDescription());
        
        
    }    

    @FXML
    private void image(ActionEvent event) {
     FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "\\Desktop"));
        fc.setTitle("Veuillez choisir l'image"); 
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image", ".jpg", ".png"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg")
        );
        selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {
             source = selectedFile.getAbsolutePath();
            path = selectedFile.getName();

          Image image = new Image(selectedFile.toURI().toString());
           imageGet.setImage(image) ;
           
            labelImage.setText(path);
              if(path.equals(""))
            {
            verificationImage=false;
            }
            else 
                  
              { verificationImage=true;}  
               
    }
    }

    @FXML
    private void modifierAction(ActionEvent event) throws IOException {
        AdsService service = new AdsService();
               java.sql.Date dd = java.sql.Date.valueOf(debutDate.getValue());
       java.sql.Date df = java.sql.Date.valueOf(finDate.getValue());
        Ads a = new Ads(dd, df, titreField.getText(), path, descField.getText(), villeField.getText());
        
        service.update(a);
        
        if (service.update(a) == true){
             ((Node) event.getSource()).getScene().getWindow().hide(); 
            Parent pa = FXMLLoader.load(getClass().getResource("/gui/puliciteAfterLogin.fxml"));
            Stage stage = new Stage();
            Scene sce = new Scene(pa);
            stage.setScene(sce);
            stage.setTitle("Liste des publicité");
            stage.show();
        }else{
            System.out.println("update Failed");
    }
    }

     private void copyFileUsingStream(File source, File dest) throws IOException {
    InputStream is = null;
    OutputStream os = null;
    try {
        is = new FileInputStream(source);
        dest = new File("C:/Users/chupa/Documents/java suivie/src/Image/"+path);
        os = new FileOutputStream(dest);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
    } finally {
        is.close();
        os.close();
    }
}
}
