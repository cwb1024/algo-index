package com.cc.algo.dp.bag.hunhe;

import java.util.ArrayList;
import java.util.List;

public class HunheBagDp {

    static class Thing {
        int v;
        int w;
        int kind;

        public Thing(int _kind, int _v, int _w) {
            kind = _kind;
            v = _v;
            w = _w;
        }
    }

    int N;
    int[] w;
    int[] v;
    int[] f;

    List<Thing> things = new ArrayList<>();

    void init(int n) {
        N = n + 10;
        w = new int[n];
        v = new int[n];
        f = new int[N];
    }

    void dp(int n, int m) {
        init(n);

        for (int i = 1; i < n; i++) {

            int kind = 0;
            int v = 0;
            int w = 0;

            //01bag
            if (kind < 0) things.add(new Thing(-1, v, w));
                //all_bag
            else if (kind == 0) things.add(new Thing(0, v, w));
                //duochong_bag
            else {
                int s = 5;
                for (int k = 1; k <= s; k *= 2) {
                    s -= k;
                    things.add(new Thing(0, v, w));
                }
            }
        }

        for (Thing thing : things) {
            if (thing.kind < 0) {//01bag
                for (int j = m; j >= thing.v; j--) {
                    f[j] = Math.max(f[j], f[j - thing.v] + thing.w);
                }
            } else {//完全背包
                for (int j = thing.v; j <= m; j++) {
                    f[j] = Math.max(f[j], f[j - thing.v] + thing.w);
                }
            }
        }

        int ans = f[m];
    }

}
