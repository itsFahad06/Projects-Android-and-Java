package user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {

    private final Scanner input = new Scanner(System.in);
    private Db_Connection con;
    user_menu um;
     public String Login_user() {
        String username, password;

        System.out.println("Welcome to the user.Login Page");

        System.out.println("Enter Your Name");
        username = input.nextLine();
        System.out.println("Enter Your Password");
        password = input.nextLine();

        try {
            con = new Db_Connection();
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

            try (PreparedStatement preparedStatement = con.get_connections().prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                try (ResultSet rs = preparedStatement.executeQuery()) {
                    if (rs.next()) {
                        um = new user_menu();
                        um.user_menus();
                    } else {
                        System.out.println("Invalid username or password");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error during login");

        } finally {
            try {
                if (con != null) {
                    con.get_connections().close();
                }
            } catch (SQLException e) {
                System.out.println("Error During Connection");
            }
        }
        return username;
    }
}