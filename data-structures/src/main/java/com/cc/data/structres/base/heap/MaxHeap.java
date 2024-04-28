package com.cc.data.structres.base.heap;

public class MaxHeap {
    private int[] heap;
    private int n;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.n = 0;
        this.heap = new int[capacity];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void heapifyUp(int i) {
        while (i > 0 && heap[parent(i)] < heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void heapifyDown(int i) {
        int maxIndex = i;
        int l = leftChild(i);
        int r = rightChild(i);

        if (l < n && heap[l] > heap[maxIndex]) {
            maxIndex = l;
        }
        if (r < n && heap[r] > heap[maxIndex]) {
            maxIndex = r;
        }

        if (i != maxIndex) {
            swap(i, maxIndex);
            heapifyDown(maxIndex);
        }
    }

    public boolean add(int e) {
        if (n == capacity) {
            return false; // Heap is full
        }

        heap[n++] = e;
        heapifyUp(n - 1);
        return true;
    }

    public int poll() {
        if (isEmpty()) {
            return Integer.MIN_VALUE; // Heap is empty
        }

        int max = heap[0];
        heap[0] = heap[--n];
        heapifyDown(0);
        return max;
    }

    public int peek() {
        if (isEmpty()) {
            return Integer.MIN_VALUE; // Heap is empty
        }
        return heap[0];
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void clear() {
        n = 0;
    }

    public static void main(String[] args) {
        // Example usage
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.add(3);
        maxHeap.add(2);
        maxHeap.add(1);
        maxHeap.add(15);
        maxHeap.add(5);
        maxHeap.add(4);
        maxHeap.add(45);

        System.out.println("Max Heap:");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();
    }
}

