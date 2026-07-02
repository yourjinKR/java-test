package org.example.test.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class StreamExample1 {
    public static void main(String[] args) {

    }
}


class Ex01 {
    public static void main(String[] args) {
        Ex01 ex = new Ex01();

        System.out.println(ex.outOfRange());

        System.out.println(ex.createNumRange());

        System.out.println(ex.getDuplicateCount());
    }

    // 숫자 리스트 범위 검사
    boolean outOfRange() {
        int lower = 1;
        int upper = 10;
        List<Integer> list = List.of(1, 2, 3, 4, 5, 11);

        return list.stream()
                .anyMatch(number -> (number < lower) || (number > upper));
    }

    // 특정 범위의 숫자 리스트 만들기
    List<Integer> createNumRange() {
        return IntStream.range(1,10).boxed().toList();
    }

    // 두 숫자 리스트 병합
    int getDuplicateCount() {
        List<Integer> list1 = List.of(1,2,3,4,5);
        List<Integer> list2 = List.of(1,3,5);

        List<Integer> matchList = list1.stream()
                .filter(n1 -> list2.stream()
                        .anyMatch(Predicate.isEqual(n1)))
                .toList();

        System.out.println(matchList);

        return matchList.size();
    }
}