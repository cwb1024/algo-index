package com.cc.data.structres.base.heap.java;

import java.util.PriorityQueue;

public class MinHeap {
    public static void main(String[] args) {
        // 创建一个小顶堆PriorityQueue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 添加元素到小顶堆
        minHeap.add(3);
        minHeap.add(1);
        minHeap.add(5);
        minHeap.add(2);
        minHeap.add(4);

        // 使用Stream打印小顶堆元素（按照小顶堆的顺序）
        minHeap.stream().forEach(System.out::println);

        // 删除小顶堆顶部元素
        minHeap.poll();
        // 打印删除后的小顶堆
        System.out.println("After poll:");
        minHeap.stream().forEach(System.out::println);
    }
}
