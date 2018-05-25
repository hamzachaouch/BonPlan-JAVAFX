/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.ListCompanyClientController.rClient;
import Services.ReviewServices;
import entite.Review;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import org.controlsfx.control.Rating;
import utils.Upload;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class AjoutAvisController implements Initializable {
     private File file;
    private Image image;
    private String pic;
    @FXML
    private TextField titre;
    @FXML
    private TextArea description;
    @FXML
    private DatePicker date;
    @FXML
    private Button Btn_Clear_Event;
    @FXML
    private Label loc1a;
    @FXML
    private Label loc1l;
    @FXML
    private Rating globale;
    @FXML
    private Rating service;
    @FXML
    private Rating satisfaction;
    @FXML
    private Rating qp;
    @FXML
    private Label noteGlobLabel;
    @FXML
    private Label noteServiceLabel;
    @FXML
    private Label noteQPLabel1;
    @FXML
    private Label noteSatLabel;
    @FXML
    private TextField path;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        globale.ratingProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
            noteGlobLabel.setText( t1+"");
            }
        });
        service.ratingProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
            noteServiceLabel.setText( t1+"");
            }
        });
        satisfaction.ratingProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
            noteSatLabel.setText(t1+"");
            }
        });
         qp.ratingProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
            noteQPLabel1.setText( t1+"");
            }
        });
        
        
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
        Review r = new Review();
        if (description.getText().isEmpty()||date.getValue().toString().isEmpty()
               ||titre.getText().isEmpty()
                ||path.getText().isEmpty()||noteGlobLabel.getText().isEmpty()
                ||noteQPLabel1.getText().isEmpty()||noteSatLabel.getText().isEmpty()
                ||noteServiceLabel.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ATTENTION");
            alert.setContentText("Verifier vos champs!");
            alert.showAndWait();
        
        }else{
            r.setContent(description.getText());
            if (date.getValue().compareTo(LocalDate.now())<0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ATTENTION");
            alert.setContentText("Date erreur!");
            alert.showAndWait();
            
            }else{
                  r.setDateOfVisit(java.sql.Date.valueOf(date.getValue()));
            }
      
         r.setTitle(titre.getText());
         r.setService( (int)Float.parseFloat(noteServiceLabel.getText()));
         r.setSatisfaction((int)Float.parseFloat(noteSatLabel.getText()));
         r.setQualitePrix((int)Float.parseFloat(noteQPLabel1.getText()));
         r.setImgUrl(pic);
         r.setIdClient(0);
         r.setIdCompany(rClient.getId());
         r.setGlobalMark((int)Float.parseFloat(noteGlobLabel.getText()));
         ReviewServices s = new ReviewServices();
         s.insert(r);
        
         
         
         
          Parent pa = FXMLLoader.load(getClass().getResource("/gui/ListCompanyClient.fxml"));
         Stage stage = new Stage();
         Scene sce = new Scene(pa);
         stage.setScene(sce);
         stage.show();
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
             Parent parentInscit = FXMLLoader.load(getClass().getResource("ListCompanyClient.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }
    
}
