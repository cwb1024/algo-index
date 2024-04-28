package com.cc.algo.graph.SPFA;

import java.util.*;

public class SPFA {
    public boolean hasNegativeCycle(int[][] graph) {
        int n = graph.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // 假设起点为0

        Queue<Integer> queue = new LinkedList<>();
        boolean[] inQueue = new boolean[n];
        int[] count = new int[n]; // 记录每个顶点被松弛的次数

        queue.offer(0); // 将起点加入队列
        inQueue[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            inQueue[node] = false;

            for (int neighbor : graph[node]) {
                if (dist[node] + 1 < dist[neighbor]) { // 松弛操作
                    dist[neighbor] = dist[node] + 1;
                    if (!inQueue[neighbor]) {
                        queue.offer(neighbor);
                        inQueue[neighbor] = true;
                        count[neighbor]++;
                        if (count[neighbor] >= n) {
                            return true; // 存在负环
                        }
                    }
                }
            }
        }

        return false; // 不存在负环
    }

    public static void main(String[] args) {
        SPFA spfa = new SPFA();
        int[][] graph = {
                {1},
                {2},
                {0}
        };
        System.out.println(spfa.hasNegativeCycle(graph)); // Output: true
    }
}

