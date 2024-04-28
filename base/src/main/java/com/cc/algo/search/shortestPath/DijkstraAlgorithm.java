package com.cc.algo.search.shortestPath;

import java.util.*;

public class DijkstraAlgorithm {

    public static int[] dijkstra(int[][] graph, int src) {
        int n = graph.length;
        int[] dist = new int[n]; // 存储从源节点到每个节点的最短距离
        boolean[] visited = new boolean[n]; // 记录节点是否已访问

        Arrays.fill(dist, Integer.MAX_VALUE); // 初始化距离为无穷大
        dist[src] = 0; // 源节点到自身的距离为0

        for (int count = 0; count < n - 1; count++) {
            int u = minDistance(dist, visited); // 从尚未访问的节点中选择距离最短的节点
            visited[u] = true; // 将该节点标记为已访问

            // 更新源节点到所有未访问节点的距离
            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        return dist;
    }

    // 从尚未访问的节点中选择距离最短的节点
    private static int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
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

        int[] shortestDistances = dijkstra(graph, src);

        System.out.println("最短距离从节点 " + src + " 到其他节点：");
        for (int i = 0; i < shortestDistances.length; i++) {
            System.out.println("节点 " + i + ": " + shortestDistances[i]);
        }
    }
}

