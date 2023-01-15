package Components;

import Model.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean answer;

    public static boolean confirm(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);

        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }

    public static boolean confirmRegistration(String title, String email, String password, String username) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        window.setMinHeight(200);

        Label emailLabel = new Label();
        emailLabel.setText("Email: " + email);

        // Label label2 = new Label();
        // label2.setText(password);

        Label usernameLabel = new Label();
        usernameLabel.setText("Username: " + username);

        Button yesButton = new Button("Yes");
        yesButton.setMinWidth(100);
        Button noButton = new Button("No");
        noButton.setMinWidth(100);

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(emailLabel, usernameLabel, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }

    public static boolean confirmBooking(Transaction transaction, Destination destination) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Payment confirmation");
        window.setMinWidth(250);
        window.setMinHeight(200);

        Label transactionIdLabel = new Label();
        transactionIdLabel.setText("ID: " + transaction.getTransactionId());

        Label destinationLabel = new Label();
        destinationLabel.setText("Destionation Location: " + destination.getDestinationName());

        Label emailUserLabel = new Label();
        emailUserLabel.setText("Email user: " + transaction.getEmailUser());

        Label quantityLabel = new Label();
        quantityLabel.setText("Quantity: " + transaction.getQuantity());

        Label totalPriceLabel = new Label();
        totalPriceLabel.setText("Total price: " + transaction.getTotalPrice());

        Button yesButton = new Button("Yes");
        yesButton.setMinWidth(100);
        Button noButton = new Button("No");
        noButton.setMinWidth(100);

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(transactionIdLabel, destinationLabel, emailUserLabel, quantityLabel, totalPriceLabel, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
