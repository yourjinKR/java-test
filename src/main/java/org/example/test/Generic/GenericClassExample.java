package org.example.test.Generic;


import java.util.ArrayList;
import java.util.List;

public class GenericClassExample {
    public static void main(String[] args) {

        // 1. 제네릭 클래스
        GenericClass<Integer> integerClass = new GenericClass<>(123);
        GenericClass<String> stringClass = new GenericClass<>("안녕");

        // 2. 부모 클래스 제네릭
        Box<Fruit> fruitBox = new Box<>();
        fruitBox.addItem(new Apple("사과", 3000));
        fruitBox.addItem(new Melon("멜론", 2000));

        Calculator<Integer> c1 = new Calculator<>();
        Calculator<Long> c2 = new Calculator<>();
//        Calculator<String> c3 = new Calculator<String>(); 불가능
    }
}


class GenericClass<T> {
    T obj;

    GenericClass(T obj) {
        setObj(obj);
    }

    void setObj(T obj) {
        this.obj = obj;
    }

    T getObj() {
        return obj;
    }
}

class Box<T> {
    List<T> items = new ArrayList<T>();

    public Box() {
    }

    public Box(List<T> items) {
        this.items = items;
    }

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}

class Fruit {
    String name;
    int price;

    Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }
}


class Apple extends Fruit {
    Apple(String name, int price) {
        super(name, price);
    }
}

class Melon extends Fruit {
    Melon(String name, int price) {
        super(name, price);
    }
}

class Calculator<T extends  Number> {
    void add(T x, T y) {}
}

