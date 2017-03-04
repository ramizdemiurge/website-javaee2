package Models;

/**
 * Created by allard on 3/4/17.
 */
public class Methods
{
    public static boolean EmptyStringDetector(String... strings)
    {
        /**
         * Is string empty?
         * yes: true
         */
        for (String string : strings)
        {
            if (string.equals(null) || string.equals(""))
            {
                String dd;
             return true;
            }
        }
        return false;
    }
}
