package Helper;

import Controller.AlertBox;

public class UserHelper {
    public Boolean validateEmail(String email) {
        if (email.endsWith("@gmail.com")) {
            if (true) { // TODO make a unique verify
                return true;
            }
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
