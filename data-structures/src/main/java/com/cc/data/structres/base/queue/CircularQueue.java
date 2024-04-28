package com.cc.data.structres.base.queue;

public class CircularQueue {
    private int[] queue;
    private int l; // 指向队列头部
    private int r; // 指向队列尾部
    private int n; // 队列当前元素个数
    private int capacity; // 队列容量

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.l = 0;
        this.r = -1;
        this.n = 0;
    }

    public void enq(int item) {
        if (isFull()) {
            return;
        }

        r = (r + 1) % capacity;
        queue[r] = item;
        n++;
    }

    public int deq() {
        if (isEmpty()) {
            return -1;
        }

        int dequeuedItem = queue[l];
        l = (l + 1) % capacity;
        n--;
        return dequeuedItem;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }

        return queue[l];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull() {
        return n == capacity;
    }

    public int size() {
        return n;
    }

    public void clear() {
        l = 0;
        r = -1;
        n = 0;
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);

        queue.enq(1);
        queue.enq(2);
        queue.enq(3);

        System.out.println("Peek: " + queue.peek()); // 1

        System.out.println("Deq: " + queue.deq()); // 1
        System.out.println("Deq: " + queue.deq()); // 2

        queue.enq(4);
        queue.enq(5);
        queue.enq(6); // Queue is full. Cannot enq.

        System.out.println("Size: " + queue.size()); // 3

        while (!queue.isEmpty()) {
            System.out.println("Deq: " + queue.deq());
        }
    }
}
