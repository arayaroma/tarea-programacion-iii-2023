package cr.ac.una.evacomuna.util;

/**
 * 
 * @author arayaroma
 */
public enum Roles {
    SUPERVISOR,
    PEER,
    SELF,
    CLIENT;

    Roles() {
    }

    public static Roles fromString(String role) {
        if (role != null) {
            for (Roles r : Roles.values()) {
                if (role.equalsIgnoreCase(r.toString())) {
                    return r;
                }
            }
        }
        return null;
    }

    public static String toString(Roles role) {
        if (role != null) {
            return role.toString();
        }
        return null;
    }
}