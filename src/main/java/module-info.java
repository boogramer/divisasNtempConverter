module com.converter.divisasntempconverter {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.json;
    requires java.logging;

    opens com.converter.divisasntempconverter to javafx.fxml;
    exports com.converter.divisasntempconverter;
    exports com.converter.divisasntempconverter.controller;
    opens com.converter.divisasntempconverter.controller to javafx.fxml;
}