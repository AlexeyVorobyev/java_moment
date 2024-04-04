public class CountryHouse extends Property {
    private double squareHouse;
    private double squareHold;

    public CountryHouse(
            double worth,
            double squareHouse,
            double squareHold
    ) {
        super(worth);
        this.squareHouse = squareHouse;
        this.squareHold = squareHold;
    }

    public double getSquareHouse() {
        return this.squareHouse;
    }

    public void setSquareHouse(double square) {
        this.squareHouse = square;
    }

    public double getSquareHold() {
        return this.squareHold;
    }

    public void setSquareHold(double square) {
        this.squareHold = square;
    }

    @Override
    public double calcTax() {
        return (double) 1 / 5000 * this.squareHold + (double) 1 / 100 * squareHouse;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        CountryHouse other = (CountryHouse) obj;
        if (
                other.squareHold != this.squareHold
                        || other.squareHouse != this.squareHouse
                        || other.worth != this.worth
        ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "Дача; Площадь дома - %s; Стоимость - %f; Площадь владений - %s;",
                this.squareHouse,
                this.worth,
                this.squareHold
        );
    }
}
