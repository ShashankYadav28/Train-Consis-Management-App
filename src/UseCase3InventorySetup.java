/**
 * =========================================================
 * MAIN CLASS - UseCase3InventorySetup
 * =========================================================
 * Demonstrates centralized inventory usage.
 *
 * @version 3.0
 * =========================================================
 */
public class UseCase3InventorySetup {

    public static void main(String[] args) {

        System.out.println("Hotel Room Inventory Status\n");

        RoomInventory inventory = new RoomInventory();

        // Single Room
        System.out.println("Single Room:");
        Room single = new SingleRoom();
        single.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Single") + "\n");

        // Double Room
        System.out.println("Double Room:");
        Room doubleRoom = new DoubleRoom();
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Double") + "\n");

        // Suite Room
        System.out.println("Suite Room:");
        Room suite = new SuiteRoom();
        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Suite"));
    }
}