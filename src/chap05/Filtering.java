package chap05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static chap05.Dish.menu;

public class Filtering {

    public static void main(String[] args) {
        //
//        List<Dish> vegetarianMenu = new ArrayList<>();
//        for(Dish d : menu){
//            if(d.isVegetarian()){
//                vegetarianMenu.add(d);
//            }
//        }
//        vegetarianMenu.forEach(System.out::println);

        //프레디케이트로 필터링
        System.out.println("Filtering with a predicate");
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .toList();
        vegetarianMenu.forEach(System.out::println);

        //고유요소 필터링
        System.out.println("Filtering unique elements:");
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0) //[2, 2, 4]
                .distinct() //[2, 4]
                .forEach(System.out::println);

    }
}
