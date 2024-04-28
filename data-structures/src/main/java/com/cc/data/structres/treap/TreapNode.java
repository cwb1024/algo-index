package com.cc.data.structres.treap;

import java.util.Random;

public class TreapNode {
    int key; // 键值
    int priority; // 优先级
    TreapNode left, right; // 左右子节点

    public TreapNode(int key) {
        this.key = key;
        this.priority = new Random().nextInt(); // 随机生成优先级
        this.left = null;
        this.right = null;
    }
}
