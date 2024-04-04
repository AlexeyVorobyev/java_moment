import java.util.Objects;

public class Apartment extends Property {
    private String address;
    private double square;

    public Apartment(
            double worth,
            String address,
            double square
    ) {
        super(worth);
        this.address = address;
        this.square = square;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSquare() {
        return this.square;
    }

    public void setSquare(float square) {
        this.square = square;
    }

    @Override
    public double calcTax() {
        return (double) 1 / 1000 * this.square;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Apartment other = (Apartment) obj;
        if (
                !Objects.equals(other.address, this.address)
                || other.square != this.square
                || other.worth != this.worth
        ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "Квартира; Адрес - %s; Стоимость - %f; Площадь - %s;",
                this.address,
                this.worth,
                this.square
        );
    }
}
