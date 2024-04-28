package com.cc.data.structres.treap;

public class Treap {
    TreapNode root;

    // 插入节点
    public TreapNode insert(TreapNode root, int key) {
        if (root == null) {
            return new TreapNode(key);
        }
        if (key < root.key) {
            root.left = insert(root.left, key);
            if (root.left.priority > root.priority) {
                root = rotateRight(root);
            }
        } else {
            root.right = insert(root.right, key);
            if (root.right.priority > root.priority) {
                root = rotateLeft(root);
            }
        }
        return root;
    }

    // 删除节点
    public TreapNode delete(TreapNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            if (root.left.priority > root.right.priority) {
                root = rotateRight(root);
                root.right = delete(root.right, key);
            } else {
                root = rotateLeft(root);
                root.left = delete(root.left, key);
            }
        }
        return root;
    }

    // 右旋转
    private TreapNode rotateRight(TreapNode node) {
        TreapNode left = node.left;
        node.left = left.right;
        left.right = node;
        return left;
    }

    // 左旋转
    private TreapNode rotateLeft(TreapNode node) {
        TreapNode right = node.right;
        node.right = right.left;
        right.left = node;
        return right;
    }

    // 中序遍历
    public void inOrderTraversal(TreapNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println("Key: " + root.key + ", Priority: " + root.priority);
            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        Treap treap = new Treap();
        treap.root = treap.insert(treap.root, 5);
        treap.root = treap.insert(treap.root, 3);
        treap.root = treap.insert(treap.root, 8);
        treap.root = treap.insert(treap.root, 2);
        treap.root = treap.insert(treap.root, 4);
        treap.root = treap.insert(treap.root, 7);
        treap.root = treap.insert(treap.root, 9);

        System.out.println("Inorder traversal of the Treap:");
        treap.inOrderTraversal(treap.root);

        treap.root = treap.delete(treap.root, 5);

        System.out.println("\nInorder traversal of the Treap after deleting key 5:");
        treap.inOrderTraversal(treap.root);
    }
}
