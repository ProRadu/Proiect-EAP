package classes.food;

public class Bread extends Food {

    public Bread(int id, double price, double weight, double energeticValue, double carbohydrates, double sodium, double proteins) {
        super(id, price, weight, energeticValue, carbohydrates, sodium, proteins);
    }

    public Bread() {
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
