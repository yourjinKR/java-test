package org.example.standard.oop;

// 다중 상속 이슈 예제
public class MultipleInheritance {
    public static void main(String[] args) {
        Chiwawa c = new Chiwawa();
        c.run();
    }
}

class Dog {
    public void run() {
        System.out.println("개가 달립니다");
    }
}

interface Eatable {
    void eat();
}

interface Runnable {
    void run();
}

class Chiwawa extends Dog implements Eatable, Runnable {

    @Override
    public void run() {
        System.out.println("치와와가 발립니다.");
    }

    @Override
    public void eat() {
        System.out.println("치와와가 먹음");
    }
}
