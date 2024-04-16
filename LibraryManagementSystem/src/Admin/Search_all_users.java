package Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Search_all_users {

    private final Scanner input = new Scanner(System.in);

    private Db_Connection con;

    void Search_all_user() {

        try {
            con = new Db_Connection();

            String Sql = "SELECT * FROM users";

            try (PreparedStatement preparedStatement = con.get_connections().prepareStatement(Sql)) {

                ResultSet rs = preparedStatement.executeQuery();
                System.out.println("Username | Email | Created At ");

                while (rs.next()) {
                    String username = rs.getString("username");
                    String email = rs.getString("email");
                    String creation_date = rs.getString("created_at");


                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("| "+username + " | " + email + " | " + creation_date + " |" );
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
