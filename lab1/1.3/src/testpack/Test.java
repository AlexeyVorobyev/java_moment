package testpack;
import applepack.Apple;

public class Test {
    public static void main(String[] args)
    {
        System.out.println("Start of program!");
        Apple apple = new Apple();
        apple.setMass(120);
        System.out.println(apple.getMass());
    }
}