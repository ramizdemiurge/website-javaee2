package Models.dbclasses;

import Models.UserModel.User;

import java.sql.*;
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

    public static User InitUser(User user)
    {
            DBWorker worker = new DBWorker();
            String query = "select * from users WHERE username=\"" + user.getUsername() + "\"";
            try
            {
                Statement statement = worker.getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next())
                {
                    user.setRealPassword(resultSet.getString("password"));
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                    user.setRegDate(resultSet.getDate("regDate"));
                }
                if (user.getPassword().equals(user.getRealPassword())) user.setCorrectness(true);
            } catch (SQLException Exception)
            {
                System.err.print(Exception);
            }
        return user;
    }
}
