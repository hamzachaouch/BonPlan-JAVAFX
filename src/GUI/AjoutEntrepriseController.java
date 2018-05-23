/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.CompanyServices;
import entite.Company;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static javax.swing.JOptionPane.showMessageDialog;
import utils.Upload;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AjoutEntrepriseController implements Initializable {
ObservableList<String> typeList = FXCollections.observableArrayList("Restaurant","Salon de thé","Hotels","Cinema");
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    @FXML
    private TextField nom_entreprise;
    @FXML
    private TextField ville;
    
   @FXML
    private ChoiceBox typeBox;
   @FXML 
   private TextArea description;
   @FXML
   private TextField adresse;
   private TextField image;
   @FXML
   private TextField email;
   @FXML
   private File file;
      private String pic;
    private Image imageU;


    @FXML
    private Button annuler;
  
    @FXML
    private Button ajouter;
    @FXML
    private Button retour;
    @FXML
    private TextField path;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            typeBox.setItems(typeList);
          typeBox.setValue("Restaurant");

          
    }    
    @FXML
    private void ajoutercompany(ActionEvent event) throws IOException, MessagingException {
           Company c = new Company();
           c.setLogin(login.getText());
           c.setPassword(password.getText());
          c.setBudget(0);
          c.setPrenium(Boolean.TRUE);
          c.setEmail(email.getText());
           c.setName(nom_entreprise.getText());  
          c.setType((String) typeBox.getSelectionModel().getSelectedItem());
          c.setAddress(adresse.getText());
          c.setVille(ville.getText());
          c.setDescription(description.getText());
          c.setImg_url(pic)
          ;
          
          CompanyServices companyservices = new CompanyServices();
          companyservices.insert(c);
          
            //send Mail
            String host = "smtp.gmail.com" ;
            String utilisateur = "wajdi.felhi@esprit.tn";
            String pass = "wajdimayar";
            String SendTo = email.getText();
            String from = "wajdi.felhi@esprit.tn";
            String Subject = "Information à propos l'ajout d'une entreprise";
            String textMessage = "Votre entreprise est ajoutée   ";
            boolean seesionDebug = false;
            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
             java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(seesionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(email.getText())};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(Subject);

            msg.setText(textMessage);

            Transport transport=mailSession.getTransport("smtp");
            transport.connect(host, "wajdi.felhi@esprit.tn", "wajdimayar");
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            System.out.println("message send successfully");
            showMessageDialog(null, "Success");
            ((Node) event.getSource()).getScene().getWindow().hide(); 
            
            Parent parent = FXMLLoader.load(getClass().getResource("/GUI/ListCompanyClient.fxml"));
            Stage stage = new Stage();
            Scene sc = new Scene(parent);
            stage.setScene(sc);
            stage.show();
        
    }

    @FXML
    private void annulerAction(ActionEvent event) {
        Company c = new Company();

        c.setBudget(0);
          c.setPrenium(Boolean.TRUE);
          c.setLogin("");
          c.setPassword("");
          c.setEmail("");
           c.setName("");  
          c.setType("Restaurant");
          c.setAddress("");
          c.setVille("");
          c.setDescription("");
          c.setImg_url("");
    }

    @FXML
    private void retour(ActionEvent event) {
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
           pic=new Upload().upload(file,"images");
            System.out.println(pic);
           imageU= new Image("http://localhost/bpPI/web/images/"+pic);
    }
    
}
