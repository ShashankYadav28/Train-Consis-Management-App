

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Welcome Banner
        System.out.println("===================================");
        System.out.println("   Train Consist Management App   ");
        System.out.println("===================================\n");

        // Initialize empty train consist (dynamic list)
        List<String> trainConsist = new ArrayList<>();

        // Display initialization
        System.out.println("Train initialized successfully.");

        // Display bogie count
        System.out.println("Initial bogie count: " + trainConsist.size());

        // Display current state
        System.out.println("Current train consist: " + trainConsist);
    }
}