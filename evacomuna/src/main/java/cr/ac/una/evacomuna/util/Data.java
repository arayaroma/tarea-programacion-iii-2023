package cr.ac.una.evacomuna.util;

import cr.ac.una.controller.UserDto;

/**
 *
 * @author estebannajera
 */
public class Data {

    private static boolean passwordChanged;
    private static UserDto userModified;
    private static UserDto userLogged;
    public Data() {
    }

    public static void setPasswordChanged(boolean passwordChanged) {
        Data.passwordChanged = passwordChanged;
    }

    public static boolean isPasswordChanged() {
        return passwordChanged;
    }

    public static UserDto getUserLogged() {
        return userLogged;
    }

    public static UserDto getUserModified() {
        return userModified;
    }

    public static void setUserModified(UserDto userModified) {
        Data.userModified = userModified;
    }

    public static void setUserLogged(UserDto userLogged) {
        Data.userLogged = userLogged;
    }

    

}
