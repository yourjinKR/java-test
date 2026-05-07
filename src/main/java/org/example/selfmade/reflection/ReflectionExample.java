package org.example.selfmade.reflection;

public class ReflectionExample {
    public int a;
    public int b;
    public int c;


    public static void main(String[] args) {
        int length = ReflectionExample.class.getDeclaredFields().length;
        System.out.println(length);
        double v1 = 100.0 / length;
        System.out.println(v1);
        double v2 = Math.round(v1 * 100) / 100.0;
        System.out.println(v2);

        System.out.println(v1 / 33.333333331263336);
    }
}
