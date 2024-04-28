package com.cc.algo.base.sort;

import java.util.Arrays;

public class MergeSort {

    private static final int[] nums = {2, 4, 6, 8, 1, 3, 5, 7};

    public static void main(String[] args) {
        MergeSort process = new MergeSort();

        process.merge_sort(nums);

        System.out.println(Arrays.toString(nums));
    }

    void merge_sort(int[] nums) {
        dfs(nums, 0, nums.length - 1);
    }

    public void dfs(int[] arr, int l, int r) {
        if (l >= r) return;

        int mid = l + r >> 1;
        dfs(arr, l, mid);
        dfs(arr, mid + 1, r);
        int[] tmp = new int[r - l + 1];
        int i = l, j = mid + 1, t = 0;
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }
        while (i <= mid) tmp[t++] = arr[i++];
        while (j <= r) tmp[t++] = arr[j++];
        for (i = l, t = 0; i <= r; i++, t++) {
            arr[i] = tmp[t];
        }
    }
}
