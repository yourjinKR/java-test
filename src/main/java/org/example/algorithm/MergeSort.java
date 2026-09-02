package org.example.algorithm;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {4, 3, 10, 8, 2, 1, 6, 7, 9, 5};

        mergeSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 병합 정렬
     *
     * 배열을 절반씩 계속 나눈 뒤,
     * 더 이상 나눌 수 없으면 정렬하면서 다시 병합한다.
     *
     * 시간 복잡도: O(N log N)
     */
    public static void mergeSort(int[] arr, int left, int right) {

        // 원소가 2개 이상인 경우에만 분할한다.
        // left == right이면 원소가 하나이므로 이미 정렬된 상태이다.
        if (left < right) {

            // 현재 범위를 절반으로 나눈다.
            int mid = left + (right - left) / 2;

            // 왼쪽 영역 정렬
            // [left ~ mid]
            mergeSort(arr, left, mid);

            // 오른쪽 영역 정렬
            // [mid + 1 ~ right]
            mergeSort(arr, mid + 1, right);

            // 정렬된 두 영역을 하나의 정렬된 영역으로 병합
            merge(arr, left, mid, right);
        }
    }

    /**
     * 두 개의 정렬된 배열 영역을 하나로 병합한다.
     *
     * 왼쪽 영역 : arr[left ~ mid]
     * 오른쪽 영역: arr[mid + 1 ~ right]
     */
    public static void merge(int[] arr, int left, int mid, int right) {

        // 정렬된 왼쪽 영역을 임시 배열로 복사
        int[] L = Arrays.copyOfRange(arr, left, mid + 1);

        // 정렬된 오른쪽 영역을 임시 배열로 복사
        int[] R = Arrays.copyOfRange(arr, mid + 1, right + 1);

        // i: 왼쪽 배열 L의 현재 위치
        // j: 오른쪽 배열 R의 현재 위치
        // k: 원본 배열 arr에서 값을 넣을 위치
        int i = 0;
        int j = 0;
        int k = left;

        int ll = L.length;
        int rl = R.length;

        /*
         * 두 배열의 가장 앞쪽 값을 비교하면서
         * 더 작은 값을 원본 배열에 넣는다.
         *
         * 예)
         * L = [1, 4, 8]
         * R = [2, 3, 7]
         *
         * 1 vs 2 → 1
         * 4 vs 2 → 2
         * 4 vs 3 → 3
         * ...
         */
        while (i < ll && j < rl) {

            if (L[i] <= R[j]) {
                arr[k] = L[i++];
            } else {
                arr[k] = R[j++];
            }

            k++;
        }

        /*
         * 오른쪽 배열을 모두 사용했다면
         * 왼쪽 배열에 남아 있는 값들을 그대로 추가한다.
         */
        while (i < ll) {
            arr[k++] = L[i++];
        }

        /*
         * 왼쪽 배열을 모두 사용했다면
         * 오른쪽 배열에 남아 있는 값들을 그대로 추가한다.
         */
        while (j < rl) {
            arr[k++] = R[j++];
        }
    }
}