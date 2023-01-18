package Helper;

import java.util.*;
import java.sql.*;
import Model.*;
import Connection.*;

public class DestinationHelper {
    Random rand = new Random();
    public ArrayList<Destination> destinations = new ArrayList<>();
    Connect connection = new Connect();

    public void updateDestinationsData() {
        destinations.clear();
        String query = "SELECT * FROM destination";
        ResultSet result = connection.execQuery(query);

        try {
            while (result.next()) {
                String destinationId = result.getString("destinationId");
                String destinationName = result.getString("destinationName");
                Integer price = result.getInt("price");

                destinations.add(new Destination(destinationId, destinationName, price));
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public String generateDestinationId() {
        updateDestinationsData();
		String result = "DN";
		
		for (int i = 0; i < 3; i++) {
			Integer temp = rand.nextInt(10);
			result += temp;
		}
		
		if (!destinations.isEmpty()) {
			for (Destination temp: destinations) {
				if (temp.getDestinationId().equals(result)) {
					generateDestinationId();
				}
			}
		}
		return result;
	}

    public void createDestination(String destinationName, Integer price) {
        destinationName = destinationName.toUpperCase();
        String query = "INSERT INTO destination(destinationId, destinationName, price) VALUES ('" + generateDestinationId() + "','" + destinationName + "','" + price + "')";
        connection.executeUpdate(query);
        
        System.out.println("New destination created!");
        this.updateDestinationsData();
        return;
    }

    public Destination findByName(String name) {
        if (destinations.isEmpty()) {
            return null;
        }
        
        for (Destination item : destinations) {
            if (item.getDestinationName().equals(name)) {
                return item;
            }
        }
        return null;
    }
}
