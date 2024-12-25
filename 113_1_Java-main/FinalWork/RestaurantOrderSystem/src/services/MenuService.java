package services;

import models.Dish;
import java.util.List;

public interface MenuService {
    void addDish(Dish dish);
    void removeDish(String dishName);
    List<Dish> getMenu();
}
