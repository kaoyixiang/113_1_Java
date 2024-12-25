package main;

import models.Dish;
import models.Order;
import services.MenuService;
import services.MenuServiceImpl;
import services.OrderService;
import services.OrderServiceImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MenuService menuService = new MenuServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        // Add dishes to menu
        menuService.addDish(new Dish("Pasta", 10.99));
        menuService.addDish(new Dish("Pizza", 8.99));
        menuService.addDish(new Dish("Salad", 5.99));

        System.out.println("Menu: " + menuService.getMenu());

        // Place an order
        orderService.placeOrder(new Order(1, "John", Arrays.asList(
                new Dish("Pasta", 10.99),
                new Dish("Salad", 5.99)
        )));

        // Process an order
        System.out.println("Processing Order: " + orderService.processNextOrder());
    }
}
