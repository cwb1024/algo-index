package com.cc.algo.graph.DAG;

import java.util.*;

public class TopologicalSort {
    // 使用邻接表表示有向图
    private Map<Integer, List<Integer>> graph;
    private int numVertices;

    public TopologicalSort(int numVertices) {
        this.numVertices = numVertices;
        graph = new HashMap<>();
        for (int i = 0; i < numVertices; i++) {
            graph.put(i, new ArrayList<>());
        }
    }

    // 添加有向边
    public void addEdge(int src, int dest) {
        if (!graph.containsKey(src) || !graph.containsKey(dest)) {
            throw new IllegalArgumentException("Vertex does not exist");
        }
        graph.get(src).add(dest);
    }

    // 拓扑排序
    public List<Integer> topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numVertices];

        // 将所有顶点按深度优先搜索的顺序压栈
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }

        // 将栈中的元素逆序，得到拓扑排序的顺序
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    // 深度优先搜索，将顶点按深度优先遍历的顺序压栈
    private void dfs(int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack);
            }
        }
        stack.push(vertex);
    }

    public static void main(String[] args) {
        TopologicalSort graph = new TopologicalSort(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        List<Integer> result = graph.topologicalSort();
        System.out.println("Topological sorting order: " + result);
    }
}

