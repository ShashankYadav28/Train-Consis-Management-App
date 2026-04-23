import java.util.*;

/**
 * MAIN CLASS UseCase11ConcurrentBookingSimulation
 * Use Case 11: Concurrent Booking Simulation (Thread Safety)
 */

class RoomInventory {
    private Map<String, Integer> inventory = new HashMap<>();
    private Map<String, Integer> counters = new HashMap<>();

    public RoomInventory() {
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        counters.put("Single", 0);
        counters.put("Double", 0);
        counters.put("Suite", 0);
    }

    // synchronized → prevents race condition
    public synchronized String allocateRoom(String guest, String roomType) {

        if (inventory.get(roomType) > 0) {

            int count = counters.get(roomType) + 1;
            counters.put(roomType, count);

            inventory.put(roomType, inventory.get(roomType) - 1);

            String roomId = roomType + "-" + count;

            System.out.println("Booking confirmed for " + guest + " → " + roomId);
            return roomId;
        } else {
            System.out.println("No rooms available for " + guest);
        }

        return null;
    }

    public void displayInventory() {
        System.out.println("\nRemaining Inventory:");
        for (String type : inventory.keySet()) {
            System.out.println(type + ": " + inventory.get(type));
        }
    }
}

class BookingTask implements Runnable {
    private RoomInventory inventory;
    private String guest;
    private String roomType;

    public BookingTask(RoomInventory inventory, String guest, String roomType) {
        this.inventory = inventory;
        this.guest = guest;
        this.roomType = roomType;
    }

    public void run() {
        inventory.allocateRoom(guest, roomType);
    }
}

public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        System.out.println("Concurrent Booking Simulation\n");

        RoomInventory inventory = new RoomInventory();

        Thread t1 = new Thread(new BookingTask(inventory, "Abhi", "Single"));
        Thread t2 = new Thread(new BookingTask(inventory, "Subha", "Single"));
        Thread t3 = new Thread(new BookingTask(inventory, "Vanmathi", "Double"));
        Thread t4 = new Thread(new BookingTask(inventory, "Kural", "Suite"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        inventory.displayInventory();
    }
}