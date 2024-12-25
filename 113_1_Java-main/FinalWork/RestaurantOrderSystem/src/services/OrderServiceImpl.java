package services;

import models.Order;
import java.util.LinkedList;
import java.util.Queue;

public class OrderServiceImpl implements OrderService {
    private Queue<Order> orderQueue = new LinkedList<>();

    @Override
    public void placeOrder(Order order) {
        orderQueue.add(order);
    }

    @Override
    public Order processNextOrder() {
        return orderQueue.poll();
    }
}
