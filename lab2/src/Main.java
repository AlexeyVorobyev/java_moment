import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program started!");
        List<Property> instances = new ArrayList<>();

        instances.add(new Apartment(
                1000,
                "Russia, krasnodar",
                43.4
        ));

        instances.add(new Apartment(
                100000,
                "Russia, Moscow",
                433.4
        ));

        instances.add(new Car(
                100000,
                1.6,
                1993
        ));

        instances.add(new Car(
                1000001,
                3,
                2003
        ));

        instances.add(new CountryHouse(
                100000,
                100,
                433.4
        ));

        instances.add(new CountryHouse(
                10000000,
                1000,
                100000
        ));

        instances.add(new CountryHouse(
                10000000,
                1000,
                100000
        ));

        instances.forEach((item) -> {
            System.out.println("Описание проперти:");
            System.out.println(item.toString());
            System.out.println("Налог:");
            System.out.println(item.calcTax());
            System.out.println("--------------------");
        });

        instances.forEach((item) -> {
            instances.forEach((_item) -> {
                System.out.println(item.toString());
                System.out.println(_item.toString());
                System.out.println(item.equals(_item));
                System.out.println("--------------------");
            });
        });
    }
}