
package org.example.test.stream;

import java.util.Arrays;

// enum과 filter를 활용한 예시
public class FilterExample {
    public static void main(String[] args) {

    }
}

enum RANK {
    FIRST(6, false),
    SECOND(5, true),
    THIRD(5, false),
    NONE(0, false);

    RANK(int score, boolean isBonusMatched) {
        this.score = score;
        this.isBonusMatched = isBonusMatched;
    }

    RANK of(int score, boolean isBonusMatched) {
        return Arrays.stream(values())
                .filter(rank -> rank.score == score)
                .filter(rank -> !rank.isBonusMatched)
                .findFirst()
                .orElse(NONE);
    }

    private final int score;
    private final boolean isBonusMatched;

    public int getScore() {
        return score;
    }

    public boolean isBonusMatched() {
        return isBonusMatched;
    }
}
