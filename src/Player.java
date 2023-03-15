import java.io.Serializable;

public class Player implements Serializable{
    int id;
    float money;
    String username;

    public Player(int id, float money, String username) {
        this.id = id;
        this.money = money;
        this.username = username;
    }

    @Override
    public String toString() {
        return "Player " + username + " logged in, id: " + id + ", amount of money: " + money;
    }
}
