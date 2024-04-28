package com.cc.data.structres.base.adjacencyList;

import java.util.LinkedList;

public class AdjacencyList {
    private int V; // 图的顶点数
    private LinkedList<Integer>[] adj; // 邻接表数组

    // 构造函数，初始化邻接表
    public AdjacencyList(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // 添加边
    public void addEdge(int u, int v) {
        adj[u].add(v); // 将v添加到u的邻接表中
        adj[v].add(u); // 将u添加到v的邻接表中
    }

    // 打印邻接表
    public void printAdjacencyList() {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (int neighbor : adj[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 5; // 图的顶点数
        AdjacencyList graph = new AdjacencyList(V);

        // 添加边
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // 打印邻接表
        graph.printAdjacencyList();
    }
}

