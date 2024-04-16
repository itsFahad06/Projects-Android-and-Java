package Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Search_all_books {
    private final Scanner input = new Scanner(System.in);

    private Db_Connection con;

    public void Search_all_Book() {

            try {
                con = new Db_Connection();

                String Sql = "SELECT * FROM books";

                try (PreparedStatement preparedStatement = con.get_connections().prepareStatement(Sql)) {

                    ResultSet rs = preparedStatement.executeQuery();
                    System.out.println("Title | Author | Description | Published Date | Publisher | Price");
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    int i = 0;
                    while (rs.next()) {
                        String title = rs.getString("title");
                        String author = rs.getString("author");
                        String description = rs.getString("description");
                        String published_date = rs.getString("published_date");
                        String publisher = rs.getString("publisher");
                        int price = rs.getInt("price");

                        i++;

                        System.out.println(i+" | "+title + " | " + author + " | " + description + " | " + published_date + " | " + publisher + " | " + price + " |");
                        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
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
        }

    }
