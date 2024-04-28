package com.cc.algo.graph.DifferenceConstraints;

import java.util.*;

public class DifferenceConstraints {
    public static void main(String[] args) {
        int n = 3; // 变量个数
        int[] d = new int[n]; // 变量的最短距离

        // 构建差分约束图
        List<int[]> constraints = new ArrayList<>();
        constraints.add(new int[]{0, 1, 2}); // x1 - x0 ≤ 2
        constraints.add(new int[]{0, 2, 5}); // x2 - x0 ≤ 5
        constraints.add(new int[]{1, 2, 2}); // x2 - x1 ≤ 2

        // 拓扑排序
        List<Integer> topoOrder = topologicalSort(n, constraints);

        // 根据拓扑序列依次进行松弛操作
        for (int node : topoOrder) {
            for (int[] constraint : constraints) {
                int from = constraint[0];
                int to = constraint[1];
                int weight = constraint[2];
                if (to == node) {
                    d[to] = Math.min(d[to], d[from] + weight);
                }
            }
        }

        // 输出结果
        for (int i = 0; i < n; i++) {
            System.out.println("x" + i + " = " + d[i]);
        }
    }

    // 拓扑排序
    private static List<Integer> topologicalSort(int n, List<int[]> constraints) {
        List<Integer> topoOrder = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];

        // 构建图和计算入度
        for (int[] constraint : constraints) {
            int from = constraint[0];
            int to = constraint[1];
            if (!graph.containsKey(from)) {
                graph.put(from, new ArrayList<>());
            }
            graph.get(from).add(to);
            indegree[to]++;
        }

        // 找到入度为0的节点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 拓扑排序
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);
            if (graph.containsKey(node)) {
                for (int neighbor : graph.get(node)) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return topoOrder;
    }
}

