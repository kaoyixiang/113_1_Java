package services;

import models.Order;

public interface OrderService {
    void placeOrder(Order order);
    Order processNextOrder();
}
