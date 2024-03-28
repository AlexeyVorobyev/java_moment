public class Apartment implements Property {
    private double worth;
    private String address;
    private double square;

    public Apartment(
            double worth,
            String address,
            double square
    ) {
        this.worth = worth;
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
    public double getWorth() {
        return this.worth;
    }

    @Override
    public void setWorth(double worth) {
        this.worth = worth;
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
