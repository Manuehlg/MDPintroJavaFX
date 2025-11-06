module com.pp.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.pp.demo.sesion5 to javafx.graphics, javafx.fxml;

    opens com.pp.demo.sesion6 to javafx.graphics, javafx.fxml;

    exports com.pp.demo.sesion5;

    exports com.pp.demo.sesion6;
}
