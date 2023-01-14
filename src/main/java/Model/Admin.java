package Model;

public class Admin extends Account {
    private String adminName;

    public Admin(String email, String password, String adminName) {
        super(email, password);
        this.adminName = adminName;
    }

    public String getAdminName() {
        return this.adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

}
