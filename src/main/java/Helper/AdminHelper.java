package Helper;

import java.util.ArrayList;

import Connection.Connect;
import Model.*;

public class AdminHelper {
    Connect database = new Connect();
    AccountHelper accountHelper = new AccountHelper();
    UserHelper userHelper = new UserHelper();

    public ArrayList<Account> createAdmin(ArrayList<Account> dataUser, String email, String password,
        String adminName) {
        String query = "INSERT INTO admin(email, password, adminName) VALUES ('" + email + "','" + password + "','" + adminName + "')";
        Connect database = new Connect();
        database.executeUpdate(query);
        
        System.out.println("User created!");
        return accountHelper.updateDataUser(dataUser);
    }

    public ArrayList<Account> promoteUser(ArrayList<Account> dataUser, User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        String username = user.getUsername();
        dataUser = userHelper.deleteUser(dataUser, user.getEmail());

        dataUser = createAdmin(dataUser, email, password, username);
        return dataUser;
    }
}
