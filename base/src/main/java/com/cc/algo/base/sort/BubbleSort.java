package com.cc.algo.base.sort;

import java.util.Arrays;

public class BubbleSort {
    private static final int[] nums = {2, 4, 6, 8, 1, 3, 5, 7};

    public static void main(String[] args) {
        BubbleSort process = new BubbleSort();

        process.bubble_sort(nums);

        System.out.println(Arrays.toString(nums));
    }

    void bubble_sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
