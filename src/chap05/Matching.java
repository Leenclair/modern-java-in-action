package chap05;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Matching {

    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;

        if(menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        if(menu.stream().allMatch(dish -> dish.getCalories() < 1000)){
            System.out.println("The menu is (somewhat) healthy!!");
        }

        if(menu.stream().noneMatch(dish -> dish.getCalories() >= 1000)){
            System.out.println("The menu is (somewhat) healthy!!");
        }

        Optional<Dish> dish = menu.stream().filter(Dish::isVegetarian).findAny();
        System.out.println("dish = " + dish);

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst();
        System.out.println("firstSquareDivisibleByThree = " + firstSquareDivisibleByThree);

    }

}
