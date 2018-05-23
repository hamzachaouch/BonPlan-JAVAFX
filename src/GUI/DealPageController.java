/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.ListDealsClientController.modifClient;
import static GUI.ListDealsController.modif;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.xml.internal.bind.v2.runtime.output.NamespaceContextImpl.Element;
import entite.Deals;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import static javax.swing.JOptionPane.showMessageDialog;
import pitest2018.Pitest2018;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Hamza
 */
public class DealPageController implements Initializable {

    @FXML
    private Label titre;
    @FXML
    private Label deb;
    @FXML
    private Label fin;
    @FXML
    private Label description;
    @FXML
    private Label lieux;
    @FXML
    private Label prog;
    @FXML
    private ImageView img;
    @FXML
    private Button valider;
    @FXML
    private Button annuler;
    @FXML
    private Label text;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        titre.setText(modifClient.getName());
        deb.setText(modifClient.getDateDebut()+"");
        fin.setText(modifClient.getDateFin()+"");
        description.setText(modifClient.getDescription());
             
        lieux.setText(modifClient.getAddress());
        prog.setText(modifClient.getProgramme());
        img.setImage(new Image("http://localhost/bpPI/web/images/"+modifClient.getImgUrl(),200,200,true,true));
        
    }    

    @FXML
    private void genererCoupon(ActionEvent event) throws IOException, InterruptedException, AddressException, MessagingException {
        Document document =new Document();
        try{
           
           PdfWriter writer= PdfWriter.getInstance(document, new FileOutputStream("src\\pdf\\coupon.pdf"));
            document.open();
            com.itextpdf.text.Image logo = com.itextpdf.text.Image.getInstance("src\\Images\\logo.png");
                        document.add(logo);

            document.add(new Paragraph("Votre Coupon",FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD,BaseColor.RED)));
            document.add(new Paragraph("------------------------------------------------------------------------"));
            document.add(new Paragraph("Notez bien"));
           
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(105);
            table.setSpacingBefore(11f);
            table.setSpacingAfter(11f);
            
            float[] colWidth={2f,2f,2f,2f,2f};
            table.setWidths(colWidth);
            PdfPCell titre = new PdfPCell(new Paragraph("Information du coupon "));
            titre.setColspan(5);
            titre.setRowspan(2);
            titre.setBackgroundColor(BaseColor.GREEN);
              PdfPCell c2=new PdfPCell(new Paragraph("Nom Client"));
              PdfPCell c3=new PdfPCell(new Paragraph("Email"));
              PdfPCell c4=new PdfPCell(new Paragraph("Nom du deal"));
              PdfPCell c5=new PdfPCell(new Paragraph("Date debut"));
              PdfPCell c6=new PdfPCell(new Paragraph("Date de fin"));
             
              
             table.addCell(titre);
             table.addCell(c2);
             table.addCell(c3);
             table.addCell(c4);
             table.addCell(c5); table.addCell(c6);
            
             table.addCell(new Paragraph(""+modifClient.getName()));
             table.addCell(new Paragraph(""+modifClient.getDateDebut()));
             table.addCell(new Paragraph(""+modifClient.getName()));
             table.addCell(new Paragraph(""+modifClient.getDateDebut()));
             table.addCell(new Paragraph(""+modifClient.getDateFin()));
             document.add(table);
             document.add(
                     new Paragraph("Votre Code",FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD,BaseColor.MAGENTA)));
             document.add(
                    new Paragraph(Pitest2018.getSaltString(),FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD,BaseColor.BLACK)));

             document.close();
            writer.close();
            
           
        }catch(Exception e){
            System.out.println(e);
        }
        //************Sending mail**************
           //send Mail
     try{
            String host ="smtp.mailtrap.io";
            String user = "584118ff3f6377";
            String pass = "44439812529c15";
            String to = "wajdi.felhi@esprit.tn";
            String from = "wajdi.felhi@esprit.tn";
            String subject = "Coupon du Deal";
            String messageText = "Your Is Test Email :";
            boolean sessionDebug = false;

            Properties props = System.getProperties();
            
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "2525");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
            props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            //props.put("mail.smtp.socketFactory.fallback", "false");
            props.put("mail.smtp.socketFactory.fallback", "true");
            props.setProperty("mail.imap.ssl.enable", "true");
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); 
            msg.setText(messageText);
                
            
            MimeBodyPart messageBodyPart = new MimeBodyPart();
        Multipart multipart = new MimeMultipart();
        
         String file = "C:\\Users\\Hamza\\Desktop\\Exple javafx\\hamza\\Pitest2018\\src\\pdf\\coupon.pdf";
        String fileName = "coupon.pdf";
    messageBodyPart = new MimeBodyPart();   
    DataSource source = new FileDataSource(file);      
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setFileName(fileName);
    multipart.addBodyPart(messageBodyPart);
        
     msg.setContent(multipart);

       
        System.out.println("sending");
        
        System.out.println("Done");
        
        
           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);
        }

        
        
        //***************************************
        System.out.println("itext PDF program executed");
              String title = "Coupon généré";
        String message = "Coupon. généré avec Succes";
        //********** Notif pc
        TrayNotification tray = new TrayNotification();
        
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setAnimationType(AnimationType.POPUP);
        tray.setNotificationType(NotificationType.NOTICE);
        tray.showAndDismiss(Duration.seconds(5));
        Parent parentInscit = FXMLLoader.load(getClass().getResource("ListDeals.fxml"));
            Scene sceneInscit = new Scene(parentInscit);
            Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
           // stageInscit .hide();
            stageInscit .setScene(sceneInscit );
            stageInscit .show();
        
    }
     
    
    
 
    @FXML
    private void annuler(ActionEvent event) throws IOException {
     Parent parentInscit = FXMLLoader.load(getClass().getResource("ListDeals.fxml"));
            Scene sceneInscit = new Scene(parentInscit);
            Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
           // stageInscit .hide();
            stageInscit .setScene(sceneInscit );
            stageInscit .show();
    }
    
}
