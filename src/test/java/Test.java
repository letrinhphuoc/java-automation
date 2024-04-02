import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test {
    public static void main(String[] args) {
//        Supplier<Double> random = () -> Math.random();
//        Supplier<Double> random = Math::random;
//        System.out.println(random.get());
//        BiConsumer<String, Integer> biConsumer = (s, integer) -> {
//            System.out.println("My name is :: " + s);
//            System.out.println("My age is :: " + integer);
//        };
//        biConsumer.accept("James", 30);
        Predicate<Integer> isGT2 = (n) -> n > 2;
        Predicate<Integer> isLT10 = (n) -> n < 10;
        System.out.println(
                isGT2.negate().test(1)
//                isGT2.and(isLT10).test(5)
        );

    }
}
