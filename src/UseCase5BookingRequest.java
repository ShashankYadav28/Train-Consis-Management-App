import java.util.LinkedList;
import java.util.Queue;

/**
 * =========================================================
 * Use Case 5: Booking Request (FIFO)
 * =========================================================
 * Demonstrates queue-based booking request handling.
 * =========================================================
 */

public class UseCase5BookingRequest {

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

    // ===================== Queue =====================
    static class BookingRequestQueue {
        private Queue<Reservation> requestQueue;

        public BookingRequestQueue() {
            requestQueue = new LinkedList<>();
        }

        public void addRequest(Reservation reservation) {
            requestQueue.offer(reservation);
        }

        public Reservation getNextRequest() {
            return requestQueue.poll();
        }

        public boolean hasPendingRequests() {
            return !requestQueue.isEmpty();
        }
    }

    // ===================== MAIN =====================
    public static void main(String[] args) {

        BookingRequestQueue queue = new BookingRequestQueue();

        // Adding booking requests
        queue.addRequest(new Reservation("Shashank", "Single"));
        queue.addRequest(new Reservation("Rahul", "Double"));
        queue.addRequest(new Reservation("Amit", "Suite"));

        System.out.println("Processing Booking Requests (FIFO):\n");

        // Processing requests
        while (queue.hasPendingRequests()) {
            Reservation r = queue.getNextRequest();
            System.out.println("Guest: " + r.getGuestName());
            System.out.println("Requested Room: " + r.getRoomType());
            System.out.println("-------------------------");
        }
    }
}