package cr.ac.una.evacomuna;

import cr.ac.una.controller.LoginController;
import cr.ac.una.controller.MainController;
import cr.ac.una.controller.RegisterWorkerController;
import cr.ac.una.controller.WorkerController;
import cr.ac.una.controller.WorkersModuleController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static LoginController loginController;
    private static WorkerController workerController;
    private static RegisterWorkerController registerWorkerController;
    private static WorkersModuleController workersModuleController;
    private static MainController mainController;
    
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Login"));
        scene.getRoot().setStyle("-fx-font-family: 'Trebuchet MS';");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        scene.getRoot().setStyle("-fx-font-family: 'Trebuchet MS';");
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/cr/ac/una/evacomuna/view/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static FXMLLoader getFXMLLoader(String fxml) {
        return new FXMLLoader(App.class.getResource("/cr/ac/una/evacomuna/view/" + fxml + ".fxml"));
    }

    public static LoginController getLoginController() {
        return loginController;
    }

    public static MainController getMainController() {
        return mainController;
    }

    public static RegisterWorkerController getRegisterWorkerController() {
        return registerWorkerController;
    }

    public static void setLoginController(LoginController loginController) {
        App.loginController = loginController;
    }

    public static void setMainController(MainController mainController) {
        App.mainController = mainController;
    }

    public static void setRegisterWorkerController(RegisterWorkerController registerWorkerController) {
        App.registerWorkerController = registerWorkerController;
    }

    public static void setWorkerController(WorkerController workerController) {
        App.workerController = workerController;
    }

    public static void setWorkersModuleController(WorkersModuleController workersModuleController) {
        App.workersModuleController = workersModuleController;
    }
    

    public static void main(String[] args) {
        launch();
    }

}
