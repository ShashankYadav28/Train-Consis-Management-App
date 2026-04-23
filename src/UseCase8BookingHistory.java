import java.util.*;

class Reservation {
    String guestName;
    String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

public class UseCase8BookingHistory {

    public static void main(String[] args) {

        List<Reservation> history = new ArrayList<>();

        history.add(new Reservation("Abhi", "Single"));
        history.add(new Reservation("Subha", "Double"));
        history.add(new Reservation("Vanmathi", "Suite"));

        System.out.println("Booking History Report");

        for (Reservation r : history) {
            System.out.println("Guest: " + r.guestName + ", Room: " + r.roomType);
        }
    }
}