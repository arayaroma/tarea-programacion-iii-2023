package cr.ac.una.evacomuna.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.Image;

/**
 * @author arayaroma
 */
public class ImageLoader {

    public static File selectFile(String nameFilter, String... filters) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(nameFilter, filters));
        return fileChooser.showOpenDialog(new Stage());
    }

    public static String fileToString(File file) {
        try {
            return FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static byte[] imageToByteArray(File file) {
        try {
            return IOUtils.toByteArray(new FileInputStream(file));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static ByteArrayInputStream byteArrayToImage(byte[] image) {
        return new ByteArrayInputStream(image);
    }

    public static Image setImage(File file) {
        return new Image(file.toURI().toString());
    }

    public static Image setImage(byte[] image) {
        return new Image(byteArrayToImage(image));
    }

}
