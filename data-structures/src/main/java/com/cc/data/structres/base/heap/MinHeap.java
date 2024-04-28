package com.cc.data.structres.base.heap;

public class MinHeap {
    private int[] heap;
    private int n;
    private int capacity;

    public MinHeap(int capacity) {
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
        while (i > 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void heapifyDown(int i) {
        int minIndex = i;
        int l = leftChild(i);
        int r = rightChild(i);

        if (l < n && heap[l] < heap[minIndex]) {
            minIndex = l;
        }
        if (r < n && heap[r] < heap[minIndex]) {
            minIndex = r;
        }

        if (i != minIndex) {
            swap(i, minIndex);
            heapifyDown(minIndex);
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

        int min = heap[0];
        heap[0] = heap[--n];
        heapifyDown(0);
        return min;
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
        MinHeap minHeap = new MinHeap(10);
        minHeap.add(3);
        minHeap.add(2);
        minHeap.add(1);
        minHeap.add(15);
        minHeap.add(5);
        minHeap.add(4);
        minHeap.add(45);

        System.out.println("Min Heap:");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();
    }
}

