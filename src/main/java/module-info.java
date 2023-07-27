module com.converter.divisasntempconverter {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.converter.divisasntempconverter to javafx.fxml;
    exports com.converter.divisasntempconverter;
}