package projectoop;

import Controller.AlertBox;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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

        //username
        Label emailLabel = new Label("VacationId");
        GridPane.setConstraints(emailLabel, 0, 0);
        
        //button
        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 0, 1);
        loginButton.setOnAction(e -> goToLoginUI());
        
        Button registerButton = new Button("Register");
        GridPane.setConstraints(registerButton, 0, 2);
        registerButton.setOnAction(e -> goToRegisterUI());

        grid.getChildren().addAll(emailLabel, loginButton, registerButton);
        
        Scene scene = new Scene(grid, 640, 360);
        window.setScene(scene);
        window.getIcons().add(new Image("logo.png")); 
        window.setResizable(false);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void validateAccount(String email, String password) {
        if (email.endsWith("@gmail.com") == true)
        {
            appUI(email, password);
        }
        else
        {
            AlertBox.display("Wrong Email Format Alert", "Please input your email with format @gmail.com");
        }
    }
    
    public void appUI(String username, String password)
    {
        Label usernameLabel = new Label(username);
        GridPane.setConstraints(usernameLabel, 0, 0);

        Label passwordLabel = new Label(password);
        GridPane.setConstraints(passwordLabel, 0, 1);
        
        GridPane grid = new GridPane();
        grid.setCenterShape(false);
        grid.setPadding(new Insets(10, 20, 10, 20));
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setAlignment(Pos.CENTER);
        
        grid.getChildren().addAll(usernameLabel, passwordLabel);
        
        Scene scene = new Scene(grid, 640, 360);
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }
    
    public void goToLoginUI()
    {
        GridPane grid = new GridPane();
        grid.setCenterShape(false);
        grid.setPadding(new Insets(10, 20, 10, 20));
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setAlignment(Pos.CENTER);

        //username
        Label emailLabel = new Label("Email: ");
        GridPane.setConstraints(emailLabel, 0, 0);
        TextField emailInput = new TextField();
        emailInput.setPromptText("Username");
        GridPane.setConstraints(emailInput, 1, 0);
        String email = emailInput.getText();
        
        //pw
        Label passwordLabel = new Label("Password: ");
        GridPane.setConstraints(passwordLabel, 0, 1);
        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("Password");
        GridPane.setConstraints(passwordInput, 1, 1);
        
        //button
        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> validateAccount(emailInput.getText(), passwordInput.getText()));
        
        GridPane.setConstraints(loginButton, 1, 2);
        Button registerButton = new Button("Don't have any account?, register a new account");
        registerButton.setOnAction(e -> goToRegisterUI());
        GridPane.setConstraints(registerButton, 1, 3);

        grid.getChildren().addAll(emailLabel, emailInput, passwordLabel, passwordInput, loginButton, registerButton);
        
        Scene scene = new Scene(grid, 640, 360);
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    public void goToRegisterUI() {
        GridPane grid = new GridPane();
        grid.setCenterShape(false);
        grid.setPadding(new Insets(10, 20, 10, 20));
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setAlignment(Pos.CENTER);

        // email
        Label emailLabel = new Label("Email: ");
        GridPane.setConstraints(emailLabel, 0, 0);
        TextField emailInput = new TextField();
        emailInput.setPromptText("email@gmail.com");
        GridPane.setConstraints(emailInput, 1, 0);

        //username
        Label usernameLabel = new Label("Username: ");
        GridPane.setConstraints(usernameLabel, 0, 1);
        TextField usernameInput = new TextField();
        usernameInput.setPromptText("Username");
        GridPane.setConstraints(usernameInput, 1, 1);

        //password
        Label passwordLabel = new Label("Password: ");
        GridPane.setConstraints(passwordLabel, 0, 2);
        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("Password");
        GridPane.setConstraints(passwordInput, 1, 2);

        //button
        Button loginButton = new Button("Back to login menu");
        GridPane.setConstraints(loginButton, 1, 3);
        Button registerButton = new Button("Register");
        GridPane.setConstraints(registerButton, 1, 4);
        registerButton.setOnAction(e -> validateAccount(emailInput.getText(), passwordInput.getText()));

        grid.getChildren().addAll(emailLabel, emailInput, usernameLabel, usernameInput, passwordLabel, passwordInput, loginButton, registerButton);

        Scene scene = new Scene(grid, 640, 360);
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }
}