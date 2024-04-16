package Admin;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class Add_a_new_Book {

    private final Scanner input = new Scanner(System.in);

    private Db_Connection con;

    void add_a_book ()
    {
        String b_title, b_author, b_description, a_published_date, a_publisher;
        int price;

        System.out.println("Enter Book Title");
        b_title = input.nextLine();
        System.out.println("Enter Book Author");
        b_author = input.nextLine();
        System.out.println("Enter Book Description");
        b_description = input.nextLine();
        System.out.println("Enter Book Published Date");
        a_published_date = input.nextLine();
        System.out.println("Enter Book Publisher");
        a_publisher = input.nextLine();
        System.out.println("Enter Book Price");
        price = input.nextInt();

        try{

            con = new Db_Connection();

            String Sql = "INSERT INTO books (title, author, description, published_date, publisher , price) VALUES (?,?,?,?,?,?)";

            try(PreparedStatement preparedStatement = con.get_connections().prepareStatement(Sql))
            {
                preparedStatement.setString(1,b_title);
                preparedStatement.setString(2,b_author);
                preparedStatement.setString(3,b_description);
                preparedStatement.setString(4,a_published_date);
                preparedStatement.setString(5,a_publisher);
                preparedStatement.setInt(6,price);

                int inserted_row = preparedStatement.executeUpdate();

                if (inserted_row > 0)
                {
                    System.out.println("Inserted A book Record Successfully");
                }
                else {
                    System.out.println("Can't Inserted Successfully");
                }

            }
        }catch (Exception e)
        {
            System.out.println("Error During Query");
        }finally {
            try {
                input.close();
                if (con != null) {
                    con.get_connections().close();
                    input.close();
                }
            } catch (Exception e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }


    }
}
