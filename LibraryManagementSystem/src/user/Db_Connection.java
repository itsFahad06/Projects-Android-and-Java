package user;

import java.sql.Connection;
import java.sql.DriverManager;

public class Db_Connection {

    Connection get_connections()
    {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("");
        }catch (Exception e)
        {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return c;
    }
}
