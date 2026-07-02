package org.example.test.functional;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class FunctionalExample1 {
    public static void main(String[] args) {
        // Consumer
        Consumer<String> c1 = System.out::println;
        c1.accept("hello world");
        // BiConsumer
        BiConsumer<String,Integer> c2 = (name, age) -> System.out.println(name + " : " + age);
        c2.accept("유어진",26);

        // Supplier
        Supplier<String> s1 = () -> new Object().toString();
        System.out.println(s1.get());

        // IntSupplier (BooleanSupplier, DoubleSupplier, LongSupplier들 또한 동일)
        IntSupplier s2 = () -> 100;
        System.out.println("백원 : " + s2);

        // int -> String
        Function<Integer, String> intToStr = String::valueOf;
        String str = intToStr.apply(123);

        // String, String -> int
        BiFunction<String, String, Integer> plusString = (t, u) -> {
            return Integer.parseInt(t) + Integer.parseInt(u);
        };


        Function<Integer, Integer> f = num -> (num - 4); // f(x)
        Function<Integer, Integer> g = num -> (num * 2); // g(x)

        // f(g(x))
        int a = f.andThen(g).apply(10);
        System.out.println(a); // (10 - 4) * 2 = 12

        // g(f(x)) - andThen을 반대로 해석하면 된다
        int b = f.compose(g).apply(10);
        System.out.println(b); // 10 * 2 - 4 = 16
    }
}

