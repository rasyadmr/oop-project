package Model;

public class Transaction {
    private Integer transactionId, destinationId, quantity, totalPrice;
    private String emailUser, emailAdmin;

    public Transaction(Integer transactionId, Integer destinationId, Integer quantity, Integer totalPrice, String emailUser, String emailAdmin) {
        this.transactionId = transactionId;
        this.destinationId = destinationId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.emailUser = emailUser;
        this.emailAdmin = emailAdmin;
    }

    public Integer getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getDestinationId() {
        return this.destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getEmailUser() {
        return this.emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getEmailAdmin() {
        return this.emailAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }

}
