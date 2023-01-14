package projectoop;

import java.util.*;

import Components.ConfirmBox;
import Components.Table;
import Helper.AccountHelper;
import Helper.AdminHelper;
import Helper.UserHelper;
import Model.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

    Stage window;
    Table table = new Table();
    ArrayList<Account> dataUser = new ArrayList<>();
    Account userSession;
    AccountHelper accountHelper = new AccountHelper();
    AdminHelper adminHelper = new AdminHelper();
    UserHelper userHelper = new UserHelper();
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("TicketID");

        GridPane grid = new GridPane();
        grid.setCenterShape(false);
        grid.setPadding(new Insets(10, 20, 10, 20));
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setAlignment(Pos.CENTER);
        
        ImageView imageview = new ImageView("logo.png");
        imageview.setFitHeight(146);
        imageview.setFitWidth(175);
        GridPane.setConstraints(imageview, 0, 0);
        
        //button
        Button loginButton = new Button("Login");
        // loginButton.minWidth(50);
        GridPane.setConstraints(loginButton, 1, 0);
        loginButton.setOnAction(e -> goToLoginUI());
        
        Button registerButton = new Button("Register");
        // registerButton.minWidth(50);
        GridPane.setConstraints(registerButton, 2, 0);
        registerButton.setOnAction(e -> goToRegisterUI());

        grid.getChildren().addAll(imageview, loginButton, registerButton);
        grid.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

        Scene scene = new Scene(grid, 640, 360);
        window.setScene(scene);
        window.getIcons().add(new Image("logo.png")); 
        window.setResizable(false);
        window.show();
    }
    
    public void appUI()
    {
        if (userSession instanceof User) {
            // TODO User menu
        } else {
            // TODO Admin menu
            Label usernameLabel = new Label(userSession.getEmail());
            GridPane.setConstraints(usernameLabel, 0, 0);

            Label passwordLabel = new Label(userSession.getPassword());
            GridPane.setConstraints(passwordLabel, 0, 1);

            Button viewUser = new Button("View user");
            viewUser.setOnAction(e -> table.displayUser(dataUser));
            viewUser.setMinWidth(200);
            GridPane.setConstraints(viewUser, 0, 2);

            Button viewAdmin = new Button("View admin");
            viewAdmin.setOnAction(e -> table.displayAdmin(dataUser));
            viewAdmin.setMinWidth(200);
            GridPane.setConstraints(viewAdmin, 0, 3);
            
            GridPane grid = new GridPane();
            grid.setCenterShape(false);
            grid.setPadding(new Insets(10, 20, 10, 20));
            grid.setHgap(10);
            grid.setVgap(5);
            grid.setAlignment(Pos.CENTER);
            
            grid.getChildren().addAll(viewAdmin, viewUser, usernameLabel, passwordLabel);
            grid.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
            
            Scene scene = new Scene(grid, 640, 360);
            window.setScene(scene);
            window.setResizable(false);
            window.show();
        }

    }
    
    public void goToLoginUI()
    {
        GridPane grid = new GridPane();
        grid.setCenterShape(false);
        grid.setPadding(new Insets(10, 20, 10, 20));
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setAlignment(Pos.CENTER);

        // Username
        Label emailLabel = new Label("Email: ");
        GridPane.setConstraints(emailLabel, 0, 0);
        TextField emailInput = new TextField();
        emailInput.setPromptText("Username");
        GridPane.setConstraints(emailInput, 1, 0);
        
        // Password
        Label passwordLabel = new Label("Password: ");
        GridPane.setConstraints(passwordLabel, 0, 1);
        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("Password");
        GridPane.setConstraints(passwordInput, 1, 1);
        
        // Button
        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> onClickLogin(emailInput.getText(), passwordInput.getText()));
        
        GridPane.setConstraints(loginButton, 1, 2);
        Button registerButton = new Button("Don't have any account?, register a new account");
        registerButton.setOnAction(e -> goToRegisterUI());
        GridPane.setConstraints(registerButton, 1, 3);

        grid.getChildren().addAll(emailLabel, emailInput, passwordLabel, passwordInput, loginButton, registerButton);
        grid.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        
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

        Label emailLabel = new Label("Email: ");
        GridPane.setConstraints(emailLabel, 0, 0);
        TextField emailInput = new TextField();
        emailInput.setMinWidth(250);
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

        Label phoneLabel = new Label("Phone number: ");
        GridPane.setConstraints(phoneLabel, 0, 3);
        TextField phoneInput = new TextField();
        phoneInput.setPromptText("081234567890");
        GridPane.setConstraints(phoneInput, 1, 3);

        Button loginButton = new Button("Back to login menu");
        GridPane.setConstraints(loginButton, 1, 4);
        loginButton.setOnAction(e -> goToLoginUI());
        Button registerButton = new Button("Register");
        GridPane.setConstraints(registerButton, 1, 5);
        registerButton.setOnAction(e -> onClickRegister(emailInput.getText(), passwordInput.getText(), usernameInput.getText(), phoneInput.getText()));

        grid.getChildren().addAll(emailLabel, emailInput, usernameLabel, usernameInput, passwordLabel, passwordInput, phoneLabel, phoneInput, loginButton, registerButton);
        grid.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

        Scene scene = new Scene(grid, 640, 360);
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    public void onClickLogin(String email, String password) {
        AccountHelper accountHelper = new AccountHelper();

        if (accountHelper.logging(dataUser, email, password)) {
            userSession = new Account(email, password);
            appUI();
        } else {
            goToLoginUI();
        }
    }

    public void onClickRegister(String email, String password, String username, String phone) {
        if (ConfirmBox.confirmRegistration("Confirm data input", email, password, username)) {
            dataUser = userHelper.createUser(dataUser, email, password, username, phone);
            goToLoginUI();
        } else {
            goToRegisterUI();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}