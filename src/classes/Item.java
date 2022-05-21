package classes;

import java.util.Comparator;
import java.util.Objects;

public class Item{
    private int id;
    private double price;
    private double weight;
    private double energeticValue;
    private double carbohydrates;
    private double sodium;
    private double proteins;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getEnergeticValue() {
        return energeticValue;
    }

    public void setEnergeticValue(double energeticValue) {
        this.energeticValue = energeticValue;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Item(int id, double price, double weight, double energeticValue, double carbohydrates, double sodium, double proteins) {
        this.id = id;
        this.price = price;
        this.weight = weight;
        this.energeticValue = energeticValue;
        this.carbohydrates = carbohydrates;
        this.sodium = sodium;
        this.proteins = proteins;
    }

    public Item(){}

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", price=" + price +
                ", weight=" + weight +
                ", energeticValue=" + energeticValue +
                ", carbohydrates=" + carbohydrates +
                ", sodium=" + sodium +
                ", proteins=" + proteins +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && Double.compare(item.price, price) == 0 && Double.compare(item.weight, weight) == 0 && Double.compare(item.energeticValue, energeticValue) == 0 && Double.compare(item.carbohydrates, carbohydrates) == 0 && Double.compare(item.sodium, sodium) == 0 && Double.compare(item.proteins, proteins) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, weight, energeticValue, carbohydrates, sodium, proteins);
    }


}
