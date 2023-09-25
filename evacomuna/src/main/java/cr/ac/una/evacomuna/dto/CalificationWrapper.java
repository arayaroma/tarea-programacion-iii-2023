package cr.ac.una.evacomuna.dto;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 *
 * @author estebannajera
 */
public class CalificationWrapper extends Pane {

    private int x;
    private int y;
    private Node data;

    public CalificationWrapper(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setData(Node data) {
        this.data = data;
    }

    public Node getData() {
        return data;
    }

    public CalificationWrapper(int x, int y, Node data) {
        this.x = x;
        this.y = y;
        this.data = data;
    }

}
