module projectoop {
    requires java.sql;
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    

    opens projectoop to javafx.fxml;
    exports projectoop;
}
