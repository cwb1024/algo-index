package com.cc.algo.search.bidirectionalDFS;

import java.util.*;

public class BidirectionalDFS {
    static class Graph {
        int V; // 图的顶点数
        LinkedList<Integer>[] adj; // 邻接表表示图

        public Graph(int V) {
            this.V = V;
            adj = new LinkedList[V];
            for (int i = 0; i < V; ++i) {
                adj[i] = new LinkedList();
            }
        }

        // 添加边
        void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }

        // 双向DFS
        boolean bidirectionalDFS(int start, int end) {
            Set<Integer> startVisited = new HashSet<>(); // 记录起点已访问的节点
            Set<Integer> endVisited = new HashSet<>(); // 记录终点已访问的节点
            Stack<Integer> startStack = new Stack<>(); // 起点搜索栈
            Stack<Integer> endStack = new Stack<>(); // 终点搜索栈

            startStack.push(start);
            endStack.push(end);

            while (!startStack.isEmpty() && !endStack.isEmpty()) {
                if (extendFromStart(startVisited, startStack, endVisited)) {
                    return true; // 从起点扩展搜索路径找到路径
                }
                if (extendFromEnd(endVisited, endStack, startVisited)) {
                    return true; // 从终点扩展搜索路径找到路径
                }
            }

            return false; // 未找到路径
        }

        // 从起点扩展搜索路径
        boolean extendFromStart(Set<Integer> startVisited, Stack<Integer> startStack, Set<Integer> endVisited) {
            int currentNode = startStack.pop();
            if (endVisited.contains(currentNode)) { // 如果起点搜索到了终点已访问的节点，说明找到路径
                return true;
            }
            startVisited.add(currentNode);
            for (int neighbor : adj[currentNode]) { // 扩展当前节点的邻居
                if (!startVisited.contains(neighbor)) {
                    startStack.push(neighbor);
                }
            }
            return false;
        }

        // 从终点扩展搜索路径
        boolean extendFromEnd(Set<Integer> endVisited, Stack<Integer> endStack, Set<Integer> startVisited) {
            int currentNode = endStack.pop();
            if (startVisited.contains(currentNode)) { // 如果终点搜索到了起点已访问的节点，说明找到路径
                return true;
            }
            endVisited.add(currentNode);
            for (int neighbor : adj[currentNode]) { // 扩展当前节点的邻居
                if (!endVisited.contains(neighbor)) {
                    endStack.push(neighbor);
                }
            }
            return false;
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        int start = 0, end = 3;
        if (g.bidirectionalDFS(start, end)) {
            System.out.println("There is a path between " + start + " and " + end);
        } else {
            System.out.println("There is no path between " + start + " and " + end);
        }
    }
}

