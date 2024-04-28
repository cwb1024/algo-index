package com.cc.data.structres.binaryIndexedTree;

public class BinaryIndexedTree {
    int[] BITree;
    int[] nums;
    int size;

    public BinaryIndexedTree(int[] nums) {
        this.size = nums.length;
        this.BITree = new int[size + 1];
        this.nums = new int[size];
        for (int i = 0; i < size; i++) {
            update(i, nums[i]);
        }
    }

    // 更新数组中 index 位置的元素值
    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        index++;
        while (index <= size) {
            BITree[index] += diff;
            index += index & (-index); // 更新下一个节点的索引
        }
    }

    // 查询数组中 0 到 index 区间的元素和
    public int query(int index) {
        int sum = 0;
        index++;
        while (index > 0) {
            sum += BITree[index];
            index -= index & (-index); // 更新上一个节点的索引
        }
        return sum;
    }

    // 查询数组中 [left, right] 区间的元素和
    public int queryRange(int left, int right) {
        return query(right) - query(left - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};
        BinaryIndexedTree bit = new BinaryIndexedTree(nums);
        System.out.println(bit.queryRange(0, 2)); // 输出：9
        bit.update(1, 2);
        System.out.println(bit.queryRange(0, 2)); // 输出：8
    }
}

