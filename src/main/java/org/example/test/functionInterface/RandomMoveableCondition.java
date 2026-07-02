package org.example.test.functionInterface;

import java.util.Random;

public class RandomMoveableCondition implements MoveableCondition {
    public static final int REQ_MIN_POWER = 4;

    @Override
    public boolean moveable() {
        Random random = new Random();
        int randomPower = random.nextInt(0,9);

        System.out.printf("랜덤 숫자 %d\n", randomPower);
        if (randomPower >= 4) {
            System.out.println("움직일게~");
            return true;
        }

        return false;
    }
}
