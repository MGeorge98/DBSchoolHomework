import java.io.Serializable;

public class Transaction implements Serializable {
    int id;
    float amount;
    String transactionType;

    public Transaction(int id, float amount, String transactionType) {
        this.id = id;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "Transaction type: " + transactionType + ", id: " + id + ", cost:" + amount;
    }
}
