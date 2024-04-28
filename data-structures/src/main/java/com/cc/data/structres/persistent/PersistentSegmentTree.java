package com.cc.data.structres.persistent;

public class PersistentSegmentTree {
    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }

    Node[] versions; // 保存每个版本的根节点
    int[] nums; // 初始数组

    public PersistentSegmentTree(int[] nums) {
        this.nums = nums;
        versions = new Node[nums.length];
        build(0, nums.length - 1, 0);
    }

    private void build(int left, int right, int version) {
        if (left == right) {
            versions[version] = new Node(nums[left]);
            return;
        }
        int mid = left + (right - left) / 2;
        build(left, mid, 2 * version + 1);
        build(mid + 1, right, 2 * version + 2);
        versions[version] = new Node(merge(versions[2 * version + 1], versions[2 * version + 2]));
    }

    private int merge(Node left, Node right) {
        if (left == null) return right.val;
        if (right == null) return left.val;
        return left.val + right.val;
    }

    // 查询某个版本的区间和
    public int query(int version, int queryLeft, int queryRight) {
        return query(versions[version], 0, nums.length - 1, queryLeft, queryRight);
    }

    private int query(Node node, int left, int right, int queryLeft, int queryRight) {
        if (node == null || left > queryRight || right < queryLeft) {
            return 0;
        }
        if (left >= queryLeft && right <= queryRight) {
            return node.val;
        }
        int mid = left + (right - left) / 2;
        return query(node.left, left, mid, queryLeft, queryRight) +
                query(node.right, mid + 1, right, queryLeft, queryRight);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        PersistentSegmentTree pst = new PersistentSegmentTree(nums);

        // 第一个版本的查询
        System.out.println(pst.query(0, 0, 2)); // 输出：9

        // 修改数据，创建新版本
        nums[2] = 6;
        pst = new PersistentSegmentTree(nums);

        // 第二个版本的查询
        System.out.println(pst.query(0, 0, 2)); // 输出：10
    }
}
