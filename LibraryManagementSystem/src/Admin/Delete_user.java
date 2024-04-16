package Admin;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class Delete_user {
    private final Scanner input = new Scanner(System.in);
    private Db_Connection con;



    public void Delete_a_user() {
        char choice;
        String name;

        System.out.println("Enter Username");
        name = input.nextLine();

        System.out.println("Are you sure you want to delete the user?");
        System.out.println("Y for Yes and N for No");

        choice = input.nextLine().charAt(0);

        if (choice == 'Y' || choice == 'y') {
            try {
                con = new Db_Connection();
                String Sql = "DELETE FROM users WHERE username = ?";

                try (PreparedStatement preparedStatement = con.get_connections().prepareStatement(Sql)) {
                    preparedStatement.setString(1, name);

                    int deletedRows = preparedStatement.executeUpdate();

                    if (deletedRows > 0) {
                        System.out.println("Row Deleted with Username: " + name);
                    } else {
                        System.out.println("No rows found with Username: " + name);
                    }
                }
            } catch (Exception e) {
                System.err.println("Error During Deletion: " + e.getMessage());
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
        }
        else {
            System.out.println("Not Deleting Anything ");
            System.exit(0);
        }
    }
}
