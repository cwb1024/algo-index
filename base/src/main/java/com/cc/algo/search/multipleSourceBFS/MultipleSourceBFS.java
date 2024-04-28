package com.cc.algo.search.multipleSourceBFS;

import java.util.*;

public class MultipleSourceBFS {
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

        // 多源广度优先搜索
        List<Integer> multipleSourceBFS(List<Integer> sources) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[V];
            List<Integer> shortestPaths = new ArrayList<>();

            for (int source : sources) {
                visited[source] = true;
                queue.offer(source);
            }

            while (!queue.isEmpty()) {
                int current = queue.poll();
                shortestPaths.add(current);

                for (int neighbor : adj[current]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }

            return shortestPaths;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);

        List<Integer> sources = Arrays.asList(0, 1); // 设置起始节点
        List<Integer> shortestPaths = graph.multipleSourceBFS(sources);

        System.out.println("Shortest paths from sources: " + shortestPaths);
    }
}

