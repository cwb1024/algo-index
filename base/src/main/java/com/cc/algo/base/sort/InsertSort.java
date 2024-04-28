package com.cc.algo.base.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    private static final int[] nums = {2, 4, 6, 8, 1, 3, 5, 7};

    public static void main(String[] args) {
        InsertSort process = new InsertSort();

        process.insert_sort(nums);

        System.out.println(Arrays.toString(nums));
    }

    void insert_sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
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
