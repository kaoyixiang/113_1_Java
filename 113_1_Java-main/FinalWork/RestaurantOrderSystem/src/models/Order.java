package models;

import java.util.List;

public class Order {
    private int orderId;
    private String customerName;
    private List<Dish> dishes;

    public Order(int orderId, String customerName, List<Dish> dishes) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.dishes = dishes;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    @Override
    public String toString() {
        return "Order{orderId=" + orderId + ", customerName='" + customerName + "', dishes=" + dishes + '}';
    }
}
