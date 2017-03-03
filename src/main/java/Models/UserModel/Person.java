package Models.UserModel;


abstract class Person extends Object
{
    private String username;
    private String name;

    Person(String username)
    {
        /* dsfsfsdf */
        this.username = username;
    }

    public String getName()
    {
        /*asasaaa */
        return name;
    }

    public abstract String getDescription();

    @Override
    public abstract String toString();

    public String getUsername()
    {
        return username;
    }


}