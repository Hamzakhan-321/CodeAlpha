import java.util.ArrayList;
import java.util.Scanner;

public class HotelChat {

    private static ArrayList<Room> rooms; 
    private static Scanner scanner = new Scanner(System.in); 

    public static void main(String[] args) {
        System.out.println("Welcome to the Hotel Chat.");
        rooms = initializeRooms(); 

        boolean keepGoing = true;
        while (keepGoing) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    findAvailableRooms();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    viewBookingDetails();
                    break;
                case 4:
                    keepGoing = false;
                    System.out.println("Thanks for chatting! See you next time.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close(); 
    }

    private static ArrayList<Room> initializeRooms() {
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(101, "Standard", 100.0));
        rooms.add(new Room(102, "Deluxe", 150.0));
        rooms.add(new Room(201, "Suite", 200.0));
        return rooms;
    }

    private static void displayMenu() {
        System.out.println("\nWhat can I help you with today?");
        System.out.println("1. Find available rooms");
        System.out.println("2. Make a reservation");
        System.out.println("3. View booking details");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void findAvailableRooms() {
        System.out.println("Available rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }
    }

    private static void makeReservation() {
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter your name: ");
        String guestName = scanner.nextLine();

        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                room.setAvailable(false);
                System.out.println("Reservation made successfully!");
                return;
            }
        }
        System.out.println("Failed to make reservation. Room might be unavailable.");
    }

    private static void viewBookingDetails() {
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                System.out.println("Room Number: " + room.getRoomNumber());
                System.out.println("Room Type: " + room.getRoomType());
                System.out.println("Price per Night: $" + room.getPricePerNight());
                return;
            }
        }
        System.out.println("Reservation not found.");
    }

    static class Room {
        private int roomNumber;
        private String roomType;
        private double pricePerNight;
        private boolean available;

        public Room(int roomNumber, String roomType, double pricePerNight) {
            this.roomNumber = roomNumber;
            this.roomType = roomType;
            this.pricePerNight = pricePerNight;
            this.available = true;
        }

        public int getRoomNumber() {
            return roomNumber;
        }

        public String getRoomType() {
            return roomType;
        }

        public double getPricePerNight() {
            return pricePerNight;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

        @Override
        public String toString() {
            return "Room Number: " + roomNumber + ", Room Type: " + roomType + ", Price per Night: $" + pricePerNight;
        }
    }
}
