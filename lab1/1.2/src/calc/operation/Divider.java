package calc.operation;

public class Divider
{
    private float div;

    public Divider()
    {
        div = 0;
    }

    public void div(float a, float b)
    {
        div = a / b;
    }

    public float getDiv()
    {
        return div;
    }
}