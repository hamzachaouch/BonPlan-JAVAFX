/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Company;
import static GUI.ListCompanyAdminController.modifier;
import Services.CompanyServices;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import java.io.IOException;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ModifierEntrepriseController implements Initializable {
ObservableList<String> typeList = FXCollections.observableArrayList("Restaurant","Salon de thé","Hotels","Cinema");

    @FXML
    private TextField nom;
    @FXML
    private TextField ville;
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    @FXML
    private ChoiceBox type;
    @FXML
    private TextArea description;
    @FXML
    private TextField adresse;
    @FXML
    private TextField email;
    @FXML
    private TextField image;
    @FXML
    private Button modif;
    @FXML
    private Button annuler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          type.setItems(typeList);
          type.setValue("Restaurant");
          
        login.setText(modifier.getLogin());
        password.setText(modifier.getPassword());
        nom.setText(modifier.getName());
        ville.setText(modifier.getVille());
      
        description.setText(modifier.getDescription());
        adresse.setText(modifier.getAddress());
        email.setText(modifier.getEmail());
        image.setText(modifier.getImg_url());
    }          
            
    
    @FXML
    private void updateAction(ActionEvent event) throws IOException {
        
          modifier.setLogin(login.getText());
          modifier.setPassword(password.getText());
          modifier.setName(nom.getText());
          modifier.setEmail(email.getText());
          modifier.setType((String) type.getSelectionModel().getSelectedItem());
          modifier.setAddress(adresse.getText());
          modifier.setVille(ville.getText());
          modifier.setDescription(description.getText());
          modifier.setImg_url(image.getText());
          CompanyServices u = new CompanyServices();
          u.debloquer(modifier);
            
            Parent parentInscit = FXMLLoader.load(getClass().getResource("ListCompanyAdmin.fxml"));
            Scene sceneInscit = new Scene(parentInscit);
            Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
            stageInscit .setScene(sceneInscit );
            stageInscit .show();
    }
    
}
