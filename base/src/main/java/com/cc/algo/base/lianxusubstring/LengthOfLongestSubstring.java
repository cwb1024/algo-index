package com.cc.algo.base.lianxusubstring;

import java.util.HashMap;

//滑动窗口：连续字串枚举+hash统计判断边界条件+移动left解除冲突，更新有效过程的max

// https://leetcode.cn/problems/longest-substring-without-repeating-characters

// === 【思路】 ==

// 结果状态集合，如果继续枚举的值，不会出现有效状态，是单调的，在边界处停止，逆向缩减尝试。
//
//枚举字符+hash统计判断边界条件+继续扩展right当前状态无效，扩大过程更无效。移动left解除冲突，统计有效状态的max

//解题方法

//一个一个枚举字符，从左到右，对于每一个字符，判断它的有效性，有没有跟之前出现的字符冲突（重复出现，如果有冲突，就移动左边的指针，直到不冲突，并且计算max(right - left +1）
//
//利用hash表，存储下经过的字符，枚举到一个字符的时候，从hash表中O(1)查找下遇到过没有，直到打破非有效状态（冲突）
//

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();

        int ans = 0;
        int l = 0;
        int r = 0;
        int n = arr.length;

        HashMap<Character, Integer> hash = new HashMap<>();

        for (; r < n; r++) {
            while (hash.get(arr[r]) != null && hash.get(arr[r]) == 1) {
                hash.put(arr[l++], 0);
            }
            ans = Math.max(ans, r - l + 1);
            hash.put(arr[r], 1);
        }
        return ans;
    }
}

