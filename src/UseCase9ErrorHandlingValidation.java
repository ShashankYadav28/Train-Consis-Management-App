import java.util.*;

class InvalidBookingException extends Exception {
    public InvalidBookingException(String msg) {
        super(msg);
    }
}

public class UseCase9ErrorHandlingValidation {

    static void validate(String roomType) throws InvalidBookingException {
        if (!roomType.equals("Single") &&
            !roomType.equals("Double") &&
            !roomType.equals("Suite")) {
            throw new InvalidBookingException("Invalid room type!");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Room Type: ");
            String type = sc.nextLine();

            validate(type);

            System.out.println("Booking successful for " + type);

        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}