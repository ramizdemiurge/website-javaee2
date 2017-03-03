package Models.UserModel;

/**
 * Created by allard on 3/3/17.
 */
public class User extends Person
{
    private String login;
    private String password;

    public User(String username)
    {
        super(username);
    }


    public String getLogin()
    {
        return login;
    }

    public String getPassword()
    {
        return password;
    }


    public String getDescription()
    {
        return null;
    }

    public String toString()
    {
        //return getClass().getName() + "[name=" + getUsername() + "]";
        if (!(this.getName().equals(null)))
        {
            return this.getName() + "(" + getLogin() + ")";
        }
        return this.getLogin();
    }

    public static void main(String[] args)
    {
        User test = new User("abd");
    }
}
