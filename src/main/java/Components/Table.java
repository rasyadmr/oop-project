package Components;

import java.util.*;

import Helper.*;
import Model.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Table {
    AlertBox alertBox = new AlertBox();
    DestinationHelper destinationHelper = new DestinationHelper();
    AccountHelper accountHelper = new AccountHelper();
    AdminHelper adminHelper = new AdminHelper();

    public void displayUser(ArrayList<Account> dataUser) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("View user");
        TableView<User> tableView = new TableView<>();

        TableColumn<User, String> column1 = new TableColumn<>("Email");
        column1.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<User, String> column2 = new TableColumn<>("Password");
        column2.setCellValueFactory(new PropertyValueFactory<>("password"));

        TableColumn<User, String> column3 = new TableColumn<>("Username");
        column3.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<User, String> column4 = new TableColumn<>("Phone number");
        column4.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        TableColumn<User, String> column5 = new TableColumn<>("Status");
        column5.setCellValueFactory(new PropertyValueFactory<>("userStatus"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);


        for (Account user: dataUser) {
            if (user instanceof User) {
                tableView.getItems().add((User)user);
            }
        }

        TextField emailInput = new TextField();
        emailInput.setPromptText("Email");
        emailInput.setMinWidth(100);

        Button removeButton = new Button();
        removeButton.setText("Remove");

        Button adminButton = new Button();
        adminButton.setText("Promote");

        removeButton.setOnAction(e -> {
            accountHelper.deleteUser(dataUser, emailInput.getText());
            window.close();
            displayUser(dataUser);
            return;
        });
        adminButton.setOnAction(e -> {
            adminHelper.promoteUser(dataUser, emailInput.getText());
            window.close();
            displayUser(dataUser);
            return;
        });

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.setSpacing(10);
        hbox.getChildren().addAll(emailInput, removeButton, adminButton);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(tableView, hbox);
        Scene scene = new Scene(vbox, 478, 400);
        window.setScene(scene);
        window.showAndWait();
    }

    public void displayAdmin(ArrayList<Account> dataUser) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("View admin");
        accountHelper.updateDataUser(dataUser);
        TableView<Admin> tableView = new TableView<>();

        TableColumn<Admin, String> column1 = new TableColumn<>("Email");
        column1.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Admin, String> column2 = new TableColumn<>("Admin name");
        column2.setCellValueFactory(new PropertyValueFactory<>("adminName"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);

        for (Account admin: dataUser) {
            if (admin instanceof Admin) {
                tableView.getItems().add((Admin)admin);
            }
        }

        VBox vbox = new VBox(tableView);
        Scene scene = new Scene(vbox, 250, 400);
        window.setScene(scene);
        window.show();
    }

    public void displayDestionation() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("View Destination");
        destinationHelper.updateDestinationsData();
        TableView<Destination> tableView = new TableView<>();

        TableColumn<Destination, String> column1 = new TableColumn<>("Destination ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("destinationId"));

        TableColumn<Destination, String> column2 = new TableColumn<>("Destination Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("destinationName"));

        TableColumn<Destination, Integer> column3 = new TableColumn<>("Price");
        column3.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);

        for (Destination destination: destinationHelper.destinations) {
            tableView.getItems().add(destination);
        }

        TextField destinationNameInput = new TextField();
        destinationNameInput.setPromptText("Destination Name");

        TextField priceInput = new TextField();
        priceInput.setPromptText("Price");

        Button addButton = new Button();
        addButton.setText("Add destination");

        addButton.setOnAction(e -> {
            try {
                destinationHelper.createDestination(destinationNameInput.getText(), Integer.parseInt(priceInput.getText()));
                window.close();
                displayDestionation();
                return;
            } catch (Exception ex) {
                alertBox.display("Error", "Price must be numerical!");
            }
        });
        
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.setSpacing(10);
        hbox.getChildren().addAll(destinationNameInput, priceInput, addButton);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(tableView, hbox);
        Scene scene = new Scene(vbox, 600, 400);
        window.setScene(scene);
        window.showAndWait();
    }

    public void displayTransaction(ArrayList<Transaction> dataTransaction) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("View transaction");
        TableView<Transaction> tableView = new TableView<>();

        TableColumn<Transaction, String> column1 = new TableColumn<>("Transaction ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("transactionId"));

        TableColumn<Transaction, String> column2 = new TableColumn<>("Destination ID");
        column2.setCellValueFactory(new PropertyValueFactory<>("destinationId"));

        TableColumn<Transaction, String> column3 = new TableColumn<>("Email user");
        column3.setCellValueFactory(new PropertyValueFactory<>("emailUser"));

        TableColumn<Transaction, String> column4 = new TableColumn<>("Quantity");
        column4.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableColumn<Transaction, String> column5 = new TableColumn<>("Total price");
        column5.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);

        for (Transaction transaction: dataTransaction) {
            tableView.getItems().add(transaction);
        }

        VBox vbox = new VBox(tableView);
        Scene scene = new Scene(vbox, 600, 400);
        window.setScene(scene);
        window.showAndWait();
    }
}
