package calc.operation;

public class Inverter
{
    private int invertNum;

    public Inverter()
    {
        invertNum = 0;
    }

    public Inverter(int a)
    {
        this.invertNum = a;
    }

    public void invert(int a)
    {
        String bin_string = Integer.toBinaryString(a);
        StringBuilder invertBin = new StringBuilder();

        for (int i = 0; i < bin_string.length(); i++) {
            char bit = bin_string.charAt(i);
            invertBin.append(bit == '0' ? '1' : '0');
        }

        invertNum = Integer.parseInt(invertBin.toString(), 2);
    }

    public int getInvertNum()
    {
        return invertNum;
    }
}