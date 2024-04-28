package com.cc.algo.graph.Eulerian;

import java.util.*;

public class EulerianPathAndCircuit {

    // 欧拉回路
    public static List<Integer> eulerianCircuit(int[][] graph) {
        List<Integer> circuit = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // 从起始顶点开始

        while (!stack.isEmpty()) {
            int current = stack.peek();
            if (graph[current].length == 0) {
                // 如果当前顶点的邻接列表为空，则将其加入到欧拉回路中，并从栈中移除
                circuit.add(stack.pop());
            } else {
                // 否则，选择一个邻接顶点，并将其从邻接列表中移除
                int next = graph[current][0];
                stack.push(next);
                graph[current] = Arrays.copyOfRange(graph[current], 1, graph[current].length);
                // 移除另一端的邻接边
                for (int i = 0; i < graph[next].length; i++) {
                    if (graph[next][i] == current) {
                        graph[next] = removeElement(graph[next], i);
                        break;
                    }
                }
            }
        }

        return circuit;
    }

    // 欧拉路径
    public static List<Integer> eulerianPath(int[][] graph) {
        List<Integer> circuit = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int start = findStart(graph); // 寻找起始顶点
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.peek();
            if (graph[current].length == 0) {
                // 如果当前顶点的邻接列表为空，则将其加入到欧拉路径中，并从栈中移除
                circuit.add(stack.pop());
            } else {
                // 否则，选择一个邻接顶点，并将其从邻接列表中移除
                int next = graph[current][0];
                stack.push(next);
                graph[current] = Arrays.copyOfRange(graph[current], 1, graph[current].length);
                // 移除另一端的邻接边
                for (int i = 0; i < graph[next].length; i++) {
                    if (graph[next][i] == current) {
                        graph[next] = removeElement(graph[next], i);
                        break;
                    }
                }
            }
        }

        // 将路径逆序后返回
        Collections.reverse(circuit);
        return circuit;
    }

    // 在邻接列表中找到起始顶点
    private static int findStart(int[][] graph) {
        int start = 0;
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length > 0) {
                start = i;
                break;
            }
        }
        return start;
    }

    // 移除数组中的元素
    private static int[] removeElement(int[] arr, int index) {
        int[] newArr = new int[arr.length - 1];
        System.arraycopy(arr, 0, newArr, 0, index);
        System.arraycopy(arr, index + 1, newArr, index, arr.length - index - 1);
        return newArr;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2},
                {0, 2, 3},
                {0, 1, 3},
                {1, 2}
        };

        System.out.println("欧拉回路：" + eulerianCircuit(graph));
        System.out.println("欧拉路径：" + eulerianPath(graph));
    }
}

