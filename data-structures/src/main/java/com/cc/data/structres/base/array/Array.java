package com.cc.data.structres.base.array;

public class Array {

    private static final int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};

    private static final int[] target = new int[8];

    public static void main(String[] args) {
        Array process = new Array();
        process.buildArray();
    }

    void buildArray() {
        dfs(0);
        for (int i = 0; i < target.length; i++) {
            System.out.print(target[i] + ",");
        }
    }

    void dfs(int i) {
        if (i == nums.length) {
            return;
        }
        target[i] = nums[i];
        dfs(i + 1);
    }
}
