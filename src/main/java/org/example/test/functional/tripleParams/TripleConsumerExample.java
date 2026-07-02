package org.example.test.functional.tripleParams;


public class TripleConsumerExample {
    public static void main(String[] args) {
        TripleConsumer<String, Double, Integer> c1 = (t, u, k) -> {
            System.out.println(t);
            System.out.println(u);
            System.out.println(k);
        };
    }
}

