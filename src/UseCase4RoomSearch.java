/**
 * =========================================================
 * MAIN CLASS - UseCase4RoomSearch
 * =========================================================
 * Demonstrates room search functionality.
 *
 * @version 4.0
 * =========================================================
 */
public class UseCase4RoomSearch {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        RoomSearchService searchService = new RoomSearchService();

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        searchService.searchAvailableRooms(
                inventory,
                single,
                doubleRoom,
                suite
        );
    }
}