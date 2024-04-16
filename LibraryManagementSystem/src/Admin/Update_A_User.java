package Admin;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update_A_User {

    private final Scanner input = new Scanner(System.in);
    private Db_Connection con;


    public void updateUsername() {
        String oldUsername, newUsername;
        char choice;

        System.out.println("Enter Username To Update");
        oldUsername = input.nextLine();

        System.out.println("Are you sure you want to update the username?");
        System.out.println("Y for Yes and N for No");

        choice = input.nextLine().charAt(0);

        if (choice == 'Y' || choice == 'y') {
            try {
                con = new Db_Connection();
                String sql = "UPDATE users SET username = ? WHERE username = ?";

                try (PreparedStatement preparedStatement = con.get_connections().prepareStatement(sql)) {
                    System.out.println("Enter New Username");
                    newUsername = input.nextLine();

                    preparedStatement.setString(1, newUsername);
                    preparedStatement.setString(2, oldUsername);

                    int updatedRows = preparedStatement.executeUpdate();

                    if (updatedRows > 0) {
                        System.out.println("Username Updated Successfully");
                    } else {
                        System.out.println("Failed to update username. Username not found.");
                    }
                }
            } catch (Exception e) {
                System.err.println("Error during update: " + e.getMessage());
            } finally {
                try {
                    input.close();
                    if (con != null) {
                        con.get_connections().close();
                    }
                } catch (Exception e) {
                    System.err.println("Error closing resources: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Not updating anything.");
        }
    }

}
