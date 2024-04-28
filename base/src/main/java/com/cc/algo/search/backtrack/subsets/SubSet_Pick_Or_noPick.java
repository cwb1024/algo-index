package com.cc.algo.search.backtrack.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/TVdhkn/description/
 * <p>
 * <p>
 * // 子集：子集型回溯，“选择不选” 和 “枚举选哪个”
 * <p>
 * //生成子集的思考方式：
 * // ===========【从 “输入” 的角度】=====================
 * // 递归入口和入口：枚举范围从 i [ 0 ~ n)
 * <p>
 * // 当前操作？：每一层要做的事情，这个元素，选择 或者 不选择
 * <p>
 * // 子问题： 下标 >= i层 “选择” 或 “不选择”,构造子集
 * <p>
 * // 下一个子问题：下标 >= i+1 层 “选择” 或 “不选择”，构造子集
 */
public class SubSet_Pick_Or_noPick {
    int[] nums;
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> pick = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        dfs(0);
        return res;
    }

    public void dfs(int i) {
        if (i == nums.length) {
            //有效结果
            //全局变量拷贝为每个有效答案，形成结果
            ArrayList<Integer> copy = new ArrayList<>();
            copy.addAll(pick);
            res.add(copy);
            return;
        }

        //“不选”
        dfs(i + 1);

        //“选择”
        int x = nums[i];
        pick.add(x);
        dfs(i + 1);
        //"恢复递归前的样子"
        pick.remove(pick.size() - 1);
    }

    public void dfs_1(int i){
        if(i == nums.length){
            //有效结果
            ArrayList<Integer> copy = new ArrayList<>();
            copy.addAll(pick);
            res.add(copy);
            return;
        }
        //“选择”
        int x = nums[i];
        pick.add(x);
        dfs_1(i+1);

        //“不选”
        pick.remove(pick.size()-1);
        dfs_1(i+1);
    }
}
