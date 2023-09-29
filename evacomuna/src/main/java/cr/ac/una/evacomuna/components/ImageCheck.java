package cr.ac.una.evacomuna.components;

import cr.ac.una.evacomuna.App;
import javafx.scene.image.ImageView;

public class ImageCheck {
    public static ImageView createImageCheck() {
        ImageView check = new ImageView(App.class.getResource("/cr/ac/una/evacomuna/img/comprobar.png").toString());
        check.setPreserveRatio(false);
        check.setSmooth(false);
        check.setFitHeight(30);
        check.setFitWidth(30);
        check.getStyleClass().add("check");
        return check;
    }

}
