package Components;

import java.util.*;
import Model.*;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Table {
    public void displayUser(ArrayList<Account> dataUser) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("View user");
        TableView tableView = new TableView();

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
                tableView.getItems().add(new User(user.getEmail(), user.getPassword(), ((User) user).getEmail(), ((User) user).getPhoneNumber(), ((User) user).getUserStatus()));
            }
        }

        VBox vbox = new VBox(tableView);

        Scene scene = new Scene(vbox, 478, 400);
        window.setScene(scene);
        window.show();
    }

    public void displayAdmin(ArrayList<Account> dataUser) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("View admin");
        TableView tableView = new TableView();

        TableColumn<Admin, String> column1 = new TableColumn<>("Email");
        column1.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Admin, String> column2 = new TableColumn<>("Admin name");
        column2.setCellValueFactory(new PropertyValueFactory<>("adminName"));



        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);

        for (Account admin: dataUser) {
            if (admin instanceof Admin) {
                tableView.getItems().add(new Admin(admin.getEmail(), admin.getPassword(), ((Admin) admin).getAdminName()));
            }
        }

        VBox vbox = new VBox(tableView);

        Scene scene = new Scene(vbox, 250, 400);
        window.setScene(scene);
        window.show();
    }
}
