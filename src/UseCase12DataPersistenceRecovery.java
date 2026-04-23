import java.io.*;
import java.util.*;

public class UseCase12DataPersistenceRecovery {

    static final String FILE = "data.dat";

    static void save(Map<String, Integer> data) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE));
            out.writeObject(data);
            out.close();
            System.out.println("Saved");
        } catch (Exception e) {
            System.out.println("Error saving");
        }
    }

    static Map<String, Integer> load() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE));
            Map<String, Integer> map = (Map<String, Integer>) in.readObject();
            in.close();
            System.out.println("Loaded");
            return map;
        } catch (Exception e) {
            System.out.println("No file, creating new");
            return null;
        }
    }

    public static void main(String[] args) {

        Map<String, Integer> inv = load();

        if (inv == null) {
            inv = new HashMap<>();
            inv.put("Single", 5);
            inv.put("Double", 3);
            inv.put("Suite", 2);
        }

        System.out.println("Inventory:");
        for (String k : inv.keySet()) {
            System.out.println(k + ": " + inv.get(k));
        }

        save(inv);
    }
}