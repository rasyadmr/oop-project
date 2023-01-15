package projectoop;

import java.util.*;
import Components.*;
import Helper.*;
import Model.*;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {
    Stage window;
    AlertBox alertBox = new AlertBox();
    ConfirmBox confirmBox = new ConfirmBox();
    Account userSession;
    Table table = new Table();
    ArrayList<Account> dataUser = new ArrayList<>();
    ArrayList<Transaction> dataTransaction = new ArrayList<>();
    AccountHelper accountHelper = new AccountHelper();
    AdminHelper adminHelper = new AdminHelper();
    UserHelper userHelper = new UserHelper();
    TransactionHelper transactionHelper = new TransactionHelper();
    DestinationHelper destinationHelper = new DestinationHelper();
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        dataUser = accountHelper.updateDataUser(dataUser);
        dataTransaction = transactionHelper.updateTransactionData(dataTransaction);

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

        RotateTransition rotate = new RotateTransition();
        rotate.setDuration(new Duration(10000));
        rotate.setNode(imageview);
        rotate.setByAngle(360);
        rotate.setCycleCount(1000);
        rotate.setAutoReverse(true);
        rotate.play();

        Group image = new Group(imageview);
        GridPane.setConstraints(image, 0, 0);
        
        Button loginButton = new Button("Login");
        loginButton.setMinWidth(100);
        GridPane.setConstraints(loginButton, 1, 0);
        loginButton.setOnAction(e -> goToLoginUI());
        
        Button registerButton = new Button("Register");
        registerButton.setMinWidth(100);
        GridPane.setConstraints(registerButton, 2, 0);
        registerButton.setOnAction(e -> goToRegisterUI());

        grid.getChildren().addAll(image, loginButton, registerButton);
        grid.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

        FadeTransition fade = new FadeTransition();
        fade.setDuration(new Duration(1000));
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.setCycleCount(1);
        fade.setAutoReverse(false);
        fade.setNode(grid);
        fade.play();

        Scene scene = new Scene(grid, 640, 360);
        window.setScene(scene);
        window.getIcons().add(new Image("logo.png")); 
        window.setResizable(false);
        window.show();
    }
    
    public void appUI(Boolean isAdmin) {
        if (!isAdmin) {
            Label usernameLabel = new Label("Welcome " + userSession.getEmail() + "!");

            Button buyButton = new Button("Buy ticket");
            buyButton.setOnAction(e -> goBuyMenu());
            buyButton.setMinWidth(100);

            Button upgradeButton = new Button("Upgrade member");
            upgradeButton.setOnAction(e -> {
                Boolean confirm = confirmBox.confirm("Upgrade member", "Are you sure want to become a member?");
                if (confirm) {
                    userHelper.upgradeUser(dataUser, userSession.getEmail());
                }
            });
            upgradeButton.setMinWidth(100);

            Button logout = new Button("Log out");
            logout.setOnAction(e -> onClickLogout());
            logout.setMinWidth(100);
            
            GridPane grid = new GridPane();
            grid.setCenterShape(true);
            grid.setPadding(new Insets(10, 20, 10, 20));
            grid.setHgap(10);
            grid.setVgap(5);
            grid.setAlignment(Pos.CENTER);
            
            grid.add(buyButton, 0, 0);
            grid.add(upgradeButton, 1, 0);
            grid.add(logout, 2, 0);

            grid.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

            VBox vbox = new VBox();
            vbox.setAlignment(Pos.CENTER);
            vbox.getChildren().addAll(usernameLabel, grid);
            vbox.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

            Scene scene = new Scene(vbox, 640, 360);
            window.setScene(scene);
            window.setResizable(false);
            window.show();
        } else {
            Label usernameLabel = new Label("Welcome " + userSession.getEmail() + "!");

            Button viewUser = new Button("View user");
            viewUser.setOnAction(e -> table.displayUser(dataUser));
            viewUser.setMinWidth(100);

            Button viewAdmin = new Button("View admin");
            viewAdmin.setOnAction(e -> table.displayAdmin(dataUser));
            viewAdmin.setMinWidth(100);

            Button viewDestionation = new Button("View destination");
            viewDestionation.setOnAction(e -> table.displayDestionation());
            viewDestionation.setMinWidth(100);

            Button viewTransaction = new Button("View transaction");
            viewTransaction.setOnAction(e -> table.displayTransaction(dataTransaction));
            viewTransaction.setMinWidth(100);

            Button logout = new Button("Log out");
            logout.setOnAction(e -> onClickLogout());
            logout.setMinWidth(100);
            
            GridPane grid = new GridPane();
            grid.setCenterShape(true);
            grid.setPadding(new Insets(10, 20, 10, 20));
            grid.setHgap(10);
            grid.setVgap(5);
            grid.setAlignment(Pos.CENTER);
            
            grid.add(viewUser, 0, 0);
            grid.add(viewAdmin, 1, 0);
            grid.add(viewDestionation, 2, 0);
            grid.add(viewTransaction, 3, 0);
            grid.add(logout, 4, 0);

            grid.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
            
            VBox vbox = new VBox();
            vbox.setAlignment(Pos.CENTER);
            vbox.getChildren().addAll(usernameLabel, grid);
            vbox.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

            Scene scene = new Scene(vbox, 640, 360);
            window.setScene(scene);
            window.setResizable(false);
            window.show();
        }

    }
    
    public void goToLoginUI() {
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
        
        Label passwordLabel = new Label("Password: ");
        GridPane.setConstraints(passwordLabel, 0, 1);
        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("Password");
        GridPane.setConstraints(passwordInput, 1, 1);
        
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

    public void goBuyMenu() {
        destinationHelper.updateDestinationsData();
        ArrayList<Destination> destinationData = destinationHelper.destinations;

        GridPane grid = new GridPane();
        grid.setCenterShape(false);
        grid.setPadding(new Insets(10, 20, 10, 20));
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setAlignment(Pos.CENTER);

        ComboBox<String> pilihDestinasi = new ComboBox<>();
        pilihDestinasi.setPromptText("Pilih destinasi!");
        for (Destination destination: destinationData) {
            pilihDestinasi.getItems().add(destination.getDestinationName());
        }

        Spinner<Integer> pilihJumlahTiket = new Spinner<>(1, 10, 1);
        
        Button buyButton = new Button("Buy");
        buyButton.setOnAction(e -> {
            Boolean buy = false;
            for (Destination destination: destinationData) {
                if (destination.getDestinationName().equalsIgnoreCase(pilihDestinasi.getValue())) {
                    dataTransaction = transactionHelper.createTransaction(dataTransaction, destination, userSession, pilihJumlahTiket.getValue());
                    buy = true;
                    break;
                } else if (destinationData.indexOf(destination) == destinationData.size() - 1) {
                    alertBox.display("Error booking", "Destination is unknown");
                }
            }

            if (buy) {
                appUI(false);
            } else {
                goBuyMenu();
            }
        });
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> appUI(false));
        cancelButton.setAlignment(Pos.CENTER_LEFT);

        grid.add(pilihDestinasi, 0, 0);
        grid.add(pilihJumlahTiket, 1, 0);
        grid.add(buyButton, 1, 1);
        grid.add(cancelButton, 0, 1);

        grid.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        Scene scene = new Scene(grid, 640, 360);
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    public void onClickLogin(String email, String password) {
        AccountHelper accountHelper = new AccountHelper();
        Boolean admin = false;

        for (Account account: dataUser) {
            if (account.getEmail().equals(email)) {
                if (account instanceof Admin) {
                    admin = true;
                    break;
                }
                break;
            }
        }

        if (accountHelper.logging(dataUser, email, password)) {
            userSession = new Account(email, password);
            if (admin) {
                appUI(true);
            } else {
                appUI(false);
            }
        } else {
            goToLoginUI();
        }
    }

    public void onClickRegister(String email, String password, String username, String phone) {
        if (email.isEmpty() || password.isEmpty() || username.isEmpty() || phone.isEmpty()) {
            alertBox.display("Error", "Please input data correctly");
            goToRegisterUI();
            return;
        }

        if (ConfirmBox.confirmRegistration("Confirm data input", email, password, username)) {
            dataUser = userHelper.createUser(dataUser, email, password, username, phone);
            goToLoginUI();
        } else {
            goToRegisterUI();
        }
    }

    public void onClickLogout() {
        userSession = null;
        try {
            start(window);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}