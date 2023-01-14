package Helper;

import java.util.*;
import Connection.Connect;
import Model.Account;

public class UserHelper {
    Connect database = new Connect();
    AccountHelper accountHelper = new AccountHelper();

    public ArrayList<Account> createUser(ArrayList<Account> dataUser, String email, String password,
        String username, String phoneNumber) {
        String query = "INSERT INTO user(email, password, username, phoneNumber, userStatus) VALUES ('" + email + "','" + password + "','" + username + "','" + phoneNumber + "','Normal')";
        database.executeUpdate(query);
        
        System.out.println("User created!");
        return accountHelper.updateDataUser(dataUser);
    }

    public ArrayList<Account> deleteUser(ArrayList<Account> dataUser, String email) {
        String query = "DELETE FROM user WHERE email = '" + email + "'";
        database.executeUpdate(query);

        System.out.println("User deleted!");
        return accountHelper.updateDataUser(dataUser);
    }

    public ArrayList<Account> upgradeUser(ArrayList<Account> dataUser, String email) {
        String query = "UPDATE user SET userStatus = 'Member' WHERE email = '" + email + "'";
        database.executeUpdate(query);

        System.out.println("User successfully upgraded!");
        return accountHelper.updateDataUser(dataUser);
    }
}
