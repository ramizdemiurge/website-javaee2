package Models.UserModel;

import java.util.Date;

/**
 * Created by allard on 3/3/17.
 */
public class User extends Person
{
    private int id;
    private String password;
    private String realPassword;
    private String email;
    private Date regDate;
    private boolean correctness;
    private String profile_photo;

    public User()
    {
        super(null);
    }

    public void setCorrectness (boolean correctness)
    {
        this.correctness = correctness;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public User(String username)
    {
        super(username);
    }

    public User(String username, String password)
    {
        super(username);
        this.password = password;
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
        if (this.getName() != null)
        {
            return this.getName() + "(" + getUsername() + ")";
        }
        return this.getUsername();
    }

    public static void main(String[] args)
    {
        User test = new User("abd");
    }

    public String getRealPassword()
    {
        return realPassword;
    }

    @Override
    public String getUsername()
    {
        return super.getUsername();
    }

    public void setRealPassword(String realPassword)
    {
        this.realPassword = realPassword;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Date getRegDate()
    {
        return regDate;
    }

    public void setRegDate(Date regDate)
    {
        this.regDate = regDate;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getProfile_photo()
    {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo)
    {
        this.profile_photo = profile_photo;
    }
}
