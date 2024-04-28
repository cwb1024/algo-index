package com.cc.algo.search.heuristic.astar;
import java.util.*;
public class AStar {
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

    // A* 算法
    static Node aStar() {
        PriorityQueue<Node> openSet = new PriorityQueue<>((a, b) -> Integer.compare(a.f, b.f));
        Set<Node> closedSet = new HashSet<>();
        openSet.add(startNode);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();
            if (current.x == targetNode.x && current.y == targetNode.y) {
                return current;
            }

            closedSet.add(current);

            for (int[] dir : dirs) {
                int newX = current.x + dir[0];
                int newY = current.y + dir[1];

                if (newX >= 0 && newX < ROW && newY >= 0 && newY < COL && grid[newX][newY] == 0) {
                    Node neighbor = new Node(newX, newY);
                    if (closedSet.contains(neighbor)) {
                        continue;
                    }

                    int tentativeGScore = current.g + 1; // 假设从当前节点到邻居节点的代价为 1
                    if (!openSet.contains(neighbor) || tentativeGScore < neighbor.g) {
                        neighbor.g = tentativeGScore;
                        neighbor.h = heuristic(neighbor, targetNode);
                        neighbor.f = neighbor.g + neighbor.h;
                        neighbor.parent = current;

                        if (!openSet.contains(neighbor)) {
                            openSet.add(neighbor);
                        }
                    }
                }
            }
        }

        return null; // 未找到路径
    }

    // 回溯路径
    static List<Node> reconstructPath(Node current) {
        List<Node> path = new ArrayList<>();
        while (current != null) {
            path.add(0, current);
            current = current.parent;
        }
        return path;
    }

    public static void main(String[] args) {
        Node result = aStar();
        if (result != null) {
            List<Node> path = reconstructPath(result);
            for (Node node : path) {
                System.out.println("(" + node.x + ", " + node.y + ")");
            }
        } else {
            System.out.println("Path not found");
        }
    }
}
