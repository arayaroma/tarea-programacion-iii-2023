package cr.ac.una.evacomuna.controller;

import cr.ac.una.evacomuna.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * FXML Controller class
 *
 * @author estebannajera
 */
public class ContainerEvaluationsController implements Initializable {

    @FXML
    private TabPane parent;
    @FXML
    private Tab maintenanceView;
    @FXML
    private Tab appliedView;
    @FXML
    private Tab pendingEvaluations;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void tabEvaluationModule(Event event) {
        try {
            FXMLLoader loader = App.getFXMLLoader("EvaluationModule");
            maintenanceView.setContent(loader.load());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    private void tabApliedEvaluations(Event event) {
//        try {
//            FXMLLoader loader = App.getFXMLLoader("EvaluationModule");
//            maintenanceView.setContent(loader.load());
//        } catch (IOException e) {
//            System.out.println(e.toString());
//        }
    }

    @FXML
    private void tabPendingEvaluations(Event event) {
        try {
            FXMLLoader loader = App.getFXMLLoader("PendingEvaluations");
            pendingEvaluations.setContent(loader.load());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

}
