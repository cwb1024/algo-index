package com.cc.algo.graph.MST;

import java.util.*;

public class MinimumSpanningTree {

    // Prim算法
    public static List<int[]> primMST(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        List<int[]> mst = new ArrayList<>();

        // 从顶点0开始构建最小生成树
        pq.offer(new int[]{0, 0}); // (顶点, 权值)

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int node = edge[0];
            int weight = edge[1];

            if (visited[node]) continue;
            visited[node] = true;
            if (weight > 0) mst.add(new int[]{node, weight});

            for (int i = 0; i < n; i++) {
                if (!visited[i] && graph[node][i] > 0) {
                    pq.offer(new int[]{i, graph[node][i]});
                }
            }
        }

        return mst;
    }

    // Kruskal算法
    public static List<int[]> kruskalMST(int[][] graph) {
        int n = graph.length;
        List<int[]> edges = new ArrayList<>();
        List<int[]> mst = new ArrayList<>();
        UnionFind uf = new UnionFind(n);

        // 构建边列表
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] > 0) {
                    edges.add(new int[]{i, j, graph[i][j]});
                }
            }
        }

        // 按权值排序边列表
        Collections.sort(edges, (a, b) -> a[2] - b[2]);

        // Kruskal算法
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], weight = edge[2];
            if (uf.find(u) != uf.find(v)) {
                mst.add(new int[]{u, v, weight});
                uf.union(u, v);
            }
        }

        return mst;
    }

    // 并查集
    static class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        System.out.println("Prim算法最小生成树：");
        List<int[]> primMST = primMST(graph);
        for (int[] edge : primMST) {
            System.out.println(edge[0] + " - " + edge[1] + " : " + edge[2]);
        }

        System.out.println("Kruskal算法最小生成树：");
        List<int[]> kruskalMST = kruskalMST(graph);
        for (int[] edge : kruskalMST) {
            System.out.println(edge[0] + " - " + edge[1] + " : " + edge[2]);
        }
    }
}

