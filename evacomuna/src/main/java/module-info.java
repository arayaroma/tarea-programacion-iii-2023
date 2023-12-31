@SuppressWarnings("module") module Evacomuna {
    requires java.base;
    requires java.logging;
    requires javafx.controls;
    requires transitive javafx.fxml;
    requires transitive javafx.graphics;
    requires jakarta.xml.bind;
    requires jakarta.xml.ws;
    requires org.apache.commons.compress;
    requires org.apache.commons.io;
    requires org.controlsfx.controls;
    requires AnimateFX;
    requires org.apache.poi.poi;
    requires java.desktop;
//    requires or

    opens cr.ac.una.evacomuna to javafx.fxml;
    opens cr.ac.una.evacomuna.util to javafx.fxml;
    opens cr.ac.una.evacomuna.controller to javafx.fxml;
    opens cr.ac.una.evacomuna.dto;
    opens cr.ac.una.evacomunaws.controller;

    exports cr.ac.una.evacomuna;
    exports cr.ac.una.evacomuna.controller;
    exports cr.ac.una.evacomunaws.controller;
}
