package cr.ac.una.evacomuna.util;

import cr.ac.una.evacomuna.dto.UserDto;

/**
 *
 * @author estebannajera
 */
public class Data {

    private static boolean passwordChanged;
    private static UserDto userModified;
    private static UserDto userLogged;
    private static boolean hasPrivileges;

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

    public static void setHasPrivileges(boolean hasPrivileges) {
        Data.hasPrivileges = hasPrivileges;
    }

    public static boolean isHasPrivileges() {
        return hasPrivileges;
    }

    public static void setUserLogged(UserDto userLogged) {
        Data.userLogged = userLogged;
    }

}
