package chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceTest {

    public static class Apple{
        private int weight;
        public Apple() {}
        public Apple(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    '}';
        }
    }

    public static void main(String[] args) {
        Supplier<Apple> c1 = Apple::new;
        Apple a1 = c1.get();
        System.out.println("a1 = " + a1);

        Function<Integer, Apple> function = Apple::new;
        List<Integer> weights = Arrays.asList(2, 3, 1, 9);
        List<Apple> apples = map(weights, function);
        System.out.println("apples = " + apples);
    }
    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f){
        List<Apple> result = new ArrayList<>();
        for(Integer i : list){
            result.add(f.apply(i));
        }
        return result;
    }
}
