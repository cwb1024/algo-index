package com.cc.algo.search.shortestPath;

import java.util.*;

public class BellmanFordAlgorithm {

    public static int[] bellmanFord(int[][] graph, int src) {
        int n = graph.length;
        int[] dist = new int[n]; // 存储从源节点到每个节点的最短距离

        // 初始化距离数组
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // 进行n-1次松弛操作
        for (int i = 0; i < n - 1; i++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    if (graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }

        // 检查是否存在负权环
        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    System.out.println("图中存在负权环");
                    return null;
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        int src = 0;

        int[] shortestDistances = bellmanFord(graph, src);

        System.out.println("最短距离从节点 " + src + " 到其他节点：");
        for (int i = 0; i < shortestDistances.length; i++) {
            System.out.println("节点 " + i + ": " + shortestDistances[i]);
        }
    }
}

