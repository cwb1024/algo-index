package com.cc.data.structres.treeheap;

import java.util.ArrayList;
import java.util.List;

public class TreeHeap {
    private List<Integer> heap;

    public TreeHeap() {
        heap = new ArrayList<>();
        // 在索引0处放置一个哨兵节点，简化计算
        heap.add(0);
    }

    // 插入元素
    public void insert(int val) {
        heap.add(val);
        int index = heap.size() - 1;
        while (index > 1 && heap.get(index / 2) > heap.get(index)) {
            swap(index, index / 2);
            index /= 2;
        }
    }

    // 删除堆顶元素
    public void deleteMin() {
        if (heap.size() <= 1) return; // 堆为空
        heap.set(1, heap.get(heap.size() - 1)); // 将最后一个元素移动到堆顶
        heap.remove(heap.size() - 1); // 删除最后一个元素
        heapify(1); // 从堆顶开始进行堆化操作
    }

    // 获取堆顶元素
    public int getMin() {
        if (heap.size() <= 1) return -1; // 堆为空
        return heap.get(1);
    }

    // 堆化操作
    private void heapify(int index) {
        int smallest = index;
        int left = index * 2;
        int right = index * 2 + 1;

        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    // 交换元素
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public static void main(String[] args) {
        TreeHeap minHeap = new TreeHeap();
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(4);
        minHeap.insert(5);

        System.out.println("Min Element: " + minHeap.getMin()); // 1

        minHeap.deleteMin();
        System.out.println("Min Element after deletion: " + minHeap.getMin()); // 2
    }
}
