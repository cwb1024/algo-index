package com.cc.algo.base.prefixsum;

public class PrefixSum {
    int[] prefixSum;

    public PrefixSum(int[] nums) {
        int n = nums.length;
        prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
    }

    // 计算区间 [left, right] 的元素和
    public int rangeSum(int left, int right) {
        if (left == 0) {
            return prefixSum[right];
        }
        return prefixSum[right] - prefixSum[left - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        PrefixSum prefixSum = new PrefixSum(nums);
        System.out.println(prefixSum.rangeSum(1, 3)); // 输出：15
        System.out.println(prefixSum.rangeSum(0, 4)); // 输出：25
    }
}

