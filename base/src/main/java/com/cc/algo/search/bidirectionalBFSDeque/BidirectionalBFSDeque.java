package com.cc.algo.search.bidirectionalBFSDeque;

import java.util.*;

public class BidirectionalBFSDeque {
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

        // 双端队列BFS
        boolean bidirectionalBFS(int start, int end) {
            Set<Integer> startVisited = new HashSet<>(); // 记录起点已访问的节点
            Set<Integer> endVisited = new HashSet<>(); // 记录终点已访问的节点
            Deque<Integer> startQueue = new ArrayDeque<>(); // 起点搜索队列
            Deque<Integer> endQueue = new ArrayDeque<>(); // 终点搜索队列

            startQueue.offer(start);
            endQueue.offer(end);

            while (!startQueue.isEmpty() && !endQueue.isEmpty()) {
                if (extendFromStart(startVisited, startQueue, endVisited)) {
                    return true; // 从起点扩展搜索路径找到路径
                }
                if (extendFromEnd(endVisited, endQueue, startVisited)) {
                    return true; // 从终点扩展搜索路径找到路径
                }
            }

            return false; // 未找到路径
        }

        // 从起点扩展搜索路径
        boolean extendFromStart(Set<Integer> startVisited, Deque<Integer> startQueue, Set<Integer> endVisited) {
            int size = startQueue.size();
            for (int i = 0; i < size; i++) {
                int currentNode = startQueue.poll();
                if (endVisited.contains(currentNode)) { // 如果起点搜索到了终点已访问的节点，说明找到路径
                    return true;
                }
                startVisited.add(currentNode);
                for (int neighbor : adj[currentNode]) { // 扩展当前节点的邻居
                    if (!startVisited.contains(neighbor)) {
                        startQueue.offer(neighbor);
                    }
                }
            }
            return false;
        }

        // 从终点扩展搜索路径
        boolean extendFromEnd(Set<Integer> endVisited, Deque<Integer> endQueue, Set<Integer> startVisited) {
            int size = endQueue.size();
            for (int i = 0; i < size; i++) {
                int currentNode = endQueue.poll();
                if (startVisited.contains(currentNode)) { // 如果终点搜索到了起点已访问的节点，说明找到路径
                    return true;
                }
                endVisited.add(currentNode);
                for (int neighbor : adj[currentNode]) { // 扩展当前节点的邻居
                    if (!endVisited.contains(neighbor)) {
                        endQueue.offer(neighbor);
                    }
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
        if (g.bidirectionalBFS(start, end)) {
            System.out.println("There is a path between " + start + " and " + end);
        } else {
            System.out.println("There is no path between " + start + " and " + end);
        }
    }
}

