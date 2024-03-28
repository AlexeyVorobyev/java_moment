package calc;

import calc.operation.*;

public class Calculator
{
    public int sum(int... a)
    {
        Adder adder = new Adder();

        for(int i:a)
        {
            adder.add(i);
        }

        return adder.getSum();
    }

    public int subtract(int... a)
    {
        Substracter subtract = new Substracter();

        for(int i:a)
        {
            subtract.min(i);
        }

        return subtract.getSubtracter();
    }

    public int mult(int... a)
    {
        Multiplexer multer = new Multiplexer();

        for(int i:a)
        {
            multer.mult(i);
        }

        return multer.getMult();
    }

    public float div(float a, float b)
    {
        Divider diver = new Divider();

        diver.div(a, b);

        return diver.getDiv();
    }

    public int invert(int a)
    {
        Inverter inverter = new Inverter();

        inverter.invert(a);

        return inverter.getInvertNum();
    }

    public short rightDrift(short a)
    {
        RightDrifter drifter = new RightDrifter();

        drifter.drift(a);

        return drifter.getDrift();
    }
}