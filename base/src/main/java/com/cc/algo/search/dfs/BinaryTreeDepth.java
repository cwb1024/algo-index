package com.cc.algo.search.dfs;


/**
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
 * 讲述看到这一题的思路
 * 递归：自顶向下，每一层把当前层的长度传下去，边界为子节点为空，max路径最大值
 */
public class BinaryTreeDepth {
    //【自顶向下】
    int res = 0; //结果
    int path = 0; //子问题结算时，拷贝每一层的迭代变量

    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    void dfs(TreeNode root, int path_level_Length) {
        if (root == null) {
            path = path_level_Length;
            res = Math.max(res, path_level_Length);
            return;
        }
        path_level_Length++;
        dfs(root.left, path_level_Length);
        dfs(root.right, path_level_Length);
    }
}
