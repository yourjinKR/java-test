package org.example.test.functionInterface;

public class FunctionInterFaceExample1 {
    public static void main(String[] args) {
        Car car = new Car("유어진");
        MoveableCondition moveableCondition = new RandomMoveableCondition();

        car.moveIfCan(moveableCondition);
        car.moveIfCan(moveableCondition);
        car.moveIfCan(moveableCondition);
        car.moveIfCan(moveableCondition);
        car.moveIfCan(moveableCondition);
        car.moveIfCan(moveableCondition);

        System.out.println(car.toString());
    }
}

class Car {
    private final String name;
    private int dashStatus;

    public Car(String name) {
        this.name = name;
        this.dashStatus = 0;
    }

    private void move() {
        this.dashStatus++;
    }

    public void moveIfCan(MoveableCondition condition) {
        boolean moveable = condition.moveable();
        if (moveable) {
            this.move();
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", dashStatus=" + dashStatus +
                '}';
    }
}
