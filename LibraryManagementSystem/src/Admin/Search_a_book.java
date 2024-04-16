package Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Search_a_book {

    private final Scanner input = new Scanner(System.in);

    private Db_Connection con;

    void Search_Book() {
        String b_name;
        char choice;

        System.out.println("Enter Book Name to Search it");
        b_name = input.nextLine();

        System.out.println("Are you sure you want to search the Book");
        System.out.println("Y for Yes and N for No");
        choice = input.nextLine().charAt(0);

        if (choice == 'Y' || choice == 'y') {

            try {
                con = new Db_Connection();

                String Sql = "SELECT * FROM books WHERE title = ?";

                try (PreparedStatement preparedStatement = con.get_connections().prepareStatement(Sql)) {
                    preparedStatement.setString(1, b_name);

                    ResultSet rs = preparedStatement.executeQuery();

                    if (rs.next()) {
                       String title = rs.getString("title");
                       String author = rs.getString("author");
                       String description = rs.getString("description");
                       String published_date = rs.getString("published_date");
                       String publisher = rs.getString("publisher");
                       int price = rs.getInt("price");

                        System.out.println("Title | Author | Description | Published Date | Publisher | Price");
                        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("| "+title + " | " + author + " | " + description + " | " + published_date + " | " + publisher + " | " + price + " |");
                        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    } else {
                        System.out.println("Can't Find Any Book By name " + b_name);
                    }
                }
            } catch (Exception e) {
                System.out.println("Searching Got some problem ");
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
            System.out.println("Not Searching anything.");
        }

    }
}
