package Models;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by allard on 3/4/17.
 */
public class MethodsTest
{
    @Test
    public void emptyStringDetector() throws Exception
    {
        String emptyString = "";
        Assert.assertTrue(Methods.EmptyStringDetector(emptyString));
    }

}