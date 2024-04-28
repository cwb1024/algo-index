package com.cc.data.structres.base.heap.java;

import java.util.PriorityQueue;

public class MaxHeap {
    public static void main(String[] args) {
        // 使用lambda表达式定义一个大顶堆的比较器
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // 添加元素到大顶堆
        maxHeap.add(3);
        maxHeap.add(1);
        maxHeap.add(5);
        maxHeap.add(2);
        maxHeap.add(4);

        // 打印大顶堆的元素
        System.out.println("Max Heap:");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
    }
}
