package Helper;

import Controller.AlertBox;

public class AccountHelper {
    public Boolean validateEmail(String email) {
        if (email.isEmpty()) {
            if (email.endsWith("@gmail.com")) {
                return true;
            } else {
                AlertBox.display("Invalid", "Use @gmail.com to continue!");
            }
        } else {
            AlertBox.display("Error", "Email cannot be empty!");
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

    public Boolean validateInput(String email, String username, String password) {
        if (!validateEmail(email)) {
            AlertBox.display("Invalid", "Invalid email!");
            return false;
        } else if (!validateUsername(username)) {
            AlertBox.display("Invalid", "Username is empty or too long!");
            return false;
        } else if (!validatePassword(password)) {
            AlertBox.display("Invalid", "Password is too short or too long!");
            return false;
        } else {
            return true;
        }
    }
}
