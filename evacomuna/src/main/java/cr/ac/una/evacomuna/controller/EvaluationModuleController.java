package cr.ac.una.evacomuna.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class EvaluationModuleController implements Initializable {

    @FXML
    private TabPane parent;
    @FXML
    private Tab maintanceView;
    @FXML
    private TextField txfNameEvaluation;
    @FXML
    private DatePicker dpStartDate;
    @FXML
    private DatePicker dpEndDate;
    @FXML
    private DatePicker dpAplicationDate;
    @FXML
    private ComboBox<?> cbState;
    @FXML
    private TextField txfSearchEvaluators;
    @FXML
    private ListView<?> listEvaluators;
    @FXML
    private ListView<?> listEvaluatorsFix;
    @FXML
    private ListView<?> listEvaluated;
    @FXML
    private ListView<?> listEvaluatedFix;
    @FXML
    private Tab appliedView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnAddEvaluator(ActionEvent event) {
    }

    @FXML
    private void btnDeleteEvaluator(ActionEvent event) {
    }

    @FXML
    private void btnAddEvaluated(ActionEvent event) {
    }

    @FXML
    private void btnDeleteEvaluated(ActionEvent event) {
    }

    @FXML
    private void searchByRoleAction(ActionEvent event) {
    }

    @FXML
    private void saveChangesAction(ActionEvent event) {
    }
    
}
