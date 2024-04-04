import java.util.Objects;

public class Car extends Property {
    private double volume;
    private int year;

    public Car(
            double worth,
            double volume,
            int year
    ) {
        super(worth);
        this.volume = volume;
        this.year = year;
    }

    public double getVolume() {
        return this.volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public double calcTax() {
        return (double) 1 / 10 * this.volume;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Car other = (Car) obj;
        if (
                other.year != this.year
                        || other.volume != this.volume
                        || other.worth != this.worth
        ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "Автомобиль; Объем двигателя - %s; Стоимость - %f; Год выпуска - %s;",
                this.volume,
                this.worth,
                this.year
        );
    }
}
