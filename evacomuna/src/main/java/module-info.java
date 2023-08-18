module Evacomuna {
    requires java.base;
    requires java.logging;
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.xml.bind;
    requires jakarta.xml.ws;
    
    opens cr.ac.una.evacomuna to javafx.fxml;
    opens cr.ac.una.services;
    exports cr.ac.una.evacomuna;

}
