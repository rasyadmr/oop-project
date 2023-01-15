package Model;

public class Destination {
    private Integer price;
    private String destinationId, destinationName;

    public Destination(String destinationId, String destinationName, Integer price) {
        this.destinationId = destinationId;
        this.price = price;
        this.destinationName = destinationName;
    }

    public String getDestinationId() {
        return this.destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDestinationName() {
        return this.destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

}
