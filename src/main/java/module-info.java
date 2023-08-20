module com.converter.divisasntempconverter {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.json;
    requires java.logging;

    opens com.converter.currencyntempconverter to javafx.fxml;
    exports com.converter.currencyntempconverter;
    exports com.converter.currencyntempconverter.controller;
    opens com.converter.currencyntempconverter.controller to javafx.fxml;
}