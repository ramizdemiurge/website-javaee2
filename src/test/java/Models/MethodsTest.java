package Models;

import org.junit.Assert;
import org.junit.Test;

public class MethodsTest
{
    @Test
    public void emptyStringDetector() throws Exception
    {
        String emptyString = "";
        Assert.assertTrue(Methods.EmptyStringDetector(emptyString));
    }

}