package com.cc.algo.base.sort;

import java.util.Arrays;

public class QuickSort {

    private static final int[] nums = {2, 4, 6, 8, 1, 3, 5, 7};

    public static void main(String[] args) {
        QuickSort process = new QuickSort();

        process.quick_sort(nums);

        System.out.println(Arrays.toString(nums));
    }

    void quick_sort(int[] nums) {
        dfs(nums, 0, nums.length - 1);
    }

    void dfs(int[] arr, int l, int r) {
        if (l >= r) return;

        int i = l - 1;
        int j = r + 1;
        int x = arr[l + r >> 1];
        while (i < j) {
            do i++; while (arr[i] < x);
            do j--; while (arr[j] > x);
            if (i < j) swap(arr, i, j);
        }
        dfs(arr, l, j);
        dfs(arr, j + 1, r);
    }

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
