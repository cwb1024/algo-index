package com.cc.algo.search.binary;

public class Binary_search {

    private static final int[] nums = {1, 2, 3, 4, 5, 6, 7};

    public static void main(String[] args) {
        Binary_search process = new Binary_search();

        int target = -1;

        target = process.binary_search_left(nums, 2);
        System.out.println(target);

        target = process.binary_search_right(nums, 2);
        System.out.println(target);
    }

    int binary_search_left(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

    int binary_search_right(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1; // +1
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1; // r-1
            }
        }
        return nums[l];
    }
}
