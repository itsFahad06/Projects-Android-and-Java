package Admin;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class Delete_a_Book {

    private final Scanner input = new Scanner(System.in);

    private Db_Connection con;

    void Delete_Book ()
    {
        String Searching_by_name;
        char choice;

        System.out.println("Enter Book Name to Delete? ");
        Searching_by_name = input.nextLine();

        System.out.println("Are you sure you want to update the username?");
        System.out.println("Y for Yes and N for No");
        choice = input.nextLine().charAt(0);

        if (choice == 'Y' || choice == 'y') {

            try{
                con = new Db_Connection();

                String Sql = "DELETE FROM books WHERE title = ?";

                try (PreparedStatement preparedStatement = con.get_connections().prepareStatement(Sql))
                {
                    preparedStatement.setString(1,Searching_by_name);

                    int del_row = preparedStatement.executeUpdate();

                    if (del_row > 0)
                    {
                        System.out.println("Deleted Successfully By the title Named: "+Searching_by_name);
                    }
                    else {
                        System.out.println("Can't be Deleted Successfully or Name did not match");
                    }
                }

            }catch (Exception e)
            {
                System.out.println("Problem With database");
            } finally {
                try{
                    if (con !=null)
                    {
                        con.get_connections().close();
                    }
                }catch(Exception e)
                {
                    System.out.println("Problem With the Connection ");
                }
            }
        } else {
            System.out.println("Not Updating Anything");
        }
    }
}
