import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    String category;
    boolean booked;

    Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.booked = false;
    }
}

public class HotelReservationSystem {

    static ArrayList<Room> rooms = new ArrayList<>();

    public static void initializeRooms() {
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Standard"));
        rooms.add(new Room(201, "Deluxe"));
        rooms.add(new Room(202, "Deluxe"));
        rooms.add(new Room(301, "Suite"));
    }

    public static void displayRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (!room.booked) {
                System.out.println("Room " + room.roomNumber +
                        " - " + room.category);
            }
        }
    }

    public static void bookRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && !room.booked) {
                room.booked = true;

                System.out.println("Payment Successful!");
                System.out.println("Room " + roomNumber + " booked successfully.");
                return;
            }
        }
        System.out.println("Room not available.");
    }

    public static void cancelBooking(int roomNumber) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && room.booked) {
                room.booked = false;
                System.out.println("Booking cancelled successfully.");
                return;
            }
        }
        System.out.println("No booking found.");
    }

    public static void viewBookings() {
        System.out.println("\nBooked Rooms:");
        boolean found = false;

        for (Room room : rooms) {
            if (room.booked) {
                System.out.println("Room " + room.roomNumber +
                        " - " + room.category);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No rooms booked.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        initializeRooms();

        int choice;

        do {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayRooms();
                    break;

                case 2:
                    System.out.print("Enter Room Number: ");
                    int bookRoom = sc.nextInt();
                    bookRoom(bookRoom);
                    break;

                case 3:
                    System.out.print("Enter Room Number: ");
                    int cancelRoom = sc.nextInt();
                    cancelBooking(cancelRoom);
                    break;

                case 4:
                    viewBookings();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}