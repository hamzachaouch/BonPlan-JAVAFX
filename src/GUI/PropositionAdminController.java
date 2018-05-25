/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.PropositionService;
import Services.UserService;
import entite.Admin;
import entite.Proposition;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import utils.StaticValues;

/**
 * FXML Controller class
 *
 * @author Nassreddine
 */
public class PropositionAdminController implements Initializable {

    @FXML
    private TableView<Proposition> tab;
    @FXML
    private TableColumn<Proposition, String> nom;
    @FXML
    private TableColumn<Proposition, String> cat;
    @FXML
    private TableColumn<Proposition, String> aut;
    @FXML
    private TableColumn<Proposition, String> vil;
    @FXML
    private TableColumn<Proposition, String> site;
    @FXML
    private TableColumn<Proposition, String> des;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PropositionService ps = new PropositionService();
        ArrayList<Proposition> arrayList = ps.selectAllProposition();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        tab.setItems(observableList);
        nom.setCellValueFactory(new PropertyValueFactory<>("name"));
        cat.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        aut.setCellValueFactory(new PropertyValueFactory<>("autre"));
        vil.setCellValueFactory(new PropertyValueFactory<>("city"));
        site.setCellValueFactory(new PropertyValueFactory<>("site"));
        des.setCellValueFactory(new PropertyValueFactory<>("description"));
    }    

    private void profilAction(ActionEvent event) {
        int id = tab.getSelectionModel().getSelectedItem().getId();
           System.out.println("Voter id = "+id);
           PropositionService ps = new PropositionService();
           ps.deleatePrposition(id);
            ArrayList<Proposition> arrayList = ps.selectAllProposition();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        tab.setItems(observableList);
        nom.setCellValueFactory(new PropertyValueFactory<>("name"));
        cat.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        aut.setCellValueFactory(new PropertyValueFactory<>("autre"));
        vil.setCellValueFactory(new PropertyValueFactory<>("city"));
        site.setCellValueFactory(new PropertyValueFactory<>("site"));
        des.setCellValueFactory(new PropertyValueFactory<>("description"));
    }

    @FXML
    private void satastique(ActionEvent event) throws IOException {
        Parent parentInscit = FXMLLoader.load(getClass().getResource("Statestique.fxml"));
        
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
        stageInscit .hide();
        
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }

    @FXML
    private void deleteAction(ActionEvent event) throws IOException {
        UserService us = new UserService();
        String use = StaticValues.admin.getUsername();
         Admin c = us.FindAdmintById(use);
         StaticValues.admin=c;
        Parent parentInscit = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
        stageInscit .hide();
        
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
    }

   

   

    @FXML
    private void addPropCompAction(ActionEvent event) {
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
          Parent parentInscit = FXMLLoader.load(getClass().getResource("AdministrateurC.fxml"));
        
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
        stageInscit .hide();
        
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
        
    }
    
}
