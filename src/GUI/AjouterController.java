/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Ads;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;
import java.util.Properties;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import services.AdsService;

/**
 * FXML Controller class
 *
 * @author ghaz Nada
 */
public class AjouterController implements Initializable {

    @FXML
    private Button valider;
    @FXML
    private TextField titre;
    private TextField img;
    private TextField descrp;
    @FXML
    private TextField ville;
    private TextField pub;
    @FXML
    private TextArea description;
    @FXML
    private DatePicker dateDebut;
    @FXML
    private DatePicker dateFin;
    @FXML
    private Label testDate;
    
    String path;
    File selectedFile;
    @FXML
    private ImageView imageGet;
    @FXML
    private Button ajouterImage;

    boolean verificationImage=true;
    @FXML
    private Label labelImage;
    
    public File dest ;
    public String source;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    //
    private void copyFileUsingStream(File source, File dest) throws IOException {
    InputStream is = null;
    OutputStream os = null;
    try {
        is = new FileInputStream(source);
        dest = new File("src/Image/"+path);
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

    @FXML
    private void validerAction(ActionEvent event) throws IOException {
        AdsService as = new AdsService();
        copyFileUsingStream(new File(source),dest);
          
       java.sql.Date dd = java.sql.Date.valueOf(dateDebut.getValue());
       java.sql.Date df = java.sql.Date.valueOf(dateFin.getValue());
       int test = df.compareTo(dd);
       if (test <0 ){
        testDate.setText("date fin doit etre supérieur à date début");
       }else{
       try{
           
            Ads ads = new Ads(titre.getText(), ville.getText(), path, description.getText(), dd, df,"0",2);
            as.insert(ads);
            
            //send Mail
             String host = "smtp.gmail.com" ;
                String utilisateur = "ghazouaninada02@gmail.com";
                String pass = "espritesprit";
                String SendTo = "ghazouaninada02@gmail.com";
                //
                String from = "ghazouaninada02@gmail.com";
                String Subject = "information à propos l'ajout d'une publicité";
                String textMessage = "bonjour M./Mm  votre publicité a été créer avec succée sous le nom "+titre.getText();
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
            InternetAddress[] address = {new InternetAddress(SendTo)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(Subject); msg.setSentDate(new Date());
            msg.setText(textMessage);
            
           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, utilisateur, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
            
            
        ((Node) event.getSource()).getScene().getWindow().hide(); // dans une seule fenetre ;
            Parent pa = FXMLLoader.load(getClass().getResource("/gui/puliciteAfterLogin.fxml"));
            Stage stage = new Stage();
            Scene sce = new Scene(pa);
            stage.setScene(sce);
            stage.setTitle("Liste des publicité");
            stage.show();
                                      
          }catch(Exception ex)
        {
            System.out.println(ex);
        }
          
       }
    }

    @FXML
    private void Image(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "\\Desktop"));
        fc.setTitle("Veuillez choisir l'image"); //titre de la
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image", ".jpg", ".png"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg")
        );
        selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {
             source = selectedFile.getAbsolutePath();
            path = selectedFile.getName();
//                path = selectedFile.toURI().toURL().toExternalForm();
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
    private void Retour(MouseEvent event) throws IOException {
         ((Node) event.getSource()).getScene().getWindow().hide(); 
         Parent pa = FXMLLoader.load(getClass().getResource("/gui/puliciteAfterLogin.fxml"));
         Stage stage = new Stage();
         Scene sce = new Scene(pa);
         stage.setScene(sce);
         stage.setTitle("Liste des publicité d'entreprise");
         stage.show();
    }
    
}
