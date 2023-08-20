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
        sum = 0;
        sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("sum = " + sum);

        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("product = " + product);

        sum = 0;
        sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("sum = " + sum);

        //not init reduce, return Optional
//        numbers = new ArrayList<Integer>();
        Optional<Integer> sumOpt = numbers.stream().reduce((a, b) -> a + b);
        System.out.println("sumOpt = " + sumOpt);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println("max = " + max);


    }



}
