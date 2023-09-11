package cr.ac.una.evacomuna.controller;

import cr.ac.una.controller.CharacteristicDto;
import cr.ac.una.controller.ResponseCode;
import cr.ac.una.controller.ResponseWrapper;
import cr.ac.una.evacomuna.services.Characteristic;
import cr.ac.una.evacomuna.util.Message;
import cr.ac.una.evacomuna.util.MessageType;
import cr.ac.una.evacomuna.util.Utilities;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class CharacteristicModuleController implements Initializable {
    
    @FXML
    private HBox mainCharacteristicsView;
    @FXML
    private TextField txfCharacteristic;
    @FXML
    private ListView<CharacteristicDto> listCharactersiticView;
    
    CharacteristicDto characteristicBuffer = new CharacteristicDto();
    Characteristic characteristicService;
    ObservableList<CharacteristicDto> characteristicDtos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        characteristicService = new Characteristic();
        intializeLists();
        initializeView();
    }
    
    @FXML
    private void btnNewCharactersitic(ActionEvent event) {
        try {
            String name = txfCharacteristic.getText();
            if (name.isEmpty()) {
                return;
            }
            CharacteristicDto characteristicDto = new CharacteristicDto();
            characteristicDto.setName(name);
            ResponseWrapper response = characteristicService.createCharacteristic(characteristicDto);
            Message.showNotification("Data", MessageType.INFO, response.getMessage());
            listCharactersiticView.setItems(Utilities.loadCharacteristics());
            cleanFieldsCharacteristicView();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    @FXML
    private void btnEditCharacteristic(ActionEvent event) {
        String newName = txfCharacteristic.getText();
        if (characteristicBuffer != null && !newName.isBlank()) {
            characteristicBuffer.setName(newName);
            ResponseWrapper response = characteristicService.updateCharacteristics(characteristicBuffer);
            if (response.getCode() == ResponseCode.OK) {
                listCharactersiticView.setItems(Utilities.loadCharacteristics());
                cleanFieldsCharacteristicView();
            }
        }
    }
    
    @FXML
    private void btnDeleteCharacteristic(ActionEvent event) {
        if (characteristicBuffer != null) {
            ResponseWrapper response = characteristicService.deleteCharacteristicById(characteristicBuffer.getId());
            if (response.getCode() == ResponseCode.OK) {
                Message.showNotification("Succeed", MessageType.INFO, "The Characteristic was removed succesfully");
                listCharactersiticView.setItems(Utilities.loadCharacteristics());
                cleanFieldsCharacteristicView();
            } else {
                Message.showNotification("Error", MessageType.ERROR, "Error: " + response.getMessage());
            }
        }
    }
    
    private void cleanFieldsCharacteristicView() {
        txfCharacteristic.setText("");
        characteristicBuffer = null;
    }
    
    private void initializeView() {
        characteristicDtos = Utilities.loadCharacteristics();
        listCharactersiticView.setItems(characteristicDtos);
    }
    
    private void intializeLists() {
        listCharactersiticView.setCellFactory((param) -> new ListCell() {
            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : ((CharacteristicDto) item).getName());
            }
        });
        //LISTENERS
        listCharactersiticView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            characteristicBuffer = newValue;
            txfCharacteristic.setText(characteristicBuffer.getName());
        });
    }
    
}
