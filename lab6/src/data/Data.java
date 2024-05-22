package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Data {
    public static ArrayList<Tour> data = new ArrayList<>(Arrays.asList(
            Tour.builder()
                    .type(TourType.beach)
                    .foodType(FoodType.allInclusive)
                    .price(1000)
                    .duration(123)
                    .country("Russia")
                    .name("Welcome to Russia")
                    .build(),
            Tour.builder()
                    .type(TourType.ski)
                    .foodType(FoodType.noFood)
                    .price(2000)
                    .duration(123)
                    .country("Russia")
                    .name("Welcome to Russia")
                    .build(),
            Tour.builder()
                    .type(TourType.cruise)
                    .foodType(FoodType.breakFast)
                    .price(1000)
                    .duration(123)
                    .country("Germany")
                    .name("Welcome to Germany")
                    .build(),
            Tour.builder()
                    .type(TourType.excursion)
                    .foodType(FoodType.allInclusive)
                    .price(5000)
                    .duration(123)
                    .country("Russia")
                    .name("Welcome to Russia")
                    .build()
    ));
}
