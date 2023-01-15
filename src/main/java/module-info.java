module projectoop {
    requires transitive java.sql;
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires transitive javafx.graphics;

    opens projectoop to javafx.fxml;
    exports projectoop;
    exports Model;
    exports Helper;
    exports Components;
    exports Connection;
}
