module com.example.hellofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jdk.compiler;
    requires java.sql;


    opens com.example.hellofx to javafx.fxml;
    exports com.example.hellofx;
    exports com.example.hellofx.eventDrivenProgrammingAndAnimations;
}