package org.example.algorithm;

import java.util.Arrays;

// 선택 정렬, 시간 복잡도 O(n^2), 공간 복잡도 O(n), 많은 교환이 일어나야 하는 자료상태에서 비교적 효율적
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {12, 213, 123135, 0, 111, 5};
        System.out.println(Arrays.toString(selectionSort(arr)));
    }
    
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int tmp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }
}
