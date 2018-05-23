/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.CategorieService;
import Services.PropositionService;
import Services.UserService;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entite.Client;
import entite.Proposition;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import utils.StaticValues;

/**
 * FXML Controller class
 *
 * @author Nassreddine
 */
public class PropositionController implements Initializable {
ObservableList<String> Ville = FXCollections.observableArrayList("Tunis","Bizerte","Ariana","Sousse","Sfax","Nabeul");
    ObservableList<List<Proposition>> prop;
    String cat = "";
    String auc = "";
     private JFXComboBox<String> cat1;
    private JFXComboBox<String> vil1;
    @FXML
    private Pane paneAdd;
    @FXML
    private JFXTextField txtProp;
    @FXML
    private JFXTextField sit;
    @FXML
    private JFXTextArea des;
    @FXML
    private JFXComboBox<String> vil;
    @FXML
    private JFXTextField txtAuc;
    @FXML
    private VBox box;
    @FXML
    private JFXRadioButton nn;
    @FXML
    private TableView<Proposition> tabView;
    @FXML
    private TableColumn<Proposition,String> tabnom;
    @FXML
    private TableColumn<Proposition,String> tabCat;
    @FXML
    private TableColumn<Proposition,String> tabAut;
    @FXML
    private TableColumn<Proposition,String> tabC;
    @FXML
    private TableColumn<Proposition,String> yabs;
    @FXML
    private TableColumn<Proposition,String> tabd;
    @FXML
    private Pane txtn;
    @FXML
    private JFXTextField nprop;
    @FXML
    private JFXComboBox<String> caatt;
    @FXML
    private JFXTextField aut;
    @FXML
    private JFXComboBox<String> vvvill;
    @FXML
    private JFXTextField sss;
    @FXML
    private JFXTextArea dde;
     final ObservableList<Proposition> dataProp = FXCollections.observableArrayList();
    EventHandler eh;
    private RadioButton dicbtRes;
    EventHandler eh1;
    private RadioButton dicbetHoe;
    EventHandler eh2;
    private RadioButton dicbtthe;
    EventHandler eh3;
    private RadioButton action;
    ToggleGroup group;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               PropositionService ps = new PropositionService();
        CategorieService cs = new CategorieService();
        ArrayList<String> a = cs.selectAllCategorie();
        
        cs.selectAllCategorie();
         
         
         ArrayList<Proposition> ar = ps.findPropById(StaticValues.client.getId());
         ObservableList observableList = FXCollections.observableArrayList(ar);
        tabView.setItems(observableList);
        ps.findPropById(StaticValues.client.getId());
        tabnom.setCellValueFactory(new PropertyValueFactory<>("name"));
        tabCat.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        tabAut.setCellValueFactory(new PropertyValueFactory<>("autre"));
        tabC.setCellValueFactory(new PropertyValueFactory<>("city"));
        yabs.setCellValueFactory(new PropertyValueFactory<>("site"));
        tabd.setCellValueFactory(new PropertyValueFactory<>("description"));
        
               
           vil.setItems(Ville);
           vvvill.setItems(Ville);
          
           txtAuc.setVisible(false);
           prop = FXCollections.observableArrayList();
           group = new ToggleGroup();
           nn.setToggleGroup(group);
           int i = 0;
           for(String s : a){
                Label l = new Label("");
                box.getChildren().add(l);
                JFXRadioButton di = new JFXRadioButton();
                String id = Integer.toString(i);
                di.setId(id);
                String c = s;
                di.setText(s);
                di.setToggleGroup(group);
                box.getChildren().add(di);
                caatt.getItems().add(s);
           } 
         group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
         if (group.getSelectedToggle() != null) {
            
             txtAuc.setVisible(false);
        }

     } 
});     
         ArrayList<Proposition> arrayProp = ps.findPropById(StaticValues.client.getId());
         for(Proposition p:arrayProp){
             dataProp.add(p);
         }
    }    

    @FXML
    private void AddPropoAction(ActionEvent event) throws IOException {
        String id = StaticValues.client.getUsername();
        UserService us = new UserService();
        Client c =  us.FindClientById(id);
              StaticValues.client=c;
               Parent parentInscit = FXMLLoader.load(getClass().getResource("Compt.fxml"));
        
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
        stageInscit .hide();
        
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
   
    }

    @FXML
    private void aucunAction(ActionEvent event) {
          if(nn.isSelected()){
            txtAuc.setVisible(true);
       }
    }

    @FXML
    private void addAction(ActionEvent event) {
        PropositionService ps = new PropositionService();
        String cat = "";
        String auc = "";
           for(Node node : box.getChildren()){
               if (node instanceof RadioButton) {
                   RadioButton b = (RadioButton)node;
                   if(b.isSelected()){
                       String text = b.getText();
                    if(!text.equals("Aucun")){
                       cat = text;
                       auc = "Aucun";  
                    }
                    else{
                       cat = "Aucun";
                       auc =text;
                    }
                   }
                   
               }
           }
           String n = txtProp.getText();
           String v = vil.getSelectionModel().getSelectedItem().toString();
           String s =  sit.getText();
           String ds = des.getText();
           System.out.println("Nom = "+n+" Categorie= "+cat+" Autre= "+auc+" Ville"
                   + " "+v+" Site= "+s+" Description "+ds+"idCli"+StaticValues.client.getId());
           
            if(!(ps.existProposition(n, cat, v))){
                 
                Proposition proposition = new Proposition(n,cat,auc,v,"",s,ds,null,StaticValues.client.getId());
                ps.insertPropsition(proposition);
                ArrayList<Proposition> ar = ps.findPropById(StaticValues.client.getId());
         ObservableList observableList = FXCollections.observableArrayList(ar);
        tabView.setItems(observableList);
        ps.findPropById(StaticValues.client.getId());
        tabnom.setCellValueFactory(new PropertyValueFactory<>("name"));
        tabCat.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        tabAut.setCellValueFactory(new PropertyValueFactory<>("autre"));
        tabC.setCellValueFactory(new PropertyValueFactory<>("city"));
        yabs.setCellValueFactory(new PropertyValueFactory<>("site"));
        tabd.setCellValueFactory(new PropertyValueFactory<>("description"));
                 JOptionPane d = new JOptionPane();
              d.showMessageDialog( null, "Ajout avec succée", 
               "le titre", JOptionPane.ERROR_MESSAGE);
            }
            else{
               JOptionPane d = new JOptionPane();
              d.showMessageDialog( null, "Existe déja", 
               "le titre", JOptionPane.ERROR_MESSAGE);
            }
    }

    @FXML
    private void AnnulAction(ActionEvent event) {
        txtProp.setText("");
       sit.setText("");
       des.setText("");
       txtAuc.setText("");
    }

    @FXML
    private void SelectItem(MouseEvent event) {
        if (event.getClickCount() == 1){
           nprop.setText(tabView.getSelectionModel().getSelectedItem().getName());
           aut.setText(tabView.getSelectionModel().getSelectedItem().getAutre());
           dde.setText(tabView.getSelectionModel().getSelectedItem().getDescription());
           sss.setText(tabView.getSelectionModel().getSelectedItem().getSite());
           String test = tabView.getSelectionModel().getSelectedItem().getAutre();
           if (!test.equals(test)){
        caatt.setDisable(true);
        }
        else{
           aut.setDisable(true);
        }
        
        }
    }

    @FXML
    private void updatePropAction(ActionEvent event) {
        
      
         int idCli = StaticValues.client.getId();
        int idProp = tabView.getSelectionModel().getSelectedItem().getId();
        PropositionService ps = new PropositionService();
           String n = nprop.getText();
           String a = aut.getText();
           String d = dde.getText();
           String s = sss.getText();
           String v = vvvill.getSelectionModel().getSelectedItem().toString();
           String c = caatt.getSelectionModel().getSelectedItem().toString();
           System.out.println("Categorie = "+c+" idProp = "+idProp);
           Proposition proposition = new Proposition(n,c,a,v,"",s,d,null,idCli);
           if((v.equals(null)&&(c.equals(null)))){
           aut.setDisable(true);
           }else{
              
             ps.deleatePrposition(idProp);
           ps.insertPropsition(proposition);
           nprop.setText("");
           aut.setText("");
           dde.setText("");
           sss.setText("");
            ArrayList<Proposition> ar = ps.findPropById(StaticValues.client.getId());
         ObservableList observableList = FXCollections.observableArrayList(ar);
        tabView.setItems(observableList);
        ps.findPropById(StaticValues.client.getId());
        tabnom.setCellValueFactory(new PropertyValueFactory<>("name"));
        tabCat.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        tabAut.setCellValueFactory(new PropertyValueFactory<>("autre"));
        tabC.setCellValueFactory(new PropertyValueFactory<>("city"));
        yabs.setCellValueFactory(new PropertyValueFactory<>("site"));
        tabd.setCellValueFactory(new PropertyValueFactory<>("description"));
           }
           
        
        

    }

    @FXML
    private void deletePropAction(ActionEvent event) {
        int id = tabView.getSelectionModel().getSelectedItem().getId();
           System.out.println("Voter id = "+id);
           PropositionService ps = new PropositionService();
           ps.deleatePrposition(id);
           nprop.setText("");
           aut.setText("");
           dde.setText("");
           sss.setText("");
            ArrayList<Proposition> ar = ps.findPropById(StaticValues.client.getId());
         ObservableList observableList = FXCollections.observableArrayList(ar);
        tabView.setItems(observableList);
        ps.findPropById(StaticValues.client.getId());
        tabnom.setCellValueFactory(new PropertyValueFactory<>("name"));
        tabCat.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        tabAut.setCellValueFactory(new PropertyValueFactory<>("autre"));
        tabC.setCellValueFactory(new PropertyValueFactory<>("city"));
        yabs.setCellValueFactory(new PropertyValueFactory<>("site"));
        tabd.setCellValueFactory(new PropertyValueFactory<>("description"));
    }

    @FXML
    private void annul2Action(ActionEvent event) {
        nprop.setText("");
           aut.setText("");
           dde.setText("");
           sss.setText("");
    }
    
}
