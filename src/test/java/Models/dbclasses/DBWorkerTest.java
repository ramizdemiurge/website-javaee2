package Models.dbclasses;

import Models.UserModel.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class DBWorkerTest
{
    @Test
    public void getConnection() throws Exception
    {
        DBWorker dbWorker = new DBWorker();
        Assert.assertNotEquals(null,dbWorker.getConnection());
    }

    @Test
    public void initUser() throws Exception
    {
        User user = DBWorker.InitValidUser(new User("test","test"));
        Assert.assertTrue(user.getCorrectness());
    }

    @Test
    public void initUsers() throws Exception
    {
        ArrayList<User> users;
        users = DBWorker.InitUsers();
        Iterator<User> iter = users.iterator();

        if (iter.hasNext())
        {
            System.out.println(iter.next());
        }
        Assert.assertTrue(iter.hasNext());
    }

}