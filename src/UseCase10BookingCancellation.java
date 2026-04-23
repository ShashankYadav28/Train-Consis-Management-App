import java.util.*;

public class UseCase10BookingCancellation {

    static class RoomInventory {
        Map<String, Integer> inventory = new HashMap<>();

        public RoomInventory() {
            inventory.put("Single", 5);
            inventory.put("Double", 2);
            inventory.put("Suite", 1);
        }

        public void increase(String type) {
            inventory.put(type, inventory.get(type) + 1);
        }
    }

    static class CancellationService {
        Stack<String> stack = new Stack<>();

        public void cancel(String id, String type, RoomInventory inv) {
            stack.push(id);
            inv.increase(type);
            System.out.println("Cancelled: " + id);
        }

        public void show() {
            System.out.println("Rollback History:");
            while (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
        }
    }

    public static void main(String[] args) {

        RoomInventory inv = new RoomInventory();
        CancellationService cs = new CancellationService();

        cs.cancel("Single-1", "Single", inv);
        cs.show();
    }
}