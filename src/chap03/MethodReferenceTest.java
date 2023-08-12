package chap03;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class MethodReferenceTest {

    public static void main(String[] args) {
        List<String> str = Arrays.asList("a", "b", "A", "B");
        str.sort((String::compareToIgnoreCase));
        System.out.println("str = " + str);

        ToIntFunction<String> stringToInt = (String s) -> Integer.parseInt(s);
        ToIntFunction<String> stringToIntMethodReference = Integer::parseInt;
        String s = "123";
        System.out.println("stringToInt.applyAsInt(s) = " + stringToInt.applyAsInt(s));
        System.out.println("stringToIntMethodReference.applyAsInt(s) = " + stringToIntMethodReference.applyAsInt(s));

        BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
        BiPredicate<List<String>, String> containsMethodReference = List::contains;
        List<String> list = Arrays.asList("abc", "a", "bn", "da");
        String element = "a";
        System.out.println("contains = " + contains.test(list, element));
        System.out.println("containsMethodReference = " + containsMethodReference.test(list, element));

    }

}
