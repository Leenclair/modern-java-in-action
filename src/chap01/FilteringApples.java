package chap01;

import java.util.*;

public class FilteringApples {

    public static class Apple{

        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return String.format("Apple{color='%s', weight=%d}", color, weight);
        }
    }

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(10, "green"),
                new Apple(20, "red"),
                new Apple(30, "green")
        );

        List<Apple> greenApplesV1 = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApplesV1);

        List<Apple> heavyApplesV1 = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println(heavyApplesV1);

        List<Apple> greenApplesV2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApplesV2);

        List<Apple> heavyApplesV2 = filterApples(inventory, (Apple a) -> a.getWeight() > 10);
        System.out.println(heavyApplesV2);

        List<Apple> heavyAndRedApples = filterApples(inventory, (Apple a) -> a.getWeight() > 10 && "red".equals(a.getColor()));
        System.out.println(heavyAndRedApples);
    }

    public static List<Apple> filterGreenApplesV1(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();

        for(Apple apple : inventory){
            if("green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColor());
    }

    public static List<Apple> filterHeavyApplesV1(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();

        for(Apple apple : inventory){
            if(apple.getWeight() > 10){
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight() > 10;
    }

    public interface Predicate<T>{
        boolean test(T t);
    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();

        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}
