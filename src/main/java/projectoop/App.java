package projectoop;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    Stage window;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("VacationID");

        GridPane grid = new GridPane();
        grid.setCenterShape(false);
        grid.setPadding(new Insets(10, 20, 10, 20));
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setAlignment(Pos.CENTER);

        // Email
        Label emailLabel = new Label("Email: ");
        GridPane.setConstraints(emailLabel, 0, 0);
        TextField emailInput = new TextField();
        emailInput.setPromptText("Username");
        GridPane.setConstraints(emailInput, 1, 0);
        String email = emailInput.getText();
        
        // Password
        Label passwordLabel = new Label("Password: ");
        GridPane.setConstraints(passwordLabel, 0, 1);
        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("Password");
        GridPane.setConstraints(passwordInput, 1, 1);
        
        // Button
        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> validateEmail(emailInput.getText(), passwordInput.getText()));
        
        GridPane.setConstraints(loginButton, 1, 2);
        Button registerButton = new Button("Register");
        registerButton.setOnAction(e -> registerButton());
        GridPane.setConstraints(registerButton, 1, 3);

        grid.getChildren().addAll(emailLabel, emailInput, passwordLabel, passwordInput, loginButton, registerButton);
        
        Scene scene = new Scene(grid, 640, 360);
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void validateEmail(String email, String password) {
        if (email.endsWith("@gmail.com") == true) {
            loginButton(email, password);
        } else {
            AlertBox.display("Wrong email format", "Wrong email format");
        }
    }

    public void loginButton(String username, String password) {
        GridPane grid = new GridPane();
        grid.setCenterShape(false);
        grid.setPadding(new Insets(10, 20, 10, 20));
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setAlignment(Pos.CENTER);

        Label usernameLabel = new Label(username);
        GridPane.setConstraints(usernameLabel, 0, 0);

        Label passwordLabel = new Label(password);
        GridPane.setConstraints(passwordLabel, 0, 1);

        grid.getChildren().addAll(usernameLabel, passwordLabel);
    
        Scene scene = new Scene(grid, 640, 360);
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    public void registerButton() {
        GridPane grid = new GridPane();
        grid.setCenterShape(false);
        grid.setPadding(new Insets(10, 20, 10, 20));
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setAlignment(Pos.CENTER);

        Label emailLabel = new Label("Email: ");
        GridPane.setConstraints(emailLabel, 0, 0);

        TextField emailInput = new TextField();
        emailInput.setPromptText("email@gmail.com");
        GridPane.setConstraints(emailInput, 1, 0);

        Label usernameLabel = new Label("Username: ");
        GridPane.setConstraints(usernameLabel, 0, 1);

        TextField usernameInput = new TextField();
        usernameInput.setPromptText("Username");
        GridPane.setConstraints(usernameInput, 1, 1);

        Label passwordLabel = new Label("Password: ");
        GridPane.setConstraints(passwordLabel, 0, 2);

        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("Password");
        GridPane.setConstraints(passwordInput, 1, 2);

        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 3);
        Button registerButton = new Button("Register");
        GridPane.setConstraints(registerButton, 2, 3);

        grid.getChildren().addAll(emailLabel, emailInput, usernameLabel, usernameInput, passwordLabel, passwordInput, loginButton, registerButton);

        Scene scene = new Scene(grid, 640, 360);
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }
}
