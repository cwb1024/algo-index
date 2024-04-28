package com.cc.data.structres.red.black.tree;

public class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        int key;
        Node left, right;
        boolean color;

        Node(int key) {
            this.key = key;
            this.color = RED;
        }
    }

    // 左旋
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    // 右旋
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    // 颜色翻转
    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    // 判断节点的颜色
    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    // 插入操作
    public void insert(int key) {
        root = insert(root, key);
        root.color = BLACK; // 根节点始终为黑色
    }

    private Node insert(Node h, int key) {
        if (h == null) return new Node(key);

        if (key < h.key) {
            h.left = insert(h.left, key);
        } else if (key > h.key) {
            h.right = insert(h.right, key);
        } else {
            // 如果节点已存在，则更新值
            h.key = key;
        }

        // 插入后进行颜色调整
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        return h;
    }

    // 中序遍历
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node x) {
        if (x == null) return;
        inOrder(x.left);
        System.out.print(x.key + " ");
        inOrder(x.right);
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(15);
        tree.insert(30);

        System.out.println("In-order traversal:");
        tree.inOrder(); // 5 10 15 20 30
    }
}

