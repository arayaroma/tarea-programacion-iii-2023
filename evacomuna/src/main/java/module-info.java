module Evacomuna {
    requires java.base;
    requires java.logging;
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.xml.bind;
    requires jakarta.xml.ws;
    requires org.controlsfx.controls;
    
    opens cr.ac.una.evacomuna to javafx.fxml;
    opens cr.ac.una.util to javafx.fxml;
    opens cr.ac.una.services.impl;
    opens cr.ac.una.controller to javafx.fxml;
    
    
    exports cr.ac.una.evacomuna;
    exports cr.ac.una.controller;

}
