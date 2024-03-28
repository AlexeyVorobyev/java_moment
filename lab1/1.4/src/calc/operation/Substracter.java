package calc.operation;

public class Substracter
{
    private int minus;

    public Substracter()
    {
        minus = 0;
    }

    public Substracter(int a)
    {
        this.minus = a;
    }

    public void min(int b)
    {
        minus -= b;
    }

    public int getSubtracter()
    {
        return minus;
    }
}