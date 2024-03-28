package calc.operation;

public class Multiplexer
{
    private int mult;

    public Multiplexer()
    {
        mult = 1;
    }

    public Multiplexer(int a)
    {
        this.mult = a;
    }

    public void mult(int b)
    {
        mult *= b;
    }

    public int getMult()
    {
        return mult;
    }
}