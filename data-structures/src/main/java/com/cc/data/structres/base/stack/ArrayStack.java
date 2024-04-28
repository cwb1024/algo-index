package com.cc.data.structres.base.stack;

public class ArrayStack {
    private int[] array;
    private int top; // 栈顶指针

    // 构造函数，初始化栈
    public ArrayStack(int capacity) {
        array = new int[capacity];
        top = -1; // 初始栈顶指针为-1，表示栈为空
    }

    // 压入元素到栈中
    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push.");
            return;
        }
        top++;
        array[top] = item;
    }

    // 弹出栈顶元素
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }
        int poppedItem = array[top];
        top--;
        return poppedItem;
    }

    // 查看栈顶元素
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1;
        }
        return array[top];
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    // 判断栈是否已满
    public boolean isFull() {
        return top == array.length - 1;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Peek: " + stack.peek()); // 3

        System.out.println("Pop: " + stack.pop()); // 3
        System.out.println("Pop: " + stack.pop()); // 2

        stack.push(4);
        stack.push(5);
        stack.push(6); // Stack is full. Cannot push.

        while (!stack.isEmpty()) {
            System.out.println("Pop: " + stack.pop());
        }
    }
}

