package cr.ac.una.evacomuna.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * 
 * @author arayaroma
 */
public class FileLoader {

    /**
     * FIXME: Make it work on Linux, Mac and Windows
     * open a file with the default program
     * 
     * @param path
     */
    public static void openPath(String path) {
        try {
            File file;
            file = new File(path);
            if (file.exists()) {
                Process proces = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + path);
                proces.waitFor();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * convert a file to a string
     * 
     * @param file file to convert
     * @return string representation of the file
     */
    public static String fileToString(File file) {
        try {
            return FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /**
     * select a file with a JavaFX FileChooser
     * dialog and return the selected file
     * 
     * @param nameFilter name of the filter
     * @param filters    filters
     * @return selected file
     */
    public static File selectFile(String nameFilter, String... filters) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(nameFilter, filters));
        return fileChooser.showOpenDialog(new Stage());
    }

}
