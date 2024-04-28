package com.cc.algo.search.dfs;

/**
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
 * 讲述看到这一题的思路
 * <p>
 * 递归：自底向上，每一层考虑左右子树深度最大值，返回结果时+1（当前节点长度为1）
 */
public class BinaryTreeDepth1 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l, r) + 1;
    }
}
