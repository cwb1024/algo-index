package com.cc.algo.search.heuristic.idAStar;

import java.util.*;

public class IDAStar {
    // 定义地图大小和起始、目标节点
    static int ROW = 5;
    static int COL = 5;
    static int[][] grid = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0}
    };
    static Node startNode = new Node(0, 0);
    static Node targetNode = new Node(4, 4);

    // 定义方向
    static int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    // 计算启发函数 h(n)：曼哈顿距离
    static int heuristic(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    // IDA* 算法
    static boolean idaStar() {
        int bound = heuristic(startNode, targetNode);
        Set<Node> visited = new HashSet<>();
        while (true) {
            int minCost = search(startNode, 0, bound, visited);
            if (minCost == Integer.MAX_VALUE) {
                return false; // 未找到路径
            }
            if (minCost == 0) {
                return true; // 找到路径
            }
            bound = minCost;
        }
    }

    // 深度优先搜索
    static int search(Node node, int g, int bound, Set<Node> visited) {
        int f = g + heuristic(node, targetNode);
        if (f > bound) {
            return f;
        }
        if (node.x == targetNode.x && node.y == targetNode.y) {
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        visited.add(node);
        for (int[] dir : dirs) {
            int newX = node.x + dir[0];
            int newY = node.y + dir[1];
            if (newX >= 0 && newX < ROW && newY >= 0 && newY < COL && grid[newX][newY] == 0) {
                Node nextNode = new Node(newX, newY);
                if (!visited.contains(nextNode)) {
                    int cost = search(nextNode, g + 1, bound, visited);
                    if (cost == 0) {
                        return 0;
                    }
                    if (cost < minCost) {
                        minCost = cost;
                    }
                }
            }
        }
        visited.remove(node);
        return minCost;
    }

    public static void main(String[] args) {
        boolean found = idaStar();
        if (found) {
            System.out.println("Path found");
        } else {
            System.out.println("Path not found");
        }
    }
}
