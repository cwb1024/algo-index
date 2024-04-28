package com.cc.algo.base.diff;

public class Difference {
    int[] diff;

    public Difference(int[] nums) {
        int n = nums.length;
        diff = new int[n];
        diff[0] = nums[0];
        for (int i = 1; i < n; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    // 区间更新 [start, end] 区间增加 val
    public void increment(int start, int end, int val) {
        diff[start] += val;
        if (end + 1 < diff.length) {
            diff[end + 1] -= val;
        }
    }

    // 根据差分数组得到原始数组
    public int[] result() {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        Difference diff = new Difference(nums);
        diff.increment(0, 2, 2); // 区间 [0, 2] 增加 2
        int[] result = diff.result();
        for (int num : result) {
            System.out.print(num + " "); // 输出：3 5 7 7 9
        }
    }
}

