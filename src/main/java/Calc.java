class Calc
{
    private int result;

    void add(int...params)
    {
        for (int param: params)
        {
            this.result += param;
        }
    }

    int getResult()
    {
        return result;
    }
}
