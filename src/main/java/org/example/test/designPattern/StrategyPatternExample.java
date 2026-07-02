package org.example.test.designPattern;

public class StrategyPatternExample {
}

interface Strategy {
    void doSomething();
}

// 전략 알고리즘 A
class ConcreteStrategyA implements Strategy {
    public void doSomething() {
    }
}

// 전략 알고리즘 B
class ConcreteStrategyB implements Strategy {
    public void doSomething() {
    }
}

// 컨텍스트(전략 등록/실행)
class Context {
    public static void main(String[] args) {
        Context c = new Context();

        c.setStrategy(new ConcreteStrategyA());
    }

    // 전략 인터페이스를 합성
    Strategy strategy;

    // 교체 전략 메서드
    void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    void doSomething() {
        this.strategy.doSomething();
    }
}


