/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.ListDealsController.modif;
import Services.DealsServices;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import utils.Upload;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class ModifDealController implements Initializable {

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
    @FXML
    private TextField path;
    
    private File file;
    private Image image;
    private String pic;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        name.setText(modif.getName());
        price.setText(modif.getPrice()+"");
        horraire.setText(modif.getHorraire());
        lieux.setText(modif.getAddress());
        path.setText(modif.getImgUrl());
        Programme.setText(modif.getProgramme());
        tel.setText(modif.getTelephone());
        description.setText(modif.getDescription());
        dateDeb.setValue(LocalDate.of( modif.getDateDebut().getYear(), modif.getDateDebut().getMonth(), modif.getDateDebut().getDay()));
        dateFin.setValue(LocalDate.of( modif.getDateFin().getYear(), modif.getDateFin().getMonth(), modif.getDateFin().getDay()));
    
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
    private void Modifier(ActionEvent event) throws IOException {
        modif.setAddress(lieux.getText());
        modif.setCategorie("haha");
        modif.setDescription(description.getText());
        modif.setDateDebut(java.sql.Date.valueOf(dateDeb.getValue()));
        modif.setDateFin(java.sql.Date.valueOf(dateFin.getValue()));
        modif.setHorraire(horraire.getText());
        modif.setId(modif.getId());
        modif.setIdCompany(modif.getIdCompany());
        modif.setImgUrl(pic);
        modif.setName(name.getText());
        modif.setNbrClients(modif.getNbrClients());
        modif.setNote(modif.getNote());
        modif.setPrice( Integer.valueOf(price.getText()));
        modif.setProgramme(Programme.getText());
        modif.setTelephone(tel.getText());
        DealsServices service = new DealsServices();
        service.update(modif);
        
             Parent parentInscit = FXMLLoader.load(getClass().getResource("ListDeals.fxml"));
            Scene sceneInscit = new Scene(parentInscit);
            Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
           // stageInscit .hide();
            stageInscit .setScene(sceneInscit );
            stageInscit .show();
        
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

    
}
