package com.cc.algo.dp.bag.zone;

public class ZeroToOneBagDp {

    //int N = 100;
    //int[] f; // 状态集合，前i个物品选或不选，max重量｜价值
    //int[] v; // 体积
    //int[] w; // 重量

    void init(int n, int[] v, int[] w) {
        for (int i = 1; i < n + 1; i++) {
            v[i] = i; //物品i的价值
            w[i] = i; //物品i的体积
        }
    }



    void dp(int n, int m) {// n:物品个数，m:背包剩余容量
        int[] v = new int[n + 1], w = new int[n + 1];
        int[] f = new int[m + 1];
        init(n, v, w);
        for (int i = 1; i < n + 1; i++) {
            for (int j = m; j >= v[i]; j--) {//01-bag
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }
        int ans = f[m];
    }

}
