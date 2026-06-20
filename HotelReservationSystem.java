import java.util.Scanner;

class Room {
    int roomNumber;
    String category;
    boolean booked;
    String customerName;

    Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.booked = false;
        this.customerName = "";
    }
}

public class HotelReservationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Room[] rooms = {
            new Room(101, "Standard"),
            new Room(102, "Deluxe"),
            new Room(103, "Suite")
        };

        while (true) {

            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Booking Details");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Rooms:");
                    for (Room room : rooms) {
                        System.out.println(
                            room.roomNumber + " | " +
                            room.category + " | " +
                            (room.booked ? "Booked" : "Available")
                        );
                    }
                    break;

                case 2:
                    System.out.print("Enter Room Number: ");
                    int roomNo = sc.nextInt();
                    sc.nextLine();

                    boolean found = false;

                    for (Room room : rooms) {
                        if (room.roomNumber == roomNo) {
                            found = true;

                            if (!room.booked) {
                                System.out.print("Enter Customer Name: ");
                                room.customerName = sc.nextLine();

                                room.booked = true;

                                System.out.println("Room Booked Successfully!");
                            } else {
                                System.out.println("Room Already Booked!");
                            }
                        }
                    }

                    if (!found) {
                        System.out.println("Room Not Found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Room Number: ");
                    int cancelRoom = sc.nextInt();

                    for (Room room : rooms) {
                        if (room.roomNumber == cancelRoom) {

                            if (room.booked) {
                                room.booked = false;
                                room.customerName = "";

                                System.out.println("Booking Cancelled Successfully!");
                            } else {
                                System.out.println("Room is not booked.");
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("\nBooking Details:");

                    for (Room room : rooms) {
                        if (room.booked) {
                            System.out.println(
                                "Room: " + room.roomNumber +
                                " | Category: " + room.category +
                                " | Customer: " + room.customerName
                            );
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thank You For Using Hotel Reservation System!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}