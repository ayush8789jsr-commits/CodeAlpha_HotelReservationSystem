import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    String roomType;
    boolean booked;

    Room(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.booked = false;
    }
}

public class HotelReservationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Room> rooms = new ArrayList<>();

        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Deluxe"));
        rooms.add(new Room(103, "Suite"));

        while (true) {

            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\nRoom Details:");

                    for (Room room : rooms) {

                        String status = room.booked ? "Booked" : "Available";

                        System.out.println(
                                "Room No: " + room.roomNumber +
                                " | Type: " + room.roomType +
                                " | Status: " + status);
                    }

                    break;

                case 2:

                    System.out.print("Enter Room Number to Book: ");
                    int bookRoom = sc.nextInt();

                    boolean foundBook = false;

                    for (Room room : rooms) {

                        if (room.roomNumber == bookRoom) {

                            foundBook = true;

                            if (!room.booked) {

                                room.booked = true;
                                System.out.println("Room Booked Successfully!");

                            } else {

                                System.out.println("Room Already Booked!");
                            }
                        }
                    }

                    if (!foundBook) {
                        System.out.println("Room Not Found!");
                    }

                    break;

                case 3:

                    System.out.print("Enter Room Number to Cancel Booking: ");
                    int cancelRoom = sc.nextInt();

                    boolean foundCancel = false;

                    for (Room room : rooms) {

                        if (room.roomNumber == cancelRoom) {

                            foundCancel = true;

                            if (room.booked) {

                                room.booked = false;
                                System.out.println("Booking Cancelled Successfully!");

                            } else {

                                System.out.println("Room Is Not Booked!");
                            }
                        }
                    }

                    if (!foundCancel) {
                        System.out.println("Room Not Found!");
                    }

                    break;

                case 4:

                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}