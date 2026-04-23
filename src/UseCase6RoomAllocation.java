import java.util.*;

/**
 * =========================================================
 * Use Case 6: Reservation Confirmation & Room Allocation
 * =========================================================
 */

public class UseCase6RoomAllocation {

    // ===================== Reservation =====================
    static class Reservation {
        private String guestName;
        private String roomType;

        public Reservation(String guestName, String roomType) {
            this.guestName = guestName;
            this.roomType = roomType;
        }

        public String getGuestName() {
            return guestName;
        }

        public String getRoomType() {
            return roomType;
        }
    }

    // ===================== Inventory =====================
    static class RoomInventory {
        private Map<String, Integer> availability = new HashMap<>();

        public RoomInventory() {
            availability.put("Single", 2);
            availability.put("Double", 1);
            availability.put("Suite", 1);
        }

        public int getAvailable(String type) {
            return availability.getOrDefault(type, 0);
        }

        public void reduceRoom(String type) {
            availability.put(type, availability.get(type) - 1);
        }
    }

    // ===================== Queue =====================
    static class BookingQueue {
        private Queue<Reservation> queue = new LinkedList<>();

        public void add(Reservation r) {
            queue.offer(r);
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }

        public Reservation next() {
            return queue.poll();
        }
    }

    // ===================== Allocation Service =====================
    static class RoomAllocationService {

        private Map<String, Integer> roomCounters = new HashMap<>();

        public RoomAllocationService() {
            roomCounters.put("Single", 0);
            roomCounters.put("Double", 0);
            roomCounters.put("Suite", 0);
        }

        public void allocate(Reservation r, RoomInventory inventory) {

            String type = r.getRoomType();

            if (inventory.getAvailable(type) > 0) {

                inventory.reduceRoom(type);

                int count = roomCounters.get(type) + 1;
                roomCounters.put(type, count);

                String roomId = type + "-" + count;

                System.out.println("Booking confirmed for Guest: "
                        + r.getGuestName()
                        + ", Room ID: " + roomId);

            } else {
                System.out.println("No rooms available for " + r.getGuestName()
                        + " (" + type + ")");
            }
        }
    }

    // ===================== MAIN =====================
    public static void main(String[] args) {

        System.out.println("Room Allocation Processing\n");

        RoomInventory inventory = new RoomInventory();
        BookingQueue queue = new BookingQueue();
        RoomAllocationService service = new RoomAllocationService();

        // Add requests
        queue.add(new Reservation("Abhi", "Single"));
        queue.add(new Reservation("Subha", "Single"));
        queue.add(new Reservation("Vannathi", "Suite"));

        // Process FIFO
        while (queue.hasNext()) {
            service.allocate(queue.next(), inventory);
        }
    }
}