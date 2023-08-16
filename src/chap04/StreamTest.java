package chap04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;

        //java7
        List<Dish> lowCaloricDishes = new ArrayList<>();

        for(Dish dish : menu){
            if(dish.getCalories() < 400){
                lowCaloricDishes.add(dish);
            }
        }

        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        System.out.println("lowCaloricDishes = " + lowCaloricDishes);

        List<String> lowCaloricDishesName = new ArrayList<>();
        for(Dish dish : lowCaloricDishes){
            lowCaloricDishesName.add(dish.getName());
        }
        System.out.println("lowCaloricDishesName = " + lowCaloricDishesName);

        //java8
        List<String> lowCaloricDishesNameStream = menu.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println("lowCaloricDishesNameStream = " + lowCaloricDishesNameStream);

        List<String> lowCaloricDishesNameParallelStream = menu.parallelStream()
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println("lowCaloricDishesNameParallelStream = " + lowCaloricDishesNameParallelStream);

        List<String> threeHighCaloricDishNames = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("threeHighCaloricDishNames = " + threeHighCaloricDishNames);
    }

}
