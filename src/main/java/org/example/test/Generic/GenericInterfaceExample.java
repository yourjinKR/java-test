package org.example.test.Generic;

public class GenericInterfaceExample {

    public static void main(String[] args) {
        Iadd<Integer, Integer> o1 = (x, y) -> x + y;
        Iadd<Integer, Integer> o2 = Integer::sum;
        Integer result1 = o1.add(100, 200);
        Integer result2 = o2.add(200, 300);

        Iadd<String, String> o3 = (x, y) -> x + y;
        String result3 = o3.add("안", "녕");

        Iadd<Integer, String> o4 = (x, y) -> String.valueOf(x) + String.valueOf(y);
        String result4 = o4.add(30, 40);

        System.out.println(result1); // 300
        System.out.println(result2); // 500
        System.out.println(result3); // 안녕
        System.out.println(result4); // 3040
    }
}

interface Iadd<T,R> {
    public R add(T x, T y);
}
