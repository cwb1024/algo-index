package com.cc.algo.base.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {

    private static final int[] nums = {2, 4, 6, 8, 1, 3, 5, 7};

    public static void main(String[] args) {
        HeapSort process = new HeapSort();

        process.heap_sort(nums);

        System.out.println(Arrays.toString(nums));
    }

    void heap_sort(int[] arr) {
        heapify(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            adjust_heap(arr, 0, i);
        }
    }

    void heapify(int[] arr) {
        for (int i = (arr.length >> 1) - 1; i >= 0; i--) {
            adjust_heap(arr, i, arr.length);
        }
    }

    void adjust_heap(int[] arr, int parent, int n) {
        int half = n >> 1;
        while (parent < half) {
            int child = (parent << 1) + 1;
            int right = child + 1;
            if (right < n && arr[child] < arr[right]) {
                child = right;
            }
            if (arr[child] > arr[parent]) {
                swap(arr, child, parent);
            } else {
                break;
            }
            parent = child;
        }
    }

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
