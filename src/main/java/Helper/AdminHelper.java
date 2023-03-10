package Helper;

import java.util.*;
import Connection.*;
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
        
        System.out.println("New admin created!");
        return accountHelper.updateDataUser(dataUser);
    }

    public ArrayList<Account> promoteUser(ArrayList<Account> dataUser, String email) {
        User user = userHelper.findByEmail(dataUser, email);
        String emailUser = user.getEmail();
        String passwordUser = user.getPassword();
        String usernameUser = user.getUsername();
        dataUser = accountHelper.deleteUser(dataUser, emailUser);

        return createAdmin(dataUser, emailUser, passwordUser, usernameUser);
    }

    public Admin findByEmail(ArrayList<Account> dataUser, String email) {
        if (!accountHelper.validateEmail(email)) {
            return null;
        }
        
        for (Account item : dataUser) {
            if (item.getEmail().equals(email) && item instanceof Admin) {
                return (Admin)item;
            }
        }
        return null;
    }
}
