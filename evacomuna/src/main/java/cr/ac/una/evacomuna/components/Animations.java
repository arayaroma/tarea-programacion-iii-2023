package cr.ac.una.evacomuna.components;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 *
 * @author estebannajera
 */
public class Animations {

    public static TranslateTransition translateTransition(Node node, Duration duration, int cicleCount, double byX, double byY,EventHandler<ActionEvent>event) {
        TranslateTransition transition = new TranslateTransition(duration, node);
        transition.setByX(byX);
        transition.setByY(byY);
        transition.setCycleCount(cicleCount);
        transition.setOnFinished(event);
        return transition;
    }
}
