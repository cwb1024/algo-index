package com.cc.algo.base.lianxusubstring;

//滑动窗口：连续子数组，正数累加累积，无限变大，单调性

// https://leetcode.cn/problems/minimum-size-subarray-sum

// === [分析过程] ===
// 正数，具有累加性，无限变大，单调的，局部最优，结果最优，不曲折

// 解决数组问题，一般上来一定是 枚举，无非是 从左到右，或者从右到左

// 探索尝试求和，利用正数累加、累减 单调性的特点，枚举所有的结果集，求min

// left 、 right 、 ans 、 sum

// 求最小， ans 初始化为 最大 不干扰 答案

// 更新答案的时机：右边枚举，一旦出现 超过target，left++，并且更新ans，直到不满足超过

// 枚举的每一步，需要做什么？ 需要求和，达到超过target条件后，进行 单调累减，缩减ans.length min

//可能没有答案的情况？ ans 始终没有得到更新，一直处于枚举得到 >= target的过层

public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int sum = 0;
        int ans = n + 1;//INF
        for (; r < n; r++) {
            sum += nums[r];
            //如果不断的右移动left，还是满足 结果状态，那么就放心的右移动，直到最后一次尝试不满足，那么就不尝试右移动
            while (sum - nums[l] >= target) {
                sum -= nums[l];
                l += 1;
            }
            //left右移动边界，最后满足的位置，统计下 min 答案
            if (sum >= target) {
                ans = Math.min(ans, r - l + 1);
            }
        }
        return ans <= n ? ans : 0;
    }

    public int minSubArrayLen1(int target, int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int sum = 0;
        int ans = n + 1;//INF
        for (; r < n; r++) {
            sum += nums[r];
            //如果累加的过程中，出现了 结果状态，进去 更新答案 并且 右移动 left，更新了多次，直到不满足，跳出
            while (sum >= target) {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l++];
            }
        }
        return ans <= n ? ans : 0;
    }
}

