package org.example.test.Generic;


public class GenericMultiTypeExample {
    public static void main(String[] args) {

        Product<TV, String> samsungTV = new Product<>();
        samsungTV.setKind(new TV());
        samsungTV.setModel("삼성 TV");

        Product<TV, String> lgTV = new Product<>();
        lgTV.setKind(new TV());
        lgTV.setModel("엘지 TV");

    }
}

class Product<T, M> {
    private T kind;
    private M model;

    public T getKind() {
        return this.kind;
    }

    public M getModel() {
        return this.model;
    }

    public void setKind(T kind) {
        this.kind = kind;
    }

    public void setModel(M model) {
        this.model = model;
    }
}

class TV { }

class Samsung { }

class Lg { }
