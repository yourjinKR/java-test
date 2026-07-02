package org.example.test.Generic;

public class GenericMethodExample {
    public static void main(String[] args) {
        GenericMethod<Integer, Integer> gc = new GenericMethod<>();
        gc.genericMethod(1,2);
        gc.genericMethod(1,"문자열 가능");
    }
}

class GenericMethod<T, U> {
    public<T, U> void genericMethod(T x, U y) {
        System.out.println(x.getClass().getSimpleName());
        System.out.println(y.getClass().getSimpleName());
    }
}



