package Models.dbclasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//   /opt/lampp/mysql/scripts/ctl.sh start

public class DBWorker
{
    private final String HOST = "jdbc:mysql://localhost:3306/javaee_maven";
    private final String USERNAME = "root";
    private final String PASSWORD = "";

    private Connection connection;

    public DBWorker()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(HOST,USERNAME,PASSWORD);

        } catch (SQLException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection()
    {
        return connection;
    }


}
