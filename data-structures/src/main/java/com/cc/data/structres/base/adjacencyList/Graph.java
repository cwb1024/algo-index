package com.cc.data.structres.base.adjacencyList;

public class Graph {
    int numVertices; // 图的顶点数
    GraphNode[] adjList; // 邻接表数组

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjList = new GraphNode[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new GraphNode(i); // 初始化每个顶点的链表
        }
    }

    // 添加边
    public void addEdge(int src, int dest) {
        adjList[src].neighbors.add(dest); // 在src的链表中添加dest作为邻接顶点
        adjList[dest].neighbors.add(src); // 无向图需要将dest添加到src的链表中
    }

    // 打印邻接表
    public void printAdjList() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + " neighbors: ");
            for (int neighbor : adjList[i].neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 创建一个包含5个顶点的无向图
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // 打印邻接表
        graph.printAdjList();
    }
}
