/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonplan;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ThinkPad
 */
public class EvenementController implements Initializable {

    @FXML
    private Button Btn_New_Event;
    @FXML
    private Button Btn_Clear_Event;
    @FXML
    private TextField title;
    @FXML
    private TextField city;
    @FXML
    private TextField price;
    @FXML
    private TextField tel;
    @FXML
    private TextArea description;
    @FXML
    private ComboBox<?> typeBox;
    @FXML
    private DatePicker date;
    @FXML
    private TextField image;
    @FXML
    private TextField site;
    @FXML
    private TextField longitude;
    @FXML
    private TextField latitude;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void NewEvent_onClick(ActionEvent event) {
    }

    @FXML
    private void AnnulerEvent_onClick(ActionEvent event) {
    }

    @FXML
    private void Ajouter(ActionEvent event) {
    }
    
}
