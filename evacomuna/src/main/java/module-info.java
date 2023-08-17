module ac.cr.una.evacomuna {
    requires javafx.controls;
    requires javafx.fxml;

    opens ac.cr.una.evacomuna to javafx.fxml;
    exports ac.cr.una.evacomuna;
}
