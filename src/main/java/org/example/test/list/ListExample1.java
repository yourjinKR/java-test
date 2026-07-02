package org.example.test.list;

import java.util.ArrayList;
import java.util.List;



public class ListExample1 {
    public static void main(String[] args) {
        // 2차원 리스트 평탄화
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(List.of(1, 2, 3));
        matrix.add(List.of(4, 5, 6));
        matrix.add(List.of(7, 8, 9));

        List<Integer> flattenedList = matrix.stream()
                .flatMap(List::stream)
                .toList();

        System.out.println("Flattened List: " + flattenedList);

        // List의 일부분을 자르기
        List<Integer> integers1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        int n = 2;
        integers1.subList(0, Math.min(n, integers1.size())).clear();
        System.out.println(integers1);

        //
        List<Integer> integers2 = new ArrayList<>(List.of(1, 2));
        int n1 = 3;
        List<Integer> integers = integers2.subList(0, Math.min(n1, integers2.size()));
        System.out.println(integers);

    }
}


