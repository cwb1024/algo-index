package com.cc.algo.dp.bag.group;

public class GroupHuChiBag {

    //f[j] : 容量为j的情况下，最大的重量
    // N <= 100
    void dp() {
        int n = 100;
        int m = 1000;
        int f[] = new int[n + 1];
        int v[] = new int[n + 1];
        int w[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            //init 每组中的物品体积和重量
            int s = 5; //这里简单模拟下，每组5个
//            cin >> s; // init过程
//            for (int j = 0; j < s; j++) {
//                cin >> v[j] >> w[j];
//            }
            for (int j = m; j >= 0; j--) {
                //枚举互斥决策
                for (int k = 0; k < s; k++) {
                    f[j] = Math.max(f[j], f[j - v[k]] + w[k]);
                }
            }
        }
        int ans = f[m];
    }
}
