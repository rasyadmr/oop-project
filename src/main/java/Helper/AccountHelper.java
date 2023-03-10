package Helper;

import java.sql.*;
import java.util.*;
import Components.*;
import Connection.*;
import Model.*;

public class AccountHelper {
    AlertBox alert = new AlertBox();
    Connect connection = new Connect();

    public Boolean validateEmail(String email) {
        if (!email.isEmpty()) {
            if (email.endsWith("@gmail.com")) {
                return true;
            } else {
                alert.display("Invalid", "Use @gmail.com to continue!");
            }
        } else {
            alert.display("Error", "Email cannot be empty!");
        }
        return false;
    }

    private Boolean validateUsername(String username) {
        if (username.length() >= 1 && username.length() <= 20) {
            return true;
        }
        return false;
    }

    private Boolean validatePassword(String password) {
        if (password.length() >= 8 && password.length() <= 20) {
            return true;
        }
        return false;
    }

    private Boolean validatePhone(String phoneNumber) {
        if (phoneNumber.length() < 8 || phoneNumber.length() > 20) {
            return false;
        }
        return true;
    }

    public Boolean validateInput(String email, String username, String password, String phoneNumber) {
        if (!validateEmail(email)) {
            alert.display("Invalid", "Invalid email!");
            return false;
        } else if (!validateUsername(username)) {
            alert.display("Invalid", "Username is empty or too long!");
            return false;
        } else if (!validatePassword(password)) {
            alert.display("Invalid", "Password is too short or too long!");
            return false;
        } else if (!validatePhone(phoneNumber)) {
            alert.display("Invalid", "Phone number is too short or too long!");
            return false;
        } else {
            return true;
        }
    }

    public Boolean uniqueEmail(ArrayList<Account> dataUser, String email) {
        if (dataUser.isEmpty()) {
            return true;
        }

        for (Account account: dataUser) {
            if (account.getEmail().equals(email)) {
                alert.display("Error email", "Email is used, try other");
                return false;
            }
        }
        return true;
    }

    public ArrayList<Account> updateDataUser(ArrayList<Account> dataUser) {
        dataUser.clear();
        String query = "SELECT * FROM admin";
        ResultSet result = connection.execQuery(query);

        try {
            while (result.next()) {
                String email = result.getString("email");
                String password = result.getString("password");
                String adminName = result.getString("adminName");

                dataUser.add(new Admin(email, password, adminName));
            }
        } catch (Exception e) {
            e.getMessage();
        }

        query = "SELECT * FROM user";
        result = connection.execQuery(query);

        try {
            while (result.next()) {
                String email = result.getString("email");
                String password = result.getString("password");
                String username = result.getString("username");
                String phoneNumber = result.getString("phoneNumber");
                String userStatus = result.getString("userStatus");

                dataUser.add(new User(email, password, username, phoneNumber, userStatus));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        
        return dataUser;
    }

    public ArrayList<Account> deleteUser(ArrayList<Account> dataUser, String email) {
        if (!validateEmail(email)) {
            return dataUser;
        }

        String query = "DELETE FROM user WHERE email = '" + email + "'";
        connection.executeUpdate(query);

        System.out.println("User deleted!");
        return updateDataUser(dataUser);
    }

    public Boolean logging(ArrayList<Account> dataUser, String email, String password) {
        if (!validateEmail(email)) {
            return false;
        }

        updateDataUser(dataUser);

        Integer index = -1;
        for (Account item: dataUser) {
            if (item.getEmail().equals(email)) {
                index = dataUser.indexOf(item);
                break;
            }
        }

        if (index < 0) {
            alert.display("Incorrect", "Email is not registered!");
            return false;
        } else {
            Account acc = dataUser.get(index);
            if (acc.getPassword().equals(password)) {
                System.out.println(acc.getEmail() + " is logged in!");
                return true;
            } else {
                alert.display("Incorrect", "Password is incorrect!");
                return false;
            }
        }
    }
}
