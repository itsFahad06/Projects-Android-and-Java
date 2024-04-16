package user;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Sign_Up {

    private final Scanner input = new Scanner(System.in);
    private Db_Connection db;
    public void Register_user() {
        String username, password, email;

        System.out.println("Welcome to the Sign Up Page");

        System.out.println("Enter Your Name");
        username = input.nextLine();
        System.out.println("Enter Your Email");
        email = input.nextLine();

        if (!patternMatches(email)) {
            System.out.println("Email is invalid");
            return;
        }

        System.out.println("Enter Your Password");
        password = input.nextLine();

        db = new Db_Connection();

        try {
            String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = db.get_connections().prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, password);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Registration successful");
                } else {
                    System.out.println("Registration failed");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during registration");
        } finally {
            try {
                if (db != null) {
                    db.get_connections().close();
                }
            } catch (SQLException e) {
                System.out.println("Connection Problem");
            }
        }
    }

    private static boolean patternMatches(String emailAddress) {
        return Pattern.compile("^(.+)@(.+)$").matcher(emailAddress).matches();
    }
}
