package Models.dbclasses;

import Models.UserModel.User;

import java.sql.*;
import java.util.ArrayList;
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

    public static User InitValidUser(User user)
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

    public static User InitUser(User user)
    {
        DBWorker worker = new DBWorker();
        String query = "select * from users WHERE username=\"" + user.getUsername() + "\"";
        try
        {
            user.setUsername(null);
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
                user.setUsername(resultSet.getString("username"));
                user.setRealPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setRegDate(resultSet.getDate("regDate"));
            }
        } catch (SQLException Exception)
        {
            System.err.print(Exception);
        }
        return user;
    }

    public static ArrayList<User> InitUsers()
    {
        ArrayList<User> users = new ArrayList<User>();

        DBWorker worker = new DBWorker();
        String query = "select * from users";
        try
        {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
                User temp = new User();

                temp.setId(resultSet.getInt("id"));
                temp.setUsername(resultSet.getString("username"));
                temp.setRealPassword(resultSet.getString("password"));
                temp.setName(resultSet.getString("name"));
                temp.setEmail(resultSet.getString("email"));
                temp.setRegDate(resultSet.getDate("regDate"));
                temp.setPassword(resultSet.getString("password"));
                users.add(temp);
            }
        } catch (SQLException Exception)
        {
            System.err.print(Exception);
        }
        //Collections.reverse(users);
        return users;
    }
}
