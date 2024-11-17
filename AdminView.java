import java.util.*;

public class AdminView { // something

    private DLSU_SRSAdmin_controller controller;
    private Scanner scanner;

    public AdminView(DLSU_SRSAdmin_controller controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add Shuttle Route");
            System.out.println("2. Edit Shuttle Route");
            System.out.println("3. Delete Shuttle Route");
            System.out.println("4. Modify User Booking");
            System.out.println("5. Cancel User Booking");
            System.out.println("6. Verify User Reservation");
            System.out.println("7. View Passenger Reservation Data");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addShuttleRoute();
                    break;
                case 2:
                    editShuttleRoute();
                    break;
                case 3:
                    deleteShuttleRoute();
                    break;
                case 4:
                    modifyUserBooking();
                    break;
                case 5:
                    cancelUserBooking();
                    break;
                case 6:
                    verifyUserReservation();
                    break;
                case 7:
                    viewPassengerReservationData();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addShuttleRoute() {
        System.out.print("Enter Arrows Express Line: ");
        String line = scanner.nextLine();
        System.out.print("Enter Line Number: ");
        int lineNum = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        controller.addShuttleRoute(line, lineNum);
        System.out.println("Shuttle route added successfully.");
    }

    private void editShuttleRoute() {
        System.out.print("Enter Arrows Express Line: ");
        String line = scanner.nextLine();
        System.out.print("Enter Line Number: ");
        int lineNum = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        controller.editShuttleRoute(line, lineNum);
        System.out.println("Shuttle route edited successfully.");
    }

    private void deleteShuttleRoute() {
        System.out.print("Enter Arrows Express Line: ");
        String line = scanner.nextLine();
        System.out.print("Enter Line Number: ");
        int lineNum = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        controller.deleteShuttleRoute(line, lineNum);
        System.out.println("Shuttle route deleted successfully.");
    }

    private void modifyUserBooking() {
        System.out.print("Enter User Shuttle Booking ID: ");
        int bookingID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Arrows Express Line: ");
        String line = scanner.nextLine();
        System.out.print("Enter Line Number: ");
        int lineNum = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter Time (HH:MM): ");
        String time = scanner.nextLine();
        controller.modifyUserBooking(bookingID, line, lineNum, date, time);
        System.out.println("User booking modified successfully.");
    }

    private void cancelUserBooking() {
        System.out.print("Enter User Shuttle Booking ID: ");
        int bookingID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        controller.cancelUserBooking(bookingID);
        System.out.println("User booking canceled successfully.");
    }

    private void verifyUserReservation() {
        System.out.print("Enter EAF: ");
        String eaf = scanner.nextLine();
        System.out.print("Enter Reason: ");
        String reason = scanner.nextLine();
        boolean result = controller.verifyUserReservation(eaf, reason);
        System.out.println("User reservation verification result: " + result);
    }

    private void viewPassengerReservationData() {
        List<String> data = controller.viewPassengerReservationData();
        System.out.println("Passenger Reservation Data:");
        for (String record : data) {
            System.out.println(record);
        }
    }
}
