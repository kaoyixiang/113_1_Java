package services;

import models.Dish;
import java.util.ArrayList;
import java.util.List;

public class MenuServiceImpl implements MenuService {
    private List<Dish> menu = new ArrayList<>();

    @Override
    public void addDish(Dish dish) {
        menu.add(dish);
    }

    @Override
    public void removeDish(String dishName) {
        menu.removeIf(dish -> dish.getName().equalsIgnoreCase(dishName));
    }

    @Override
    public List<Dish> getMenu() {
        return new ArrayList<>(menu);
    }
}
