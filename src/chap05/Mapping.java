package chap05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Mapping {

    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(dishNames);

        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        wordLengths.forEach(System.out::println);

        List<Integer> dishNameLengths = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());
        dishNameLengths.forEach(System.out::println);

        //flatMap
        List<String> uniqueCharacters = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        uniqueCharacters.forEach(System.out::println);

        //quiz
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbers2 = Arrays.asList(6, 7, 8);
        List<Integer> squares = numbers1.stream()
                .map(n -> n * n)
                .toList();
        squares.forEach(System.out::println);

        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i, j})
                )
                .toList();
        pairs.forEach(pair -> System.out.printf("(%d, %d)", pair[0], pair[1]));
        List<int[]> pairs2 = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j})
                )
                .toList();
        System.out.println();
        pairs2.forEach(pair -> System.out.printf("(%d, %d)", pair[0], pair[1]));
    }
}
