package org.example.standard.stream;

import java.util.Arrays;
import java.util.List;

public class ParallelStream {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.parallelStream().forEach(number ->
                System.out.println(number + " " + Thread.currentThread().getName())
        );

        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
        Integer reduce = listOfNumbers.parallelStream().reduce(5, Integer::sum);
        System.out.println(reduce);
    }
}
