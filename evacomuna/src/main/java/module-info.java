module Evacomuna {
    requires java.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.cxf.frontend.jaxws;
    
    
    opens cr.ac.una.evacomuna to javafx.fxml;
    exports cr.ac.una.evacomuna;
}
