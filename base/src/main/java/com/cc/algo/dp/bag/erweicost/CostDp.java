package com.cc.algo.dp.bag.erweicost;

public class CostDp {

    int N;
    int[][] f;
    int[] v;
    int[] w;

    int[] cost;

    void init(int n, int m, int costN) {
        N = n + 1;
        v = new int[N];
        w = new int[N];
        f = new int[m + 1][costN + 1];
    }

    void dp(int n, int m, int costN) {
        init(n, m, costN);
        for (int i = 0; i < n; i++) {
            int a = 0;
            int b = 0;
            int c = 0;
            for (int j = m; j >= a; j--) {
                for (int k = costN; k >= b; k--) {
                    f[j][k] = Math.max(f[j][k], f[j - a][k - b] + c);
                }
            }
        }

        int ans = f[m][costN];
    }
}
