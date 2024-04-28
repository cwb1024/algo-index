package com.cc.algo.base.rmq;

public class RMQSegmentTree {
    int[] nums;
    int[] tree;

    public RMQSegmentTree(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        this.tree = new int[4 * n]; // 使用数组表示线段树
        buildTree(0, 0, n - 1);
    }

    private void buildTree(int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = nums[left];
            return;
        }
        int mid = left + (right - left) / 2;
        buildTree(2 * treeIndex + 1, left, mid);
        buildTree(2 * treeIndex + 2, mid + 1, right);
        tree[treeIndex] = Math.min(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
    }

    public int queryRange(int treeIndex, int left, int right, int queryLeft, int queryRight) {
        if (left > queryRight || right < queryLeft) {
            return Integer.MAX_VALUE; // 节点区间与查询区间无交集，返回最大值
        }
        if (left >= queryLeft && right <= queryRight) {
            return tree[treeIndex]; // 节点区间完全包含在查询区间内，返回节点值
        }
        int mid = left + (right - left) / 2;
        int leftMin = queryRange(2 * treeIndex + 1, left, mid, queryLeft, queryRight);
        int rightMin = queryRange(2 * treeIndex + 2, mid + 1, right, queryLeft, queryRight);
        return Math.min(leftMin, rightMin);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 7, 9, 11};
        RMQSegmentTree rmq = new RMQSegmentTree(nums);
        System.out.println(rmq.queryRange(0, 0, nums.length - 1, 1, 3)); // 输出：2
        System.out.println(rmq.queryRange(0, 0, nums.length - 1, 0, 5)); // 输出：1
    }
}

