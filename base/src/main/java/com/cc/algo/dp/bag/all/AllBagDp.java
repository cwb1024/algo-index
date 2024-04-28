package com.cc.algo.dp.bag.all;

public class AllBagDp {

    int N;
    int[] f; // 状态集合，前i个物品选或不选，max重量｜价值
    int[] v; // 体积
    int[] w; // 重量

    void init(int n, int m) {
        N = n + 1;
        v = new int[N];
        w = new int[N];
        f = new int[m + 1];
    }

    void dp(int n, int m) {
        init(n, m);

        for (int i = 1; i < N; i++) {
            for (int j = v[i]; j <= m; j++) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }
        int ans = f[m];
    }
}
