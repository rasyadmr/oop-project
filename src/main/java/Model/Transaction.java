package Model;

public class Transaction {
    private Integer quantity, totalPrice;
    private String transactionId, destinationId, emailUser;

    public Transaction(String transactionId, String destinationId, String emailUser, Integer quantity, Integer totalPrice) {
        this.transactionId = transactionId;
        this.destinationId = destinationId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.emailUser = emailUser;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getDestinationId() {
        return this.destinationId;
    }

    public void setDestinationId(String destinationId) {
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

}
