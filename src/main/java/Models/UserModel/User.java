package Models.UserModel;

/**
 * Created by allard on 3/3/17.
 */
public class User extends Person
{
    private String password;
    private boolean correctness;

    public void setCorrectness (boolean correctness)
    {
        this.correctness = correctness;
    }

    public User(String username)
    {
        super(username);
    }

    public String getPassword()
    {
        return password;
    }

    public String getDescription()
    {
        return null;
    }

    public boolean getCorrectness()
    {
        return correctness;
    }

    public String toString()
    {
        //return getClass().getName() + "[name=" + getUsername() + "]";
        if (!(this.getName().equals(null)))
        {
            return this.getName() + "(" + getUsername() + ")";
        }
        return this.getUsername();
    }

    public static void main(String[] args)
    {
        User test = new User("abd");
    }
}
