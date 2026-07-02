package org.example.test.oop;

/**
 * 모든 생성자는 실행될때 반드시 부모의 클래스의 생성자를 먼저 호출한다.
 * <br>
 * 그러나 호출하지 않았기 때문에 암묵적으로 super()가 선언된다.
 * <br>
 * super()는 super(40)를 호출하기 때문에 super.age가 40이 된다.
 * 또한 자식 클래스에서 메소드를 오버라이드하지 않았기 때문에
 * super.getAge() 호출되고 해당 메서드는 Parent의 인스턴스 변수를 가르킨다.
 */
public class EX01 {
    public static void main(String[] args) {
        class Parent {
            int age;

            Parent() {
                this(40);
                System.out.println("부모 기본 생성자");
            }
            Parent(int age) {
                this.age = age;
            }

            int getAge() {
                return this.age;
            }
        }

        class Child extends Parent {
            int age;

            Child() {
                this(20);
                System.out.println("자식 기본 생성자");
            }
            Child(int age) {
                this.age = age;
            }
        }

        Child c1 = new Child(400);
        System.out.println(c1.getAge());


        Animal animal = new Lion();
        System.out.println(animal.name());
    }
}