package Admin;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update_a_Book {

    private final Scanner input = new Scanner(System.in);

    private Db_Connection con;

    void updating_book ()
    {
        String b_name;
        String nb_name,nb_author,nb_description,nb_publisher,nb_published_date;
        int nb_price;
        char choice;

        System.out.println("Enter Book Name to Search it");
        b_name = input.nextLine();

        System.out.println("Are you sure you want to update the username?");
        System.out.println("Y for Yes and N for No");
        choice = input.nextLine().charAt(0);

        if (choice == 'Y' || choice == 'y') {
            try {
                con = new Db_Connection();
                String sql = "UPDATE books SET title = ?, author = ?, description = ?, published_date = ?, publisher = ?, price = ? WHERE title = ?";

                try (PreparedStatement preparedStatement = con.get_connections().prepareStatement(sql)) {
                    System.out.println("Enter a new Book Title");
                    nb_name = input.nextLine();
                    System.out.println("Enter a new Book Author");
                    nb_author = input.nextLine();
                    System.out.println("Enter a new Book Description");
                    nb_description = input.nextLine();
                    System.out.println("Enter a new Book Published Date");
                    nb_published_date = input.nextLine();
                    System.out.println("Enter a new Book Publisher");
                    nb_publisher = input.nextLine();
                    System.out.println("Enter a new Book Price");
                    nb_price = input.nextInt();

                    preparedStatement.setString(1, nb_name);
                    preparedStatement.setString(2, nb_author);
                    preparedStatement.setString(3,nb_description);
                    preparedStatement.setString(4,nb_published_date);
                    preparedStatement.setString(5,nb_publisher);
                    preparedStatement.setInt(6,nb_price);
                    preparedStatement.setString(7,b_name);

                    int updatedRows = preparedStatement.executeUpdate();

                    if (updatedRows > 0) {
                        System.out.println("Book Data Updated Successfully");
                    } else {
                        System.out.println("Failed to update Data. Data not found.");
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
