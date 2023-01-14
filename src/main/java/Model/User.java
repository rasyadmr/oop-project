package Model;

public class User extends Account {
    private String username, phoneNumber, userStatus;

    public User(String email, String password, String username, String phoneNumber, String userStatus) {
        super(email, password);
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.userStatus = userStatus;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserStatus() {
        return this.userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
    
}
