package com.cc.data.structres.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class QueueMapping {
    public static void main(String[] args) {
        System.out.println("[queue ==> LinkedList]");
        System.out.println("LinkedList Swap queue Mapping , peek() == peek() , poll() == poll() , add() == add() ");
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        for (Integer i : queue) {
            System.out.println("[存储完成 for遍历] queue add i [1,3] , queue for i = " + i);
        }
        while (!queue.isEmpty()) {
            Integer top = queue.peek();
            Integer poll = queue.poll();
            System.out.println("LinkedList peek = " + top + " , LinkedList poll = " + poll);
        }

        /**
         * 二进制拆分一种物品，线性时间复杂度优化为logk的时间复杂度，常熟级别的 这个数值不会超过20，完成2kw到20的优化
         */
        int n = 10;
        int m = 100;
        List<Goods> goods = new ArrayList<Goods>();

        /**
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
        for (int i = 0; i < n; i++) {
            int v = 3, w = 2, s = 10;

            //二进制拆分
            for (int k = 1; k <= s; k *= 2) {
                s -= k;
                goods.add(new Goods(k * v, k * w));
            }
            if (s > 0) {
                goods.add(new Goods(s * v, s * w));
            }
        }

        int[] f = new int[n];
        //01背包
        for (Goods good : goods) {
            for (int j = m; j >= good.w; j--) {
                f[j] = Math.max(f[j], f[j - good.v] + good.w);
            }
        }
        int ans = f[m];
    }

    static class Goods {
        int v;
        int w;

        public Goods(int vv, int ww) {

        }
    }
}
