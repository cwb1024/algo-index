package com.cc.algo.graph.bipartiteGraph;

public class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // 用于标记顶点的颜色，0表示未染色，1表示染成红色，-1表示染成蓝色

        // 对每个未染色的顶点进行深度优先搜索
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !dfs(graph, colors, i, 1)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int[] colors, int node, int color) {
        colors[node] = color; // 染色
        for (int neighbor : graph[node]) {
            if (colors[neighbor] == color) {
                return false; // 如果相邻顶点颜色相同，则不是二分图
            }
            if (colors[neighbor] == 0 && !dfs(graph, colors, neighbor, -color)) {
                return false; // 递归染色相邻顶点
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BipartiteGraph bg = new BipartiteGraph();
        int[][] graph = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };
        System.out.println(bg.isBipartite(graph)); // Output: true
    }
}

