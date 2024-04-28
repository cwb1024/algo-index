package com.cc.algo.search.bfs;

import java.util.*;

public class BFS {
    static class Graph {
        int V; // 图的顶点数
        List<Integer>[] adj; // 邻接表表示图

        public Graph(int V) {
            this.V = V;
            adj = new ArrayList[V];
            for (int i = 0; i < V; ++i) {
                adj[i] = new ArrayList();
            }
        }

        // 添加边
        void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }

        // 广度优先搜索
        void BFS(int s) {
            boolean[] visited = new boolean[V]; // 用于标记顶点是否已经被访问过
            Queue<Integer> queue = new LinkedList<>(); // 用于保存待访问的顶点

            visited[s] = true;
            queue.offer(s);

            while (!queue.isEmpty()) {
                int current = queue.poll(); // 取出队首顶点
                System.out.print(current + " "); // 访问当前顶点

                // 遍历当前顶点的所有邻接顶点
                for (int neighbor : adj[current]) {
                    if (!visited[neighbor]) { // 如果邻接顶点未被访问过
                        visited[neighbor] = true; // 标记为已访问
                        queue.offer(neighbor); // 将邻接顶点加入队列
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7); // 创建一个包含7个顶点的图

        // 添加边
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);

        System.out.print("BFS traversal starting from vertex 0: ");
        graph.BFS(0); // 从顶点0开始进行广度优先搜索
    }
}

