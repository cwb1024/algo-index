package com.cc.algo.dp.bag.duochong;

import java.util.ArrayList;
import java.util.List;

public class DuoChongBagDp {
    static class Good {
        int v; // 价值
        int w; // 体积/重量

        public Good(int vv, int ww) {
            v = vv;
            w = ww;
        }
    }

    void DuoChongBagDp_k_i_01bag() {
        int n = 10; // 物品个数
        int m = 100; // 背包容量
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            // 这里简单模拟下，可以不一致
            int v = 3; // 价值
            int w = 2; // 重量/体积
            int s = 10; // 第i种物品，能够选的有效个
            //这不能用正序，正序的话选到后面你不知道选了多少个当前物品，只能重大到小，一次可以遍历完能放的物品总个数
            for (int j = m; j >= 0; j--) {
                for (int k = 1; k <= s && k * v >= j; k++) {
                    f[j] = Math.max(f[j], f[j - k * v] + w * v);
                }
            }
        }
        int ans = f[m];
    }

    void dp() {
        int n = 10; // 物品个数
        int m = 100; // 背包容量
        // 二进制拆分一种物品，线性时间复杂度优化为log(k)的时间复杂度，常熟级别的 这个数值不会超过20，完成2kw到20的优化
        /*
         *  只有数字一次或不用，可以加法组成小于等于10正整数
         *  10 = 1 + 2 + 4 + 3
         *  9  = 2 + 4 + 3
         *  8  = 1 + 4 + 3
         *  7  = 1 + 2 + 4
         *  6  = 2 + 4
         *  5  = 1 + 4
         *  4  = 4
         *  3  = 1 + 2
         *  2  = 2
         *  1  = 1
         */
        List<Good> goods = new ArrayList<Good>(); // 用来存储拆分完成后的物品个数
        for (int i = 0; i < n; i++) {
            // 这里简单模拟下，可以不一致
            int v = 3; // 价值
            int w = 2; // 重量/体积
            int s = 10; // 第i种物品，能够选的有效个

            ////二进制拆分过程，拆分s
            for (int k = 1; k <= s; k *= 2) {
                s -= k;
                goods.add(new Good(k * v, k * w));
            }
            if (s > 0) {
                goods.add(new Good(s * v, s * w));
            }
        }

        int[] f = new int[n];
        //01背包过程
        for (Good good : goods) {
            for (int j = m; j >= good.w; j--) {
                f[j] = Math.max(f[j], f[j - good.v] + good.w);
            }
        }
        int ans = f[m];
    }
}
