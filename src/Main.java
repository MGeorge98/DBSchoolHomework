import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Item> items = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            transactions.add(new Transaction(i+1, 12.0f * (i+1),  i%3==0 ? "regular":"market"));
            players.add(new Player(i+1, 183.0f * (i+1), "Bo$$9" + i));
            items.add(new Item(i+1, 12.0f * (i+1), "Sword+" + i));
        }

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Please type save, load or exit:");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            Thread transactionsThread = new Thread(new SaveLoad(input, transactions, "transactions.txt"));
            Thread playersThread = new Thread(new SaveLoad(input, players, "players.txt"));
            Thread itemsThread = new Thread(new SaveLoad(input, items, "items.txt"));

            transactionsThread.start();
            playersThread.start();
            itemsThread.start();

            try {
                transactionsThread.join();
                playersThread.join();
                itemsThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}
