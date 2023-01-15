package Helper;

import java.util.*;
import java.sql.*;
import Model.*;
import Components.*;
import Connection.*;

public class TransactionHelper {
    Random rand = new Random();
    Connect connection = new Connect();

    public ArrayList<Transaction> updateTransactionData(ArrayList<Transaction> transactions) {
        transactions.clear();
        String query = "SELECT * FROM transaction";
        ResultSet result = connection.execQuery(query);

        try {
            while (result.next()) {
                String transactionId = result.getString("transactionId");
                String destinationId = result.getString("destinationId");
                String emailUser = result.getString("emailUser");
                Integer quantity = result.getInt("quantity");
                Integer totalPrice = result.getInt("totalPrice");

                transactions.add(new Transaction(transactionId, destinationId, emailUser, quantity, totalPrice));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return transactions;
    }

    public String generateTransactionId(ArrayList<Transaction> transactions) {
		String result = "TR";
		
		for (int i = 0; i < 3; i++) {
			Integer temp = rand.nextInt(10);
			result += temp;
		}
		
		if (!transactions.isEmpty()) {
			for (Transaction temp: transactions) {
				if (temp.getTransactionId().equals(result)) {
					generateTransactionId(transactions);
				}
			}
		}

		return result;
	}

    public ArrayList<Transaction> createTransaction(ArrayList<Transaction> transactions, Destination destination, Account user, Integer quantity) {
        double totalPrice = (double)destination.getPrice() * quantity;

        if (user instanceof User) {
            if (((User)user).getUserStatus().equals("Member")) {
                totalPrice *= 0.9;
            }
        }

        Transaction result = new Transaction(generateTransactionId(transactions), destination.getDestinationId(), user.getEmail(), quantity, (int)totalPrice);
        if (ConfirmBox.confirmBooking(result, destination)) {
            String query = "INSERT INTO transaction(transactionId, destinationId, emailUser, quantity, totalPrice) VALUES ('" + result.getTransactionId() + "','" + result.getDestinationId() + "','" + result.getEmailUser() + "','" + result.getQuantity() + "','" + result.getTotalPrice() + "')";
            Connect database = new Connect();
            database.executeUpdate(query);
            System.out.println("New transaction created!");
        }

        return updateTransactionData(transactions);
    }
}
