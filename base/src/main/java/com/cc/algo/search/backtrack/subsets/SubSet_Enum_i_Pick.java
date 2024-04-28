package com.cc.algo.search.backtrack.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/TVdhkn/description/
 * 给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */

//站在 答案 的角度思考
//枚举第一个数 选谁。【选谁 也是对这个元素的 选或不选 操作  ---->回溯】
//枚举第二个数 选谁
//每个节点都是答案【由于子集的长度没有约束，每一个子集都可以是答案，每次递归都需要记录下答案】

//注意：【1，2】和 【2，1】是重复子集，
//      为了避免重复，下一个数应该大于当前选择的数


// 递归入口和边界 [0~n)

// 当前操作？枚举 一个 下标 j>=i 的数字， 加入 pick

// 子问题？ 从下标 >= i的数字中构造子集

// 下一个子问题？ 从下标 >= j+1 的数字中构造子集

// dfs(i) ---> dfs(i+1)
//        ---> dfs(i+2)
//        ---> dfs(i..+k)
//.       ---> dfs(n)
public class SubSet_Enum_i_Pick {
    int[] nums;
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> pick = new ArrayList();

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        dfs(0);
        return res;
    }

    public void dfs(int i) {
        res.add(new ArrayList<>(pick)); //固定答案
        // if(i == nums.length){
        //     return;
        // }
        for (int j = i; j < nums.length; j++) { //枚举选择的数字
            pick.add(nums[j]);
            dfs(j + 1);
            pick.remove(pick.size() - 1); //恢复现场
        }
    }
}
