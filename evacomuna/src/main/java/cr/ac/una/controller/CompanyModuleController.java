/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class CompanyModuleController implements Initializable {

    @FXML
    private HBox parent;
    @FXML
    private ImageView imgPhoto;
    @FXML
    private TextField txfCompanyName;
    @FXML
    private TextField txfDescription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void selectPhotoProfile(ActionEvent event) {
    }

    @FXML
    private void saveChanges(ActionEvent event) {
    }
    
}
