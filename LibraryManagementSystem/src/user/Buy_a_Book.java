package user;

import Admin.Search_all_books;
import java.sql.*;
import java.util.Scanner;

public class Buy_a_Book {

    private final Scanner input = new Scanner(System.in);

    private Db_Connection con;

     Login lg = new Login();
     Search_all_books sal;
     String get_id;
     void user_setter()
     {
         String set_id = lg.Login_user();
         user_session.setUserId(set_id);
         get_id = user_session.getUserId();
     }


    void buying_the_book ()
    {
        String b_name;

        System.out.println("Available Books");
        sal = new Search_all_books();
        sal.Search_all_Book();

        System.out.println("Enter The Name of the Book You Want to Buy");
        b_name = input.nextLine();

        try {

            con = new Db_Connection();
            String Sql = "SELECT * FROM books WHERE title = ?";

            try(PreparedStatement preparedStatement = con.get_connections().prepareStatement(Sql))
            {
                preparedStatement.setString(1,b_name);

                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next())
                {
                    System.out.println("Book is Founded With the result Name "+b_name);
                    System.out.println("\n"+"How much do you want to buy? ");

                    int quantity = input.nextInt();
                    ResultSet res = preparedStatement.executeQuery();
                    String title = res.getString("title");
                    String author = res.getString("author");
                    String description = res.getString("description");
                    String published_date = res.getString("published_date");
                    String publisher = res.getString("publisher");
                    int price = res.getInt("price");

                    String buy_query = "INSERT INTO cart (title,author,description,published_date,publisher,price,quantity,user_id) VALUES (?,?,?,?,?,?,?,?)";

                    try (PreparedStatement ps = con.get_connections().prepareStatement(buy_query)) {

                            ps.setString(1,title);
                            ps.setString(2,author);
                            ps.setString(3,description);
                            ps.setString(4,published_date);
                            ps.setString(5,publisher);
                            ps.setInt(6,price);
                            ps.setInt(7,quantity);
                            ps.setString(8,get_id);

                            int result = ps.executeUpdate();

                            if (result > 0)
                            {
                                System.out.println("Book is Added to the Cart");
                            }
                            else {
                                System.out.println("Book is not Added to the Cart");
                            }
                    }
                }
            }
        }catch (Exception e)
        {
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
