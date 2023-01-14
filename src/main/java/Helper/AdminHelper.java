package Helper;

import java.util.ArrayList;

import Connection.Connect;
import Model.Account;
import Model.Admin;

public class AdminHelper {
    Connect database = new Connect();

    public ArrayList<Account> createUser(ArrayList<Account> dataUser, String email, String password,
        String adminName) {
        String query = "INSERT INTO admin(email, password, adminName) VALUES ('" + email + "','" + password + "','" + adminName + "')";
        Connect database = new Connect();
        database.executeUpdate(query);
        
        dataUser.add(new Admin(email, password, adminName));
        System.out.println("User created!");
        return dataUser;
    }
}
