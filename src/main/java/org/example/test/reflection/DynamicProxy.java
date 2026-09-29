package org.example.test.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static void main(String[] args) {
            Card bingo = (Card) Proxy.newProxyInstance(
                    Card.class.getClassLoader(),
                    new Class[]{Card.class},
                    new CardProxyHandler(new BingoCard()) {
                    });

            bingo.draw();
            bingo.getValues();
    }
}

interface Card {
    void draw();
    void getValues();
}

class BingoCard implements Card {
    @Override
    public void draw() {
        System.out.println("빙고 카트 뽑음");
    }

    @Override
    public void getValues() {
        System.out.println("이거 장땡 아녀?");
    }
}

class SakuraCard implements Card {
    @Override
    public void draw() {
        System.out.println("바꿔치기 카드 뽑음");
    }

    @Override
    public void getValues() {
        System.out.println("사쿠라여?");
    }
}

class CardProxyHandler implements InvocationHandler {
    private Card result;
    public CardProxyHandler(Card card) {
        this.result = card;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("게임 시작");

        if (method.getName().equals("draw")) {
            System.out.println("카드를 뽑기 전");
            result = method.invoke(this.result, args);
            System.out.println("카드를 뽑은 후");
        } else if (method.getName().equals("getValues")) {
            System.out.println("카드를 확인 전");
            result = method.invoke(this.result, args);
            System.out.println("카드를 확인 후");
        }

        System.out.println("끝");
        return result;
    }
}