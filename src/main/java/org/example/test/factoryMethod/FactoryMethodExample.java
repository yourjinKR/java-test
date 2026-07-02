package org.example.test.factoryMethod;


public class FactoryMethodExample {
    public static void main(String[] args) {
    }
}

/*
    정적 팩토리 메서드 (Static Factory Method)
    객체 생성의 역할을 하는 클래스 메서드를 통해
    간접적으로 객체 생성을 유도하는 것이다.

    정적 팩토리 메서드 네이밍 규칙
    정적 팩토리 메서드 와 다른 정적 메서드와 역할을 구분짓기 위해
    독자적인 네이밍 컨벤션(Convention)이 존재한다.
    단, 정적 팩토리 메서드에서의 네이밍은 단순히 선호도 의미를 넘어서 거의 법칙 정도로 사용되는 것이니,
    각 네이밍의 역할에 대해 알아두는 것은 개념을 아는 것만큼 중요하다.
    (이를 왜 지켜야 되는지는 정적 팩토리 메서드 문제점 색션에서 후술한다)
    정적 팩토리 메서드에서 사용되는 네이밍 단어 종류는 다음과 같다.

    from: 하나의 매개 변수를 받아서 객체를 생성
    of: 여러개의 매개 변수를 받아서 객체를 생성
    getInstance | instance: 인스턴스를 생성. 이전에 반환했던 것과 같을 수 있음
    newInstance | create: 항상 새로운 인스턴스를 생성
    get[OrderType: 다른 타입의 인스턴스를 생성. 이전에 반환했던 것과 같을 수 있음
    new[OrderType: 항상 다른 타입의 새로운 인스턴스를 생성
 */
class Book {
    public static void main(String[] args) {
        Book book = Book.titleOf("백설공주");
    }

    private String title;

    private Book(String title) { this.title = title; }

    public static Book titleOf(String title) {
        return new Book(title);
    }
}

/*
    1. 생성 목적에 대한 이름 표현이 가능하다
 */
class Shoes {
    public static void main(String[] args) {
        Shoes myShoes = defaultSizeFrom("NIKE");
        Shoes giftShoes = brandSizeOf("NIKE", 220);
    }

    private String brand;
    private Integer size = 280;

    private Shoes(String brand, Integer size) {
        this.brand = brand;
        this.size = size;
    }

    private Shoes(String brand) {
        this.brand = brand;
    }

    public static Shoes defaultSizeFrom(String brand) {
        return new Shoes(brand);
    }

    public static Shoes brandSizeOf(String brand, int color) {
        return new Shoes(brand, color);
    }
}

/*
    2. 인스턴스에 대해 통제 및 관리가 가능하다
 */
class Singleton {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }

    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

/*
    3. 하위 자료형 객체를 반환할 수 있음
    하지만 java 8 버전부터는 인터페이스가 정적 메서드를 가질수 있게 되어
    동반 클래스 개념은 더이상 필요없어졌다.
    즉, 인터페이스에 그냥 정적 팩토리 메서드를 선언하면 된다.
 */
interface SmartPhone {}
class Galaxy implements SmartPhone {}
class IPhone implements SmartPhone {}
class Huawei implements SmartPhone {}

class SmartPhones {
    public static void main(String[] args) {
        SmartPhone phone1 = SmartPhones.getApplePhone();
        SmartPhone phone2 = SmartPhones.getChinesePhone();
        SmartPhone phone3 = SmartPhones.getSamsungPhone();
    }

    public static SmartPhone getSamsungPhone() {
        return new Galaxy();
    }

    public static SmartPhone getApplePhone() {
        return new IPhone();
    }

    public static SmartPhone getChinesePhone() {
        return new Huawei();
    }
}

/*
    4. 인자에 따라 객체를 반환할 수 있도록 분기 가능
 */
interface Product {
    public static Product getProduct(int price) {
        if (price > 1000) {
            return new Premium();
        }
        return new Basic();
    }
}

class Premium implements Product {}
class Basic implements Product {}

/*
    5. 객체 생성을 캡슐화
 */
interface Grade {
    String toText();
}

class A implements Grade {
    @Override
    public String toText() {
        return "A";
    }
}

class B implements Grade {
    @Override
    public String toText() {
        return "B";
    }
}

class C implements Grade {
    @Override
    public String toText() {
        return "C";
    }
}

class D implements Grade {
    @Override
    public String toText() {
        return "D";
    }
}

class F implements Grade {
    @Override
    public String toText() {
        return "F";
    }
}

class GradeCalculator {
    // 정적 팩토리 메서드
    public static Grade of(int score) {
        if (score >= 90) {
            return new A();
        } else if (score >= 80) {
            return new B();
        } else if (score >= 70) {
            return new C();
        } else if (score >= 60) {
            return new D();
        } else {
            return new F();
        }
    }
}

class Runner {
    public static void main(String[] args) {
        String jeff_score = GradeCalculator.of(36).toText();
        String herryPorter_score = GradeCalculator.of(99).toText();

        System.out.println(jeff_score); // F
        System.out.println(herryPorter_score); // A
    }
}

/*
    정적 팩토리 메서드 문제점
    1. private 생성자일 경우 상속 불가능
        - 다만 이부분은 단점이라기 보다는 스펙에 가까움
        - 왜냐하면 Collections 클래스도 생성자가 private임
        - 따라서, 이러한 제약은 상속보다는
          합성을 사용하도록 유도하거나 불변 객체를 만들고 싶을때 사용
    2. API 문서에서의 불편함
        - 그러므로 네이밍 컨벤션을 꼭 지키자

    * 보통은 정적 팩토리를 사용하는게 유리한 경우가 많음
 */