package com.cc.data.structres.skiplist;

import java.util.Random;

public class SkipList {
    private static final int MAX_LEVEL = 16; // 最大层数
    private Node head; // 头节点
    private Random random; // 随机数生成器

    public SkipList() {
        head = new Node(Integer.MIN_VALUE);
        random = new Random();
    }

    // 查找节点
    public boolean search(int target) {
        Node curr = head;
        // 从最高层开始查找
        for (int i = MAX_LEVEL - 1; i >= 0; i--) {
            while (curr.next[i] != null && curr.next[i].val < target) {
                curr = curr.next[i];
            }
        }
        // 在最底层判断是否找到目标节点
        return curr.next[0] != null && curr.next[0].val == target;
    }

    // 插入节点
    public void add(int num) {
        Node[] update = new Node[MAX_LEVEL]; // 辅助数组，用于记录每层要插入的位置
        Node curr = head;
        // 从最高层开始查找
        for (int i = MAX_LEVEL - 1; i >= 0; i--) {
            while (curr.next[i] != null && curr.next[i].val < num) {
                curr = curr.next[i];
            }
            update[i] = curr; // 记录要插入的位置
        }
        int level = randomLevel(); // 随机生成要插入的层数
        Node newNode = new Node(num, level); // 创建新节点
        // 更新每层的指针
        for (int i = 0; i < level; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
    }

    // 删除节点
    public boolean erase(int num) {
        Node[] update = new Node[MAX_LEVEL]; // 辅助数组，用于记录每层要删除的位置
        Node curr = head;
        // 从最高层开始查找
        for (int i = MAX_LEVEL - 1; i >= 0; i--) {
            while (curr.next[i] != null && curr.next[i].val < num) {
                curr = curr.next[i];
            }
            update[i] = curr; // 记录要删除的位置
        }
        // 判断是否找到目标节点
        if (curr.next[0] != null && curr.next[0].val == num) {
            // 更新每层的指针
            for (int i = MAX_LEVEL - 1; i >= 0; i--) {
                if (update[i].next[i] != null && update[i].next[i].val == num) {
                    update[i].next[i] = update[i].next[i].next[i];
                }
            }
            return true;
        } else {
            return false;
        }
    }

    // 随机生成节点的层数
    private int randomLevel() {
        int level = 1;
        while (random.nextDouble() < 0.5 && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    // 跳表节点类
    private class Node {
        int val;
        Node[] next;

        Node(int val) {
            this.val = val;
            this.next = new Node[MAX_LEVEL];
        }

        Node(int val, int level) {
            this.val = val;
            this.next = new Node[level];
        }
    }
}

