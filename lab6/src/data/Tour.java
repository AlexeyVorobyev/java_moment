package data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Tour {
    private TourType type;
    private String country;
    private String name;
    private int duration;
    private int price;
    private FoodType foodType;

    @Override
    public String toString() {
        return "Tour: " + name + " " + type + " " + country + " duration:" + duration + " " + price + " " + foodType + "\n";
    }
}
