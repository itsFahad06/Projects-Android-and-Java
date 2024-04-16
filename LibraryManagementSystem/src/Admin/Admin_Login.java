package Admin;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Admin_Login {

    private final Scanner input = new Scanner(System.in);

    private Db_Connection con;
    Admin_Menu am;
    public void Admin_login()
    {
        String Admin_name, password;

        System.out.println("Welcome to the Admin user.Login Page");

        System.out.println("Enter Your Name");
        Admin_name = input.nextLine();
        System.out.println("Enter Your Password");
        password = input.nextLine();

        try{
            con = new Db_Connection();

            String Sql = "SELECT * FROM admin WHERE admin_name = ? AND password = ?";

            try(PreparedStatement preparedStatement = con.get_connections().prepareStatement(Sql)) {
                preparedStatement.setString(1,Admin_name);
                preparedStatement.setString(2,password);

                try(ResultSet rs = preparedStatement.executeQuery())
                {
                    if(rs.next())
                    {
                        am = new Admin_Menu();
                        am.menu();
                    }
                    else {
                        System.out.println("Invalid username or password");
                    }
                }
            }
        }catch (Exception e)
        {
            System.out.println("Can't Login Due to an error enter again");
        }
        finally {
            try{
                if(con != null)
                {
                    con.get_connections().close();
                }
            }catch (Exception e)
            {
                System.out.println("Error in connection");
            }
        }
    }
}
