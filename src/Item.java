import java.io.Serializable;

public class Item implements Serializable{
    int id;
    float price;
    String name;

    public Item(int id, float price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item listed on market: " + name + ", id: " + id + ", price: " + price;
    }
}
