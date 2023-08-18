module cr.ac.una.evacomuna {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    requires java.activation;
    requires java.xml.bind;
    requires java.xml.ws;

    requires jakarta.xml.ws;
    requires jakarta.xml.bind;
    requires jakarta.activation;

    requires org.apache.cxf.core;
    requires org.apache.cxf.frontend.jaxws;
    requires org.apache.cxf.frontend.simple;

    opens cr.ac.una.evacomuna to javafx.fxml;

    exports cr.ac.una.evacomuna;
}