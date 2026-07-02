package org.example.test.oop;

public class DownCastingExample {
    public static void main(String[] args) {
        Animal animal = new Monkey();
        System.out.println(animal.name());

        Monkey monkey = (Monkey) animal;

        if (animal instanceof Monkey) {
            ((Monkey) animal).tail();
        }
    }
}
