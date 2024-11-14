import java.util.*;

public class UserView {
    private DLSU_SRSUser_controller controller;
    private Scanner scanner;

    public UserView(DLSU_SRSUser_controller controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        boolean running = true;
        while (running) {
            System.out.println("1. Register User");
            System.out.println("2. Manage Profile");
            System.out.println("3. View Reservation");
            System.out.println("4. Edit Reservation");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    manageProfile();
                    break;
                case 3:
                    viewReservation();
                    break;
                case 4:
                    editReservation();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void registerUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter designation: ");
    }
}
