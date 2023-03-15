import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveLoad implements Runnable{
    private final String action;
    private final ArrayList<?> objects;
    private final String filePath;

    public SaveLoad(String action, ArrayList<?> objects, String filePath) {
        this.action = action;
        this.objects = objects;
        this.filePath = filePath;
    }

    @Override
    public void run() {
        if (action.equals("save")) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
                oos.writeObject(objects);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (action.equals("load")) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
                ArrayList<?> loadedObjects = (ArrayList<?>) ois.readObject();
                for (Object obj : loadedObjects) {
                    System.out.println(obj);
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("You will need to save the files frist!");
            }
        }

    }
}
