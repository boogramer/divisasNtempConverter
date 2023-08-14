module com.converter.divisasntempconverter {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.json;
    requires java.logging;

    opens com.converter.divisasConverter to javafx.fxml;
    exports com.converter.divisasConverter;
    exports com.converter.divisasConverter.controller;
    opens com.converter.divisasConverter.controller to javafx.fxml;
}