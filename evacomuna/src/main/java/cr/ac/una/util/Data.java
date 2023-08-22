package cr.ac.una.util;

/**
 *
 * @author estebannajera
 */
public class Data {
 private static boolean passwordChanged;

    public Data() {
    }

    public static void setPasswordChanged(boolean passwordChanged) {
        Data.passwordChanged = passwordChanged;
    }

    public static boolean isPasswordChanged() {
        return passwordChanged;
    }
 
}
