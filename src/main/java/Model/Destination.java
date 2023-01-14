package Model;

public class Destination {
    private Integer destinationId, price;
    private String destinationName;

    public Destination(Integer destinationId, Integer price, String destinationName) {
        this.destinationId = destinationId;
        this.price = price;
        this.destinationName = destinationName;
    }

    public Integer getDestinationId() {
        return this.destinationId;
    }

    public void setDestinationId(Integer destinationId) {
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
