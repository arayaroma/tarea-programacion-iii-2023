module Evacomuna {
    requires java.base;
    requires java.logging;
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    requires jakarta.activation;
    requires jakarta.xml.ws;
    requires jakarta.xml.bind;

    opens cr.ac.una.services;
    opens cr.ac.una.evacomuna to javafx.fxml;

    exports cr.ac.una.evacomuna;
}