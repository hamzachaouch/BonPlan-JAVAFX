/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;
import services.AdsService;
import services.TemoignageService;
import utils.StaticVariables;

/**
 * FXML Controller class
 *
 * @author nada
 */
public class DetailAdsCompanyController implements Initializable {

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
    private ImageView image;
    File f ;
    @FXML
    private Label inputDescription;
    @FXML
    private ImageView btnRetour;
    @FXML
    private ListView<String> ListTem;
  
    private ObservableList listtemoign;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listtemoign = FXCollections.observableArrayList();
        TemoignageService service = new TemoignageService();
        f = new File("src/Image/"+StaticVariables.selectedAdsCompany.getImgUrl());

        
        Image img = new Image(f.toURI().toString());
        image.setImage(img);
        
        
        inputTitre.setText(StaticVariables.selectedAdsCompany.getTitre());
        titreAds.setText(StaticVariables.selectedAdsCompany.getTitre());
        InputVille.setText(StaticVariables.selectedAdsCompany.getVille());
        inputDateDebut.setText(""+StaticVariables.selectedAdsCompany.getDateBegin());
        InputDateFin.setText(""+StaticVariables.selectedAdsCompany.getDateEnd());
        inputDescription.setText(StaticVariables.selectedAdsCompany.getDescription());
        
        
          List l = service.selectTemoignageCompany();
          for(Object c:l){
            if (c instanceof Temoignage){
                listtemoign.add(((Temoignage) c).getAvis());
            }
        }
        ListTem.setItems(listtemoign);
        
    }    

    @FXML
    private void DeleteAction(ActionEvent event) throws IOException {
        AdsService as = new AdsService();
        as.delete(StaticVariables.selectedAdsCompany);    
        if (as.delete(StaticVariables.selectedAdsCompany) == false){
            System.out.println("no delete");
        }else{
        ((Node) event.getSource()).getScene().getWindow().hide(); // dans une seule fenetre ;
         Parent pa = FXMLLoader.load(getClass().getResource("/gui/puliciteAfterLogin.fxml"));
         Stage stage = new Stage();
         Scene sce = new Scene(pa);
         stage.setScene(sce);
         stage.setTitle("Liste des publicité d'entreprise");
         stage.show();
    }
    }

    @FXML
    private void modifierAds(ActionEvent event) throws IOException {
         ((Node) event.getSource()).getScene().getWindow().hide(); // dans une seule fenetre ;
            Parent pa = FXMLLoader.load(getClass().getResource("/gui/UpdateAds.fxml"));
            Stage stage = new Stage();
            Scene sce = new Scene(pa);
            stage.setScene(sce);
            stage.setTitle("Liste des publicité");
            stage.show();
        
    }

    @FXML
    private void partagerAds(ActionEvent event) {
        showMessageDialog(null, "Ads shared with success");
        String token ="EAACEdEose0cBAAElnEIGzyOBm19YcPTW6zXtoofJivkFERxFyvcaNAgQJABWnaDz3qgtxjbRkfyPjuU8SynOZA769ezqHzVZAidfuKb6gGK39fU3VtQkyjvEXHS4bIfxhU2ZC12peFzDsm7KyeDZCm5EANRIFbgYEw6KS9EtTcmRpVMXbGhKWZCrgJkDEIsRsY123QLsWWgZDZD";
        FacebookClient fb=new DefaultFacebookClient(token);
        FacebookType r=fb.publish("me/feed", FacebookType.class, Parameter.with("message", StaticVariables.selectedAdsCompany.getTitre()+":"+StaticVariables.selectedAdsCompany.getDescription()+" Dans "+StaticVariables.selectedAdsCompany.getVille()+"et aura lieu de "+StaticVariables.selectedAdsCompany.getDateBegin()+"jusqu'à"+StaticVariables.selectedAdsCompany.getDateEnd()));
        System.out.println("fb.com"+r.getId());
    }


    @FXML
    private void Retour(MouseEvent event) throws IOException {
        
         ((Node) event.getSource()).getScene().getWindow().hide(); // dans une seule fenetre ;
         Parent pa = FXMLLoader.load(getClass().getResource("/gui/puliciteAfterLogin.fxml"));
         Stage stage = new Stage();
         Scene sce = new Scene(pa);
         stage.setScene(sce);
         stage.setTitle("Liste des publicité d'entreprise");
         stage.show();
    }

    @FXML
    private void deleteTemoignageAction(ActionEvent event) throws IOException {
        
        TemoignageService serviceTemoignage = new TemoignageService();
       
        StaticVariables.itemTemoignage =  ListTem.getSelectionModel().getSelectedItem();
       serviceTemoignage.delete(StaticVariables.itemTemoignage);
       showMessageDialog(null, "Success");
         ((Node) event.getSource()).getScene().getWindow().hide(); // dans une seule fenetre ;
         Parent pa = FXMLLoader.load(getClass().getResource("/gui/puliciteAfterLogin.fxml"));
         Stage stage = new Stage();
         Scene sce = new Scene(pa);
         stage.setScene(sce);
         stage.setTitle("Liste des publicité d'entreprise");
         stage.show();
    }
}
