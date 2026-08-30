package org.example.algorithm;

public class QuickSort {

    public static void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        // 원소가 1개 이하인 구간은 정렬할 필요 없음
        if (left >= right) {
            return;
        }

        // partition을 수행하면 pivot의 최종 위치가 결정된다.
        int pivotIndex = partition(array, left, right);

        // pivot 기준 왼쪽 구간 정렬
        quickSort(array, left, pivotIndex - 1);

        // pivot 기준 오른쪽 구간 정렬
        quickSort(array, pivotIndex + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        // 맨 오른쪽 값을 pivot으로 사용
        int pivot = array[right];

        // i는 "pivot 이하 구역의 마지막 인덱스"
        // 아직 아무 값도 pivot 이하 구역에 없으므로 left - 1로 시작
        int i = left - 1;

        // j는 왼쪽부터 pivot 직전까지 순회하며 검사
        for (int j = left; j < right; j++) {

            // 현재 값이 pivot 이하라면
            // 그 값을 왼쪽의 pivot 이하 구역으로 보내야 한다.
            if (array[j] <= pivot) {
                i++; // pivot 이하 구역을 한 칸 확장
                swap(array, i, j); // 현재 값을 그 구역 끝으로 이동
            }
        }

        // 반복문이 끝나면
        // left ~ i       : pivot 이하
        // i+1 ~ right-1  : pivot 초과
        // right          : pivot
        //
        // 따라서 pivot을 i+1 위치로 옮기면
        // pivot의 최종 위치가 확정된다.
        swap(array, i + 1, right);

        return i + 1;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}