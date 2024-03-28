package calc;
public class Calc
{
    public static void main(String[] args)
    {
        System.out.println("Start of calculation!");
        Calculator calc = new Calculator();
        System.out.println("1+2+3="+calc.sum(1,2,3));
        System.out.println("-12-6="+calc.subtract(12,6));
        System.out.println("2*2*3="+calc.mult(2,2,3));
        System.out.println("10/3="+calc.div(10,3));
        System.out.println("123="+calc.invert(123));
    }
}