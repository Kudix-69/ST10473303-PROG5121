import java.util.Scanner;

public class Main {
    // Add a Login instance to use its methods
    private Login loginSystem = new Login();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main mainApp = new Main();

        System.out.println(" Registration ");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.println(mainApp.loginSystem.returnUsernameMessage(username));

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.println(mainApp.loginSystem.returnPasswordMessage(password));

        System.out.print("Enter cell phone number: ");
        String cellNumber = scanner.nextLine();
        System.out.println(mainApp.loginSystem.returnCellNumberMessage(cellNumber));

        if (mainApp.loginSystem.registerUser(username, password, cellNumber)) {
            System.out.println("Registration complete!");
        } else {
            System.out.println("Registration failed. Please try again.");
            scanner.close();
            return;
        }

        System.out.println("\n=== Login ===");
        System.out.print("Enter username: ");
        String loginUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine();

        System.out.println(mainApp.loginSystem.returnLoginStatus(loginUsername, loginPassword));

        scanner.close();
    }
}