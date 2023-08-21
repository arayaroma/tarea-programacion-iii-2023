package cr.ac.una.util;

import static cr.ac.una.util.MessageType.ERROR;
import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author estebannajera
 */
public class Message {

    public static void showNotification(String header, MessageType type, String content) {

        Notifications notification = Notifications.create()
                .title(header)
                .text(content)
                .graphic(null)
                .hideAfter(Duration.seconds(5))
                .darkStyle()
                .position(Pos.TOP_RIGHT);
        switch (type) {
            case ERROR:
                notification.showError();
                break;
            case INFO:
                notification.show();
                break;
            case CONFIRMATION:
                
                break;
        }
    }
}
