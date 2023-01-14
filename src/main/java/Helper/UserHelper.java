package Helper;

import java.util.*;
import Connection.Connect;
import Model.Account;
import Model.User;

public class UserHelper {
    Connect database = new Connect();

    public ArrayList<Account> createUser(ArrayList<Account> dataUser, String email, String password,
        String username, String phoneNumber) {
        String query = "INSERT INTO user(email, password, username, phoneNumber, userStatus) VALUES ('" + email + "','" + password + "','" + username + "','" + phoneNumber + "','Normal')";
        Connect database = new Connect();
        database.executeUpdate(query);
        
        dataUser.add(new User(email, password, username, phoneNumber, "Normal"));
        System.out.println("User created!");
        return dataUser;
    }
}
