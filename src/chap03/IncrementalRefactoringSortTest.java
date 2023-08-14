package chap03;

import chap02.FilteringApplesV2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IncrementalRefactoringSortTest {

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

    enum Color {
        RED, GREEN
    }

    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(
                new Apple(50 ,Color.GREEN),
                new Apple(20 ,Color.RED),
                new Apple(30 ,Color.GREEN)
        ));

        inventory.sort(new AppleComparator());
        System.out.println("inventory1 = " + inventory);

        inventory.set(1, new Apple(10, Color.RED));
        inventory.sort((Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight());
        System.out.println("inventory2 = " + inventory);

        inventory.set(2, new Apple(5, Color.GREEN));
        inventory.sort((a1, a2) -> a1.getWeight() - a2.getWeight());
        System.out.println("inventory3 = " + inventory);

        inventory.set(2, new Apple(1, Color.GREEN));
        inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println("inventory4 = " + inventory);

    }

    static class AppleComparator implements Comparator<Apple> {

        @Override
        public int compare(Apple a1, Apple a2) {
            return a1.getWeight() - a2.getWeight();
        }
    }

}
