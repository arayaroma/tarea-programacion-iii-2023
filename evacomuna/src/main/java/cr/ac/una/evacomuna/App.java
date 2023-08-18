package cr.ac.una.evacomuna;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import cr.ac.una.util.RequestExample;
import javafx.scene.layout.Pane;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Login"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
//        try{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/cr/ac/una/evacomuna/view/"+fxml + ".fxml"));
        return fxmlLoader.load();
//        }catch(Exception ex){
//            System.out.println(ex.toString());
//            return new Pane();
//        }
//        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        RequestExample.request();
        launch();
    }

}