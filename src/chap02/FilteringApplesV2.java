package chap02;

import chap01.FilteringApples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FilteringApplesV2 {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(10, Color.RED),
                new Apple(30, Color.RED),
                new Apple(20, Color.GREEN),
                new Apple(30, Color.GREEN)
        );

        List<Apple> greenApples = filterGreenApples(inventory);
        System.out.println(greenApples);
        List<Apple> redApples = filterApplesByColor(inventory, Color.RED);
        System.out.println(redApples);
        List<Apple> greenApplesV2 = filterApples(inventory, Color.GREEN, 0, true);
        System.out.println(greenApplesV2);
        List<Apple> redAndHeavyApples = filterApplesV2(inventory, new AppleRedAndHeavyPredicate());
        System.out.println(redAndHeavyApples);
        List<Apple> redApplesV2 = filterApplesV2(inventory, new ApplePredicate() {
            public boolean test(Apple apple) {
                return Color.RED.equals(apple.getColor());
            }
        });
        System.out.println(redApplesV2);
        List<Apple> redApplesLambda = filterApplesV2(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));
        System.out.println("redApplesLambda=" + redApplesLambda);
        List<Apple> redApplesAbsList = filter(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));
        System.out.println("redApplesAbsList=" + redApplesAbsList);

        List<Integer> numbers = Arrays.asList(1,2,3,4);
        List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);
        System.out.println("evenNumbers=" + evenNumbers);

    }

    enum Color {
        RED, GREEN
    }

    public static class Apple{

        private int weight = 0;
        private Color color;

        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return String.format("Apple{color='%s', weight=%d}", color, weight);
        }
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(apple.getColor() == Color.GREEN){
                result.add(apple);
            }
        }
        return result;
    }

    public interface ApplePredicate{
        boolean test (Apple apple);
    }

    public interface ApplePredicateV2<T>{
        boolean test (T t);
    }

    public static <T> List<T> filter(List<T> list, ApplePredicateV2<T> p){
        List<T> result = new ArrayList<>();
        for(T e: list){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(apple.getColor() == color){
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if((flag && apple.getColor() == color) || (!flag && apple.getWeight() > weight)){
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesV2(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public class AppleHeavyWeightPredicate implements ApplePredicate{
        public boolean test(Apple apple){
            return apple.getWeight() > 150;
        }
    }

    public class AppleGreenColorPredicate implements ApplePredicate{
        public boolean test(Apple apple) {
            return apple.getColor() == Color.GREEN;
        }
    }

    public static class AppleRedAndHeavyPredicate implements ApplePredicate{
        public boolean test(Apple apple){
            return apple.getColor() == Color.RED && apple.getWeight() > 20;
        }
    }
}
