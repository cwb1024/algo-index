package com.cc.data.structres.base.queue;

import java.util.ArrayDeque;

public class QueueUsingArrayDeque {
    private ArrayDeque<Integer> stack1; // 入队栈
    private ArrayDeque<Integer> stack2; // 出队栈

    public QueueUsingArrayDeque() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void enq(int item) {
        stack1.addLast(item);
    }

    public int deq() {
        if (isEmpty()) {
            return -1;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.addLast(stack1.pollLast());
            }
        }

        return stack2.pollLast();
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.addLast(stack1.pollLast());
            }
        }

        return stack2.peekLast();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }

    public static void main(String[] args) {
        QueueUsingArrayDeque queue = new QueueUsingArrayDeque();

        queue.enq(1);
        queue.enq(2);
        queue.enq(3);

        System.out.println("Peek: " + queue.peek()); // 1

        System.out.println("Deq: " + queue.deq()); // 1
        System.out.println("Deq: " + queue.deq()); // 2

        queue.enq(4);
        queue.enq(5);

        System.out.println("Size: " + queue.size()); // 3

        while (!queue.isEmpty()) {
            System.out.println("Deq: " + queue.deq());
        }
    }
}

