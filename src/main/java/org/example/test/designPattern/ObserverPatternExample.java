package org.example.test.designPattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternExample {
    public static void main(String[] args) {

        // 발행자 등록
        ISubject publisher = new ConcreteSubject();

        // 발행자를 구독할 관찰자들 리스트로 등록
        IObserver o1 = new ObserverA();
        IObserver o2 = new ObserverB();
        publisher.registerObserver(o1);
        publisher.registerObserver(o2);

        // 관찰자에게 이벤트 전파
        publisher.notifyObserver();

        // ObserverB가 구독 취소
        publisher.removeObserver(o2);

        // ObserverA 한테만 이벤트 전파
        publisher.notifyObserver();
    }
}

// 관찰 대상자 / 발행자
interface ISubject {
    void registerObserver(IObserver o);
    void removeObserver(IObserver o);
    void notifyObserver();
}

class ConcreteSubject implements ISubject {
    // 관찰자들을 등록하여 담는 리스트
    List<IObserver> observers = new ArrayList<>();

    // 관찰자를 리스트에 등록
    @Override
    public void registerObserver(IObserver o) {
        observers.add(o);
        System.out.println(o + " 구독 완료");
    }

    // 관찰자를 리스트에 제거
    @Override
    public void removeObserver(IObserver o) {
        observers.remove(o);
        System.out.println(o + " 구독 취소");
    }

    // 관찰자에게 이벤트 송신
    @Override
    public void notifyObserver() {
        for (IObserver o : observers) { // 관찰자 리스트를 순회하며
            o.update(); // 위임
        }
    }
}

// 관찰자 / 구독자
interface IObserver {
    void update();
}

class ObserverA implements IObserver {
    public void update() {
        System.out.println("ObserverA 한테 이벤트 알림이 왔습니다.");
    }

    public String toString() {
        return "ObserverA";
    }
}

class ObserverB implements IObserver {
    public void update() {
        System.out.println("ObserverB 한테 이벤트 알림이 왔습니다.");
    }

    public String toString() {
        return "ObserverB";
    }
}