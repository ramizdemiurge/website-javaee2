package Model;
public class Calc
{
    private int result;

    public void add(int...params)
    {
        for (int param: params)
        {
            this.result += param;
        }
    }

    public int getResult()
    {
        return result;
    }
}
