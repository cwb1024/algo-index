package com.cc.algo.base.sort;

import java.util.Arrays;

public class SelectSort {

    private static final int[] nums = {2, 4, 6, 8, 1, 3, 5, 7};

    public static void main(String[] args) {
        SelectSort process = new SelectSort();

        process.select_sort(nums);

        System.out.println(Arrays.toString(nums));
    }

    void select_sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            swap(arr, i, min);
        }
    }

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
