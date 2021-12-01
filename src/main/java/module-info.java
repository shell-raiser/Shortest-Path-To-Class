module com.example.shortestpath {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.shortestpath to javafx.fxml;
    exports com.example.shortestpath;
}