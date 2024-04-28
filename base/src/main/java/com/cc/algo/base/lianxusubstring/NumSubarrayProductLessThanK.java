package com.cc.algo.base.lianxusubstring;

/**
 * # 思路
 * <p>
 * > 结果状态集合，如果继续枚举的值，不会出现有效状态，是单调的，在边界处停止，逆向缩减尝试。
 * <p>
 * <p>
 * > 连续子串，单调性求和、单调性求积 逼近k 。
 * <p>
 * <p>
 * > 枚举当前值拼上去，判断出现非有效状态，继续尝试只会增大无效，这种状态不会出现在有效结果集合中，逆向【无效尝试有效】
 * <p>
 * <p>
 * > 求和-->减去nums[left++]或求积-->除去nums[left++]，更新答案，累加 当前值1 或者 每个连续子串[r-l+1] 子串 转换为数组 ， 双指针遍历尝试 ，滑动窗口 枚举每一个当前值，
 * <p>
 * <p>
 * > 求累积，反着来如果不满足有效，积相除left，然后left++，直到有效退出移动left 更新答案，当前枚举值，拼上去长区间有效 [l,r],简单推一下，[l+1,r]...[r,r] 都是有效的 更新答案的长度，应该增加 r-l+1， 而不是仅仅增加 当前枚举值的1
 */

/**
 * # 解题方法
 * > left、 right、val、ans
 * > （val>=k）非法条件，然后变得有效val nums[l++]
 * > 更新答案ans，统计有效结果
 * > 加多少？ r - l + 1 (上面思路中推出来的)
 */
public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int n = nums.length;
        int l = 0;
        int r = 0;
        int val = 1;
        int ans = 0;
        for (; r < n; r++) {
            val *= nums[r];
            while (val >= k) {//不满足要求
                val /= nums[l++];
            }

            //有效答案，例如[10,5]=>[10][5],枚举到5，需要计算的是以5为右端点，满足要求的子数组的个数
            //[l,r]有效状态,都是有效状态 [l+1,r]...[r,r]
            //子数组个数 = r - l +1
            ans += r - l + 1;
        }
        return ans;
    }
}
