public class Car implements Property {
    private double worth;
    private double volume;
    private int year;

    public Car(
            double worth,
            double volume,
            int year
    ) {
        this.worth = worth;
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
                "Автомобиль; Объем двигателя - %s; Стоимость - %f; Год выпуска - %s;",
                this.volume,
                this.worth,
                this.year
        );
    }
}
