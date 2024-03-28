public abstract class Property {
    protected double worth;

    public Property(double worth) {
        this.worth = worth;
    }

    public double getWorth() {
        return this.worth;
    }

    public abstract double calcTax();
}
