import Models.Calc;
import org.junit.Assert;
import org.junit.Test;


public class CalcTest
{
    @Test
    public void testAdd()
    {
        Calc calculator = new Calc();
        calculator.add(1,2,3);
        Assert.assertEquals(6,calculator.getResult());
    }

}