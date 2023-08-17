package chap05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mapping {

    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println("dishNames = " + dishNames);

        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("wordLengths = " + wordLengths);

        List<Integer> dishNameLengths = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("dishNameLengths = " + dishNameLengths);

        //flatMap
        List<String> uniqueCharacters = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("uniqueCharacters = " + uniqueCharacters);
    }
}
