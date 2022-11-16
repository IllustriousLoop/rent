module com.rentp.rent {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.rentp to javafx.fxml;
    exports com.rentp;
    exports com.rentp.user;
    opens com.rentp.user to javafx.fxml;
}