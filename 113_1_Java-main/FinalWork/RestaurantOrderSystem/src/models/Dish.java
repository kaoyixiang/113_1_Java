package models;

public class Dish {
    private String name;
    private double price;

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Dish{name='" + name + "', price=" + price + '}';
    }
}
