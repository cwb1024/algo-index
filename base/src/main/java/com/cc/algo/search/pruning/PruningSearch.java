package com.cc.algo.search.pruning;

import java.util.*;

public class PruningSearch {

    // 示例问题：在给定的数组中查找是否存在指定的目标值
    static boolean pruningSearch(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }

    // 深度优先搜索（DFS）函数
    static boolean dfs(int[] nums, int target, int index, int sum) {
        // 剪枝条件：当前和已经超过目标值
        if (sum > target) {
            return false;
        }
        // 剪枝条件：当前和等于目标值
        if (sum == target) {
            return true;
        }
        // 剪枝条件：已经搜索完所有元素
        if (index == nums.length) {
            return false;
        }

        // 在当前位置不选择当前元素的情况下进行搜索
        if (dfs(nums, target, index + 1, sum)) {
            return true;
        }

        // 在当前位置选择当前元素的情况下进行搜索
        if (dfs(nums, target, index + 1, sum + nums[index])) {
            return true;
        }

        // 如果上述两种情况都没有找到目标值，则返回 false
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 9;
        boolean found = pruningSearch(nums, target);
        if (found) {
            System.out.println("Found target");
        } else {
            System.out.println("Target not found");
        }
    }
}

