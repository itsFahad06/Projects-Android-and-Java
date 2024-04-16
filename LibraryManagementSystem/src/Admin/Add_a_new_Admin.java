package Admin;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class Add_a_new_Admin {

    private final Scanner input = new Scanner(System.in);

    private Db_Connection con;

    void adding_a_admin ()
    {
        String name, password;

        System.out.println("Enter admin name ");
        name = input.nextLine();
        System.out.println("Enter admin password ");
        password = input.nextLine();

        try{
            con = new Db_Connection();

            String Sql = "INSERT INTO admin (admin_name,password) VALUES (?,?)";

            try (PreparedStatement preparedStatement = con.get_connections().prepareStatement(Sql))
            {
                preparedStatement.setString(1,name);
                preparedStatement.setString(2,password);

                int result_insert_row = preparedStatement.executeUpdate();

                if (result_insert_row > 0)
                {
                    System.out.println("New Admin Added Successfully ");
                }
                else{
                    System.out.println("Can't Add the admin");
                }
            }

        }catch (Exception e)
        {
            System.out.println("Error With Inserting Data");
        } finally {
            try {
                if (con != null)
                {
                    con.get_connections().close();
                }
            }catch (Exception e)
            {
                System.out.println("Error during connection");
            }
        }
    }

}
