/**
 * =========================================================
 * MAIN CLASS - UseCase2RoomInitialization
 * =========================================================
 * Demonstrates basic room initialization and availability.
 *
 * @version 2.0
 * =========================================================
 */
public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        System.out.println("Hotel Room Initialization\n");

        // Single Room
        System.out.println("Single Room:");
        Room single = new SingleRoom();
        single.displayRoomDetails();
        System.out.println("Available: 5\n");

        // Double Room
        System.out.println("Double Room:");
        Room doubleRoom = new DoubleRoom();
        doubleRoom.displayRoomDetails();
        System.out.println("Available: 3\n");

        // Suite Room
        System.out.println("Suite Room:");
        Room suite = new SuiteRoom();
        suite.displayRoomDetails();
        System.out.println("Available: 2");
    }
}