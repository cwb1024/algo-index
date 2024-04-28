package com.cc.data.structres.segmentTree;

public class SegmentTree {
    int[] tree;
    int size;

    public SegmentTree(int[] nums) {
        this.size = nums.length;
        this.tree = new int[4 * size];
        buildTree(nums, 0, 0, size - 1);
    }

    private void buildTree(int[] nums, int index, int left, int right) {
        if (left == right) {
            tree[index] = nums[left];
            return;
        }
        int mid = left + (right - left) / 2;
        buildTree(nums, 2 * index + 1, left, mid);
        buildTree(nums, 2 * index + 2, mid + 1, right);
        tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
    }

    public void update(int index, int val) {
        updateHelper(0, 0, size - 1, index, val);
    }

    private void updateHelper(int treeIndex, int left, int right, int index, int val) {
        if (left == right) {
            tree[treeIndex] = val;
            return;
        }
        int mid = left + (right - left) / 2;
        if (index <= mid) {
            updateHelper(2 * treeIndex + 1, left, mid, index, val);
        } else {
            updateHelper(2 * treeIndex + 2, mid + 1, right, index, val);
        }
        tree[treeIndex] = tree[2 * treeIndex + 1] + tree[2 * treeIndex + 2];
    }

    public int queryRange(int left, int right) {
        return queryHelper(0, 0, size - 1, left, right);
    }

    private int queryHelper(int treeIndex, int left, int right, int queryLeft, int queryRight) {
        if (left > queryRight || right < queryLeft) {
            return 0; // 节点区间与查询区间无交集
        }
        if (left >= queryLeft && right <= queryRight) {
            return tree[treeIndex]; // 节点区间完全包含在查询区间内
        }
        int mid = left + (right - left) / 2;
        int leftSum = queryHelper(2 * treeIndex + 1, left, mid, queryLeft, queryRight);
        int rightSum = queryHelper(2 * treeIndex + 2, mid + 1, right, queryLeft, queryRight);
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};
        SegmentTree segmentTree = new SegmentTree(nums);
        System.out.println(segmentTree.queryRange(0, 2)); // 输出：9
        segmentTree.update(1, 2);
        System.out.println(segmentTree.queryRange(0, 2)); // 输出：8
    }
}

