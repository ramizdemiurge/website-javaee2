package Models.dbclasses;

import Models.UserModel.User;
import org.junit.Assert;
import org.junit.Test;

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
        User user = DBWorker.InitUser(new User("test","test"));
        Assert.assertTrue(user.getCorrectness());
    }
}