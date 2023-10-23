package chap05;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reducing {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 5, 3, 9);

        //pre java8
        int sum = 0;
        for(int x : numbers){
            sum += x;
        }
        System.out.println("sum = " + sum);

        //post java8
        sum = numbers.stream().reduce(0, (a, b) -> a + b);//reduce(초깃값, 연산?)
        //0+4 -> 4+5 -> 9+3 -> 12+9 -> 21
        System.out.println("sum = " + sum);

        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("product = " + product);

        sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("sum = " + sum);

        //not init reduce, return Optional
        Optional<Integer> sumOpt = numbers.stream().reduce(Integer::sum);
        System.out.println("sumOpt = " + sumOpt);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println("max = " + max);


    }



}
